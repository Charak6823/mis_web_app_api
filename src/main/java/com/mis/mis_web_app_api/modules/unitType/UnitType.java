package com.mis.mis_web_app_api.modules.unitType;

import com.mis.mis_web_app_api.modules.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicUpdate;
import com.mis.mis_web_app_api.constants.Constants;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "unit_types")
@DynamicUpdate

public class UnitType extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="unitTypeId")
    private int unitTypeId;

    @Column(name="unitTypeName", columnDefinition="NVARCHAR(50)")
    private String unitTypeName;

    @Column(name="unitTypeNameKh",columnDefinition = "NVARCHAR(50)")
    private String unitTypeNameKh;

    private int qty;
    private boolean unitQty;
}
