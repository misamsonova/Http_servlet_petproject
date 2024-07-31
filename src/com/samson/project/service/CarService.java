package com.samson.project.service;

import com.samson.project.dao.CarDao;
import com.samson.project.dto.CarDto;
import com.samson.project.mapper.CarMapper;
import com.samson.project.mapper.UserMapper;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class CarService {
    private static CarService INSTANCE = new CarService();

    private final CarDao carDao = CarDao.getInstance();
    private final CarMapper carMapper = CarMapper.getInstance();


    private CarService(){
    }

    public List<CarDto> findAllByModel(String model){
        return carDao.findAllByModel(model).stream()
                .map(car -> CarDto.builder()
                        .id(car.getId())
                        .name_model(String.valueOf(car.getModel()))
                        .number(car.getNumber())
                        .build()
                )
                .collect(toList());
    }

    public String findFirstByModel(String model){
        return carDao.findFirstByModel(model).getNumber();
    }

    public CarDto getModelName(String model){
        return  CarDto.builder().name_model(model).build();
    }


    public static CarService getInstance(){
        return INSTANCE;
    }
}
