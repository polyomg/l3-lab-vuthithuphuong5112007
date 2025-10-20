package com.poly.lab7.controller;

import com.poly.lab7.dao.ProductDao;
import com.poly.lab7.model.Product;
import com.poly.lab7.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

// http://localhost:8080/product/search-and-page
@Controller
@RequestMapping("/product")
public class B2ProductController {
    @Autowired
    ProductDao dao;

    @Autowired
    SessionService session;

    @RequestMapping("/search-and-page")
    public String searchAndPage(Model model,
                                @RequestParam("keywords") Optional<String> kw,
                                @RequestParam("p") Optional<Integer> p) {

        // Lấy từ khóa người dùng nhập (nếu có) hoặc lấy từ session
        String kwords = kw.orElse(session.get("keywords", ""));

        // Lưu từ khóa vào session để giữ khi đổi trang
        session.set("keywords", kwords);

        // Tạo phân trang (PageRequest.of(số trang hiện tại, kích thước mỗi trang))
        Pageable pageable = PageRequest.of(p.orElse(0), 5);

        // Bài 2 Gọi DAO tìm sản phẩm theo tên + phân trang
        //Page<Product> page = dao.findByKeywords("%" + kwords + "%", pageable);

        // Bài 5
        Page<Product> page = dao.findAllByNameLike("%" + kwords + "%", pageable);

        // Gửi dữ liệu ra view
        model.addAttribute("page", page);
        model.addAttribute("keywords", kwords);
        return "product/search-and-page";
    }
}
