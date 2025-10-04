package com.poly.lab3.controller;


import com.poly.lab3.entity.B1Staff;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

// http://localhost:8080/b1staff/b1detail
// http://localhost:8080/anhphuong.jpg
@Controller

public class B1StaffController {
    @RequestMapping("/b1staff/b1detail")
    public String detail(Model model) {
        B1Staff staff = B1Staff.builder()
                .id("phuong@gmail.com")
                .fullname("Vũ Thị Thu Phương")
                .photo("anhphuong.jpg")   // file ảnh để trong static/
                .gender(true)
                .birthday(new Date())
                .salary(98765.4321)
                .level(2)  // 0 = Úy, 1 = Tá, 2 = Tướng
                .build();

        model.addAttribute("staff", staff);

        // file html nằm trong templates
        return "b1staff-detail";
    }
}
