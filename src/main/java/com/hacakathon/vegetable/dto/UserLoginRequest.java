package com.hacakathon.vegetable.dto;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class UserLoginRequest {
    @NotNull
    private String userId;

    @NotNull
    private String password;

    @Builder
    public UserLoginRequest(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }
}
