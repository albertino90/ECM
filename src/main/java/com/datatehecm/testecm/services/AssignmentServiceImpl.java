package com.datatehecm.testecm.services;


import com.datatehecm.testecm.model.Assignment;
import com.datatehecm.testecm.repositories.AssignmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssignmentServiceImpl implements AssignmentService {

    private final AssignmentRepository assignmentRepository;

    @Override
    public Assignment getAssignment(Long id) {
        return assignmentRepository.getById(id);
    }

    @Override
    public List<Assignment> findAll() {
        return assignmentRepository.findAll();
    }

    @Override
    public Assignment addAssignment(Assignment assignment) {
        return assignmentRepository.saveAndFlush(assignment);
    }

    @Override
    public void delete(Long id) {
        assignmentRepository.deleteById(id);
    }

    @Override
    public Assignment update(Assignment assignment) {
        return assignmentRepository.saveAndFlush(assignment);
    }
}
