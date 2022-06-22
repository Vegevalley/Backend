package com.hacakathon.vegetable.service;

import com.hacakathon.vegetable.domain.User;
import com.hacakathon.vegetable.dto.user.UserCreateRequest;
import com.hacakathon.vegetable.dto.user.UserGetInfoResponse;
import com.hacakathon.vegetable.dto.user.UserLoginRequest;
import com.hacakathon.vegetable.dto.user.UserLoginResponse;
import com.hacakathon.vegetable.repository.EmdRepository;
import com.hacakathon.vegetable.repository.UserRepository;
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

    public String changePassword(String authorization, String password) {
        User user = userRepository.findByUserId(jwtTokenProvider.getUserId(authorization));
        user.setPassword(passwordEncoder.encode(password));
        return userRepository.save(user).getUserId();
    }

    public String changePhoneNum(String authorization, String phoneNum) {
        User user = userRepository.findByUserId(jwtTokenProvider.getUserId(authorization));
        user.setPhoneNumber(phoneNum);
        return userRepository.save(user).getUserId();
    }
}
