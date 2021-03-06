package com.hacakathon.vegetable.service;

import com.hacakathon.vegetable.domain.Comment;
import com.hacakathon.vegetable.domain.RecepiContent;
import com.hacakathon.vegetable.domain.User;
import com.hacakathon.vegetable.dto.content.ContentListRequest;
import com.hacakathon.vegetable.dto.content.ContentListSearchRequest;
import com.hacakathon.vegetable.dto.content.ContentMainRequest;
import com.hacakathon.vegetable.dto.content.comment.CommentCreateRequest;
import com.hacakathon.vegetable.dto.content.comment.CommentListRequest;
import com.hacakathon.vegetable.dto.content.comment.CommentListResponse;
import com.hacakathon.vegetable.dto.content.recepi.RecepiContentCreateRequest;
import com.hacakathon.vegetable.dto.content.recepi.RecepiContentDto;
import com.hacakathon.vegetable.dto.content.recepi.RecepiContentListResponse;
import com.hacakathon.vegetable.dto.content.vege.VegeContentListResponse;
import com.hacakathon.vegetable.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeContentService {

    private final RecipeContentRepository recipeContentRepository;
    private final VegeContentRepository vegeContentRepository;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final EmdRepository emdRepository;

    public String create(RecepiContentCreateRequest recipeContentCreateRequest) {
        String userId = jwtTokenProvider.getUserId(recipeContentCreateRequest.getAuthorization());

        User user = userRepository.findByUserId(userId);

        recipeContentRepository.save(RecepiContent.builder()
                .author(user)
                .title(recipeContentCreateRequest.getTitle())
                .mainText(recipeContentCreateRequest.getMainText())
                .build());

        return "????????? ?????? ??????";
    }

    public String newComment(CommentCreateRequest commentCreateRequest){

        String userId = jwtTokenProvider.getUserId(commentCreateRequest.getAuthorization());

        User user = userRepository.findByUserId(userId);

        commentRepository.save(Comment.builder()
                .author(user)
                .vegeContent(null)
                .recepiContent(recipeContentRepository.findByRecepiContentId(commentCreateRequest.getContentId()))
                .commentText(commentCreateRequest.getCommentText())
                .build()
        );
        return "?????? ?????? ??????";
    }

    public List<CommentListResponse> getComment(CommentListRequest commentListRequest){

        System.out.println("commentListRequest.getContentId() = " + commentListRequest.getContentId());

        List<Comment> allCommentList = commentRepository.findAll();

        System.out.println("allCommentList = " + allCommentList);

        return CommentListResponse.toDtoList(allCommentList);
    }

    public List<RecepiContentListResponse> getContentList(ContentListRequest contentListRequest){
        Pageable pageable = PageRequest.of(contentListRequest.getPage()-1, 10);
        List<RecepiContentListResponse> recepiContentListResponses =
                RecepiContentListResponse.toDtoList(recipeContentRepository.findAll(pageable).getContent());
        return recepiContentListResponses;
    }

    public List<RecepiContentListResponse> contentListSearch(ContentListSearchRequest contentListSearchRequest){
        String searchText = contentListSearchRequest.getSearchText();
        Pageable pageable = PageRequest.of(contentListSearchRequest.getPage()-1, 10);
        List<RecepiContentListResponse> allContentList =
                RecepiContentListResponse.toDtoList(recipeContentRepository.findByTitleContainsOrMainTextContains(searchText, searchText, pageable));

        return allContentList;
    }

    public RecepiContentDto getContentMain (ContentMainRequest contentMainRequest){
        RecepiContent recepiContent = recipeContentRepository.findByRecepiContentId(contentMainRequest.getContentId());
        return RecepiContentDto.builder()
                .contentId(recepiContent.getRecepiContentId())
                .authorName(recepiContent.getAuthor().getUserName())
                .title(recepiContent.getTitle())
                .mainText(recepiContent.getMainText())
                .dateCreated(recepiContent.getCreatedDate())
                .dateUpdated(recepiContent.getUpdatedDate())
                .commentListResponseList(CommentListResponse.toDtoList(recepiContent.getCommentList()))
                .build();
    }
}
