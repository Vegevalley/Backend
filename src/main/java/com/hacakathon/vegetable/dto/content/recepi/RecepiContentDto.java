package com.hacakathon.vegetable.dto.content.recepi;


import com.hacakathon.vegetable.dto.content.comment.CommentListResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Getter
@ToString
public class RecepiContentDto {

    private Long contentId;

    private String authorName;

    private String title;

    private String mainText;

    private LocalDateTime dateCreated;

    private LocalDateTime dateUpdated;

    private List<CommentListResponse> commentListResponseList;

    @Builder
    public RecepiContentDto(Long contentId, String authorName, String title, String mainText,
                            LocalDateTime dateCreated, LocalDateTime dateUpdated, List<CommentListResponse> commentListResponseList){
        this.contentId = contentId;
        this.authorName = authorName;
        this.title = title;
        this.mainText = mainText;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.commentListResponseList = commentListResponseList;
    }
}
