package com.poly.lab5.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class B4Item {
    Integer id;
    String name;
    double price;
    int qty = 1;


}
