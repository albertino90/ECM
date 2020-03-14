package com.datatehecm.testecm.repositories;

import com.datatehecm.testecm.model.Employee;
import com.datatehecm.testecm.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee getById(Long id);


    @Query("select u from Employee u where u.organization = :organization")
    List<Employee> findAllOrganizationEmployees (@Param("organization") Organization organization);

}
