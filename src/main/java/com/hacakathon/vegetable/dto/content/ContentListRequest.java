package com.hacakathon.vegetable.dto.content;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class ContentListRequest {

    private String authorization;
    private String localField;
    private int page;

    @Builder
    public ContentListRequest(String authorization, String localField, int page){
        this.authorization = authorization;
        this.localField = localField;
        this.page = page;
    }
}
