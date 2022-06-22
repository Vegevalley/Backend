package com.hacakathon.vegetable.controller;

import com.hacakathon.vegetable.dto.ContentListRequest;
import com.hacakathon.vegetable.dto.ContentListResponse;
import com.hacakathon.vegetable.dto.RecipeContentCreateRequest;
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

    private final RecipeContentRepository recipeContentRepository;

    @PostMapping("/content/recipe/new")
    public ResponseEntity<String> create(@RequestBody RecipeContentCreateRequest recipeContentCreateRequest){
        return ResponseEntity.ok(recipeContentRepository.create(recipeContentCreateRequest));
    }

    @GetMapping("/contene/recipe/comment")
    public ResponseEntity<String> newComment(@RequestBody CommentCreateRequest commentCreateRequest){
        return ResponseEntity.ok(recipeContentRepository.newComment(commentCreateRequest);
    }

    @GetMapping("/content/recipe/contentList")
    public ResponseEntity<List<ContentListResponse>> contentList(@RequestBody ContentListRequest contentListRequest){
        return ResponseEntity.ok(recipeContentRepository.getContentList(page));

    }


}
