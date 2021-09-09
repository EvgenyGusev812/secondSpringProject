package com.evgeny.springproject3.service;

import com.evgeny.springproject3.entity.ToDoEntity;
import com.evgeny.springproject3.entity.UserEntity;
import com.evgeny.springproject3.model.ToDos;
import com.evgeny.springproject3.repository.ToDoRepository;
import com.evgeny.springproject3.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ToDoService {

    @Autowired
    private final ToDoRepository toDoRepository;

    @Autowired
    private final UserRepository userRepository;

    public ToDos createToDo(ToDoEntity todo, Long id) {
        UserEntity user = userRepository.findById(id).get();
        todo.setUser(user);
        return ToDos.toModel(toDoRepository.save(todo));
    }

    public ToDos completeToDo(Long id) {
        ToDoEntity todo = toDoRepository.findById(id).get();
        todo.setCompleted(!todo.getCompleted());
        return ToDos.toModel(toDoRepository.save(todo));
    }
}
