package com.poly.lab7.controller;
import com.poly.lab7.dao.ProductDao;
import com.poly.lab7.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.*;

// http://localhost:8080/product/search

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductDao dao;

    @RequestMapping("/search")
    public String search(Model model,
                         @RequestParam("min") Optional<Double> min,
                         @RequestParam("max") Optional<Double> max) {

        double minPrice = min.orElse(Double.MIN_VALUE);
        double maxPrice = max.orElse(Double.MAX_VALUE);

        // List<Product> items = dao.findByPrice(minPrice, maxPrice);
        List<Product> items = dao.findByPriceBetween(minPrice, maxPrice);

        model.addAttribute("items", items);
        return "product/search";
    }
}
