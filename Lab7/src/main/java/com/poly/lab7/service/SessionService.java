package com.poly.lab7.service;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService {
    @Autowired
    HttpSession session;

    /**
     * Lưu giá trị vào session
     * @param name  tên key
     * @param value giá trị muốn lưu
     */
    public void set(String name, Object value) {
        session.setAttribute(name, value);
    }

    /**
     * Lấy giá trị từ session
     * @param name tên key
     * @param defaultValue giá trị mặc định nếu không tìm thấy
     * @param <T> kiểu dữ liệu
     * @return giá trị lấy được hoặc mặc định
     */
    @SuppressWarnings("unchecked")
    public <T> T get(String name, T defaultValue) {
        T value = (T) session.getAttribute(name);
        return (value != null) ? value : defaultValue;
    }

    /**
     * Xóa một giá trị khỏi session
     * @param name tên key
     */
    public void remove(String name) {
        session.removeAttribute(name);
    }

}
