package com.esprit.microservice.Voitureservice;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Voiture implements Serializable{
	private static final long serialVersionUID = 6711457437559348053L;

	@Id
	@GeneratedValue
	private int id;
	private String type;
	private BigDecimal price;
	private String marque;
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public Voiture() {
	}
	public Voiture(String type) {
		super();
		this.type = type;
	}
	public Voiture(String type, BigDecimal price) {
		this.type = type;
		this.price = price;
	}

}
