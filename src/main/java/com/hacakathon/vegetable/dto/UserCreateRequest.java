package com.hacakathon.vegetable.dto;


import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class UserCreateRequest {

    @NotNull
    private String userId;

    @NotNull
    private String password;

    @NotNull
    private String userName;

    @NotNull
    private String localField;

    @NotNull
    private String phoneNum;

    @Builder
    public UserCreateRequest(String userId, String password, String userName, String localField, String phoneNum){
        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.localField = localField;
        this.phoneNum = phoneNum;
    }
}
