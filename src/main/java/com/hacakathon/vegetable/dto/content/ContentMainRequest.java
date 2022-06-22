package com.hacakathon.vegetable.dto.content;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class ContentMainRequest {

    private String authorization;

    private long contentId;

    @Builder
    public ContentMainRequest(String authorization, long contentId){
        this.authorization = authorization;
        this.contentId = contentId;
    }
}
