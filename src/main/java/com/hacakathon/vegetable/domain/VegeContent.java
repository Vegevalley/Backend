package com.hacakathon.vegetable.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="VEGE_CONTENT")
public class VegeContent {
    @Id
    @Column(name="VEGE_CONTENT_ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long vegeContentId;

    @ManyToOne
    @JoinColumn(name="AUTHOR_ID")
    private User author;

    @Column(name="TITLE")
    private String title;

    @Column(name="MAIN_TEXT", columnDefinition = "LONGTEXT")
    private String mainText;

    @Column(name="DATE_CREATED")
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Column(name="LAST_UPDATED")
    @UpdateTimestamp
    private LocalDateTime updatedDate;

    @Column(name="VEGE")
    private String vegetable;

    @Column(name="SELL_CHECK")
    private boolean sellCheck;

    @Column(name="DATE_BUY")
    private LocalDateTime boughtDate;

    // 지역
    @ManyToOne
    @JoinColumn(name="LOCAL_ID")
    private EMD emd;

    // 댓글
    @OneToMany(mappedBy = "vegeContent")
    private List<Comment> commentList;

    // 이미지
    @OneToMany(mappedBy = "vegeContent")
    private List<ImgInfo> imgInfoList;
}
