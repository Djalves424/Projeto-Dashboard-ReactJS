package com.devsuperior.dssales.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class SalesByDateDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private LocalDate date;
	private Double sum;
	
	public SalesByDateDTO() {
	}

	public SalesByDateDTO(LocalDate date, Double sum) {
		this.date = date;
		this.sum = sum;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Double getSum() {
		return sum;
	}

	public void setSum(Double sum) {
		this.sum = sum;
	}
}
