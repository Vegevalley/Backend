package com.hacakathon.vegetable.controller;

import com.hacakathon.vegetable.dto.content.comment.CommentCreateRequest;
import com.hacakathon.vegetable.dto.content.ContentListRequest;
import com.hacakathon.vegetable.dto.content.comment.CommentListResponse;
import com.hacakathon.vegetable.dto.content.recepi.RecepiContentDto;
import com.hacakathon.vegetable.dto.content.recepi.RecepiContentListResponse;
import com.hacakathon.vegetable.dto.content.vege.VegeContentListResponse;
import com.hacakathon.vegetable.dto.content.recepi.RecepiContentCreateRequest;
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
            @RequestBody RecepiContentCreateRequest recipeContentCreateRequest
    ){
        return ResponseEntity.ok(recipeContentService.create(authorization, recipeContentCreateRequest));
    }

    @PostMapping("/contene/recipe/comment")
    public ResponseEntity<String> newComment(
            @RequestBody String authorization,
            @RequestBody CommentCreateRequest commentCreateRequest
    ){
        return ResponseEntity.ok(recipeContentService.newComment(authorization, commentCreateRequest);
    }

    @GetMapping("/contene/recipe/comment")
    public ResponseEntity<List<CommentListResponse>> getComment(
            @RequestBody String authorization,
            @RequestBody long contentId
    ){
        return ResponseEntity.ok(recipeContentService.newComment(authorization, contentId);
    }

    @GetMapping("/content/recipe/contentList")
    public ResponseEntity<List<RecepiContentListResponse>> contentList(
            @RequestBody String authorization,
            @RequestBody ContentListRequest contentListRequest
    ){
        return ResponseEntity.ok(recipeContentService.getContentList(authorization, contentListRequest));
    }

    @GetMapping("/content/recipe/contentListSerch")
    public ResponseEntity<List<RecepiContentListResponse>> contentSearchList(
            @RequestBody String authorization,
            @RequestBody ContentListRequest contentListRequest,
            @RequestBody String searchText
    ){
        return ResponseEntity.ok(recipeContentService.contentListSerch(authorization, contentListRequest, searchText));
    }

    @GetMapping("/content/recipe/contentMain")
    public ResponseEntity<RecepiContentDto> contentMain(
            @RequestBody String authorization,
            @RequestBody long contentId
    )
    {
        return ResponseEntity.ok(recipeContentService.getContentMain(authorization, contentId));
    }

}
