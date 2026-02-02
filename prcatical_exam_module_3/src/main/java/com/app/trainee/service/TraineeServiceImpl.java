package com.app.trainee.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.trainee.dao.TraineeDao;
import com.app.trainee.exceptions.TraineeDataAccessException;
import com.app.trainee.model.Trainee;
@Service
public class TraineeServiceImpl implements TraineeService {
	
	private final TraineeDao traineeDao;
	

	public TraineeServiceImpl(TraineeDao traineeDao) {
		this.traineeDao = traineeDao;
	}
	
	@Override
	@Transactional
	public void addTrainee(Trainee trainee) {
		traineeDao.addTrainee(trainee);
		
	}

	@Override
	public Trainee getTraineeById(int traineeId) {
		Trainee t = traineeDao.findById(traineeId);

        if (t == null) {
            throw new TraineeDataAccessException("Trainee with id " + traineeId + " not found");
        }

        return t;
    }
	}


