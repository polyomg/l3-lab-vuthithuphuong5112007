package com.poly.lab6.controller;


import com.poly.lab6.dao.ProductDAO;
import com.poly.lab6.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

// http://localhost:8080/product/sort?field=price                  bai3
// http://localhost:8080/product/page?p=0                          bai4
// http://localhost:8080/product/pageAndSort?p=0&field=price       bai5
@Controller
public class ProductController {

    @Autowired
    ProductDAO dao;

    // Bài 3: Sắp xếp
    @RequestMapping("/product/sort")
    public String sort(Model model, @RequestParam("field") Optional<String> field) {
        // Nếu chưa chọn cột -> mặc định sắp theo price giảm dần
        String sortField = field.orElse("price");
        Sort sort = Sort.by(Direction.DESC, sortField);

        // Lấy danh sách sản phẩm đã sắp xếp
        List<Product> items = dao.findAll(sort);

        model.addAttribute("items", items);
        model.addAttribute("field", sortField.toUpperCase());

        return "product/sort";
    }

    // Bài 4: Phân trang
    @RequestMapping("/product/page")
    public String paginate(Model model, @RequestParam("p") Optional<Integer> p) {
        Pageable pageable = PageRequest.of(p.orElse(0), 5); // mỗi trang 5 sản phẩm
        Page<Product> page = dao.findAll(pageable);
        model.addAttribute("page", page);
        return "product/page"; // file page.html trong templates/product/
    }

    // Bài 5: Kết hợp phân trang + sắp xếp theo giá
    @RequestMapping("/product/pageAndSort")
    public String paginateAndSort(Model model,
                                  @RequestParam("p") Optional<Integer> p,
                                  @RequestParam("field") Optional<String> field) {

        int pageNumber = p.orElse(0);
        String sortField = field.orElse("price"); // mặc định sắp theo giá
        Sort sort = Sort.by(Sort.Direction.DESC, sortField); // giảm dần theo giá

        Pageable pageable = PageRequest.of(pageNumber, 5, sort);
        Page<Product> page = dao.findAll(pageable);

        model.addAttribute("page", page);
        model.addAttribute("field", sortField);

        return "product/pageAndSort"; // file HTML tương ứng
    }
}
