package com.sirma.finalexam.matchanalyzer.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IdGenerator<T> {

    Long generateUniqueId(JpaRepository<T, Long> repository);
}
