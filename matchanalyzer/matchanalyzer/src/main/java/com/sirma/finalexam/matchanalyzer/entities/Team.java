package com.sirma.finalexam.matchanalyzer.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "teams")
public class Team {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Size(min = 2)
    @Column(nullable = false, unique = true)
    private String name;

    @Size(min = 2)
    @Column(nullable = false, unique = true)
    private String managerFullName;

    @Column(nullable = false)
    private char groupName;

}
