package com.poly.lab4.controller;

import com.poly.lab4.entity.B1Staf;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

// http://localhost:8080/b1/staff/create/form

@Controller
public class B1StafController {
    @RequestMapping("/b1/staff/create/form")
    public String createForm(Model model, @ModelAttribute("staff") B1Staf staff) {
        model.addAttribute("message", "Vui lòng nhập thông tin nhân viên!");
        return "b1staff-create";
    }
    @RequestMapping("/b1/staff/create/save")
    public String createSave(Model model, @ModelAttribute("staff") B1Staf staff,
                             @RequestPart("photo_file") MultipartFile photoFile) {
// Gán tên file upload cho thuộc tính photo của bean nếu có upload file
        if(!photoFile.isEmpty()) {
            staff.setPhoto(photoFile.getOriginalFilename());
        }
        model.addAttribute("message", "Xin chào " + staff.getFullname());
        return "b1staff-create";
    }
}
