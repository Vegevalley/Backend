package com.hacakathon.vegetable.controller;

import com.hacakathon.vegetable.dto.content.comment.CommentCreateRequest;
import com.hacakathon.vegetable.dto.content.ContentListRequest;
import com.hacakathon.vegetable.dto.content.comment.CommentListResponse;
import com.hacakathon.vegetable.dto.content.vege.VegeContentCreateRequest;
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
public class VegeContentController {

    private final VegeContentService vegeContentService;

    @PostMapping("/content/vege/new")
    public ResponseEntity<String> create (
            @RequestBody String authorization,
            @RequestBody VegeContentCreateRequest vegeContentCreateRequest
    ){
        return ResponseEntity.ok(vegeContentService.create(authorization, vegeContentCreateRequest));
    }

    @PostMapping("/contene/vege/comment")
    public ResponseEntity<String> newComment(
            @RequestBody String authorization,
            @RequestBody CommentCreateRequest commentCreateRequest
    ){
        return ResponseEntity.ok(vegeContentService.newComment(authorization, commentCreateRequest));
    }

    @GetMapping("/contene/vege/comment")
    public ResponseEntity<List<CommentListResponse>> getComment(
            @RequestBody String authorization,
            @RequestBody long contentId
    ){
        return ResponseEntity.ok(vegeContentService.newComment(authorization, contentId);
    }

    @GetMapping("/content/vege/contentList")
    public ResponseEntity<List<VegeContentListResponse>> contentList(
            @RequestBody String authorization,
            @RequestBody ContentListRequest contentListRequest
    ){
        return ResponseEntity.ok(vegeContentService.getContentList(authorization, contentListRequest));
    }

    @GetMapping("/content/vege/contentListSerch")
    public ResponseEntity<List<VegeContentListResponse>> contentSearchList(
            @RequestBody String authorization,
            @RequestBody ContentListRequest contentListRequest,
            @RequestBody String searchText
    ){
        return ResponseEntity.ok(recipeContentService.contentListSerch(authorization, contentListRequest, searchText));
    }
}
