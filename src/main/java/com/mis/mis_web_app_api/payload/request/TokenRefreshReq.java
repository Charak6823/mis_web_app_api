package com.mis.mis_web_app_api.payload.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TokenRefreshReq {
    private String refreshToken;

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
