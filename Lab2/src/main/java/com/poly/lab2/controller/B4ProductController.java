package com.poly.lab2.controller;


import com.poly.lab2.entity.B4Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// http://localhost:8080/l2b4product/l2b4form
// http://localhost:8080/l2b4product/3/0

@Controller
public class B4ProductController {

    @GetMapping("/l2b4product/l2b4form")
    public String form(Model model) {
        model.addAttribute("p1", new B4Product("iPhone 30", 5000.0));
        model.addAttribute("p2", new B4Product());
        model.addAttribute("p3", products); // lấy danh sách chung
        return "b4form";
    }

    @PostMapping("/l2b4product/l2b4save")
    public String save(@ModelAttribute("p2") B4Product p, Model model) {
        model.addAttribute("p1", new B4Product("iPhone 30", 5000.0));
        model.addAttribute("p2", p);

        // Thêm sản phẩm mới vào danh sách p3
        products.add(new B4Product(p.getName(), p.getPrice()));
        model.addAttribute("p3", products);

        return "b4form";
    }


    // Danh sách sản phẩm chung (thay cho getItems() cố định)
    private List<B4Product> products = new ArrayList<>(Arrays.asList(
            new B4Product("A", 1.0),
            new B4Product("B", 12.0),
            new B4Product("C", 5.5),
            new B4Product("D", 20.0),
            new B4Product("E", 8.0),
            new B4Product("F", 15.5),
            new B4Product("G", 30.0),
            new B4Product("H", 7.0),
            new B4Product("I", 50.0),
            new B4Product("J", 25.0)
    ));

    @GetMapping("/l2b4product/{size}/{page}")
    public String listProducts(
            @PathVariable("size") int pageSize,
            @PathVariable("page") int page,
            Model model) {

        // Dùng danh sách products toàn cục (không tạo mới)
        int fromIndex = page * pageSize;
        int toIndex = Math.min(fromIndex + pageSize, products.size());

        // Nếu fromIndex lớn hơn size thì tránh lỗi
        if (fromIndex > products.size()) {
            fromIndex = products.size();
        }

        List<B4Product> subList = products.subList(fromIndex, toIndex);

        model.addAttribute("p3", subList);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", (int) Math.ceil((double) products.size() / pageSize));
        model.addAttribute("pageSize", pageSize);

        return "b4list";
    }
}
