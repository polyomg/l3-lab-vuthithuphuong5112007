package com.poly.lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// http://localhost:8080/param/form
@Controller
public class B2ParamController {
    @RequestMapping("/param/form")
    public String form() {
        return "b2form";
    }
    @RequestMapping("/param/save/{x}")
    public String save(
            @PathVariable("x") String x, // biến đường dẫn
            @RequestParam("y") String y, // tham số y sau ?
            Model model) {
        model.addAttribute("x", x);
        model.addAttribute("y", y);
        return "b2form";
    }
}
