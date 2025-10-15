package com.poly.lab6.dao;

import com.poly.lab6.entity.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDAO extends JpaRepository<Product, Integer> {
    // Lấy tất cả sản phẩm sắp xếp theo giá tăng dần
    default List<Product> findAllByPriceAsc() {
        return findAll(Sort.by(Sort.Direction.ASC, "price"));
    }

    // Hoặc giảm dần
    default List<Product> findAllByPriceDesc() {
        return findAll(Sort.by(Sort.Direction.DESC, "price"));
    }

    // Sắp xếp theo ngày tạo (mới nhất trước)
    default List<Product> findAllByNewest() {
        return findAll(Sort.by(Sort.Direction.DESC, "createDate"));
    }
}