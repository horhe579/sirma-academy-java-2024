package com.sirma.finalexam.matchanalyzer.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IdGenerator<T, ID> {

    Long generateUniqueId(JpaRepository<T, ID> repository);
}
