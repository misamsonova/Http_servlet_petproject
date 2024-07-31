package com.samson.project.dao;

import com.samson.project.entity.Car;
import com.samson.project.entity.CarStatus;
import com.samson.project.entity.Model;
import com.samson.project.util.ConnectionManager;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CarDao implements Dao<Long, Car>{
    public static final CarDao INSTANCE = new CarDao();

    public static final String FIND_ALL_BY_MODEL= """
            SELECT *
            FROM car
            WHERE model = ? AND status = 'READY'
            """;

    public static final String FIND_FIRST_BY_MODEL= """
            SELECT *
            FROM car
            WHERE model = ? AND status = 'READY'
            LIMIT 1
            """;

    public static CarDao getInstance(){
        return INSTANCE;
    }

    @SneakyThrows
    public List<Car> findAllByModel(String model) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(FIND_ALL_BY_MODEL)) {
            preparedStatement.setObject(1,model);
            var resultSet = preparedStatement.executeQuery();
            List<Car> cars = new ArrayList<>();
            while(resultSet.next()){
                cars.add(buildCar(resultSet));
            }

            return cars;
        }
    }

    private Car buildCar(ResultSet resultSet) throws SQLException {
        System.out.println(resultSet.getObject("id", Long.class));
        System.out.println(resultSet.getObject("number", String.class));
        System.out.println(resultSet.getObject("status", String.class));
        return new Car(
                resultSet.getObject("id", Long.class),
                resultSet.getObject("number", String.class),
                Model.builder()
                        .model_name(resultSet.getObject("model", String.class))
                        .build(),
                CarStatus.valueOf(resultSet.getObject("status", String.class))
        );
    }

    @SneakyThrows
    public Car findFirstByModel(String model) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(FIND_FIRST_BY_MODEL)) {
            preparedStatement.setObject(2,model);
            var resultSet = preparedStatement.executeQuery();
            Car car = new Car();
            resultSet.next();
            car = buildCar(resultSet);
            return car;
        }
    }

    @Override
    public List<Car> findAll() {
        return null;
    }

    @Override
    public Optional<Car> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete() {
        return false;
    }

    @Override
    public void update(Car entity) {

    }

    @Override
    public Car save(Car entity) {
        return null;
    }
}
