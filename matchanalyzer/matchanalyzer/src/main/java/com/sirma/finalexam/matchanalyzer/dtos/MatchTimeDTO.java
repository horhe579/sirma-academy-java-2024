package com.sirma.finalexam.matchanalyzer.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Related to a pair of players only, a player pair has a reference to a list of objects of this class
//holding information about the time a pair spent together in a match
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchTimeDTO {
    private Long matchID;
    private Long timeInMatch;
}
