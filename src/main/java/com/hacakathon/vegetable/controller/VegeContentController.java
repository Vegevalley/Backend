package com.hacakathon.vegetable.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class VegeContentController {

    @PostMapping("/content/vege/new")
    public ResponseEntity<> create (@RequestBody VegeContentCreateRequest vegeContentCreateRequest){
        return ResponseEntity.ok();
    }
}
