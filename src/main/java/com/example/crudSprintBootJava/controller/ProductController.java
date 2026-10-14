package com.example.crudSprintBootJava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    @GetMapping("/")
    public String index() {
        return "products/index"; // Apunta a src/main/resources/templates/products/index.html
    }
}