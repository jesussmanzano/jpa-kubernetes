package com.example.crud.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class Citizen {
    @Id
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String fistLastName;

    @NotNull
    private String secondLastName;

    private String uniquePopulationRegistryCode;



}
