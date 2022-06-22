package com.hacakathon.vegetable.controller;

import com.hacakathon.vegetable.dto.content.ContentListSearchRequest;
import com.hacakathon.vegetable.dto.content.ContentMainRequest;
import com.hacakathon.vegetable.dto.content.comment.CommentCreateRequest;
import com.hacakathon.vegetable.dto.content.ContentListRequest;
import com.hacakathon.vegetable.dto.content.comment.CommentListRequest;
import com.hacakathon.vegetable.dto.content.comment.CommentListResponse;
import com.hacakathon.vegetable.dto.content.recepi.RecepiContentDto;
import com.hacakathon.vegetable.dto.content.vege.VegeContentCreateRequest;
import com.hacakathon.vegetable.dto.content.vege.VegeContentDto;
import com.hacakathon.vegetable.dto.content.vege.VegeContentListResponse;
import com.hacakathon.vegetable.service.VegeContentService;
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
            @RequestBody VegeContentCreateRequest vegeContentCreateRequest
    ){
        return ResponseEntity.ok(vegeContentService.create(vegeContentCreateRequest));
    }

    @PostMapping("/content/vege/comment")
    public ResponseEntity<String> newComment(
            @RequestBody CommentCreateRequest commentCreateRequest
    ){
        return ResponseEntity.ok(vegeContentService.newComment(commentCreateRequest));
    }
    /*
    @GetMapping("/contene/vege/comment")
    public ResponseEntity<List<CommentListResponse>> getComment(
            @RequestBody CommentListRequest commentListRequest
    ){
        return ResponseEntity.ok(vegeContentService.newComment(commentListRequest));
    }
     */

    @PostMapping("/content/vege/contentList")
    public ResponseEntity<List<VegeContentListResponse>> contentList(
            @RequestBody ContentListRequest contentListRequest
    ){
        return ResponseEntity.ok(vegeContentService.getContentList(contentListRequest));
    }

    @PostMapping("/content/vege/contentListSearch")
    public ResponseEntity<List<VegeContentListResponse>> contentSearchList(
            @RequestBody ContentListSearchRequest contentListSearchRequest
    ){
        return ResponseEntity.ok(vegeContentService.contentListSearch(contentListSearchRequest));
    }

    @PostMapping("/content/vege/contentMain")
    public ResponseEntity<VegeContentDto> contentMain(
            @RequestBody ContentMainRequest contentMainRequest
    )
    {
        return ResponseEntity.ok(vegeContentService.getContentMain(contentMainRequest));
    }

    @PostMapping("/content/vege/sell")
    public ResponseEntity<String> updateSell(@RequestBody ContentMainRequest contentMainRequest) {
        return ResponseEntity.ok(vegeContentService.updateSell(contentMainRequest));
    }

}
