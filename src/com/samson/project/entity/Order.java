package com.samson.project.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    Long id;
    String first_name;
    String last_name;
    String patronymic;
    Long passport;
    String model;
    String number;
    Long price;
    LocalDateTime time_order;
    LocalDate start_rent;
    LocalDate finish_rent;

}
