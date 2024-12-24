package com.mis.mis_web_app_api.models.req;

import lombok.Data;

@Data
public class UserBusinessReq {
    private int id;
    private String userBusinessId;
    private String userAccountId;
    private String shopId;
    private String type;
    private String status;

}
