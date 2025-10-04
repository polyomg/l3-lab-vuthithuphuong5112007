package com.poly.lab3.controller;


import com.poly.lab3.entity.B4StaffStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

// http://localhost:8080/b4/staff/list
// http://localhost:8080/anhphuong.jpg

@Controller
public class B4StaffStatusController {
    @GetMapping("/b4/staff/list")
    public String list(Model model) {
        List<B4StaffStatus> list = List.of(
                B4StaffStatus.builder().id("phuong1@gmail.com").fullname("Vũ Thị Thu Phương 1").level(0).build(),
                B4StaffStatus.builder().id("phuong2@gmail.com").fullname("Vũ Thị Thu Phương 2").level(1).build(),
                B4StaffStatus.builder().id("phuong3@gmail.com").fullname("Vũ Thị Thu Phương 3").level(2).build(),
                B4StaffStatus.builder().id("phuong4@gmail.com").fullname("Vũ Thị Thu Phương 4").level(2).build(),
                B4StaffStatus.builder().id("phuong5@gmail.com").fullname("Vũ Thị Thu Phương 5").level(1).build(),
                B4StaffStatus.builder().id("phuong6@gmail.com").fullname("Vũ Thị Thu Phương 6").level(0).build()
        );
        model.addAttribute("list", list);
        return "b4list-status"; // view
    }
}
