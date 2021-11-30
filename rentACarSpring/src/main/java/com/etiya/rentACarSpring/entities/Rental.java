package com.etiya.rentACarSpring.entities;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rentals")
public class Rental {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rental_id")
	private int rentalId;
	
	@Column (name ="rent_date")
	private Date rentDate; 

	@Column (name="return_date")
	private Date returnDate;
	
	@ManyToOne(cascade = CascadeType.DETACH) 
	@JoinColumn (name= "id")
	private Car car;
	
	@ManyToOne(cascade = CascadeType.DETACH) 
	@JoinColumn (name= "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "take_city_id")
	private City takeCity;

	@ManyToOne
	@JoinColumn(name = "return_city_id")
	private City returnCity;
	
	
	
//	@ManyToOne(cascade = CascadeType.DETACH)
//	@JoinColumn(name = "individualCustomers_id")
//	private IndividualCustomer individualCustomer;
//	
//	@ManyToOne(cascade = CascadeType.DETACH)
//	@JoinColumn(name = "corparate_customer_id")
//	private CorparateCustomer corparateCustomer;
	
}
