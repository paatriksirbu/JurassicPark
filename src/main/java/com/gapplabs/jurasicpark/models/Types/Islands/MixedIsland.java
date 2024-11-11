package com.gapplabs.jurasicpark.models.Types.Islands;

import com.gapplabs.jurasicpark.models.Island;
import com.gapplabs.jurasicpark.models.Types.Dinos.Carnivore;
import com.gapplabs.jurasicpark.models.Types.Dinos.Herbivore;
import com.gapplabs.jurasicpark.models.Types.Dinos.Omnivore;

public class MixedIsland extends Island {

    @Override
    protected void createDinosaurs() {
        dinosaurs.add(new Carnivore());
        dinosaurs.add(new Herbivore());
        dinosaurs.add(new Omnivore());
        System.out.println("Creando dinosaurios mezclados.");
    }
}
