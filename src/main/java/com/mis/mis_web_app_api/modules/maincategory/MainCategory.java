package com.mis.mis_web_app_api.modules.maincategory;

import com.mis.mis_web_app_api.modules.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "category_mains")
@DynamicUpdate

public class MainCategory extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="categoryMainId")
    private int categoryMainId;

    @Column(name="name",columnDefinition = "NVARCHAR(255)")
    private String name;

    @Column(name="shortName", columnDefinition = "NVARCHAR(255)")
    private String shortName;

    private String status="ACT";
}
