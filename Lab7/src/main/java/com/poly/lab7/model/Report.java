package com.poly.lab7.model;

import java.io.Serializable;
// Nó là interface projection — dùng để hứng dữ liệu tổng hợp từ JPQL query
public interface Report {
    Serializable getGroup();  // Tên nhóm (category)
    Double getSum();          // Tổng giá
    Long getCount();          // Số lượng sản phẩm
}
