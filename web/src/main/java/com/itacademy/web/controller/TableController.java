package com.itacademy.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TableController {

    @GetMapping("/tableinput")
    public String getPage(){
        return "tableinput";
    }
}
