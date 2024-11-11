package com.gapplabs.jurasicpark.models.Types.Islands;

import com.gapplabs.jurasicpark.models.Island;
import com.gapplabs.jurasicpark.models.Types.Dinos.Carnivore;

public class CarnivoreIsland extends Island {

    @Override
    protected void createDinosaurs() {
        dinosaurs.add(new Carnivore());
        dinosaurs.add(new Carnivore());
        System.out.println("Creando dinosaurios carnivoros.");
    }
}
