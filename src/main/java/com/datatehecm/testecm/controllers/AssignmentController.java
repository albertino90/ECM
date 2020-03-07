package com.datatehecm.testecm.controllers;


import com.datatehecm.testecm.model.Assignment;
import com.datatehecm.testecm.services.AssignmentService;
import com.datatehecm.testecm.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/organizations")
@RequiredArgsConstructor
public class AssignmentController {

    private final AssignmentService assignmentService;
    private final EmployeeService employeeService;

    @GetMapping("employees/{id}/addassignment")
    public String addAssignt(@PathVariable Long id, Model model){
        employeeService.getEmployee(id);
        Assignment assignment = new Assignment();
        model.addAttribute("employee", employeeService.getEmployee(id));
        model.addAttribute(assignment);
        return "newAssignment";
    }
//todo Все что связанно с поручениями, подключить Spring state Machine
//    @PostMapping


}
