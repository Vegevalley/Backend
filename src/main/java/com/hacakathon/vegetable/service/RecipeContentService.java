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

    public String create(RecepiContentCreateRequest recipeContentCreateRequest) {
        String userId = jwtTokenProvider.getUserId(recipeContentCreateRequest.getAuthorization());

        User user = userRepository.findByUserId(userId);

        recipeContentRepository.save(RecepiContent.builder()
                .author(user)
                .title(recipeContentCreateRequest.getTitle())
                .mainText(recipeContentCreateRequest.getMainText())
                .build());

        return "게시글 작성 완료";
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
        return "댓글 작성 완료";
    }

    public List<CommentListResponse> getComment(CommentListRequest commentListRequest){

        System.out.println("commentListRequest.getContentId() = " + commentListRequest.getContentId());

        List<Comment> allCommentList = commentRepository.findAll();

        System.out.println("allCommentList = " + allCommentList);

        return CommentListResponse.toDtoList(allCommentList);
    }

    public List<RecepiContentListResponse> getContentList(ContentListRequest contentListRequest){
        List<RecepiContent> allContentList = recipeContentRepository.findAll();

        return RecepiContentListResponse.toDtoList(allContentList);
    }

    public List<RecepiContentListResponse> contentListSearch(ContentListSearchRequest contentListSearchRequest){
        List<RecepiContent> allContentList = recipeContentRepository.findByTitleContains(contentListSearchRequest.getSearchText());

        return RecepiContentListResponse.toDtoList(allContentList);
    }

    public RecepiContentDto getContentMain (ContentMainRequest contentMainRequest){
        RecepiContent recepiContent = recipeContentRepository.findByRecepiContentId(contentMainRequest.getContentId());
        return new RecepiContentDto(
                recepiContent.getRecepiContentId(),
                recepiContent.getAuthor().getUserName(),
                recepiContent.getTitle(),
                recepiContent.getMainText(),
                recepiContent.getCreatedDate(),
                recepiContent.getUpdatedDate()
        );
    }

}
