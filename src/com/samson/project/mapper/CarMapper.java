package com.samson.project.mapper;

import com.samson.project.dto.CarDto;
import com.samson.project.entity.Car;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor( access = PRIVATE)
public class CarMapper implements Mapper<Car, CarDto>{
    private static final CarMapper INSTANCE = new CarMapper();
    @Override
    public CarDto mapFrom(Car object) {
        return CarDto.builder()
                .number(object.getNumber())
                .build();
    }

    public static CarMapper getInstance() {
        return INSTANCE;
    }

}
