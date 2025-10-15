package com.poly.lab6.dao;


import com.poly.lab6.entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.function.Supplier;

public interface SupplierDAO extends JpaRepository<SupplierEntity, String> {
}
