package com.poly.lab5.controller;

import com.poly.lab5.db.B5DB;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// http://localhost:8080/item/index
@Controller
public class B5ItemController {
    @RequestMapping("/item/index")
    public String list(Model model) {
        model.addAttribute("items", B5DB.items.values());
        return "item/index";
    }
}
