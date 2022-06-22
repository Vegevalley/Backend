package com.hacakathon.vegetable.dto.content.vege;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.tomcat.jni.Local;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@ToString
public class VegeContentDto {

    private Long contentId;

    private String authorName;

    private String title;

    private String mainText;

    private LocalDateTime dateCreated;

    private LocalDateTime dateUpdated;

    private String vegetable;

    private boolean sellCheck;

    private LocalDateTime boughtDate;

    private String localField;


    @Builder
    public VegeContentDto(Long contentId, String authorName, String title, String mainText, LocalDateTime dateCreated,
                          LocalDateTime dateUpdated, String vegetable, boolean sellCheck, LocalDateTime boughtDate,
                          String localField){
        this.contentId = contentId;
        this.authorName = authorName;
        this.vegetable = vegetable;
        this.title = title;
        this.sellCheck = sellCheck;
        this.mainText = mainText;
        this.boughtDate = boughtDate;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.localField = localField;
    }
}
