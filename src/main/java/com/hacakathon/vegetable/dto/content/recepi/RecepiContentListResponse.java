package com.hacakathon.vegetable.dto.content.recepi;


import com.hacakathon.vegetable.domain.RecepiContent;
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
public class RecepiContentListResponse {

    private Long contentId;

    private String authorName;

    private String title;

    private String mainText;

    private LocalDateTime dateCreated;

    private LocalDateTime dateUpdated;


    @Builder
    public RecepiContentListResponse(Long contentId, String authorName, String title, String mainText,
                                     LocalDateTime dateCreated, LocalDateTime dateUpdated){
        this.contentId = contentId;
        this.authorName = authorName;
        this.title = title;
        this.mainText = mainText;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }

    public static List<RecepiContentListResponse> toDtoList(List<RecepiContent> tradeList){

        ArrayList<RecepiContentListResponse> transferResponseList = new ArrayList<>();
        for (RecepiContent recepiContent : tradeList) {
            RecepiContentListResponse transferResponse = RecepiContentListResponse.builder()
                    .contentId(recepiContent.getRecepiContentId())
                    .authorName(recepiContent.getAuthor().getUserName())
                    .title(recepiContent.getTitle())
                    .mainText(recepiContent.getMainText())
                    .dateCreated(recepiContent.getCreatedDate())
                    .dateUpdated(recepiContent.getUpdatedDate())
                    .build();

            transferResponseList.add(transferResponse);
        }

        return transferResponseList;
    }

}
