package com.hacakathon.vegetable.controller;

import com.hacakathon.vegetable.dto.content.comment.CommentCreateRequest;
import com.hacakathon.vegetable.dto.content.ContentListRequest;
import com.hacakathon.vegetable.dto.content.vege.VegeContentListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class VoteContentController {

    private final VoteContentService voteContentService;

        @PostMapping("/content/vote/new")
    public ResponseEntity<String> create (
            @RequestBody String authorization,
            @RequestBody VoteContentCreateRequest voteContentCreateRequest
    ){
        return ResponseEntity.ok(voteContentService.create(authorization, voteContentCreateRequest));
    }

    @GetMapping("/contene/vote/comment")
    public ResponseEntity<String> newComment(
            @RequestBody String authorization,
            @RequestBody CommentCreateRequest commentCreateRequest
    ){
        return ResponseEntity.ok(voteContentService.newComment(authorization, commentCreateRequest));
    }

    @GetMapping("/content/vote/contentList")
    public ResponseEntity<List<VegeContentListResponse>> contentList(
            @RequestBody String authorization,
            @RequestBody ContentListRequest contentListRequest
    ){
        return ResponseEntity.ok(voteContentService.getContentList(authorization, contentListRequest));

    }
}
