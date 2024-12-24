package com.mis.mis_web_app_api.models.req;

import lombok.Data;

@Data
public class ForgetPasswordReq {
    private String deviceId;
    private String phoneNumber;
    private String oldPassword;
    private String password;
    private String confirmPassword;
    private String otp;
}
