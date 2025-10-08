package com.poly.lab4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// http://localhost:8080/home/index
// http://localhost:8080/home/about

@Controller
public class B4_5HomeController {
    @RequestMapping("/home/index")
    public String index() {
        return "b4home/index";
    }

    @RequestMapping("/home/about")
    public String about() {
        return "b4home/about";
    }
}
