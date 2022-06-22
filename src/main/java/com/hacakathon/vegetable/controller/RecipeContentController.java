package com.hacakathon.vegetable.controller;

import com.hacakathon.vegetable.dto.content.ContentListSearchRequest;
import com.hacakathon.vegetable.dto.content.ContentMainRequest;
import com.hacakathon.vegetable.dto.content.comment.CommentCreateRequest;
import com.hacakathon.vegetable.dto.content.ContentListRequest;
import com.hacakathon.vegetable.dto.content.comment.CommentListRequest;
import com.hacakathon.vegetable.dto.content.comment.CommentListResponse;
import com.hacakathon.vegetable.dto.content.recepi.RecepiContentDto;
import com.hacakathon.vegetable.dto.content.recepi.RecepiContentListResponse;
import com.hacakathon.vegetable.dto.content.recepi.RecepiContentCreateRequest;
import com.hacakathon.vegetable.service.RecipeContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RecipeContentController {

    private final RecipeContentService recipeContentService;

    @PostMapping("/content/recipe/new")
    public ResponseEntity<String> create(
            @RequestBody RecepiContentCreateRequest recipeContentCreateRequest
    ){
        return ResponseEntity.ok(recipeContentService.create(recipeContentCreateRequest));
    }

    @PostMapping("/content/recipe/comment")
    public ResponseEntity<String> newComment(
            @RequestBody CommentCreateRequest commentCreateRequest
    ){
        return ResponseEntity.ok(recipeContentService.newComment(commentCreateRequest));
    }

//    @GetMapping("/content/recipe/comment")
//    public ResponseEntity<List<CommentListResponse>> getComment(
//            @RequestBody CommentListRequest commentListRequest
//    ){
//        return ResponseEntity.ok(recipeContentService.getComment(commentListRequest));
//    }

    @GetMapping("/content/recipe/contentList")
    public ResponseEntity<List<RecepiContentListResponse>> contentList(
            @RequestBody ContentListRequest contentListRequest
    ){
        return ResponseEntity.ok(recipeContentService.getContentList(contentListRequest));
    }

    @GetMapping("/content/recipe/contentListSearch")
    public ResponseEntity<List<RecepiContentListResponse>> contentSearchList(
            @RequestBody ContentListSearchRequest contentListSearchRequest
    ){
        return ResponseEntity.ok(recipeContentService.contentListSearch(contentListSearchRequest));
    }

    @GetMapping("/content/recipe/contentMain")
    public ResponseEntity<RecepiContentDto> contentMain(
            @RequestBody ContentMainRequest contentMainRequest
    )
    {
        return ResponseEntity.ok(recipeContentService.getContentMain(contentMainRequest));
    }

}
