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
import com.hacakathon.vegetable.repository.CommentRepository;
import com.hacakathon.vegetable.repository.RecipeContentRepository;
import com.hacakathon.vegetable.repository.UserRepository;
import com.hacakathon.vegetable.repository.VegeContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

        User user = userRepository.findByUserId(recipeContentCreateRequest.getAuthorName());

        recipeContentRepository.save(RecepiContent.builder()
                .author(user)
                .title(recipeContentCreateRequest.getTitle())
                .mainText(recipeContentCreateRequest.getMainText())
                .build());

        return "게시글 작성 완료";
    }

    public String newComment(CommentCreateRequest commentCreateRequest){

        if(recipeContentRepository.existsByRecepiContentId(commentCreateRequest.getContentId()))
        {
            commentRepository.save(Comment.builder()
                    .author(userRepository.findByUserName(commentCreateRequest.getAuthor()))
                    .vegeContent(null)
                    .recepiContent(recipeContentRepository.findByRecepiContentId(commentCreateRequest.getContentId()))
                    .commentText(commentCreateRequest.getCommentText())
                    .build()
            );
        }else
        {
            commentRepository.save(Comment.builder()
                    .author(userRepository.findByUserName(commentCreateRequest.getAuthor()))
                    .vegeContent(vegeContentRepository.findByVegeContentId(commentCreateRequest.getContentId()))
                    .recepiContent(null)
                    .commentText(commentCreateRequest.getCommentText())
                    .build()
            );
        }
        return "댓글 작성 완료";
    }

    public List<CommentListResponse> getComment(CommentListRequest commentListRequest){
        List<Comment> allCommentList = commentRepository.findAllByCommentId(commentListRequest.getContentId());

        return CommentListResponse.toDtoList(allCommentList);
    }

    public List<RecepiContentListResponse> getContentList(ContentListRequest contentListRequest){
        Page<RecepiContent> allContentList = recipeContentRepository.findAll(PageRequest.of(contentListRequest.getPage() -1, 10, Sort.Direction.DESC));

        return RecepiContentListResponse.toDtoList(allContentList.getContent());
    }

    public List<RecepiContentListResponse> contentListSearch(ContentListSearchRequest contentListSearchRequest){
        Page<RecepiContent> allContentList = recipeContentRepository.findByTitleContains(contentListSearchRequest.getSearchText(), PageRequest.of(contentListSearchRequest.getPage() -1, 10, Sort.Direction.DESC));

        return RecepiContentListResponse.toDtoList(allContentList.getContent());
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
