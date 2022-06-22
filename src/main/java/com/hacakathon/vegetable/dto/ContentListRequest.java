package com.hacakathon.vegetable.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class ContentListRequest {

    private String localField;
    private int page;

    @Builder
    public ContentListRequest(String localField, int page){
        this.localField = localField;
        this.page = page;
    }
}
