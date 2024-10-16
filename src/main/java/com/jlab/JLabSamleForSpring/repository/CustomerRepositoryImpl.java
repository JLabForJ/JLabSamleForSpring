package com.jlab.JLabSamleForSpring.repository;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jlab.JLabSamleForSpring.model.Customer;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private final JdbcTemplate jdbcTemplate;

    public CustomerRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insert(Customer customer) {
        String sql = "INSERT INTO customer (LAST_NAME, FIRST_NAME, GENDER, PHONE, ADDRESS, MODIFY_DT, MODIFY_BY, CREATE_DT, CREATE_BY) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, customer.getLastName(), customer.getFirstName(), customer.getGender(), customer.getPhone(), customer.getAddress(), customer.getModifyDt(), customer.getModifyBy(), customer.getCreateDt(), customer.getCreateBy());
    }

    @Override
    public int update(Customer customer) {
        String sql = "UPDATE customer SET LAST_NAME = ?, FIRST_NAME = ?, GENDER = ?, PHONE = ?, ADDRESS = ?, MODIFY_DT = ?, MODIFY_BY = ? WHERE ID = ?";
        return jdbcTemplate.update(sql, customer.getLastName(), customer.getFirstName(), customer.getGender(), customer.getPhone(), customer.getAddress(), customer.getModifyDt(), customer.getModifyBy(), customer.getId());
    }

    @Override
    public int delete(int id) {
        String sql = "DELETE FROM customer WHERE ID = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public Customer findById(int id) {
    	String sql = "SELECT * FROM customer WHERE ID = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Customer.class), id);
    }

    @Override
    public List<Customer> findAll() {
        String sql = "SELECT * FROM customer";
//        return jdbcTemplate.query(sql, Customer.class);
//        return jdbcTemplate.query(sql, new Object[] {}, new BeanPropertyRowMapper(Customer.class));
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Customer.class));
    }
}