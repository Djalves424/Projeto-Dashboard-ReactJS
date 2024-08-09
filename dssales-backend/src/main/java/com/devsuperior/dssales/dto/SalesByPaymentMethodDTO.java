package com.devsuperior.dssales.dto;

import java.io.Serializable;

import com.devsuperior.dssales.entities.PaymentMethod;

public class SalesByPaymentMethodDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String description;
	private Double sum;
	
	public SalesByPaymentMethodDTO() {
	}

	public SalesByPaymentMethodDTO(PaymentMethod paymentMethod, Double sum) {
		this.description = paymentMethod.getDescription();
		this.sum = sum;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getSum() {
		return sum;
	}

	public void setSum(Double sum) {
		this.sum = sum;
	}
}
