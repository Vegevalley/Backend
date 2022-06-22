package com.hacakathon.vegetable.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.tomcat.jni.Local;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@ToString
public class ContentListResponse {

    private Long contentId;

    private String authorName;

    private String localField;

    private String title;

    private String mainText;

    private String vegetable;

    private Boolean sellCheck;

    private LocalDateTime dateBuy;

    private LocalDateTime dateCreated;

    private LocalDateTime dateUpdated;


    @Builder
    public ContentListResponse(Long contentId, String authorName, String localField, String title, String mainText, String vegetable, Boolean sellCheck,
                               LocalDateTime dateBuy, LocalDateTime dateCreated, LocalDateTime dateUpdated){
        this.contentId = contentId;
        this.authorName = authorName;
        this.localField = localField;
        this.title = title;
        this.mainText = mainText;
        this.vegetable = vegetable;
        this.sellCheck = sellCheck;
        this.dateBuy = dateBuy;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }

    public static List<ContentListResponse> toDtoList(List<VegeContent> tradeList){

        ArrayList<ContentListResponse> transferResponseList = new ArrayList<>();
        for (VegeContent vegeContent : tradeList) {
            ContentListResponse transferResponse = ContentListResponse.builder()
                    .contentId()
                    .authorName()
                    .localField()
                    .title()
                    .mainText()
                    .vegetable()
                    .sellCheck()
                    .dateBuy()
                    .dateCreated()
                    .dateUpdated()
                    .build();

            transferResponseList.add(transferResponse);
        }

        return transferResponseList;
    }

}
