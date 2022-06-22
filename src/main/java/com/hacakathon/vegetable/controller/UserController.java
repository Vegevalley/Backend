package com.hacakathon.vegetable.controller;


import com.hacakathon.vegetable.dto.user.*;
import com.hacakathon.vegetable.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user/new")
    public ResponseEntity<String> create(@RequestBody UserCreateRequest userCreateRequest){

        return ResponseEntity.ok(userService.create(userCreateRequest));
    }


    @PostMapping("/user/login")
    public ResponseEntity<UserLoginResponse> login(@RequestBody UserLoginRequest userLoginRequest){
        return ResponseEntity.ok(userService.login(userLoginRequest));
    }


    @PostMapping("/user/getInfo")
    public ResponseEntity<UserGetInfoResponse> getInfo(@RequestBody Map<String, String> JwtToken){
        return ResponseEntity.ok(userService.getInfo(JwtToken.get("JwtToken")));
    }


    @PostMapping("/user/passwordChange")
    public ResponseEntity<String> changePassword(@RequestBody Map<String, String> json){
        return ResponseEntity.ok(userService.changePassword(json.get("authorization"), json.get("password")));
    }

    @PostMapping("/user/phoneChange")
    public ResponseEntity<String> phoneChange(@RequestBody Map<String, String> json){

        return ResponseEntity.ok(userService.changePhoneNum(json.get("authorization"), json.get("phoneNum")));
    }

}
