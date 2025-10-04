package com.poly.lab1;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// http://localhost:8080/l1b4login/l1b4form
@Controller
@RequestMapping("/l1b4login")

public class B4AuthController {

    @Autowired
    HttpServletRequest request;

    // Hiển thị form
    @GetMapping("/l1b4form")
    public String form() {
        return "trangchu"; // trả về login.html
    }

    // Xử lý login
    @PostMapping("/l1b4check")
    public String login(Model model) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("poly".equals(username) && "123".equals(password)) {
            model.addAttribute("message", "Đăng nhập thành công!");
        } else {
            model.addAttribute("message", "Đăng nhập thất bại!");
        }

        return "trangchu"; // quay lại trang login.html
    }
}
