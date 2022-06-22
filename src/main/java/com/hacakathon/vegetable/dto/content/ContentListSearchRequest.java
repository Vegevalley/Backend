package com.hacakathon.vegetable.dto.content;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class ContentListSearchRequest {

    private String authorization;
    private String searchText;
    private String localField;
    private int page;

    @Builder
    public ContentListSearchRequest(String authorization, String searchText, String localField, int page){
        this.authorization = authorization;
        this.searchText = searchText;
        this.localField = localField;
        this.page = page;
    }
}
