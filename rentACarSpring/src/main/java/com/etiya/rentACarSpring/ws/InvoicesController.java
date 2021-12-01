package com.etiya.rentACarSpring.ws;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import com.etiya.rentACarSpring.businnes.request.RentalRequest.DropOffCarUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.rentACarSpring.businnes.abstracts.InvoiceService;
import com.etiya.rentACarSpring.businnes.dtos.CarSearchListDto;
import com.etiya.rentACarSpring.businnes.dtos.InvoiceSearchListDto;
import com.etiya.rentACarSpring.businnes.request.CarRequest.CreateCarRequest;
import com.etiya.rentACarSpring.businnes.request.CarRequest.DeleteCarRequest;
import com.etiya.rentACarSpring.businnes.request.CarRequest.UpdateCarRequest;
import com.etiya.rentACarSpring.businnes.request.InvoiceRequest.CreateInvoiceDateRequest;
import com.etiya.rentACarSpring.businnes.request.InvoiceRequest.CreateInvoiceRequest;
import com.etiya.rentACarSpring.businnes.request.InvoiceRequest.DeleteInvoiceRequest;
import com.etiya.rentACarSpring.businnes.request.InvoiceRequest.UpdateInvoiceRequest;
import com.etiya.rentACarSpring.core.utilities.results.DataResult;
import com.etiya.rentACarSpring.core.utilities.results.Result;
import com.etiya.rentACarSpring.entities.complexTypes.CarDetailForColorAndBrand;

@RestController
@RequestMapping("api/invoices")
public class InvoicesController {

	private InvoiceService invoiceService;

	@Autowired
	public InvoicesController(InvoiceService invoiceService) {
		super();
		this.invoiceService = invoiceService;
	}

	@GetMapping("all")
	public DataResult<List<InvoiceSearchListDto>> getAll() {
		return invoiceService.getAll();
	}

	@PostMapping("add")
	public Result add(@RequestBody @Valid DropOffCarUpdateRequest dropOffCarUpdateRequest) {

		return this.invoiceService.Add(dropOffCarUpdateRequest);
	}

	@PutMapping("update")
	public Result update(@RequestBody @Valid UpdateInvoiceRequest updateInvoiceRequest) {
		return this.invoiceService.Update(updateInvoiceRequest);
	}

	@DeleteMapping("delete")
	public Result delete(@RequestBody @Valid DeleteInvoiceRequest deleteInvoiceRequest) {
		return this.invoiceService.Delete(deleteInvoiceRequest);
	}

	@GetMapping("getInvoiceByDate")
	public DataResult<List<InvoiceSearchListDto>> getCarByColor(@RequestParam("minDate") Date minDate,
			@RequestParam("maxDate") Date maxDate) throws ParseException {

		CreateInvoiceDateRequest createInvoiceDateRequest = new CreateInvoiceDateRequest();
		createInvoiceDateRequest.setMinDate(minDate);
		createInvoiceDateRequest.setMaxDate(maxDate);
		return invoiceService.getInvoiceByDate(createInvoiceDateRequest);
	}

	@GetMapping("getInvoiceByUserId")
	public DataResult<List<InvoiceSearchListDto>> getInvoiceByUserId(@RequestParam("userId") Integer userId) {

		return invoiceService.getInvoiceByUserId(userId);
	}
}
