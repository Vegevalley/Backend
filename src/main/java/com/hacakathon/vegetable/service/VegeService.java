package com.hacakathon.vegetable.service;

import com.hacakathon.vegetable.domain.Comment;
import com.hacakathon.vegetable.domain.User;
import com.hacakathon.vegetable.domain.VegeContent;
import com.hacakathon.vegetable.dto.content.ContentListRequest;
import com.hacakathon.vegetable.dto.content.comment.CommentCreateRequest;
import com.hacakathon.vegetable.dto.content.vege.VegeContentCreateRequest;
import com.hacakathon.vegetable.dto.content.vege.VegeContentListResponse;
import com.hacakathon.vegetable.repository.CommentRepository;
import com.hacakathon.vegetable.repository.EmdRepository;
import com.hacakathon.vegetable.repository.UserRepository;
import com.hacakathon.vegetable.repository.VegeContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VegeService {

    private final VegeContentRepository vegeContentRepository;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final EmdRepository emdRepository;
    private final CommentRepository commentRepository;

    public String create(String authorization, VegeContentCreateRequest vegeContentCreateRequest) {
        User user = userRepository.findByUserId(jwtTokenProvider.getUserId(authorization));
        VegeContent vegeContent = VegeContent.builder()
                .author(user)
                .emd(emdRepository.findByEmdName(vegeContentCreateRequest.getLocalField()))
                .title(vegeContentCreateRequest.getTitle())
                .mainText(vegeContentCreateRequest.getMainText())
                .vegetable(vegeContentCreateRequest.getVegetable())
                .sellCheck(vegeContentCreateRequest.getSellCheck())
                .boughtDate(vegeContentCreateRequest.getDateBuy())
                .build();

        return vegeContentRepository.save(vegeContent).getTitle();
    }

    public String newComment(String authorization, CommentCreateRequest commentCreateRequest) {
        User user = userRepository.findByUserId(jwtTokenProvider.getUserId(authorization));
        Comment comment = Comment.builder()
                .author(user)
                .vegeContent(vegeContentRepository.findByVegeContentId(commentCreateRequest.getContentId()))
                .commentText(commentCreateRequest.getCommentText())
                .build();

        return commentRepository.save(comment).getAuthor().getUserId();
    }

    public List<VegeContentListResponse> getContentList(String authorization, ContentListRequest contentListRequest) {
        if (!jwtTokenProvider.validateToken(authorization)) {
            throw new IllegalArgumentException("잘못된 토큰");
        }
        else {
            Pageable pageable = PageRequest.of(contentListRequest.getPage()-1, 10);
            List<VegeContentListResponse> vegeContentListResponseList =
                    VegeContentListResponse.toDtoList(vegeContentRepository.findBylocalId(contentListRequest.getLocalField(), pageable));
            return vegeContentListResponseList;
        }
    }
}
