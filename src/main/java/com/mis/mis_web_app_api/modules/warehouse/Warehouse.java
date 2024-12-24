package com.mis.mis_web_app_api.modules.warehouse;

import com.mis.mis_web_app_api.constants.Constants;
import com.mis.mis_web_app_api.modules.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicUpdate;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "warehouses")
@DynamicUpdate
public class Warehouse extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="warehouseId")
    private int warehouseId;

    @Column(name="warehouseCode",columnDefinition = "NVARCHAR")
    private String warehouseCode;

    @Column(name="warehouseName", columnDefinition = "NVARCHAR")
    private String warehouseName;

    @Column(name="ownerName", columnDefinition = "NVARCHAR(255)")
    private String ownerName;

    @Column(name="phone", columnDefinition = "NVARCHAR(255)")
    private String phone;

    private String status= Constants.STATUS_ACTIVE;

    @Column(name="tax")
    private boolean tax=false;

}
