package com.poly.lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// http://localhost:8080/l2b1ctrl/ok-form

@Controller
@RequestMapping("/l2b1ctrl")

public class B1OkController {
    // Hiển thị form ban đầu (chỉ hiện "?")
    @RequestMapping("/ok-form")
    public String form(Model model) {
        model.addAttribute("methodName", "?");
        return "B1ok"; // không set methodName
    }

    // OK 1 → POST /ctrl/ok
    @PostMapping("/ok")
    public String m1(Model model) {
        model.addAttribute("methodName", "m1()");
        return "B1ok";
    }

    // OK 2 → GET /ctrl/ok
    @GetMapping("/ok")
    public String m2(Model model) {
        model.addAttribute("methodName", "m2()");
        return "B1ok";
    }

    // OK 3 → POST /ctrl/ok?x
    @PostMapping(value = "/ok", params = "x")
    public String m3(Model model) {
        model.addAttribute("methodName", "m3()");
        return "B1ok";
    }
}
