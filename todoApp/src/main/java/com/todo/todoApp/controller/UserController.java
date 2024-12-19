package com.todo.todoApp.controller;
import java.util.*;
import com.todo.todoApp.dto.UserRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/add")
    public ResponseEntity<Map<String, Object>> addUser(@Validated @RequestBody UserRequest user){
        System.out.println("printing something");
        Map<String, Object> response = new HashMap<>();
        response.put("data", user);
        response.put("message", "user has been created");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
