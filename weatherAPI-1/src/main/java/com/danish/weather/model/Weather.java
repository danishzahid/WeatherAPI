package com.danish.weather.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;


@Data
@Entity
@Table(name="weatherdata")
public class Weather {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="date")
	private String date;
	
	@Column(name="lat")
	private double lat;
	
	@Column(name="lon")
	private double lon;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="temperature")
	private long temperature;
}
