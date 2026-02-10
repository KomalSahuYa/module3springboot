package com.app.trainee.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.app.trainee.exceptions.TraineeDataAccessException;
import com.app.trainee.model.Trainee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceException;

@Repository
@Profile("prod")
public class TraineeDaoJpaImpl implements TraineeDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void addTrainee(Trainee trainee) {
		em.persist(trainee);
		
	}

	@Override
	public Trainee findById(int traineeId) {
		try {
			return em.find(Trainee.class, traineeId);
		}
		catch(PersistenceException ex) {
			throw new TraineeDataAccessException("Jpa: Failed to fetch trainee",ex);
		}
		
		 
	}
	
	

}
