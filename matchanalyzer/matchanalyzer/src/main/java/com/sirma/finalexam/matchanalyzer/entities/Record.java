package com.sirma.finalexam.matchanalyzer.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "records")
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

    @ManyToOne
    @JoinColumn(name = "match_id", nullable = false)
    private Match match;

    @Max(value = 90, message = "To must be at most 90.")
    @Min(value = 0, message = "From must be at least 0.")
    @Column(nullable = false)
    private Integer fromMinutes;

    //NULL value indicates a player played until the end of the match
    @Max(value = 90, message = "To must be at most 90.")
    private Integer toMinutes;
}
