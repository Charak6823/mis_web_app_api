package com.mis.mis_web_app_api.payload.response;

import com.mis.mis_web_app_api.models.User;
import lombok.Data;
import lombok.Setter;

@Data
public class JwtRes {
    private String accessToken;
    private String tokenType = "Bearer";
    private String refreshToken;
    private int expiresIn;

    public void setUser(User user) {
    }
}
