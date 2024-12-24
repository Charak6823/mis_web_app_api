package com.mis.mis_web_app_api.modules.employee;

import lombok.Data;

@Data
public class EmployeeDTO {
    private int employeeId;
    private String name;
    private String nameKh;
    private String sex;
    private String position;
    private String phone;
    private String email;
    private String address;
    private String status;
    private String image;
    private String cv;
}
