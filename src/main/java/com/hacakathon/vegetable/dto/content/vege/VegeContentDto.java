package com.hacakathon.vegetable.dto.content.vege;

import com.hacakathon.vegetable.dto.content.comment.CommentListResponse;
import lombok.Builder;
import lombok.Getter;
import org.apache.tomcat.jni.Local;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class VegeContentDto {
    private Long contentId;

    private String authorName;

    private String title;

    private String mainText;

    private LocalDateTime dateCreated;

    private LocalDateTime dateUpdated;

    private boolean sellCheck;

    private LocalDateTime dateBuyed;

    private List<CommentListResponse> commentListResponseList;

    @Builder
    public VegeContentDto(Long contentId, String authorName, String title, String mainText,
                            LocalDateTime dateCreated, LocalDateTime dateUpdated, boolean sellCheck, LocalDateTime dateBuyed, List<CommentListResponse> commentListResponseList){
        this.contentId = contentId;
        this.authorName = authorName;
        this.title = title;
        this.mainText = mainText;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.sellCheck = sellCheck;
        this.dateBuyed = dateBuyed;
        this.commentListResponseList = commentListResponseList;
    }
}
