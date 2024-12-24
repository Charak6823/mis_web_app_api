package com.mis.mis_web_app_api.modules.company;

import com.mis.mis_web_app_api.modules.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicUpdate;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "companies")
@DynamicUpdate
public class Company extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="companyId")
    private int companyId;

    @Column(name="companyName",columnDefinition = "NVARCHAR")
    private String companyName;

    @Column(name="description", columnDefinition = "NVARCHAR")
    private String description;

    @Column(name="status")
    private String status;
}
