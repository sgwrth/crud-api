package com.wbs.oraclecrud.controller;

import com.wbs.oraclecrud.entity.Product;
import com.wbs.oraclecrud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @CrossOrigin
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return service.saveProducts(products);
    }

    @CrossOrigin
    @GetMapping("/products")
    public List<Product> findAllProducts() {
        return service.getProducts();
    }

    @GetMapping("/product/{id}")
    public Product findProductById(int id) {
        return service.getProductById(id);
    }

    @GetMapping("/product/{name}")
    public Product findProductByName(String name) {
        return service.getProductByName(name);
    }

    @PutMapping("/updateProduct")
    public Product updateProduct(@RequestBody Product product) {
        return service.updateProduct(product);
    }

    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public String updateProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }
}