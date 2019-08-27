package com.s2.otms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="trip")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Trip {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer tripId;

	private Integer empId;

	private Timestamp startTime;

	private Timestamp endTime;

	private Integer distance;

	private Float cost;

	public Trip() {
		
	}

	public Integer getTripId() {
		return tripId;
	}

	public void setTripId(Integer id) {
		this.tripId = id;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer id) {
		this.empId = id;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp ts) {
		startTime = ts;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp ts) {
		endTime = ts;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer d) {
		this.distance = d;
	}

	public Float getCost() {
		return cost;
	}

	public void setCost(Float c) {
		this.cost = c;
	}

}
