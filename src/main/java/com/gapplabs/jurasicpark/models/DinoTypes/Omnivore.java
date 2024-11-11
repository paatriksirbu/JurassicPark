package com.gapplabs.jurasicpark.models.DinoTypes;

import com.gapplabs.jurasicpark.models.Dinosaur;

public class Omnivore implements Dinosaur {

    @Override
    public void feed() {
        System.out.println("El dinosaurio omnivoro come plantas y carne");
    }

    @Override
    public void move() {
        System.out.println("El dinosaurio omnivoro se esta moviendo");
    }

    @Override
    public void makeSound() {
        System.out.println("El dinosaurio omnivoro esta rugiendo fuertemente");
    }
}
