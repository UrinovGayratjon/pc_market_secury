package com.company.pcmarket.controller;

import com.company.pcmarket.entity.Product;
import com.company.pcmarket.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.net.http.HttpResponse;
import java.util.List;

@RestController()
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    ProductRepository repository;

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(repository.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getProduct(@PathVariable Integer id) {
        return ResponseEntity.ok(repository.findById(id).orElseThrow());
    }

    @DeleteMapping
    public ResponseEntity<?> addProduct(@PathVariable Integer body) {
        repository.deleteById(body);
        return ResponseEntity.ok(null);
    }


}
