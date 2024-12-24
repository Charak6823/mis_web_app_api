package com.mis.mis_web_app_api.models.req;

import com.mis.mis_web_app_api.modules.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class UserProductGroupDetailReq extends BaseEntity {
    private Integer id;
    private Integer productUnitId;
    private Integer productGroupId;
    private String status;
}