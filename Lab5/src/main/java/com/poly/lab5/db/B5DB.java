package com.poly.lab5.db;

import com.poly.lab5.dao.B4Item;

import java.util.HashMap;
import java.util.Map;

public class B5DB {
    public static Map<Integer, B4Item> items = new HashMap<>();
    static {
        items.put(1, new B4Item(1, "Samsung", 10.0, 0));
        items.put(2, new B4Item(2, "Nokia 2021", 20.50, 0));
        items.put(3, new B4Item(3, "iPhone 20", 90.49, 0));
        items.put(4, new B4Item(4, "Motorola", 15.55, 0));
        items.put(5, new B4Item(5, "Seamen", 8.99, 0));
    }
}
