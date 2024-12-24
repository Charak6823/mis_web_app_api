package com.mis.mis_web_app_api.models.req;

import com.mis.mis_web_app_api.modules.BaseEntity;
import lombok.Data;

import java.util.List;

@Data
public class UserProductGroupReq extends BaseEntity {
    private Integer id;
    private String name;
    private String nameKh;
    private String note;
    private Double price;
    private Double cost;
    private String status;
    private String userAccountId;
    private String shopId;
    private String saleDefault;
    private List<UserProductGroupDetailReq> groupDetailReqList;
}