package com.gapplabs.jurasicpark.models;

import com.gapplabs.jurasicpark.enums.AlertLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Alert {
    private String id;
    private AlertLevel level;
    private String description;
    private Long timestamp;

    // Constructor vacio
    public Alert() {}

    // Constructor con todos los atributos
    public Alert(String id, AlertLevel level, String description, Long timestamp) {
        this.id = id;
        this.level = level;
        this.description = description;
        this.timestamp = timestamp;
    }
}
