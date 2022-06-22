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
@Table(name="user")
public class User {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="LOCAL_ID")
    private EMD emd;

    @Column(name="USER_ID", unique = true)
    private String userId;

    @Column(name="USER_NAME", unique = true)
    private String userName;

    @Column(name="PASSWORD")
    private String password;

    @Column(name="DATE_CREATED")
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Column(name="LAST_UPDATED")
    @UpdateTimestamp
    private LocalDateTime updatedDate;

    @Column(name="ROLE")
    private String role;

    @Column(name="GOOD_VOTE")
    private long goodVote;

    @Column(name="PHONE_NUM", unique = true)
    private String phoneNumber;

    @OneToMany(mappedBy = "user")
    private List<VoteContent> voteContentList;

    @Column(name="DATE_CREATED")
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Column(name="LAST_UPDATED")
    @UpdateTimestamp
    private LocalDateTime updatedDate;
}
