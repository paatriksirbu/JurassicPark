package com.gapplabs.jurasicpark.models.Types.Islands;

import com.gapplabs.jurasicpark.models.Types.Dinos.Herbivore;
import com.gapplabs.jurasicpark.models.Island;

public class BreedingIsland extends Island {

    @Override
    protected void createDinosaurs() {
        dinosaurs.add(new Herbivore());
        dinosaurs.add(new Herbivore());
        System.out.println("Creando dinosaurios herbivoros.");
    }
}
