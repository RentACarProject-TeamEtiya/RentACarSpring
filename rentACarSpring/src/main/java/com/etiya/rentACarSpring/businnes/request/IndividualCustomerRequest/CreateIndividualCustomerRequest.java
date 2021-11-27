package com.etiya.rentACarSpring.businnes.request.IndividualCustomerRequest;

import java.sql.Date;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateIndividualCustomerRequest {
	@JsonIgnore
	private int individualCustomersId;
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date birthday;
	@NotNull
	private String email;
	@NotNull
	private String password; 
	@NotNull
	private int findexScore;
//	@NotNull
//	private int userId;

}