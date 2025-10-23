package com.poly.lab8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling  // 🔹 Bật chức năng chạy tác vụ nền (Scheduled)
@SpringBootApplication
public class Lab8Application {

    public static void main(String[] args) {
        SpringApplication.run(Lab8Application.class, args);
    }

}
