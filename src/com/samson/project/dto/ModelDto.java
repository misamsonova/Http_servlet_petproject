package com.samson.project.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ModelDto {
    Integer id;
    String description;
}
