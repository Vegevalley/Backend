package com.hacakathon.vegetable.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class VoteContentController {

    @PostMapping("/content/vote/new")
    public ResponseEntity<> create (@RequestBody VoteContentCreateRequest voteContentCreateRequest){
        return ResponseEntity.ok();
    }
}
