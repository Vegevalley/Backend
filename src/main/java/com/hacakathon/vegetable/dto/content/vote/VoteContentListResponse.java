package com.hacakathon.vegetable.dto.content.vote;


import com.hacakathon.vegetable.domain.VegeContent;
import com.hacakathon.vegetable.domain.VoteContent;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@ToString
public class VoteContentListResponse {

    private Long contentId;

    private String userName;

    private String title;

    private String mainText;

    private LocalDateTime dateCreated;

    private LocalDateTime dateUpdated;


    @Builder
    public VoteContentListResponse(Long contentId, String userName, String title, String mainText,
                                   LocalDateTime dateCreated, LocalDateTime dateUpdated){
        this.contentId = contentId;
        this.userName = userName;
        this.title = title;
        this.mainText = mainText;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }

    public static List<VoteContentListResponse> toDtoList(List<VoteContent> voteContentList){

        ArrayList<VoteContentListResponse> voteResponseList = new ArrayList<>();
        for (VoteContent voteContent : voteContentList) {
            VoteContentListResponse voteContentResponse = VoteContentListResponse.builder()
                    .contentId(voteContent.getGoodContentId())
                    .userName(voteContent.getUser().getUserName())
                    .title(voteContent.getTitle())
                    .mainText(voteContent.getMainText())
                    .dateCreated(voteContent.getCreatedDate())
                    .dateUpdated(voteContent.getUpdatedDate())
                    .build();
            System.out.println("voteContentResponse.userName = " + voteContentResponse.userName);
            voteResponseList.add(voteContentResponse);
        }

        return voteResponseList;
    }

}
