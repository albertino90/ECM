package com.datatehecm.testecm.repositories;

import com.datatehecm.testecm.model.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AssignmentRepository extends JpaRepository <Assignment, Long> {
    Assignment getById(Long id);

}
