package com.poly.lab6.controller;

import java.util.List;

import com.poly.lab6.dao.CategoryDAO;
import com.poly.lab6.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

// http://localhost:8080/category/index   bai2

@Controller

public class CategoryController {
    @Autowired
    CategoryDAO dao;

    // Hiển thị danh sách + form
    @RequestMapping("/category/index")
    public String index(Model model) {
        Category item = new Category();
        model.addAttribute("item", item);
        model.addAttribute("isEdit", false); // chế độ thêm mới

        List<Category> items = dao.findAll();
        model.addAttribute("items", items);
        return "category/index";
    }

    // Nút Edit
    @RequestMapping("/category/edit/{id}")
    public String edit(Model model, @PathVariable("id") String id) {
        Category item = dao.findById(id).orElse(new Category());
        model.addAttribute("item", item);
        model.addAttribute("isEdit", true); // 👈 đang ở chế độ chỉnh sửa

        List<Category> items = dao.findAll();
        model.addAttribute("items", items);
        return "category/index";
    }

    // Nút Create
    @RequestMapping("/category/create")
    public String create(Category item) {
        // Nếu id đã tồn tại thì không cho thêm mới
        if (dao.existsById(item.getId())) {
            return "redirect:/category/edit/" + item.getId();
        }
        dao.save(item);
        return "redirect:/category/index";
    }

    // Nút Update
    @RequestMapping("/category/update")
    public String update(Category item) {
        dao.save(item);
        return "redirect:/category/edit/" + item.getId();
    }

    // Nút Delete
    @RequestMapping("/category/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        dao.deleteById(id);
        return "redirect:/category/index";
    }

}
