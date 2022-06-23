package com.hacakathon.vegetable.domain;

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
@Table(name="VOTE_CONTENT")
public class VoteContent {
    @Id
    @Column(name="GOOD_CONTENT_ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long goodContentId;

    @ManyToOne
    @JoinColumn(name="USER_ID")
    private User user;

    @Column(name="TITLE")
    private String title;

    @Column(name = "MAIN_TEXT", columnDefinition = "LONGTEXT")
    private String mainText;

    @Column(name="DATE_CREATED")
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Column(name="LAST_UPDATED")
    @UpdateTimestamp
    private LocalDateTime updatedDate;
}
