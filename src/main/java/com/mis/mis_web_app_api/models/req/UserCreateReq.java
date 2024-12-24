package com.mis.mis_web_app_api.models.req;

import com.mis.mis_web_app_api.models.Role;
import lombok.Data;

import java.util.List;

@Data
public class UserCreateReq {
    private Integer id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String phoneNumber;
    private String password;
    private String confirmPassword;
    private String profile;
    private List<Role> role;
}
