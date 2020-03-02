package com.datatehecm.testecm.controllers;


import com.datatehecm.testecm.model.Assignment;
import com.datatehecm.testecm.services.AssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/assign")
@RequiredArgsConstructor
public class AssignmentController {

    private final AssignmentService assignmentService;

    @GetMapping("/all")
    public String getAllAssignments(Model model){
        model.addAttribute("assignments", assignmentService.findAll());
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

    @GetMapping("/{id}")
    public String getAssignmentById(@PathVariable Long id, Model model) {
        model.addAttribute("assignment",assignmentService.getAssignment(id));
        return "showAssignment";
    }

    @GetMapping("/delete/{id}")
    public String deleteAssignment(@PathVariable Long id ){
//        Contact contact = contactRepository.findOne(id);
//        contactRepository.delete(contact);
//        assignmentService.delete(id);
        Assignment assignment = assignmentService.getAssignment(id);
        assignmentService.delete(id);
        return "redirect:/all";
    }
    @GetMapping("/update/{id}")
    public String updateAssignment(@PathVariable Long id, Model model){
        model.addAttribute("assignment", assignmentService.getAssignment(id));
        return "updateAssignment";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute("assignment") Assignment assignment){
        assignmentService.update(assignment);
        return "redirect:/all";
    }







}
