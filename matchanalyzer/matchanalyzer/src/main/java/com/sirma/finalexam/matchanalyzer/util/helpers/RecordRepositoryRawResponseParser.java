package com.sirma.finalexam.matchanalyzer.util.helpers;

import com.sirma.finalexam.matchanalyzer.dtos.playeranalysis.PlayerRecordForMatchDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RecordRepositoryRawResponseParser {


    //Helper method to make the grouping by in the getPlayerTimeForAllMatches() function easier to understand
    //Casts a field of an Object born from an SQL query that corresponds to the ID of the match
    public static Long getMatchId(Object[] record)
    {
        //assuming a record is correct and follows the format
        Long matchId = ((Number) record[0]).longValue();
        return matchId;
    }

    //Helper method to make the grouping by in the getPlayerTimeForAllMatches() function easier to understand
    //Casts an Object born from an SQL Query to a PlayerRecordForMatchDTO, taking into accounting
    //That NULL means 90 minutes
    public static PlayerRecordForMatchDTO getPlayerRecordForMatchDTO(Object[] record)
    {
        //again assuming the record is correct and in the right structure
        Long playerId = ((Number) record[1]).longValue();
        Long fromMinutes = ((Number) record[2]).longValue();
        Long toMinutes = ((Number) (record[3] == null ? 90 : record[3])).longValue();

        return new PlayerRecordForMatchDTO(playerId, fromMinutes, toMinutes);
    }



}
