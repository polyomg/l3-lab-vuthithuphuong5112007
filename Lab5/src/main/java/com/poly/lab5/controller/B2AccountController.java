package com.poly.lab5.controller;

import com.poly.lab5.Service.B1CookieService;
import com.poly.lab5.Service.B1ParamService;
import com.poly.lab5.Service.B1SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

// http://localhost:8080/account/login

@Controller
public class B2AccountController {
    @Autowired
    B1CookieService cookieService;
    @Autowired
    B1ParamService paramService;
    @Autowired
    B1SessionService sessionService;

    @GetMapping("/account/login")
    public String login1() {
        return "views/login";
    }
    @PostMapping("/account/login")
    public String login2(Model model) {
        // 1️⃣ Đọc tham số từ form bằng ParamService
        String username = paramService.getString("username", "");
        String password = paramService.getString("password", "");
        boolean remember = paramService.getBoolean("remember", false);

        // 2️⃣ Kiểm tra đăng nhập (theo yêu cầu đề)
        if (username.equals("poly") && password.equals("123")) {

            // 3️⃣ Lưu username vào session
            sessionService.set("username", username);

            // 4️⃣ Xử lý ghi nhớ tài khoản
            if (remember) {
                // nhớ 10 ngày (10 * 24 = 240 giờ)
                cookieService.add("user", username, 240);
            } else {
                cookieService.remove("user");
            }

            model.addAttribute("message", "Đăng nhập thành công!");
        } else {
            model.addAttribute("message", "Sai tên đăng nhập hoặc mật khẩu!");
        }
        return "views/login";
    }
}
