package com.app.trainee.dao;

import com.app.trainee.model.Trainee;

public interface TraineeDao {
	void addTrainee(Trainee trainee);
    Trainee findById(int traineeId);

}
