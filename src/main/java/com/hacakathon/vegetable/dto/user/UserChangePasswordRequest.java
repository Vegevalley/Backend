package com.hacakathon.vegetable.dto.user;

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
    String password;

    @Builder
    public UserChangePasswordRequest(String jwtToken, String password){
        this. password = password;
    }
}
