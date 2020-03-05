package com.datatehecm.testecm.controllers;



import com.datatehecm.testecm.model.StructuralUnit;
import com.datatehecm.testecm.services.StructuralUnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
//обрати внимание на окончания атрибутов моделей
@Controller
@RequestMapping("/strunits")
@RequiredArgsConstructor
public class StructuralUnitController {

    private final StructuralUnitService structuralUnitService;

    @GetMapping("/all")
    public String getAllStrUnits(Model model){
        model.addAttribute("structuralUnits", structuralUnitService.findAll());
        return "strUnitsList";
    }

    @GetMapping("/addsu")
    public String addStrUnit() {
        return "addStructuralUnit";
    }

    @PostMapping("/addsu")
    public String addStrUnit(@ModelAttribute("structuralUnit") StructuralUnit structuralUnit) throws Exception {
        structuralUnitService.addStructuralUnit(structuralUnit);
        return "redirect:/strunits/all";
    }
//    нет шаблона
    @GetMapping("/{id}")
    public String getStrUnitById(@PathVariable Long id, Model model) {
        model.addAttribute("strunit",structuralUnitService.getStructuralUnit(id));
        return "showStrUnit";
    }

    @GetMapping("/delete/{id}")
    public String deleteStrUnit(@PathVariable Long id ){
        structuralUnitService.delete(id);
        return "redirect:/strunits/all";
    }
    @GetMapping("/update/{id}")
    public String updateStrUnit(@PathVariable Long id, Model model){
        model.addAttribute("strunits", structuralUnitService.getStructuralUnit(id));
        return "updateStrUnit";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute("strunit") StructuralUnit structuralUnit){
        structuralUnitService.update(structuralUnit);
        return "redirect:/strunits/all";
    }







}
