package com.datatehecm.testecm.repositories;

import com.datatehecm.testecm.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee getById(Long id);

}
