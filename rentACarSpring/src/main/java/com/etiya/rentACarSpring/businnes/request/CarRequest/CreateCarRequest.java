package com.etiya.rentACarSpring.businnes.request.CarRequest;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateCarRequest {

	@JsonIgnore
	private int carId;
	
	@NotNull
	private int color_Id;
	
	@NotNull
	private int brand_Id;
	
	@NotNull
	@Min(100)	
	private int dailyPrice;
	
	@NotNull
	@Size(min=10,max=200)
	private String description;

}
