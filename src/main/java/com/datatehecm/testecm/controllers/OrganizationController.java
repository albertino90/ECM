package com.datatehecm.testecm.controllers;

import com.datatehecm.testecm.model.Organization;
import com.datatehecm.testecm.services.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequiredArgsConstructor
@RequestMapping("/organizations")
public class OrganizationController {

    private final OrganizationService organizationService;


    @GetMapping(value = {"/all","/"})
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
}

