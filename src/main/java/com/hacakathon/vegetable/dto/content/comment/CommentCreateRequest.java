package com.hacakathon.vegetable.dto.content.comment;


import com.hacakathon.vegetable.domain.Comment;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.tomcat.jni.Local;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@ToString
public class CommentCreateRequest {
    private String authorization;

    private String author;
    private long contentId;
    private long recepiId;
    private String commentText;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;

    @Builder
    public CommentCreateRequest(String author, long recepiId, String commentText,
                                LocalDateTime dateCreated, LocalDateTime dateUpdated
    ){
        this.authorization = authorization;
        this.author = author;
        this.recepiId = recepiId;
        this.commentText = commentText;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }
}
