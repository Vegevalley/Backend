package com.hacakathon.vegetable.dto;


import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class UserGetInfoResponse {

    @NotNull
    private String userId;

    @NotNull
    private String userName;

    @NotNull
    private String phoneNum;

    @NotNull
    private String vote;

    @Builder
    public UserGetInfoResponse(String userId, String userName, String phoneNum, String vote) {
        this.userId = userId;
        this.userName = userName;
        this.phoneNum = phoneNum;
        this. vote = vote;

    }


}
