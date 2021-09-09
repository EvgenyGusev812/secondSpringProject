package com.evgeny.springproject3.repository;

import com.evgeny.springproject3.entity.ToDoEntity;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<ToDoEntity, Long> {
}
