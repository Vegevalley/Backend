package com.hacakathon.vegetable.controller;

import com.hacakathon.vegetable.dto.content.comment.CommentCreateRequest;
import com.hacakathon.vegetable.dto.content.ContentListRequest;
import com.hacakathon.vegetable.dto.content.vege.VegeContentListResponse;
import com.hacakathon.vegetable.dto.content.recepi.RecipeContentCreateRequest;
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
            @RequestBody String authorization,
            @RequestBody RecipeContentCreateRequest recipeContentCreateRequest
    ){
        return ResponseEntity.ok(recipeContentService.create(authorization, recipeContentCreateRequest));
    }

    @GetMapping("/contene/recipe/comment")
    public ResponseEntity<String> newComment(
            @RequestBody String authorization,
            @RequestBody CommentCreateRequest commentCreateRequest
    ){
        return ResponseEntity.ok(recipeContentService.newComment(authorization, commentCreateRequest);
    }

    @GetMapping("/content/recipe/contentList")
    public ResponseEntity<List<VegeContentListResponse>> contentList(
            @RequestBody String authorization,
            @RequestBody ContentListRequest contentListRequest
    ){
        return ResponseEntity.ok(recipeContentService.getContentList(authorization, contentListRequest));
    }


}
