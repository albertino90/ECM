package com.datatehecm.testecm.services;

import com.datatehecm.testecm.model.Assignment;

import java.util.List;

public interface AssignmentService {

    Assignment getAssignment(Long id);
    List<Assignment> findAll();
    Assignment addAssignment (Assignment assignment);
    void delete(Long id);
    Assignment update(Assignment assignment);

}
