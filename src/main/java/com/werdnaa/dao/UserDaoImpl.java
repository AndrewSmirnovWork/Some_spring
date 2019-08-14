package com.werdnaa.dao;

import com.werdnaa.entity.User;
import com.werdnaa.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    public final JdbcTemplate jdbcTemplate;

    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void save(User user) {
        String sql = "INSERT INTO user (name, age, email) values (?,?,?)";
        jdbcTemplate.update(sql, user.getName(), user.getAge(), user.getEmail());
    }

    @Override
    public User getById(int id) {
        String sql ="SELECT * FROM USER where id=?";
        return jdbcTemplate.queryForObject(sql, new UserMapper(), id);
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM user where id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE USER set name=?,age=? ,email=? where id=?";
        jdbcTemplate.update(sql,user.getName(),user.getAge(),user.getEmail(), user.getId());
    }

    @Override
    public List<User> findAll() {
        String sql = "SELECT * FROM USER";
        return jdbcTemplate.query(sql, new UserMapper());
    }
}
