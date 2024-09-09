package com.sirma.finalexam.matchanalyzer.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    //Add validation to not have the same ID of team A and B in a match(maybe in the service)
    @ManyToOne
    @JoinColumn(name = "teamA_id", nullable = false)
    private Team teamA;

    @ManyToOne
    @JoinColumn(name = "teamB_id", nullable = false)
    private Team teamB;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private String score;
}