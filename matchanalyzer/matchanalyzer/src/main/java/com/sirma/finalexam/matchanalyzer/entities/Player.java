package com.sirma.finalexam.matchanalyzer.entities;

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
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(nullable = false)
    private Long teamNumber;

    @Size(min = 1)
    @Column(nullable = false)
    private String fullName;

    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PlayerPosition position;
}
