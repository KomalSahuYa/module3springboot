package com.app.trainee.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.app.trainee.model.Trainee;

public class TraineeMapper implements RowMapper<Trainee> {

    @Override
    public Trainee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Trainee t = new Trainee();
        t.setTraineeId(rs.getInt("trainee_id"));
        t.setTraineeName(rs.getString("trainee_name"));
        t.setBranch(rs.getString("branch"));
        t.setPercentage(rs.getDouble("percentage"));
        return t;
    }
}