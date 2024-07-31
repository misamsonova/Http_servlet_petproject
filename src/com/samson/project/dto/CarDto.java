package com.samson.project.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CarDto {
    Long id;
    String name_model;
    String number;
}
