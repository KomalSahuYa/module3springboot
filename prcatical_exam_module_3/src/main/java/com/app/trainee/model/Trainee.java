package com.app.trainee.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Trainee {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer traineeId;
	private String traineeName;
	private String branch;
	private Double percentage;

	public Trainee(Integer traineeId, String traineeName, String branch, Double percentage) {
		super();
		this.traineeId = traineeId;
		this.traineeName = traineeName;
		this.branch = branch;
		this.percentage = percentage;
	}

	public Trainee(String traineeName, String branch, Double percentage) {
		super();
		this.traineeName = traineeName;
		this.branch = branch;
		this.percentage = percentage;
	}

	public Trainee() {
		
	}

	public Integer getTraineeId() {
		return traineeId;
	}

	public String getTraineeName() {
		return traineeName;
	}

	public void setTraineeId(Integer traineeId) {
		this.traineeId = traineeId;
	}

	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

	@Override
	public String toString() {
		return "TraineeDto [traineeId=" + traineeId + ", traineeName=" + traineeName + ", branch=" + branch
				+ ", percentage=" + percentage + "]";
	}
	
	
	

}
