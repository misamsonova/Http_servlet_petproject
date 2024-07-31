package com.samson.project.dao;

import com.samson.project.entity.Model;
import com.samson.project.util.ConnectionManager;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor( access = AccessLevel.PRIVATE)
public class ModelDao implements Dao<Integer,Model>{

    private static final ModelDao INSTANCE = new ModelDao();

    public static final String FIND_ALL= """
                                SELECT ID, MODEL_NAME, NUMBER
                                FROM model
       """;


    @SneakyThrows
    @Override
    public List<Model> findAll() {
        try (var connection = ConnectionManager.get();
                var preparedStatement = connection.prepareStatement(FIND_ALL)) {
            var resultSet = preparedStatement.executeQuery();
            List<Model> models = new ArrayList<>();
            while(resultSet.next()){
                models.add(buildModel(resultSet));
            }

            return models;
        }

    }


    private Model buildModel(ResultSet resultSet) throws SQLException {
        return new Model(
                resultSet.getObject("id", Integer.class),
                resultSet.getObject("model_name", String.class),
                resultSet.getObject("number", Integer.class)
        );
    }

    @Override
    public Optional<Model> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public boolean delete() {
        return false;
    }

    @Override
    public void update(Model entity) {

    }

    @Override
    public Model save(Model entity) {
        return null;
    }

    public static ModelDao getInstance() {
        return INSTANCE;
    }
}
