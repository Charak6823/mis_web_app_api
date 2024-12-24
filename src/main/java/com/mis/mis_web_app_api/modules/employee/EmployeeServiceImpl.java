package com.mis.mis_web_app_api.modules.employee;

import com.mis.mis_web_app_api.exceptions.ApiException;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public List<Employee> index() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee store(Employee employee) throws ApiException {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee show(int id) {
        return employeeRepository.findById(id).orElseThrow(
                ()->new EntityNotFoundException("Data is not found!"));

    }

    @Override
    public Employee update(int id, Employee employee) {
        return null;
    }

    @Override
    public void destroy(int id, Employee employee) {

    }

    @Override
    public void permanentlyDestroy(int id) {

    }

}

