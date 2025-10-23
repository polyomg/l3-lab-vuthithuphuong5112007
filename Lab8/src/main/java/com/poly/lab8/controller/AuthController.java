package com.poly.lab8.controller;

import com.poly.lab8.entity.Account;
import com.poly.lab8.service.AccountService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// http://localhost:8080/

@Controller
public class AuthController {
    @Autowired
    AccountService accountService;

    @GetMapping("/auth/login")
    public String loginForm(Model model) {
        return "/auth/login"; // tên file login.html
    }

    @PostMapping("/auth/login")
    public String loginProcess(Model model,
                               @RequestParam("username") String username,
                               @RequestParam("password") String password,
                               HttpSession session) {
        Account user = accountService.findById(username);
        if(user == null) {
            model.addAttribute("message", "Invalid username!");
        } else if(!user.getPassword().equals(password)) {
            model.addAttribute("message", "Invalid password!");
        } else {
            session.setAttribute("user", user);

            // Quay về URI trước nếu có
            String securityUri = (String) session.getAttribute("securityUri");
            if(securityUri != null) {
                return "redirect:" + securityUri;
            }

            model.addAttribute("message", "Login successfully!");
        }
        return "/auth/login";
    }

    @GetMapping("account/edit-profile")
    public String editProfile() {
        return "account/edit-profile"; // Thymeleaf sẽ tìm templates/account/edit-profile.html
    }



}
