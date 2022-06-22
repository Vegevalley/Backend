package domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="comment")
public class Comment {
    @Id
    @Column(name="COMMENT_ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long commentId;

    @ManyToOne
    @JoinColumn(name="AUTHOR_ID")
    private User author;

    // 게시글
    @ManyToOne
    @JoinColumn(name="CONTENT_ID")
    private VegeContent vegeContent;

    // 레시피 게시글
    @ManyToOne
    @JoinColumn(name="RECEPI_ID")
    private RecepiContent recepiContent;

    @Column(name="COMMENT_TEXT")
    private String commentText;

    @Column(name="DATE_CREATED")
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Column(name="LAST_UPDATED")
    @UpdateTimestamp
    private LocalDateTime updatedDate;
}
