package com.hacakathon.vegetable.dto.content.vote;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Getter
public class VoteContentCreateRequest {

    private String authorization;
    private String userName;
    private String title;
    private String mainText;

    @Builder
    public VoteContentCreateRequest(String authorization, String userName, String title, String mainText){
        this.authorization = authorization;
        this.userName = userName;
        this.title = title;
        this.mainText = mainText;
    }
}
