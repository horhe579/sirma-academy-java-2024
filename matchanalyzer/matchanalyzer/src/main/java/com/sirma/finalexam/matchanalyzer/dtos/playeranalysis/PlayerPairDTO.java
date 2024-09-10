package com.sirma.finalexam.matchanalyzer.dtos.playeranalysis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerPairDTO {

    private Long playerAId;

    private Long playerBId;

    //private Long timeTogether;

    @Override
    public boolean equals(Object o)
    {
        if(!(o instanceof PlayerPairDTO) || o == null)
        {
            return false;
        }
        if(this == o)
        {
            return true;
        }
        PlayerPairDTO that = (PlayerPairDTO) o;
        //overriding the method so when a new pair is created and merged in the map
        //and a player pair already exists it changes the value
        return (playerAId.equals(that.playerBId) && playerBId.equals(that.playerAId) ||
                playerAId.equals(that.playerAId) && playerBId.equals(that.playerBId));
    }

    @Override
    public int hashCode()
    {
        Long minId = Math.min(playerAId, playerBId);
        Long maxId = Math.max(playerAId, playerBId);
        return Objects.hash(minId, maxId);
    }

}
