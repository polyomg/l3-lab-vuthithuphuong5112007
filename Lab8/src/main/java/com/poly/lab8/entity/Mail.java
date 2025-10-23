package com.poly.lab8.entity;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class Mail {
    private String from;
    private String to;
    private String cc;
    private String bcc;
    private String subject;
    private String body;
    private MultipartFile[] attachments;

}
