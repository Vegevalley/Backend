package com.hacakathon.vegetable.domain;


import lombok.*;

import javax.persistence.*;
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
    private String userID;

    @Column(name="USER_NAME", unique = true)
    private String userName;

    @Column(name="PASSWORD")
    private String password;

    @Column(name="ROLE")
    private String role;

    @Column(name="GOOD_VOTE")
    private long goodVote;

    @Column(name="PHONE_NUM", unique = true)
    private String phoneNumber;

    @OneToMany(mappedBy = "user")
    private List<VoteContent> voteContentList;
}
