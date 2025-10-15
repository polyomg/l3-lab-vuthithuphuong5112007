package com.poly.lab4.controller;

import com.poly.lab4.entity.B2Staff;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

// http://localhost:8080/b2/staff/create/form
@Controller
public class B2ValidationController {
    @RequestMapping("/b2/staff/create/form")
    public String showForm(Model model, @ModelAttribute("staff") B2Staff staff) {
        model.addAttribute("message", "Vui lòng nhập thông tin nhân viên!");
        return "b2staff-validate";
    }
    @RequestMapping("/b2/staff/create/save")
    public String createSave(@RequestPart("photo_file") MultipartFile photoFile,
                             @Valid @ModelAttribute("staff") B2Staff staff,
                             Errors errors,
                             Model model) {

        if(!photoFile.isEmpty()) {
            staff.setPhoto(photoFile.getOriginalFilename());
        }

        if(errors.hasErrors()) {
            model.addAttribute("message", "Vui lòng sửa các lỗi sau!");
        } else {
            model.addAttribute("message", "Xin chào " + staff.getFullname() + " - Dữ liệu hợp lệ!");
        }

        return "b2staff-validate";
    }
}
