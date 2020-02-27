package com.datatehecm.testecm.controllers;

import com.datatehecm.testecm.model.Assignment;
import com.datatehecm.testecm.services.AssignmentService;
import com.datatehecm.testecm.services.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AssignmentController {

    private final AssignmentService assignmentService;
    private final OrganizationService organizationService;

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
//        model.addAttribute("account",accountService.getAccount(id));
//        Message message = new Message(text, tag, user);
//
//        messageRepo.save(message);
//
//        Iterable<Message> messages = messageRepo.findAll();
//
//        model.put("messages", messages);
        return "showAssignment";
    }

    @GetMapping("/delete/{id}")
    public String deleteAssignment(@PathVariable Long id ){
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
