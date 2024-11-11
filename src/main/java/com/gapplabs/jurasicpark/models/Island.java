package com.gapplabs.jurasicpark.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Island {
    private String id;
    private String name;
    private String description;
    private String location;

    // Constructor vacio
    public Island() {}

    // Constructor con todos los atributos
    public Island(String id, String name, String description, String location) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.location = location;
    }
}
