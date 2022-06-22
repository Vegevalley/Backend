package com.hacakathon.vegetable.dto;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.catalina.User;

@Getter
@NoArgsConstructor
@ToString
public class UserChangePasswordRequest {

    @NotNull
    String jwtToken;

    @NotNull
    String password;

    @Builder
    public UserChangePasswordRequest(String jwtToken, String password){
        this.jwtToken = jwtToken;
        this. password = password;
    }
}
