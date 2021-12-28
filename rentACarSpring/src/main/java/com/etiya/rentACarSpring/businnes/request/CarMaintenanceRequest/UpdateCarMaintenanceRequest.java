package com.etiya.rentACarSpring.businnes.request.CarMaintenanceRequest;

import java.sql.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarMaintenanceRequest {
	@NotNull
	private int carMaintenanceId;
	@NotNull
	private Date returnDate;

	//private Date maintenanceDate;

}
