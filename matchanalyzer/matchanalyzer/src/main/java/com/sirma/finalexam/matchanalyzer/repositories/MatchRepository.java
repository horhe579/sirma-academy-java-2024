package com.sirma.finalexam.matchanalyzer.repositories;

import com.sirma.finalexam.matchanalyzer.entities.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
}
