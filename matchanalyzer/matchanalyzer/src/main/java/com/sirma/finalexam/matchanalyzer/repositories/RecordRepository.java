package com.sirma.finalexam.matchanalyzer.repositories;

import com.sirma.finalexam.matchanalyzer.entities.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
}
