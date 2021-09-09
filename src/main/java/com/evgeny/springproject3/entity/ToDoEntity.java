package com.evgeny.springproject3.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class ToDoEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private Boolean completed;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
