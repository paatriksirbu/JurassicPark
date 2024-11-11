package com.gapplabs.jurasicpark.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SensorDataDTO {

    private String id;
    private String sensorId;
    private String value;
    private Long timestamp;
}
