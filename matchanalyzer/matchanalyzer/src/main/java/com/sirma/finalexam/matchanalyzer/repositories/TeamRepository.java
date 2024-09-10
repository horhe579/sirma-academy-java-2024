package com.sirma.finalexam.matchanalyzer.repositories;

import com.sirma.finalexam.matchanalyzer.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    @Query("SELECT t.id FROM Team t WHERE t.id IN :ids")
    List<Long> getExistingIds(@Param("ids") List<Long> ids);

    boolean existsByName(String name);

    boolean existsByManagerFullName(String managerFullName);

    @Query("SELECT CASE WHEN COUNT(t) > 0 THEN TRUE ELSE FALSE END FROM Team t WHERE t.managerFullName = :managerFullName AND t.id <> :teamId")
    boolean existsByManagerFullNameAndIdNot(@Param("managerFullName") String managerFullName, @Param("teamId") Long teamId);

    @Query("SELECT CASE WHEN COUNT(t) > 0 THEN TRUE ELSE FALSE END FROM Team t WHERE t.name = :teamName AND t.id <> :teamId")
    boolean existsByNameAndIdNot(@Param("teamName") String teamName, @Param("teamId") Long teamId);
}
