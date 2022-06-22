package com.hacakathon.vegetable.dto.content.vote;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.bind.annotation.RequestBody;

@NoArgsConstructor
@Getter
@ToString
public class VoteContentListRequest {
    private String authorization;
    private int page;

    @Builder
    public VoteContentListRequest(String authorization, int page){
        this.authorization = authorization;
        this.page = page;
    }
}
