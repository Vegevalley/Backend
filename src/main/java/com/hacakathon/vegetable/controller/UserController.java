package com.hacakathon.vegetable.controller;


import com.hacakathon.vegetable.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user/new")
    public ResponseEntity<String> create(@RequestBody UserCreateRequest userCreateRequest){

        return ResponseEntity.ok(userService.create(userCreateRequest));
    }


    @GetMapping("/user/login")
    public ResponseEntity<UserLoginResponse> login(@RequestBody UserLoginRequest userLoginRequest){
        return ResponseEntity.ok(userService.login(userLoginRequest));
    }


    @PostMapping("/user/getInfo")
    public ResponseEntity<UserGetInfoResponse> getInfo(@RequestBody String JwtToken){
        return ResponseEntity.ok(userService.getInfo(JwtToken));
    }


    @PostMapping("/user/passwordChange")
    public ResponseEntity<String> changePassword(@RequestBody UserChangePasswordRequest userChangePasswordRequest){

        return ResponseEntity.ok(userService.changePassword(userChangePasswordRequest));
    }

}
