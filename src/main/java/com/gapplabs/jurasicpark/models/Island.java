package com.gapplabs.jurasicpark.models;

import java.util.ArrayList;
import java.util.List;

public abstract class Island {
    protected List<Dinosaur> dinosaurs = new ArrayList<>();

    public final void operateIsland() {
        System.out.println("Isla: " + this.getClass().getSimpleName());
        createDinosaurs();
        performActivities();
        monitorDinosaurs();
    }

    protected abstract void createDinosaurs();

    protected void performActivities() {
        for (Dinosaur dinosaur : dinosaurs) {
            dinosaur.feed();
            dinosaur.move();
            dinosaur.makeSound();
        }
    }

    protected void monitorDinosaurs() {
        System.out.println("Monitorizando dinosaurios en: " + this.getClass().getSimpleName());
        System.out.println("Numero de dinosaurios: " + dinosaurs.size());
    }
}
