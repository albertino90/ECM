package com.datatehecm.testecm.controllers;


import com.datatehecm.testecm.model.Assignment;
import com.datatehecm.testecm.model.Employee;
import com.datatehecm.testecm.services.AssignmentService;
import com.datatehecm.testecm.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/organizations")
@RequiredArgsConstructor
public class AssignmentController {

    private final AssignmentService assignmentService;
    private final EmployeeService employeeService;

    @GetMapping("/assignment/{id}")
    public String watchAssign(@PathVariable Long id, Model model){
        model.addAttribute("assignment",assignmentService.getAssignment(id));
        return "showAssignment";
    }


    @GetMapping("employees/{id}/addassignment")
    public String addAssignt(@PathVariable Long id, Model model){
        Employee employee = employeeService.getEmployee(id);
        List<Employee> employee_contractors = employeeService.findAllEmplByOrganization(employee);
        employee_contractors.remove(employee);
        model.addAttribute("employee", employeeService.getEmployee(id));
        model.addAttribute(new Assignment());
        model.addAttribute("employee_contractor", employee_contractors);
        return "newAssignment";
    }

    @PostMapping("/addassignment")
    public String addAssignt(@ModelAttribute("assignment") Assignment assignment){
        assignmentService.addAssignment(assignment);
        Long redirectId = assignment.getAuthor().getId();
        return "redirect:/organizations/employees/" + redirectId;
    }


    @GetMapping("/assignment/update/{id}")
    public String updateAssign(@PathVariable Long id, Model model){
        List<Employee> employee_contractors = employeeService.findAllEmplByOrganization(employeeService.getEmployee(id));
        model.addAttribute("employee_contractor", employee_contractors);
        model.addAttribute("assignment", assignmentService.getAssignment(id));
        return "updateAssignment";
    }

    @PostMapping("assignment/update")
    public String updateAssign(@ModelAttribute("assignment") Assignment assignment){
        Long redirectId = assignment.getAuthor().getId();
        assignmentService.update(assignment);
        return "redirect:/organizations/employees/" + redirectId;
    }


    @GetMapping("/assignment/delete/{id}")
    public String delAssignment(@PathVariable Long id){
        Assignment assignment = assignmentService.getAssignment(id);
        Long redirectId = assignment.getAuthor().getId();
        assignment.setEmployee_contractor(null);
        assignmentService.delete(id);
        return "redirect:/organizations/employees/" + redirectId;
    }


}
