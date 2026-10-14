package com.example.crudSprintBootJava.repository;

import com.example.crudSprintBootJava.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}