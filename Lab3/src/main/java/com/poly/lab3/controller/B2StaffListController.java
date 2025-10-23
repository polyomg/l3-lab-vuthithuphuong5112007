package com.poly.lab3.controller;

import com.poly.lab3.entity.B2StaffList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
// http://localhost:8080/b2/staff/list
// http://localhost:8080/anhphuong.jpg
@Controller

public class B2StaffListController {
    @GetMapping("/b2/staff/list")
    public String list(Model model) {
        List<B2StaffList> list = List.of(
                B2StaffList.builder().id("phuong1@gmail.com").fullname("Vũ Thị Thu Phương 1").photo("anhphuong.jpg").salary(1000.0).level(0).build(),
                B2StaffList.builder().id("phuong2@gmail.com").fullname("Vũ Thị Thu Phương 2").photo("anhphuong.jpg").salary(2000.0).level(2).build(),
                B2StaffList.builder().id("phuong3@gmail.com").fullname("Vũ Thị Thu Phương 3").photo("anhphuong.jpg").salary(3000.0).level(2).build(),
                B2StaffList.builder().id("phuong4@gmail.com").fullname("Vũ Thị Thu Phương 4").photo("anhphuong.jpg").salary(1500.0).level(2).build(),
                B2StaffList.builder().id("phuong5@gmail.com").fullname("Vũ Thị Thu Phương 5").photo("anhphuong.jpg").salary(2500.0).level(1).build(),
                B2StaffList.builder().id("phuong6@gmail.com").fullname("Vũ Thị Thu Phương 6").photo("anhphuong.jpg").salary(3500.0).level(0).build()
        );

        model.addAttribute("list", list);
        return "b2staff-list";  // view ở templates/
    }
}
