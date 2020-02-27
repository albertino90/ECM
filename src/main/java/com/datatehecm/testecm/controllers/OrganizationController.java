package com.datatehecm.testecm.controllers;

import com.datatehecm.testecm.model.StructuralUnit;
import com.datatehecm.testecm.repositories.OrganizationRepository;
import com.datatehecm.testecm.repositories.StructuralUnitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class OrganizationController {

    OrganizationRepository organizationRepository;

    @GetMapping("/allorg")
    public String getAllUsers(Model model){
        model.addAttribute("organizations", organizationRepository.findAll());
        return "organizationsList";
    }

}
