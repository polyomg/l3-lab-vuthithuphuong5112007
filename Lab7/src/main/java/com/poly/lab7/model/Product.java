package com.poly.lab7.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table(name = "productLab7")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    private String name;
    private Double price;
    private String category;

    @Temporal(TemporalType.DATE)
    @Column(name = "create_date")
    private Date createDate = new Date();

    @Transient
    private Boolean available;
}
