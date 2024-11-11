package com.gapplabs.jurasicpark.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlertDTO {

    private String id;
    private String level;
    private String description;
    private Long timestamp;

}
