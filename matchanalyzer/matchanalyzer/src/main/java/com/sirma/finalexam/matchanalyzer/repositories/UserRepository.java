package com.sirma.finalexam.matchanalyzer.repositories;

import java.util.Optional;
import com.sirma.finalexam.matchanalyzer.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
