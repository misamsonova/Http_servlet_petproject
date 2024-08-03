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

    public static final String FIND_FIRST_BY_MODEL= """
            SELECT *
            FROM car
            WHERE model = ? AND status = 'READY'
            LIMIT 1;
            """;
    public static final String FIND_ALL_BY_MODEL= """
            SELECT *
            FROM car
            WHERE model = ? AND status = 'READY';
            """;

    public static CarDao getInstance(){
        return INSTANCE;
    }

    @SneakyThrows
    public List<Car> findAllByModel(String model) {
        model = model.trim();
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

    @SneakyThrows
    public Car findFirstByModel(String model) {
        model = model.trim();
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(FIND_FIRST_BY_MODEL)) {
            preparedStatement.setObject(1,model);
            var resultSet = preparedStatement.executeQuery();
            Car car = null;
            if(resultSet.next()){
                car = buildCar(resultSet);
            }
            return car;
        }
    }

    private Car buildCar(ResultSet resultSet) throws SQLException {
        return new Car(
                resultSet.getObject("id", Long.class),
                resultSet.getObject("number", String.class),
                Model.builder()
                        .model_name(resultSet.getObject("model", String.class))
                        .build(),
                CarStatus.valueOf(resultSet.getObject("status", String.class))
        );
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
