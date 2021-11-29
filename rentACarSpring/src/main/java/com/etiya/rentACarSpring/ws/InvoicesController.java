package com.etiya.rentACarSpring.ws;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.rentACarSpring.businnes.abstracts.InvoiceService;
import com.etiya.rentACarSpring.businnes.dtos.CarSearchListDto;
import com.etiya.rentACarSpring.businnes.dtos.InvoiceSearchListDto;
import com.etiya.rentACarSpring.businnes.request.CarRequest.CreateCarRequest;
import com.etiya.rentACarSpring.businnes.request.CarRequest.DeleteCarRequest;
import com.etiya.rentACarSpring.businnes.request.CarRequest.UpdateCarRequest;
import com.etiya.rentACarSpring.businnes.request.InvoiceRequest.CreateInvoiceRequest;
import com.etiya.rentACarSpring.businnes.request.InvoiceRequest.DeleteInvoiceRequest;
import com.etiya.rentACarSpring.businnes.request.InvoiceRequest.UpdateInvoiceRequest;
import com.etiya.rentACarSpring.core.utilities.results.DataResult;
import com.etiya.rentACarSpring.core.utilities.results.Result;

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
	public Result add(@RequestBody @Valid CreateInvoiceRequest createInvoiceRequest) {

		return this.invoiceService.Add(createInvoiceRequest);
	}

	@PutMapping("update")
	public Result update(@RequestBody @Valid UpdateInvoiceRequest updateInvoiceRequest) {
		return this.invoiceService.Update(updateInvoiceRequest);
	}

	@DeleteMapping("delete")
	public Result delete(@RequestBody @Valid DeleteInvoiceRequest deleteInvoiceRequest) {
		return this.invoiceService.Delete(deleteInvoiceRequest);
	}
}
