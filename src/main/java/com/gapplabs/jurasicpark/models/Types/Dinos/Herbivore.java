package com.gapplabs.jurasicpark.models.Types.Dinos;

import com.gapplabs.jurasicpark.models.Dinosaur;

public class Herbivore implements Dinosaur {

    @Override
    public void feed() {
        System.out.println("El dinosaurio herbívoro se esta alimentando de plantas");
    }

    @Override
    public void move() {
        System.out.println("El dinosaurio herbívoro se esta moviendo lentamente");
    }

    @Override
    public void makeSound() {
        System.out.println("El dinosaurio herbívoro esta haciendo un sonido");
    }
}
