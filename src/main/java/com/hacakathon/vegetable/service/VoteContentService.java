package com.hacakathon.vegetable.service;


import com.hacakathon.vegetable.domain.User;
import com.hacakathon.vegetable.domain.VoteContent;
import com.hacakathon.vegetable.dto.content.recepi.RecepiContentListResponse;
import com.hacakathon.vegetable.dto.content.vote.VoteContentCreateRequest;
import com.hacakathon.vegetable.dto.content.vote.VoteContentListRequest;
import com.hacakathon.vegetable.dto.content.vote.VoteContentListResponse;
import com.hacakathon.vegetable.repository.UserRepository;
import com.hacakathon.vegetable.repository.VoteContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VoteContentService {


    private final VoteContentRepository voteContentRepository;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    public String create(VoteContentCreateRequest voteContentCreateRequest){
        
        String userId = jwtTokenProvider.getUserId(voteContentCreateRequest.getAuthorization());
        User user = userRepository.findByUserId(userId);

        voteContentRepository.save(VoteContent.builder()
                .user(userRepository.findByUserId(userId))
                .title(voteContentCreateRequest.getTitle())
                .mainText(voteContentCreateRequest.getMainText())
                .build()
        );

        return "리뷰 작성 완료";
    }
    public List<VoteContentListResponse> getContentList(VoteContentListRequest voteContentListRequest){
        String userId = jwtTokenProvider.getUserId(voteContentListRequest.getAuthorization());
        Pageable pageable = PageRequest.of(voteContentListRequest.getPage()-1, 10);
        List<VoteContentListResponse> voteContentListResponses =
                VoteContentListResponse.toDtoList(voteContentRepository.findByUser(userRepository.findByUserId(userId), pageable));
        return voteContentListResponses;
    }
}
