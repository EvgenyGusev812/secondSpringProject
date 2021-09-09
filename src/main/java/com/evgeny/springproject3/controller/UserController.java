package com.evgeny.springproject3.controller;

import com.evgeny.springproject3.exception.UserAlreadyExist;
import com.evgeny.springproject3.exception.UserNotFoundException;
import com.evgeny.springproject3.entity.UserEntity;
import com.evgeny.springproject3.model.Users;
import com.evgeny.springproject3.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;

    @GetMapping
    public ResponseEntity getUsers() {
        try {
            return ResponseEntity.ok("It's ok");
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Mistake");
        }
    }

    @PostMapping("/save")
    public ResponseEntity registration(@RequestBody UserEntity user) {
        try {
            userService.registration(user);
            return ResponseEntity.ok("User saved");
        }
        catch (UserAlreadyExist e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Mistake");
        }
    }

    @GetMapping("/get")
    public ResponseEntity getOneUser(@RequestParam Long id) {
        try {
            Users user = userService.getOne(id);
            return ResponseEntity.ok(user);
        }
        catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Mistake");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userService.deleteUser(id));
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Mistake");
        }
    }
}
