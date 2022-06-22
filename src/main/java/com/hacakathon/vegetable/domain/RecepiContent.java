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
@Table(name="recepi_content")
public class RecepiContent {
    @Id
    @Column(name="RECEPI_CONTENT_ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long recepiContentId;

    @ManyToOne
    @JoinColumn(name="AUTHOR_ID")
    private User author;

    @Column(name="TITLE")
    private String title;

    @Column(name="MAIN_TEXT")
    private String mainText;

    @Column(name="DATE_CREATED")
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Column(name="LAST_UPDATED")
    @UpdateTimestamp
    private LocalDateTime updatedDate;

    @OneToMany(mappedBy = "recepiContent")
    private List<ImgInfo> imgInfoList;

    @OneToMany(mappedBy = "recepiContent")
    private List<Comment> commentList;
}
