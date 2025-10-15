package com.poly.lab5.controller;


import com.poly.lab5.Service.CookieService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// http://localhost:8080/my-url?fullname=Poly
// http://localhost:8080/my-url-get
@Controller
public class MyController {
    @Autowired
    HttpServletRequest request;

    @Autowired
    CookieService cookieService;

    @RequestMapping("/my-url")
    public String method(Model model) {
        String uri = request.getParameter("fullname");

        String upcaseFullname = uri.toUpperCase();
        cookieService.create("name","Poly" + upcaseFullname,60);
        model.addAttribute("fullname", upcaseFullname);
        return "/demo/page";
    }

    @GetMapping("/my-url-get")
    public String methodGet(Model model) {
        String getcookie = cookieService.getValue("name");

        model.addAttribute("fullname", getcookie + " - Get - " + cookieService.getNum().toString());
        return "/demo/page";
    }
}

