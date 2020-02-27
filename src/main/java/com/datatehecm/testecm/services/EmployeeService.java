package com.datatehecm.testecm.services;

import com.datatehecm.testecm.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee getEmployee(Long id);
    List<Employee> findAll();
    Employee addEmployee (Employee employee);
    void delete(Long id);
    Employee update(Employee employee);
}
