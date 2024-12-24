package com.mis.mis_web_app_api.models.req;

import lombok.Data;

@Data
public class RegisterInviteCodeReq {
    private String deviceId;
    private String phoneNumber;
    private String inviteCode;
    private String password;
    private String confirmPassword;
    private String username;
    private String otp;
}
