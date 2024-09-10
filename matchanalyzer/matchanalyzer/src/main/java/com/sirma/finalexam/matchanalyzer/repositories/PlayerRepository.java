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

    boolean existsByFullNameAndTeamId(String fullName, Long teamId);

    boolean existsByTeamNumberAndTeamId(Long teamNumber, Long teamId);
}
