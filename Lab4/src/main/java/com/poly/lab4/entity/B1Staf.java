package com.poly.lab4.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

public class B1Staf {
    private String id;
    private String fullname;

    @Builder.Default
    private String photo = "anhphuong.jpg";

    @Builder.Default
    private Boolean gender = true;

    @Builder.Default
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date birthday = new Date();

    @Builder.Default
    private double salary = 12345.6789;

    @Builder.Default
    private Integer level = 0;
}
