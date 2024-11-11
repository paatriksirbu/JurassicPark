package com.gapplabs.jurasicpark.models;

import com.gapplabs.jurasicpark.enums.AlertLevel;
import com.gapplabs.jurasicpark.enums.SensorStatus;
import com.gapplabs.jurasicpark.enums.SensorType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sensor {
    private String id;
    private SensorType type;
    private SensorStatus status;
    private String location;

    // Constructor vacio
    public Sensor() {}

    // Constructor con todos los atributos
    public Sensor(String id, SensorType type, SensorStatus status, String location) {
        this.id = id;
        this.type = type;
        this.status = status;
        this.location = location;
    }
    
    public String getId() {
		return id;
	}
	
	public SensorType getLevel() {
		return type;
	}
	
	public SensorStatus getStatus() {
		return status;
	}
	
	public String getLocation() {
		return location;
	}
    
}
