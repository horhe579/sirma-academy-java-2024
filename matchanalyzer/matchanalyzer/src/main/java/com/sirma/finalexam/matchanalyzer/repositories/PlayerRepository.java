package com.sirma.finalexam.matchanalyzer.repositories;

import com.sirma.finalexam.matchanalyzer.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Query("SELECT p.id FROM Player p WHERE p.id IN :ids")
    List<Long> getExistingIds(@Param("ids") List<Long> ids);

    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN TRUE ELSE FALSE END FROM Player p WHERE p.teamNumber = :teamNumber AND p.team.id = :teamId AND p.id <> :playerId")
    boolean existsByTeamNumberAndTeamIdAndIdNot(@Param("teamNumber") Long teamNumber, @Param("teamId") Long teamId, @Param("playerId") Long playerId);

    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN TRUE ELSE FALSE END FROM Player p WHERE p.fullName = :fullName AND p.team.id = :teamId AND p.id <> :playerId")
    boolean existsByFullNameAndTeamIdAndIdNot(@Param("fullName") String fullName, @Param("teamId") Long teamId, @Param("playerId") Long playerId);

    boolean existsByFullNameAndTeamId(String fullName, Long teamId);

    boolean existsByTeamNumberAndTeamId(Long teamNumber, Long teamId);


}
