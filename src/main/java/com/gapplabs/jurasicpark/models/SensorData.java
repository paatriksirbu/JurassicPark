package com.gapplabs.jurasicpark.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SensorData {
    private String id;
    private String sensorId;
    private Double value;
    private Long timestamp;

    // Constructor vacio
    public SensorData() {}

    // Constructor con todos los atributos
    public SensorData(String id, String sensorId, Double value, Long timestamp) {
        this.id = id;
        this.sensorId = sensorId;
        this.value = value;
        this.timestamp = timestamp;
    }
    
    public String getId() {
		return id;
	}
	
	public String getSensorId() {
		return sensorId;
	}
	
	public Double value() {
		return value;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
    
}
