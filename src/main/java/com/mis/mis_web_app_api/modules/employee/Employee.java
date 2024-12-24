package com.mis.mis_web_app_api.modules.employee;

import com.mis.mis_web_app_api.constants.Constants;
import com.mis.mis_web_app_api.modules.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Entity(name="employees")
@Data
public class Employee extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;

    @Column(columnDefinition = "NVARCHAR(255)")
    private String name;

    @Column(columnDefinition = "NVARCHAR(255)")
    private String nameKh;

    @Column(columnDefinition = "NVARCHAR(20)")
    private String sex;

    @Column(columnDefinition = "NVARCHAR(255)")
    private String position;

    @Column(columnDefinition = "NVARCHAR(10)")
    private String phone;

    private String email;

    @Column(columnDefinition = "NTEXT")
    private String address;

    @Column(columnDefinition = "NVARCHAR(25) DEFAULT 'ACT'")
    private String status= Constants.STATUS_ACTIVE;

    @Column(nullable = true)
    private String image;

    @Column(nullable = true)
    private String cv;
}
