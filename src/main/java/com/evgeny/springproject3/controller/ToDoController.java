package com.evgeny.springproject3.controller;

import com.evgeny.springproject3.entity.ToDoEntity;
import com.evgeny.springproject3.service.ToDoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
@AllArgsConstructor
public class ToDoController {

    @Autowired
    private final ToDoService toDoService;

    @PostMapping
    public ResponseEntity createTodo(@RequestBody ToDoEntity toDoEntity, @RequestParam Long userId) {
        try {
            return ResponseEntity.ok(toDoService.createToDo(toDoEntity, userId));
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Mistake");
        }
    }

    @PutMapping
    public ResponseEntity createTodo(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(toDoService.completeToDo(id));
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Mistake");
        }
    }
}
