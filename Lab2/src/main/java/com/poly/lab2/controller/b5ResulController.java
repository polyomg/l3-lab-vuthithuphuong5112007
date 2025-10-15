package com.poly.lab2.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

// http://localhost:8080/a
@Controller
public class b5ResulController {

    @RequestMapping("/a")
    public String m1() {
        return "b5result";
    }

    @RequestMapping("/b")
    public String m2(Model model) {
        model.addAttribute("message", "I come from b");
        return "forward:/a";   // ?1: forward tới /a
    }

    @RequestMapping("/c")
    public String m3(RedirectAttributes params) {
        params.addAttribute("message", "I come from c");
        return "redirect:/a";  // ?2: redirect tới /a
    }

    @ResponseBody   // ?3: để in trực tiếp ra trình duyệt
    @RequestMapping("/d2")
    public String m4() {
        return "I come from d";
    }
}
