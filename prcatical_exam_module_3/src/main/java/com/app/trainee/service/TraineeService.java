package com.app.trainee.service;

import com.app.trainee.model.Trainee;

public interface TraineeService {
	void addTrainee(Trainee trainee);
	Trainee getTraineeById(int traineeId);

}
