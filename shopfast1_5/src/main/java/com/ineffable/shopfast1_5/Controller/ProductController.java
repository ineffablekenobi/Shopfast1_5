package com.ineffable.shopfast1_5.Controller;

import com.ineffable.shopfast1_5.Model.Product;
import com.ineffable.shopfast1_5.Services.ProductService;
import com.ineffable.shopfast1_5.Util.BPlusTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private BPlusTree bPlusTree;

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
        if(bPlusTree.cacheHit(id)){
            return ResponseEntity.ok(bPlusTree.getUser(id));
        }else {
            bPlusTree.insert(id,productService.getProductById(id));
            return ResponseEntity.status(HttpStatus.OK).body(bPlusTree.getUser(id));
        }
    }

}
