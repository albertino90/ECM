package com.datatehecm.testecm.controllers;



import com.datatehecm.testecm.model.StructuralUnit;
import com.datatehecm.testecm.services.OrganizationService;
import com.datatehecm.testecm.services.StructuralUnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/organizations")
@RequiredArgsConstructor
public class StructuralUnitController {

    private final StructuralUnitService structuralUnitService;
    private final OrganizationService organizationService;

    @GetMapping("strunits/{id}")
    public String getAllStrUnitEmployees(@PathVariable Long id,Model model){
        model.addAttribute("strUnit",structuralUnitService.getStructuralUnit(id));
        return "showStrUnit";
    }

    @GetMapping("{id}/addsu")
    public String addStructuralUnit(@PathVariable Long id, Model model){
        StructuralUnit structuralUnit = new StructuralUnit();
        model.addAttribute("organization",organizationService.getOrganization(id));
        model.addAttribute("strUnit",structuralUnit);
        return "addStructuralUnit";
    }

    @PostMapping("/addsu")
    public String addStrUnit(@ModelAttribute("organization") StructuralUnit structuralUnit) throws Exception {
        structuralUnitService.addStructuralUnit(structuralUnit);
        Long redirectId = structuralUnit.getOrganization().getId();
        return "redirect:/organizations/" + redirectId;
    }

    @GetMapping("strunits/update/{id}")
    public String updateOrg(@PathVariable Long id, Model model){
        model.addAttribute("strUnit", structuralUnitService.getStructuralUnit(id));
        return "updateStrUnit";
    }
    @PostMapping("strunits/update")
    public String update(@ModelAttribute("strUnit") StructuralUnit structuralUnit){
        Long redirectId = structuralUnit.getOrganization().getId();
        structuralUnitService.update(structuralUnit);
        return "redirect:/organizations/" + redirectId;
    }

    @GetMapping("strunits/delete/{id}")
    public String deleteStructuralUnit(@PathVariable Long id ){
        StructuralUnit structuralUnit = structuralUnitService.getStructuralUnit(id);
        Long redirectId = structuralUnit.getOrganization().getId();
        structuralUnitService.delete(id);
        return "redirect:" + "/organizations/" + redirectId;
    }







}
