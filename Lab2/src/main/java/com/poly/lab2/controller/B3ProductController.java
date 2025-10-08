package com.poly.lab2.controller;
import com.poly.lab2.entity.B3Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// http://localhost:8080/l2b3product/l2b3form
@Controller
public class B3ProductController {
    @GetMapping("/l2b3product/l2b3form")
    public String form() {
        return "b3form";
    }

    @PostMapping("/l2b3product/l2b3save")
    public String save(@ModelAttribute B3Product product, Model model) {
        // đưa dữ liệu product vào model để hiển thị ở view
        model.addAttribute("product", product);
        return "b3form";
    }
}
