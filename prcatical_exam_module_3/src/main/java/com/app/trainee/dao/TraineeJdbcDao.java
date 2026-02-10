package com.app.trainee.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.dao.DataAccessException; 
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.app.trainee.exceptions.TraineeDataAccessException;
import com.app.trainee.model.Trainee;

@Repository
@Profile("dev")
public class TraineeJdbcDao implements TraineeDao {

    private final JdbcTemplate jdbcTemplate;

    public TraineeJdbcDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addTrainee(Trainee trainee) {
        String sql = "INSERT INTO trainee(trainee_name, branch, percentage) VALUES(?,?,?)";

        try {
            jdbcTemplate.update(sql,
                    trainee.getTraineeName(),
                    trainee.getBranch(),
                    trainee.getPercentage()
            );
        } catch (DataAccessException ex) {
            throw new TraineeDataAccessException("JDBC: Failed to add trainee", ex);
        }
    }

	@Override
	public Trainee findById(int traineeId) {
		String sql = "SELECT trainee_id, trainee_name, branch, percentage FROM trainee WHERE trainee_id = ?";
		try {
			return jdbcTemplate.queryForObject(sql, new TraineeMapper(), traineeId);
			
		}
		catch(DataAccessException ex) {
			throw new TraineeDataAccessException("trainee with id " + traineeId+" not found", ex);
		}
	    
	}

}
