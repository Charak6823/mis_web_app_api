package com.mis.mis_web_app_api.modules.supplier;

import com.mis.mis_web_app_api.modules.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "suppliers")
@DynamicUpdate

public class Supplier extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="supplierId")
    private int supplierId;

    @Column(name="supplierName", columnDefinition = "NVARCHAR(50)")
    private String supplierName;

    @Column(name="sex", columnDefinition = "NVARCHAR(20)")
    private String sex;

    @Column(name="contactName", columnDefinition = "NVARCHAR(50)")
    private String contactName;

    private String contactPhone;

    @Column(name="address", columnDefinition = "NTEXT")
    private String address;

    @Column(name="description", columnDefinition = "NTEXT")
    private String description;

    
}
