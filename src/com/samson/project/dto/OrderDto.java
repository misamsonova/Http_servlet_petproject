package com.samson.project.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class OrderDto {
    Long id;
    String description;

}
