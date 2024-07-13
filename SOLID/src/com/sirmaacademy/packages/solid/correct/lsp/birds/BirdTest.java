package com.sirmaacademy.packages.solid.correct.lsp.birds;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BirdTest {
    public static void main(String[] args) {
        Penguin penguin = new Penguin("Peter");
        Pigeon pigeon = new Pigeon("Pesho");
        Ostrich ostrich = new Ostrich("Pepi");

        Set<Bird> birdSet = new HashSet<>(Arrays.asList(penguin, pigeon, ostrich));

        for(Bird bird : birdSet)
        {
            bird.fly();
        }
    }
}
