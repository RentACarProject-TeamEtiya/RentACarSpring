package com.etiya.rentACarSpring.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "invoices")
public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "invoiceId")
	private int invoiceId;

	@Column(name = "invoice_number")
	private String invoiceNumber;

	@Column(name = "create_date")
	private Date createDate;

	@Column(name = "total_price")
	private int totalPrice;

	@Column(name = "total_rent_day")
	private int totalRentDay;

	@OneToOne
	@JoinColumn(name = "rental_id")
	private Rental rental;

}
