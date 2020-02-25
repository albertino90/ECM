package com.datatehecm.testecm.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequiredArgsConstructor
public class EmployeeController {

    @GetMapping("/")
    public String index(){
        return "hello";
    }

}
