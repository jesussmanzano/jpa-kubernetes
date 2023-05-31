package com.example.crud.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Table(name = "CITIZEN")
@Entity
@AllArgsConstructor
public class Citizen {
    public Citizen(){
        super();
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String firstLastName;

    @Column(nullable = false)
    private String secondLastName;

    @Column
    private String uniquePopulationRegistryCode;




}
