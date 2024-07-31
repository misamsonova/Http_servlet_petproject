package com.samson.project.dao;

import com.samson.project.entity.Order;
import com.samson.project.util.ConnectionManager;
import lombok.SneakyThrows;

import java.sql.*;
import java.util.List;
import java.util.Optional;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class OrderDao implements Dao<Long, Order>{

    public static final String FIND_BY_ID = """
            SELECT *
            FROM orders
            WHERE id = ?
        """;

    public static final String SAVE_SQL="INSERT INTO orders(first_name_client, last_name_client, patronymic_client, passport_client, car_model, car_number, price, time_order, start_rent, finish_rent) VALUES (?,?,?,?,?,?,?,?,?,?)";
    private static final OrderDao INSTANCE = new OrderDao();

    @Override
    public List<Order> findAll() {
        return null;
    }

    @SneakyThrows
    @Override
    public Optional<Order> findById(Long id) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            preparedStatement.setObject(1,id);
            var resultSet = preparedStatement.executeQuery();
            return buildOrder(resultSet);
        }
    }

    private Optional<Order> buildOrder(ResultSet resultSet) throws SQLException {
        return Optional.of(new Order(
                resultSet.getObject("id", Long.class),
                resultSet.getObject("first_name_client", String.class),
                resultSet.getObject("last_name_client", String.class),
                resultSet.getObject("patronymic_client", String.class),
                resultSet.getObject("passport_client", Long.class),
                resultSet.getObject("car_model", String.class),
                resultSet.getObject("car_number", String.class),
                resultSet.getObject("price", Long.class),
                resultSet.getObject("time_order", Timestamp.class).toLocalDateTime(),
                resultSet.getObject("start_rent", Date.class).toLocalDate(),
                resultSet.getObject("finish_rent", Date.class).toLocalDate()
        ));
    }

    @Override
    public boolean delete() {
        return false;
    }

    @Override
    public void update(Order entity) {

    }

    @SneakyThrows
    @Override
    public Order save(Order entity) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(SAVE_SQL, RETURN_GENERATED_KEYS)) {
            preparedStatement.setObject(1,entity.getFirst_name());
            preparedStatement.setObject(2,entity.getLast_name());
            preparedStatement.setObject(3,entity.getPatronymic());
            preparedStatement.setObject(4,entity.getPassport());
            preparedStatement.setObject(5,entity.getModel());
            preparedStatement.setObject(6,entity.getNumber());
            preparedStatement.setObject(7,entity.getPrice());
            preparedStatement.setObject(8, entity.getTime_order());
            preparedStatement.setObject(9,entity.getStart_rent());
            preparedStatement.setObject(10,entity.getFinish_rent());

        preparedStatement.executeUpdate();
        var generatedKeys = preparedStatement.getGeneratedKeys();
        generatedKeys.next();
        entity.setId(generatedKeys.getObject("id", Long.class));
        return entity;
        }
    }

    public static OrderDao getInstance(){
        return INSTANCE;
    }
}
