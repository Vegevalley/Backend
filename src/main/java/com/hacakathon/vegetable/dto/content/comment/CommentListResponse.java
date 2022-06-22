package com.hacakathon.vegetable.dto.content.comment;


import com.hacakathon.vegetable.domain.Comment;
import com.hacakathon.vegetable.domain.RecepiContent;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@NoArgsConstructor
@ToString
public class CommentListResponse {

    private long commentId;

    private String authorName;

    private long contentId;

    private long recepiId;

    private String commentText;

    private LocalDateTime dateCreated;

    private LocalDateTime dateUpdated;


    @Builder
    public CommentListResponse(long commentId, String authorName, long contentId, long recepiId, String commentText,
                               LocalDateTime dateCreated, LocalDateTime dateUpdated){
        this.commentId = commentId;
        this.authorName = authorName;
        this.contentId = contentId;
        this.recepiId = recepiId;
        this.commentText = commentText;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }

    public static List<CommentListResponse> toDtoList(List<Comment> commentList){

        ArrayList<CommentListResponse> commentResponseList = new ArrayList<>();
        for (Comment comment : commentList) {
            if (Objects.isNull(comment.getRecepiContent())) {
                CommentListResponse transferResponse = CommentListResponse.builder()
                        .commentId(comment.getCommentId())
                        .authorName(comment.getAuthor().getUserName())
                        .contentId(comment.getVegeContent().getVegeContentId())
                        .recepiId(1)
                        .commentText(comment.getCommentText())
                        .dateCreated(comment.getCreatedDate())
                        .dateUpdated(comment.getUpdatedDate())
                        .build();

                commentResponseList.add(transferResponse);
            }
            if (Objects.isNull(comment.getVegeContent())) {
                CommentListResponse transferResponse = CommentListResponse.builder()
                        .commentId(comment.getCommentId())
                        .authorName(comment.getAuthor().getUserName())
                        .contentId(1)
                        .recepiId(comment.getRecepiContent().getRecepiContentId())
                        .commentText(comment.getCommentText())
                        .dateCreated(comment.getCreatedDate())
                        .dateUpdated(comment.getUpdatedDate())
                        .build();

                commentResponseList.add(transferResponse);
            }
        }

        return commentResponseList;
    }

}
