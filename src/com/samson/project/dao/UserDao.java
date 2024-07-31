package com.samson.project.dao;

import com.samson.project.entity.Gender;
import com.samson.project.entity.Role;
import com.samson.project.entity.User;
import com.samson.project.util.ConnectionManager;
import lombok.SneakyThrows;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class UserDao implements Dao<Integer,User>{

    public static final UserDao INSTANCE = new UserDao();

    public static final String GET_BY_EMAIL_AND_PASSWORD="SELECT * FROM users " +
                                                         "WHERE email = ? " +
                                                         "AND password = ?";

    public static final String SAVE_SQL="INSERT INTO users(first_name, last_name, patronymic, gender, birthday, country, passport, email, password, role) VALUES (?,?,?,?,?,?,?,?,?,?)";

    @Override
    public List<User> findAll() {
        return null;
    }

    @SneakyThrows
    public Optional<User> findByEmailAndPassword(String email, String password){
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(GET_BY_EMAIL_AND_PASSWORD)
        ) {
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);

            var resultSet = preparedStatement.executeQuery();
            User user = null;
            if(resultSet.next()){
                user = buildEntity(resultSet);
            }
            return Optional.ofNullable(user);
        }
        
    }

    private User buildEntity(ResultSet resultSet) throws SQLException {
        return User.builder()
                .id(resultSet.getObject("id", Long.class))
                .first_name(resultSet.getObject("first_name",String.class))
                .last_name(resultSet.getObject("last_name",String.class))
                .patronymic(resultSet.getObject("patronymic",String.class))
                .gender(Gender.valueOf(resultSet.getObject("gender",String.class)))
                .birthday(resultSet.getObject("birthday", Date.class).toLocalDate())
                .country(resultSet.getObject("country",String.class))
                .passport(resultSet.getObject("passport",Long.class))
                .email(resultSet.getObject("email",String.class))
                .password(resultSet.getObject("password", String.class))
                .role(Role.find(resultSet.getObject("role", String.class)).orElse(null))
                .build();
    }

    @Override
    public Optional<User> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public boolean delete() {
        return false;
    }

    @Override
    public void update(User entity) {

    }

    @SneakyThrows
    @Override
    public User save(User entity) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(SAVE_SQL, RETURN_GENERATED_KEYS)) {
            preparedStatement.setObject(1,entity.getFirst_name());
            preparedStatement.setObject(2,entity.getLast_name());
            preparedStatement.setObject(3,entity.getPatronymic());
            preparedStatement.setObject(4,entity.getGender().name());
            preparedStatement.setObject(5,entity.getBirthday());
            preparedStatement.setObject(6,entity.getCountry());
            preparedStatement.setObject(7,entity.getPassport());
            preparedStatement.setObject(8,entity.getEmail());
            preparedStatement.setObject(9,entity.getPassword());
            preparedStatement.setObject(10,entity.getRole().name());

            preparedStatement.executeUpdate();
            var generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
                entity.setId(generatedKeys.getObject("id", Long.class));

            return entity;
        }
    }

    public static UserDao getInstance(){
        return INSTANCE;
    }
}
