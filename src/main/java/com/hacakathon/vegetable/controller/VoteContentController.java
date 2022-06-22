//package com.hacakathon.vegetable.controller;
//
//import com.hacakathon.vegetable.dto.content.comment.CommentCreateRequest;
//import com.hacakathon.vegetable.dto.content.ContentListRequest;
//import com.hacakathon.vegetable.dto.content.vege.VegeContentListResponse;
//import com.hacakathon.vegetable.dto.content.vote.VoteContentCreateRequest;
//import com.hacakathon.vegetable.dto.content.vote.VoteContentListRequest;
//import com.hacakathon.vegetable.dto.content.vote.VoteContentListResponse;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequiredArgsConstructor
//public class VoteContentController {
//
//    private final VoteContentService voteContentService;
//
//        @PostMapping("/content/vote/new")
//    public ResponseEntity<String> create (
//            @RequestBody VoteContentCreateRequest voteContentCreateRequest
//    ){
//        return ResponseEntity.ok(voteContentService.create(voteContentCreateRequest));
//    }
//
//    @GetMapping("/content/vote/contentList")
//    public ResponseEntity<List<VoteContentListResponse>> contentList(
//            @RequestBody VoteContentListRequest voteContentListRequest
//    ){
//        return ResponseEntity.ok(voteContentService.getContentList(voteContentListRequest));
//
//    }
//}
