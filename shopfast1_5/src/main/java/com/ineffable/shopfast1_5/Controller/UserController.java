package com.ineffable.shopfast1_5.Controller;

import com.ineffable.shopfast1_5.Model.ServiceUser;
import com.ineffable.shopfast1_5.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ServiceUser serviceUser){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(serviceUser));
    }



}
