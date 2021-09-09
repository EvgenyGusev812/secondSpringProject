package com.evgeny.springproject3.model;

import com.evgeny.springproject3.entity.ToDoEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ToDos {

    private Long id;

    private String title;

    private Boolean completed;

    public static ToDos toModel(ToDoEntity toDoEntity) {
        ToDos model = new ToDos();
        model.setId(toDoEntity.getId());
        model.setTitle(toDoEntity.getTitle());
        model.setCompleted(toDoEntity.getCompleted());
        return model;
    }

}
