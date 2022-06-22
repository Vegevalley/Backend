package com.hacakathon.vegetable.service;

import com.hacakathon.vegetable.domain.User;
import com.hacakathon.vegetable.dto.*;
import com.hacakathon.vegetable.repository.EmdRepository;
import com.hacakathon.vegetable.repository.UserRepository;
import io.jsonwebtoken.Jwt;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final EmdRepository emdRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public String create(UserCreateRequest user) {
        return userRepository.save(User.builder()
        .userId(user.getUserId())
        .userName(user.getUserName())
        .password(passwordEncoder.encode(user.getPassword())) // password encode
        .role("ROLE_USER")
        .phoneNumber(user.getPhoneNum())
        .emd(emdRepository.findByEmdName(user.getLocalField()))
        .build()).getUserId();
    }

    public UserLoginResponse login(UserLoginRequest userLogin) {
        User user = userRepository.findByUserId(userLogin.getUserId());
        if (user == null) {
            throw new IllegalArgumentException("없는 ID");
        }

        if (!passwordEncoder.matches(userLogin.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("없는 비밀번호");
        }

        return UserLoginResponse.builder().accessToken(jwtTokenProvider.createToken(user.getUserId(), user.getRole())).build();
    }

    public UserGetInfoResponse getInfo(String token) {
        User user = userRepository.findByUserId(jwtTokenProvider.getUserId(token));
        return UserGetInfoResponse.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .phoneNum(user.getPhoneNumber())
                .vote(user.getGoodVote())
                .build();
    }

    public String changePassword(UserChangePasswordRequest changedUser) {
        User user = userRepository.findByUserId(jwtTokenProvider.getUserId(changedUser.getJwtToken()));
        user.setPassword(passwordEncoder.encode(changedUser.getPassword()));
        return userRepository.save(user).getUserId();
    }
}
