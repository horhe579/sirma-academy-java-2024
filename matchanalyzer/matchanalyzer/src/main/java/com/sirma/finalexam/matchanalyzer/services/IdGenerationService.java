package com.sirma.finalexam.matchanalyzer.services;

import com.sirma.finalexam.matchanalyzer.interfaces.IdGenerator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class IdGenerationService<T> implements IdGenerator<T> {
    //TODO do not permit negative IDs

    private int limit = 1000;
    private Random random = new Random();


    @Override
    public Long generateUniqueId(JpaRepository<T, Long> repository) {
        Long generatedId;
        int i = 0;

        do{
            generatedId = generateId();
            i++;
            if(i > limit)
            {
                throw new RuntimeException("Cannot generate ID.");
            }
        } while(idExists(generatedId, repository));

        return generatedId;
    }

    private Long generateId()
    {
        //add some boundary
        return Math.abs(random.nextLong());
    }

    private boolean idExists(Long id, JpaRepository<T, Long> repository) {
        return repository.existsById(id);
    }

}
