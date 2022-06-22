package com.hacakathon.vegetable.dto.content.comment;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.bind.annotation.RequestBody;


@Getter
@NoArgsConstructor
@ToString
public class CommentListRequest {

    private String authorization;
    private long contentId;

    @Builder
    public CommentListRequest(String authorization, long contentId){
        this.authorization = authorization;
        this.contentId = contentId;
    }
}
