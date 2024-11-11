package com.gapplabs.jurasicpark.models.Types.Dinos;

import com.gapplabs.jurasicpark.models.Dinosaur;

public class Carnivore implements Dinosaur {

    @Override
    public void feed() {
        System.out.println("El dinosaurio carnivoro esta cazando y alimentandose de carne");
    }

    @Override
    public void move() {
        System.out.println("El dinosaurio carnivoro se esta moviendo rapidamente");
    }

    @Override
    public void makeSound() {
        System.out.println("El dinosaurio carnivoro esta rugiendo");
    }
}
