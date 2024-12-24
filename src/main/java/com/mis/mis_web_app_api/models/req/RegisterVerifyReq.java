package com.mis.mis_web_app_api.models.req;

import lombok.Data;

@Data
public class RegisterVerifyReq {
    private String deviceId;
    private String phoneNumber;
    private String otp;
}
