package com.traineemgtapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.traineemgtapp.entities.Trainee;
import com.traineemgtapp.repo.TraineeRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TraineeServiceImpl implements TraineeService {
	private TraineeRepo traineeRepo;

	@Override
	public List<Trainee> getAll() {
		return traineeRepo.findAll();
	}

	@Override
	public Trainee addTrainee(Trainee trainee) {
		traineeRepo.save(trainee);
		return trainee;
	}

	@Override
	public Trainee getById(int id) {
		return null;
	}

	@Override
	public Trainee updateTrainee(int id, Trainee trainee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Trainee deleteTrainee(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Trainee> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
