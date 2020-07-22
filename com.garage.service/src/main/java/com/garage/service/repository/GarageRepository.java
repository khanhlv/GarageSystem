package com.garage.service.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.garage.model.Garage;
import com.garage.service.mapper.GarageRowMapper;

@Repository
public class GarageRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Garage> findAll() {
        return jdbcTemplate.query("select * from garage", new GarageRowMapper());
    }

//    public int insert(Employee employee) {
//        return jdbcTemplate.update("insert into employees (id, first_name, last_name, email_address) " + "values(?, ?, ?, ?)",
//                new Object[] {
//                        employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmailId()
//                });
//    }
//
//    public int update(Employee employee) {
//        return jdbcTemplate.update("update employees " + " set first_name = ?, last_name = ?, email_address = ? " + " where id = ?",
//                new Object[] {
//                        employee.getFirstName(), employee.getLastName(), employee.getEmailId(), employee.getId()
//                });
//    }
}
