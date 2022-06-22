package com.hacakathon.vegetable.dto.content.recepi;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@ToString
public class RecepiContentCreateRequest {
    private String authorization;
    private String authorName;
    private String title;
    private String mainText;
    private LocalDateTime dateCreate;
    private LocalDateTime dateUpdated;

    @Builder
    public RecepiContentCreateRequest(String authorization, String authorName, String title, String mainText,
                                      LocalDateTime dateCreate, LocalDateTime dateUpdated){
        this.authorization = authorization;
        this.authorName = authorName;
        this.title = title;
        this.mainText = mainText;
        this.dateCreate = dateCreate;
        this.dateUpdated = dateUpdated;
    }
}
