package com.hacakathon.vegetable.service;

import com.hacakathon.vegetable.domain.Comment;
import com.hacakathon.vegetable.domain.User;
import com.hacakathon.vegetable.domain.VegeContent;
import com.hacakathon.vegetable.dto.content.ContentListRequest;
import com.hacakathon.vegetable.dto.content.ContentListSearchRequest;
import com.hacakathon.vegetable.dto.content.ContentMainRequest;
import com.hacakathon.vegetable.dto.content.comment.CommentCreateRequest;
import com.hacakathon.vegetable.dto.content.comment.CommentListResponse;
import com.hacakathon.vegetable.dto.content.vege.VegeContentCreateRequest;
import com.hacakathon.vegetable.dto.content.vege.VegeContentDto;
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
public class VegeContentService {

    private final VegeContentRepository vegeContentRepository;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final EmdRepository emdRepository;
    private final CommentRepository commentRepository;

    public String create(VegeContentCreateRequest vegeContentCreateRequest) {
        User user = userRepository.findByUserId(jwtTokenProvider.getUserId(vegeContentCreateRequest.getAuthorization()));
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

    public String newComment(CommentCreateRequest commentCreateRequest) {
        User user = userRepository.findByUserId(jwtTokenProvider.getUserId(commentCreateRequest.getAuthorization()));
        Comment comment = Comment.builder()
                .author(user)
                .vegeContent(vegeContentRepository.findByVegeContentId(commentCreateRequest.getContentId()))
                .commentText(commentCreateRequest.getCommentText())
                .build();

        return commentRepository.save(comment).getAuthor().getUserId();
    }

    public List<VegeContentListResponse> getContentList(ContentListRequest contentListRequest) {
        if (!jwtTokenProvider.validateToken(contentListRequest.getAuthorization())) {
            throw new IllegalArgumentException("잘못된 토큰");
        }
        else {
            Pageable pageable = PageRequest.of(contentListRequest.getPage()-1, 10);
            List<VegeContentListResponse> vegeContentListResponseList =
                    VegeContentListResponse.toDtoList(vegeContentRepository.findByEmd(emdRepository.findByEmdName(contentListRequest.getLocalField()), pageable));
            return vegeContentListResponseList;
        }
    }

    public List<VegeContentListResponse> contentListSearch(ContentListSearchRequest contentListSearchRequest) {
        if (!jwtTokenProvider.validateToken(contentListSearchRequest.getAuthorization())) {
            throw new IllegalArgumentException("잘못된 토큰");
        }
        else {
            Pageable pageable = PageRequest.of(contentListSearchRequest.getPage()-1, 10);
            List<VegeContentListResponse> vegeContentListResponseList =
                    VegeContentListResponse.toDtoList(vegeContentRepository.findByTitleContainsOrMainTextContainsAndEmd(contentListSearchRequest.getSearchText(), contentListSearchRequest.getSearchText(), emdRepository.findByEmdName(contentListSearchRequest.getLocalField()), pageable));
            return vegeContentListResponseList;
        }
    }

    public VegeContentDto getContentMain(ContentMainRequest contentMainRequest) {
        if (!jwtTokenProvider.validateToken(contentMainRequest.getAuthorization())) {
            throw new IllegalArgumentException("잘못된 토큰");
        }
        else {
            VegeContent vegeContent = vegeContentRepository.findByVegeContentId(contentMainRequest.getContentId());
            return VegeContentDto.builder()
                    .contentId(vegeContent.getVegeContentId())
                    .authorName(vegeContent.getAuthor().getUserName())
                    .title(vegeContent.getTitle())
                    .mainText(vegeContent.getMainText())
                    .dateCreated(vegeContent.getCreatedDate())
                    .dateUpdated(vegeContent.getUpdatedDate())
                    .sellCheck(vegeContent.isSellCheck())
                    .dateBuyed(vegeContent.getBoughtDate())
                    .commentListResponseList(CommentListResponse.toDtoList(vegeContent.getCommentList()))
                    .build();
        }
    }
}
