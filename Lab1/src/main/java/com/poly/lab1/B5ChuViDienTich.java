package com.poly.lab1;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// http://localhost:8080/l1b5rect/l1b5form
@Controller
@RequestMapping("/l1b5rect")

public class B5ChuViDienTich {
    @Autowired
    HttpServletRequest request;

    // Hiển thị form
    @GetMapping("/l1b5form")
    public String form() {
        return "rectangle";
    }

    // Xử lý tính toán
    @PostMapping("/l1b5calc")
    public String calc(Model model) {
        double length = Double.parseDouble(request.getParameter("length"));
        double width  = Double.parseDouble(request.getParameter("width"));

        double area = length * width;
        double perimeter = 2 * (length + width);

        // Chuỗi hiển thị công thức
        String areaExpr = length + " * " + width + " = " + area;
        String periExpr = "2 * (" + length + " + " + width + ") = " + perimeter;

        model.addAttribute("areaExpr", area);
        model.addAttribute("periExpr", perimeter);

        return "rectangle";
    }
}
