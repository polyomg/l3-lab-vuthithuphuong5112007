package com.poly.lab8.controller;

import com.poly.lab8.entity.Mail;
import com.poly.lab8.service.MailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
public class MailController {
    @Autowired
    MailService mailService;

    @ResponseBody
    @RequestMapping("/mail/send")
    public String send() {
        try {
            mailService.send("phuongvtttp00328@fpt.edu.vn", "Subject Test", "This is a test email");
            return "Mail đã được gửi đi!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
