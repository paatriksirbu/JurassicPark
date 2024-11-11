package com.gapplabs.jurasicpark.dto;

import com.gapplabs.jurasicpark.enums.SensorType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SensorDTO {

    private String id;
    private SensorType type;
    private String status;
    private String location;

}
