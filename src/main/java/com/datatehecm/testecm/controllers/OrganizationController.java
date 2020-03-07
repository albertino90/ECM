package com.datatehecm.testecm.controllers;

import com.datatehecm.testecm.model.Organization;
import com.datatehecm.testecm.model.StructuralUnit;
import com.datatehecm.testecm.services.OrganizationService;
import com.datatehecm.testecm.services.StructuralUnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
//@RestController
@RequiredArgsConstructor
@RequestMapping("/organizations")
public class OrganizationController {

    private final OrganizationService organizationService;
    private final StructuralUnitService structuralUnitService;


    @GetMapping("/all")
    public String getAllOrgs (Model model){
        model.addAttribute("organizations", organizationService.findAll());
        return "organizationsList";
    }

    @GetMapping("/addorg")
    public String addOrganization() {
        return "newOrg";
    }

    @PostMapping("/addorg")
    public String addOrganization(@ModelAttribute("organization")Organization organization) throws Exception {
        organizationService.addOrganization(organization);
        return "redirect:all";
    }

    @GetMapping("/{id}")
    public String getOrgById(@PathVariable Long id, Model model) {
        model.addAttribute("organization",organizationService.getOrganization(id));
        return "showOrg";
    }

    @GetMapping("/delete/{id}")
    public String deleteOrg(@PathVariable Long id ){
        Organization organization = organizationService.getOrganization(id);
        organization.setManager(null);
        organizationService.delete(id);
        return "redirect:" + "/organizations/all";
    }
    @GetMapping("/update/{id}")
    public String updateOrg(@PathVariable Long id, Model model){
        model.addAttribute("organization", organizationService.getOrganization(id));
        return "updateOrg";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute("organization") Organization organization){
        organizationService.update(organization);
        return "redirect:/organizations/all";
    }

    @GetMapping("{id}/addsu")
    public String addStructuralUnit(@PathVariable Long id, Model model){
//        Organization organization = organizationService.getOrganization(id);
//        structuralUnit.setOrganization(organization);
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

    @GetMapping("strunits/delete/{id}")
    public String deleteStructuralUnit(@PathVariable Long id ){
        StructuralUnit structuralUnit = structuralUnitService.getStructuralUnit(id);
        Long redirectId = structuralUnit.getOrganization().getId();
//        structuralUnit.setOrganization(null);
        structuralUnitService.delete(id);

        return "redirect:" + "/organizations/" + redirectId;
    }




}
//    JSON
//    @RequestMapping(value = "/all", method = RequestMethod.GET)
//    public List<Organization> getAuthors() {
//        return organizationService.findAll();
//    }
