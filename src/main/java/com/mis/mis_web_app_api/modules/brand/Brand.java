package com.mis.mis_web_app_api.modules.brand;


import com.mis.mis_web_app_api.modules.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicUpdate;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "brands")
@DynamicUpdate
public class Brand extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brandId")
    private int brandId;

    @Column(name = "brandName", columnDefinition = "NVARCHAR(255)")
    private String brandName;

    @Column(name = "shortName", columnDefinition = "NVARCHAR(255)")
    private String shortName;

    private String status = "ACT";

    @Column(name = "image")
    private String image;

}
