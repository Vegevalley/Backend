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

    private String author;
    private String contentId;
    private String recepiId;
    private String commentText;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;

    @Builder
    public CommentCreateRequest(String author, String contentId, String recepiId, String commentText,
                                LocalDateTime dateCreated, LocalDateTime dateUpdated
    ){
        this.author = author;
        this.contentId = contentId;
        this.recepiId = recepiId;
        this.commentText = commentText;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }
}