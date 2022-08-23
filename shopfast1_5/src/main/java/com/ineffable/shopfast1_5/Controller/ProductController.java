package com.ineffable.shopfast1_5.Controller;

import com.ineffable.shopfast1_5.Model.Product;
import com.ineffable.shopfast1_5.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Product product){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.create(product));
    }

    @GetMapping("/")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAll());
    }

    @GetMapping("/id={id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProductById(id));
    }

}
