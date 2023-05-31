package com.example.crud.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Position {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public Position(String name) {
        this.name = name;
    }
}
