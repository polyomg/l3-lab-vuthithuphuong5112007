package com.poly.lab7.controller;

import com.poly.lab7.dao.ProductDao;
import com.poly.lab7.model.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

// http://localhost:8080/report/inventory-by-category
@Controller
@RequestMapping("/report")

public class B3ReportController {
    @Autowired
    ProductDao dao;

    @RequestMapping("/inventory-by-category")
    public String inventory(
            Model model,
            @RequestParam("keyword") Optional<String> keyword
    ) {
        String kw = keyword.orElse("");
        List<Report> items = dao.searchInventoryByName(kw);
        model.addAttribute("items", items);
        model.addAttribute("keyword", kw);
        return "report/inventory-by-category";
    }
}
