package com.sirma.finalexam.matchanalyzer.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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

    @ManyToOne
    @Column(nullable = false)
    private Player player;

    @ManyToOne
    @Column(nullable = false)
    private Match match;

    @Max(value = 90, message = "To must be at most 90.")
    @Min(value = 0, message = "From must be at least 0.")
    @Column(nullable = false)
    private Integer fromMinutes;

    @Max(value = 90, message = "To must be at most 90.")
    private Integer toMinutes;
}
