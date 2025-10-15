package com.poly.lab5.controller;

import com.poly.lab5.Service.B1ParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

// http://localhost:8080/account/register

@Controller
public class B3RegisterController {
    @Autowired
    B1ParamService paramService;

    @GetMapping("/account/register")
    public String showForm() {
        return "views/register";
    }

    @PostMapping("/account/register")
    public String register(Model model, MultipartFile photo) {
        try {
            // Đọc các tham số từ form
            String username = paramService.getString("username", "");
            String email = paramService.getString("email", "");
            String password = paramService.getString("password", "");

            // Lưu hình ảnh (sử dụng phương thức save)
            File savedFile = paramService.save(photo, "/uploads");

            // Hiển thị lại kết quả
            model.addAttribute("message", "Đăng ký thành công!");
            model.addAttribute("username", username);
            model.addAttribute("email", email);
            model.addAttribute("password", password);
            model.addAttribute("photoName", savedFile != null ? savedFile.getName() : "Chưa có hình");

        } catch (Exception e) {
            model.addAttribute("message", "Đăng ký thất bại: " + e.getMessage());
        }

        return "views/register";
    }
}
