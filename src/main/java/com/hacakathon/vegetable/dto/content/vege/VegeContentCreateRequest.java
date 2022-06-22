package com.hacakathon.vegetable.dto.content.vege;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@ToString
public class VegeContentCreateRequest {

    private String authorization;

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
    public VegeContentCreateRequest(String authorization, String authorName, String localField, String title, String mainText, String vegetable, Boolean sellCheck,
                                   LocalDateTime dateBuy, LocalDateTime dateCreated, LocalDateTime dateUpdated){
        this.authorization = authorization;
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

}
