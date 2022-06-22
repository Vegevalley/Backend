package com.hacakathon.vegetable.dto.content.recepi;


import com.hacakathon.vegetable.domain.ImgInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Getter
@ToString
public class RecepiContentDto {

    private Long contentId;

    private String authorName;

    private String title;

    private String mainText;

    private Image image;

    private LocalDateTime dateCreated;

    private LocalDateTime dateUpdated;

    @Builder
    public RecepiContentDto(Long contentId, String authorName, String title, String mainText,
                            LocalDateTime dateCreated, LocalDateTime dateUpdated){
        this.contentId = contentId;
        this.authorName = authorName;
        this.title = title;
        this.mainText = mainText;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }
}
