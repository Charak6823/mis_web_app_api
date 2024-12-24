package com.mis.mis_web_app_api.models.req;

import lombok.Data;

@Data
public class BaseUserReq {
    private Integer id;
    private String userAccountId;
    private String shopId;
    private String deviceId;
    private String status;

    private Integer outletId;

}
