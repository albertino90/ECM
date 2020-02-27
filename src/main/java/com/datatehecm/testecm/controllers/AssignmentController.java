package com.datatehecm.testecm.controllers;

import com.datatehecm.testecm.model.Assignment;
import com.datatehecm.testecm.services.AssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AssignmentController {

    private final AssignmentService assignmentService;

    @GetMapping("/all")
    public String getAllAssignments(Model model){
        model.addAttribute("assignments", assignmentService.findAll());
        System.out.println(assignmentService.findAll());

        return "assignmentList";
    }

    @GetMapping("/addassignment")
    public String addAssignment() {
        return "newAssignment";
    }

    @PostMapping("/addassignment")
    public String addAssignment(@ModelAttribute("assignment") Assignment assignment) throws Exception {
        assignmentService.addAssignment(assignment);
        return "redirect:/all";
    }







}
