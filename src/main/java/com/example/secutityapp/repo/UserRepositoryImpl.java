package com.example.secutityapp.repo;

import com.example.secutityapp.DBWorker;
import com.example.secutityapp.Entity.User;
import com.example.secutityapp.repo.UserRepository;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
@Repository
public class UserRepositoryImpl implements UserRepository {
    private DBWorker dbWorker = new DBWorker();
    @Override
    public List<User> findAll() {
        String query = "select * from users";
        List<User> users = new ArrayList<>();
        try {

            Statement statement = dbWorker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setEmail(resultSet.getString(3));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public User findByEmail(String email) {
        String query = "select * from users";

        try {
            Statement statement = dbWorker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                if(resultSet.getString(3).equals(email)){
                    User user = new User();
                    user.setId(resultSet.getInt(1));
                    user.setName(resultSet.getString(2));
                    user.setEmail(resultSet.getString(3));
                    return user;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(User user) {
       String query = "insert into users(id,name,email) values(?,?,?)";
        try {
            PreparedStatement statement = dbWorker.getConnection().prepareStatement(query);
            statement.setLong(1,user.getId());
            statement.setString(2,user.getName());
            statement.setString(3,user.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
