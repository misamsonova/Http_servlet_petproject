package com.samson.project.mapper;

import com.samson.project.dto.CreateOrderDto;
import com.samson.project.entity.Order;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CreateOrderMapper implements Mapper<CreateOrderDto, Order>{
    public static final CreateOrderMapper INSTANCE = new CreateOrderMapper();

    @Override
    public Order mapFrom(CreateOrderDto object) {
        return Order.builder()
                .first_name(object.getFirst_name())
                .last_name(object.getLast_name())
                .patronymic(object.getPatronymic())
                .passport(Long.valueOf(object.getPassport()))
                .model(object.getModel())
                .number(object.getNumber())
                .price(Long.valueOf(object.getPrice()))
                .time_order(LocalDateTime.parse(object.getTime_order()))
                .start_rent(LocalDate.parse(object.getStart_rent()))
                .finish_rent(LocalDate.parse(object.getFinish_rent()))
                .build();
    }

    public static CreateOrderMapper getInstance(){
        return INSTANCE;
    }
}
