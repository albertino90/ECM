package com.datatehecm.testecm.controllers;

import com.datatehecm.testecm.model.Employee;
import com.datatehecm.testecm.services.EmployeeService;
import com.datatehecm.testecm.services.OrganizationService;
import com.datatehecm.testecm.services.StructuralUnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/organizations")
@RequiredArgsConstructor
public class EmployeeController {

    private final OrganizationService organizationService;
    private final StructuralUnitService structuralUnitService;
    private final EmployeeService employeeService;

    @GetMapping("employees/{id}")
    public String watchEmployee (@PathVariable Long id,Model model){
        model.addAttribute("employee",employeeService.getEmployee(id));
        return "showEmployee";
    }

    @GetMapping("/strunits/{id}/addemployee")
    public String addEmployeeToStrUnit(@PathVariable Long id, Model model) throws Exception {
        Employee employee = new Employee();
        model.addAttribute("strUnit",structuralUnitService.getStructuralUnit(id));
        model.addAttribute("employee",employee);
        return "addEmployee";
    }

    @PostMapping("/addemployee")
    public String addEmployeee(@ModelAttribute("employee") Employee employee) throws Exception {
        employeeService.addEmployee(employee);
        Long redirectId = employee.getStructuralUnit().getId();
        return "redirect:/organizations/strunits/" + redirectId;
    }

        @GetMapping("employee/update/{id}")
    public String updateEmployee (@PathVariable Long id, Model model){
        model.addAttribute("employee", employeeService.getEmployee(id));
        return "updateEmpl";
    }

    @PostMapping("employee/update")
    public String updateEmployee (@ModelAttribute("employee") Employee employee){
        Long redirectId = employee.getStructuralUnit().getId();
        employeeService.update(employee);
        return "redirect:/organizations/strunits/" + redirectId;
    }

    @GetMapping("/employee/delete/{id}")
    public String deleteEmployee(@PathVariable Long id){
        Employee employee = employeeService.getEmployee(id);
        Long redirectId = employee.getStructuralUnit().getId();
        employeeService.delete(id);
        return "redirect:/organizations/strunits/" + redirectId;
    }

    //    Разобраться с директором
//    @GetMapping("/{id}/adddir")
//    public String addEmployeeToOrganization(@PathVariable Long id, Model model) throws Exception {
//        Employee employee = new Employee();
//        model.addAttribute("organization",organizationService.getOrganization(id));
//        model.addAttribute("employee",employee);
//        return "addDirector";
//    }
//    @PostMapping("/adddir")
//    public String addDirEmployee(@ModelAttribute("employee")Employee employee){
//        employeeService.addEmployee(employee);
//        String redirectId = employee.
//    }
}
