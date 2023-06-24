package com.esprit.microservice.rentservice;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Rent implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	private int customerId;
	private int nbrOfDays;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNbrOfDays() {
		return nbrOfDays;
	}

	public void setNbrOfDays(int nbrOfDays) {
		this.nbrOfDays = nbrOfDays;
	}

	@Override
	public String toString() {
		return "Rent [id=" + id  + ", customerId=" + customerId + "]";
	}

	public Rent() {
		super();
	}

	public Rent( int customerId) {
		super();
		this.customerId = customerId;
	}

}
