package com.samson.project.service;

import com.samson.project.dao.OrderDao;
import com.samson.project.dto.CreateOrderDto;
import com.samson.project.dto.OrderDto;

import com.samson.project.entity.Order;
import com.samson.project.mapper.CreateOrderMapper;
import java.util.List;


import static java.util.stream.Collectors.toList;

public class OrderService {

    private static final OrderService INSTANCE = new OrderService();

    private final CreateOrderMapper createOrderMapper = CreateOrderMapper.getInstance();
    private final OrderDao orderDao = OrderDao.getInstance();

    private OrderService(){
    }

    public static OrderService getInstance() {
        return INSTANCE;
    }

    public List<OrderDto> findById(Long id){
        return orderDao.findById(id).stream()
                .map(order -> OrderDto.builder().id(order.getId()).description("""
                        Your order is %s: %s.
                        """.formatted(order.getId(),order.getModel()))
                        .build()
                )
                .collect(toList());
    }

    public List<Order> findByPassport(Long passport){
        return orderDao.findByPassport(passport).stream()
                .map(order -> Order.builder()
                        .id(order.getId())
                        .first_name(order.getFirst_name())
                        .last_name(order.getLast_name())
                        .patronymic(order.getPatronymic())
                        .passport(order.getPassport())
                        .price(order.getPrice())
                        .model(order.getModel())
                        .number(order.getNumber())
                        .time_order(order.getTime_order())
                        .start_rent(order.getStart_rent())
                        .finish_rent(order.getFinish_rent())
                        .build()
                )
                .collect(toList());
    }

    public Long create(CreateOrderDto orderDto){
        var orderEntity = createOrderMapper.mapFrom(orderDto);
        orderDao.save(orderEntity);
        return orderEntity.getId();
    }


}
