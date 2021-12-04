package com.etiya.rentACarSpring.entities;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data	
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cities")
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "city_id")
	private int cityId;
	
	@Column(name = "cityName")
	private String cityName;
	
	@OneToMany(mappedBy = "city")
	private List<Car> cars;
	
	@JsonIgnore
	@OneToMany(mappedBy = "takeCity")
	private List<Rental> takeCityRentals;

	@JsonIgnore
	@OneToMany(mappedBy = "returnCity")
	private List<Rental> returnCityRentals;
	
	
}
