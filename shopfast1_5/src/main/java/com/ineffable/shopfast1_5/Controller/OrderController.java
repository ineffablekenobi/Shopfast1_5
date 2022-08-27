package com.ineffable.shopfast1_5.Controller;

import com.ineffable.shopfast1_5.DTO.OrderRequest;
import com.ineffable.shopfast1_5.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody OrderRequest orderRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.create(orderRequest));
    }

    @GetMapping("/")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getAll());
    }



}
