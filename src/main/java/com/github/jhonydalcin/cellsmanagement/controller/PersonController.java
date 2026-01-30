package com.github.jhonydalcin.cellsmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonController {

    @GetMapping("/")
    public String person(){
        return "layout";
    }

}
