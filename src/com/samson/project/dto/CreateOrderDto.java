package com.samson.project.dto;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Value
@Builder
public class CreateOrderDto {
    String first_name;
    String last_name;
    String patronymic;
    String passport;
    String model;
    String number;
    String price;
    String time_order;
    String start_rent;
    String finish_rent;
}
