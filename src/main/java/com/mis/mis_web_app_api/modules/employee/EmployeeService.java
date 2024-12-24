package com.mis.mis_web_app_api.modules.employee;

import com.mis.mis_web_app_api.exceptions.ApiException;

import java.util.List;

public interface EmployeeService {
    List<Employee> index();
    Employee store(Employee employee) throws ApiException;
    Employee show(int id);
    Employee update(int id, Employee employee);
    void destroy(int id, Employee employee);
    void permanentlyDestroy(int id);
}
