package com.poly.lab1;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// http://localhost:8080/poly/helloworld
@Controller
public class B2Controller {
    @RequestMapping("/poly/helloworld")
    public String sayHello(Model model){
        model.addAttribute("title", "FPT Polytechlic");
        model.addAttribute("subject",   "Hello World - TP00328 - VuThiThuPhuong");
        return "helloworld";
    }
}
