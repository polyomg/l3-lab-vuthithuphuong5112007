package com.poly.lab3.controller;

import com.poly.lab3.entity.B5StaffControl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
// http://localhost:8080/b5/staff/list
// http://localhost:8080/anhphuong.jpg

@Controller

public class B5StaffControlController {
    @GetMapping("/b5/staff/list")
    public String list(Model model) {
        List<B5StaffControl> list = List.of(
                B5StaffControl.builder().id("phuong1@gmail.com").fullname("Vũ Thị Thu Phương 1").level(0).build(),
                B5StaffControl.builder().id("phuong2@gmail.com").fullname("Vũ Thị Thu Phương 2").level(1).build(),
                B5StaffControl.builder().id("phuong3@gmail.com").fullname("Vũ Thị Thu Phương 3").level(2).build(),
                B5StaffControl.builder().id("phuong4@gmail.com").fullname("Vũ Thị Thu Phương 4").level(2).build(),
                B5StaffControl.builder().id("phuong5@gmail.com").fullname("Vũ Thị Thu Phương 5").level(1).build(),
                B5StaffControl.builder().id("phuong6@gmail.com").fullname("Vũ Thị Thu Phương 6").level(0).build()
        );

        model.addAttribute("list", list);
        return "b5list-control";  // view
    }
}
