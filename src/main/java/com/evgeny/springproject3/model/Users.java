package com.evgeny.springproject3.model;

import com.evgeny.springproject3.entity.UserEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Data
public class Users {

    private Long id;

    private String username;

    private List<ToDos> toDos;

    public static Users toModel(UserEntity userEntity) {
        Users model = new Users();
        model.setUsername(userEntity.getUsername());
        model.setId(userEntity.getId());
        model.setToDos(userEntity.getTodos().stream().map(ToDos::toModel).collect(Collectors.toList()));
        return model;
    }
}
