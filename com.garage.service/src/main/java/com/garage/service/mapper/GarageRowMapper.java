package com.garage.service.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.garage.model.Garage;

public class GarageRowMapper implements RowMapper<Garage> {

    @Override
    public Garage mapRow(ResultSet rs, int rowNum) throws SQLException {
        Garage garage = new Garage();
        garage.setId(rs.getLong("id"));
        garage.setName(rs.getString("name"));
        garage.setStatus(rs.getLong("status"));
        return garage;
    }
}
