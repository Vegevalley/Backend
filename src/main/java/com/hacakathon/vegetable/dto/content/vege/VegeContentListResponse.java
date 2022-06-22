package com.hacakathon.vegetable.dto.content.vege;


import com.hacakathon.vegetable.domain.VegeContent;
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
public class VegeContentListResponse {

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
    public VegeContentListResponse(Long contentId, String authorName, String localField, String title, String mainText, String vegetable, Boolean sellCheck,
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

    public static List<VegeContentListResponse> toDtoList(List<VegeContent> vegeContentList){

        ArrayList<VegeContentListResponse> vegeResponseList = new ArrayList<>();
        for (VegeContent vegeContent : vegeContentList) {
            VegeContentListResponse transferResponse = VegeContentListResponse.builder()
                    .contentId(vegeContent.getVegeContentId())
                    .authorName(vegeContent.getAuthor().getUserName())
                    .localField(vegeContent.getEmd().getEmdName())
                    .title(vegeContent.getTitle())
                    .mainText(vegeContent.getMainText())
                    .vegetable(vegeContent.getVegetable())
                    .sellCheck(vegeContent.isSellCheck())
                    .dateBuy(vegeContent.getBoughtDate())
                    .dateCreated(vegeContent.getCreatedDate())
                    .dateUpdated(vegeContent.getUpdatedDate())
                    .build();

            vegeResponseList.add(transferResponse);
        }

        return vegeResponseList;
    }

}
