package com.poly.lab7.dao;

import com.poly.lab7.model.Product;
import com.poly.lab7.model.Report;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface ProductDao extends JpaRepository<Product, Integer> {
    // Bài 1
    //@Query("FROM Product o WHERE o.price BETWEEN ?1 AND ?2")
    //List<Product> findByPrice(double minPrice, double maxPrice);
    // Bài 4
    List<Product> findByPriceBetween(double minPrice, double maxPrice);
    // Bài 2
    //@Query("FROM Product o WHERE o.name LIKE ?1")
    //Page<Product> findByKeywords(String keywords, Pageable pageable);
    // Bài 5
    Page<Product> findAllByNameLike(String keywords, Pageable pageable);

    // Bài 3
    // Tìm theo từ khóa name
    @Query("""
        SELECT o.name AS group,
               SUM(o.price) AS sum,
               COUNT(o) AS count
        FROM Product o
        WHERE o.name LIKE %?1%
           OR o.name LIKE %?1%
           OR STR(o.price) LIKE %?1%
        GROUP BY o.name
        ORDER BY SUM(o.price) DESC
    """)
    List<Report> searchInventoryByName(String keyword);
}

