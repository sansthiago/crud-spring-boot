package com.example.crudSprintBootJava.controller;

import com.example.crudSprintBootJava.model.Product;
import com.example.crudSprintBootJava.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductViewController {

    private final ProductRepository repository;

    public ProductViewController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String listProducts(Model model) {
        model.addAttribute("products", repository.findAll());
        return "products/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        return "products/form";
    }

    @PostMapping("/save")
    public String saveProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "products/form";
        }
        repository.save(product);
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de producto inválido: " + id));
        model.addAttribute("product", product);
        return "products/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/products";
    }
}