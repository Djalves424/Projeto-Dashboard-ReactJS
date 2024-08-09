package com.devsuperior.dssales.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dssales.dto.SalesByStoreDTO;
import com.devsuperior.dssales.dto.SalesByDateDTO;
import com.devsuperior.dssales.dto.SalesByPaymentMethodDTO;
import com.devsuperior.dssales.dto.SalesDTO;
import com.devsuperior.dssales.dto.SalesSummaryDTO;
import com.devsuperior.dssales.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	@Autowired
	private SaleService service;
	
	@GetMapping
	public ResponseEntity<Page<SalesDTO>> sales(
			@RequestParam(value = "minDate", defaultValue = "") String minDate,
			@RequestParam(value = "maxDate", defaultValue = "") String maxDate,
			@RequestParam(value = "gender", defaultValue = "") String gender,
			Pageable pageable) {
		Page<SalesDTO> page = service.sales(minDate, maxDate, gender, pageable);
		return ResponseEntity.ok(page);
	}
	
	@GetMapping(value = "/by-store")
	public ResponseEntity<List<SalesByStoreDTO>> salesByStore(
			@RequestParam(value = "minDate", defaultValue = "") String minDate,
			@RequestParam(value = "maxDate", defaultValue = "") String maxDate,
			@RequestParam(value = "gender", defaultValue = "") String gender) {
		List<SalesByStoreDTO> list = service.salesByStore(minDate, maxDate, gender);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/by-payment-method")
	public ResponseEntity<List<SalesByPaymentMethodDTO>> salesByPaymentMethod(
			@RequestParam(value = "minDate", defaultValue = "") String minDate,
			@RequestParam(value = "maxDate", defaultValue = "") String maxDate,
			@RequestParam(value = "gender", defaultValue = "") String gender) {
		List<SalesByPaymentMethodDTO> list = service.salesByPaymentMethod(minDate, maxDate, gender);
		return ResponseEntity.ok(list);
	}	
	
	@GetMapping(value = "/by-date")
	public ResponseEntity<List<SalesByDateDTO>> salesByDate(
			@RequestParam(value = "minDate", defaultValue = "") String minDate,
			@RequestParam(value = "maxDate", defaultValue = "") String maxDate,
			@RequestParam(value = "gender", defaultValue = "") String gender) {
		List<SalesByDateDTO> list = service.salesByDate(minDate, maxDate, gender);
		return ResponseEntity.ok(list);
	}	
	
	@GetMapping(value = "/summary")
	public ResponseEntity<SalesSummaryDTO> salesSummary(
			@RequestParam(value = "minDate", defaultValue = "") String minDate,
			@RequestParam(value = "maxDate", defaultValue = "") String maxDate,
			@RequestParam(value = "gender", defaultValue = "") String gender) {
		SalesSummaryDTO obj = service.salesSummary(minDate, maxDate, gender);
		return ResponseEntity.ok(obj);
	}	
}
