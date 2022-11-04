package com.sicredipucrs.AvesDeRapina.tests;

import com.sicredipucrs.AvesDeRapina.dto.BirdDTO;
import com.sicredipucrs.AvesDeRapina.entities.Bird;

public class Factory {
    public static Bird createBird() {
        Bird bird = new Bird();
        bird.setId(1L);
        bird.setNamePT("Pato");
        bird.setNameEN("Duck");
        bird.setNameLAT("Anas platyrhynchos");
        bird.setSize(0.40);
        bird.setGender("Macho");
        bird.setColor("Branco");
        bird.setFamily("Anatidae");
        bird.setHabitat("Água doce");
        return bird;
    }

    public static BirdDTO createBirdDTO() {
        Bird bird = createBird();
        return new BirdDTO(bird);
    }
}
