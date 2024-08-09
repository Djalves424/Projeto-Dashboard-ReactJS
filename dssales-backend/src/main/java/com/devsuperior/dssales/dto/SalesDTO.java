package com.devsuperior.dssales.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.devsuperior.dssales.entities.Gender;
import com.devsuperior.dssales.entities.Sale;

public class SalesDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private LocalDate date;
	private Integer volume;
	private Double total;
	private Gender gender;
	private String categoryName;
	private String paymentMethod;
	private String storeName;
	
	public SalesDTO() {
	}

	public SalesDTO(Sale entity) {
		id = entity.getId();
		date = entity.getDate();
		volume = entity.getVolume();
		total = entity.getTotal();
		gender = entity.getGender();
		categoryName = entity.getCategory().getName();
		paymentMethod = entity.getPaymentMethod().getDescription();
		storeName = entity.getStore().getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
}
