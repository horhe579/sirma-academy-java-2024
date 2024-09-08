package com.sirma.finalexam.matchanalyzer.entity;

import com.sirma.finalexam.matchanalyzer.enums.PlayerPosition;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "players")

public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Size(min = 1)
    @Column(nullable = false)
    private String fullName;

    @ManyToOne
    @Column(nullable = false)
    private Team team;

    @Size(max = 2, min = 2)
    @Column(nullable = false)
    private PlayerPosition position;



}
