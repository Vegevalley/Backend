package com.hacakathon.vegetable.dto.content.comment;


import com.hacakathon.vegetable.domain.Comment;
import com.hacakathon.vegetable.domain.RecepiContent;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
            CommentListResponse transferResponse = CommentListResponse.builder()
                    .commentId(comment.getCommentId())
                    .authorName(comment.getAuthor().getUserName())
                    .contentId(comment.getVegeContent().getVegeContentId())
                    .recepiId(comment.getRecepiContent().getRecepiContentId())
                    .commentText(comment.getCommentText())
                    .dateCreated(comment.getCreatedDate())
                    .dateUpdated(comment.getUpdatedDate())
                    .build();

            commentResponseList.add(transferResponse);
        }

        return commentResponseList;
    }

}
