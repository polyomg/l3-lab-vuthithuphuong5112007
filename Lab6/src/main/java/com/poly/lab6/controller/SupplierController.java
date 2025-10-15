package com.poly.lab6.controller;


import com.poly.lab6.dao.SupplierDAO;
import com.poly.lab6.entity.SupplierEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/supplier")

// http://localhost:8080/supplier/index  bai3 thêm

public class SupplierController {
    @Autowired
    SupplierDAO dao;

    @RequestMapping("/index")
    public String index(Model model) {
        SupplierEntity item = new SupplierEntity();
        model.addAttribute("item", item);
        model.addAttribute("items", dao.findAll());
        model.addAttribute("isEdit", false);
        return "supplier/index";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("item") SupplierEntity item,
                         BindingResult result,
                         Model model) {
        if (result.hasErrors()) {
            model.addAttribute("items", dao.findAll());
            model.addAttribute("isEdit", false);
            return "supplier/index"; // quay lại form nếu có lỗi
        }
        dao.save(item);
        return "redirect:/supplier/index";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("item") SupplierEntity item,
                         BindingResult result,
                         Model model) {
        if (result.hasErrors()) {
            model.addAttribute("items", dao.findAll());
            model.addAttribute("isEdit", true);
            return "supplier/index"; // quay lại form nếu có lỗi
        }
        dao.save(item);
        return "redirect:/supplier/index";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        dao.deleteById(id);
        return "redirect:/supplier/index";
    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") String id) {
        SupplierEntity item = dao.findById(id).orElse(new SupplierEntity());
        model.addAttribute("item", item);
        model.addAttribute("items", dao.findAll());
        model.addAttribute("isEdit", true);
        return "supplier/index";
    }
}
