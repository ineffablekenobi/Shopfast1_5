package com.ineffable.shopfast1_5.Controller;

import com.ineffable.shopfast1_5.Model.ServiceUser;
import com.ineffable.shopfast1_5.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ServiceUser serviceUser){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(serviceUser));
    }

    @PostMapping("/login")
    public ResponseEntity<?> SignIn(@RequestBody ServiceUser serviceUser){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(userService.login(serviceUser));
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }



}
