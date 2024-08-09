package com.devsuperior.dssales.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dssales.dto.SalesByStoreDTO;
import com.devsuperior.dssales.dto.SalesByDateDTO;
import com.devsuperior.dssales.dto.SalesByPaymentMethodDTO;
import com.devsuperior.dssales.dto.SalesSummaryDTO;
import com.devsuperior.dssales.entities.Gender;
import com.devsuperior.dssales.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

	@Query("SELECT new com.devsuperior.dssales.dto.SalesByStoreDTO(obj.store, SUM(obj.total)) "
			+ "FROM Sale AS obj "
			+ "WHERE (CAST(:min AS date) IS NULL OR obj.date >= :min) "
			+ "AND (CAST(:max AS date) IS NULL OR obj.date <= :max) "
			+ "AND (:genderEnum IS NULL OR obj.gender = :genderEnum) "
			+ "GROUP BY obj.store")
	List<SalesByStoreDTO> salesByStore(LocalDate min, LocalDate max, Gender genderEnum);

	@Query("SELECT new com.devsuperior.dssales.dto.SalesByPaymentMethodDTO(obj.paymentMethod, SUM(obj.total)) "
			+ "FROM Sale AS obj "
			+ "WHERE (CAST(:min AS date) IS NULL OR obj.date >= :min) "
			+ "AND (CAST(:max AS date) IS NULL OR obj.date <= :max) "
			+ "AND (:genderEnum IS NULL OR obj.gender = :genderEnum) "
			+ "GROUP BY obj.paymentMethod")
	List<SalesByPaymentMethodDTO> salesByPaymentMethod(LocalDate min, LocalDate max, Gender genderEnum);
	
	@Query("SELECT new com.devsuperior.dssales.dto.SalesByDateDTO(obj.date, SUM(obj.total)) "
			+ "FROM Sale AS obj "
			+ "WHERE (CAST(:min AS date) IS NULL OR obj.date >= :min) "
			+ "AND (CAST(:max AS date) IS NULL OR obj.date <= :max) "
			+ "AND (:genderEnum IS NULL OR obj.gender = :genderEnum) "
			+ "GROUP BY obj.date")
	List<SalesByDateDTO> salesByDate(LocalDate min, LocalDate max, Gender genderEnum);
	
	@Query("SELECT obj FROM Sale obj "
			+ "JOIN FETCH obj.category "
			+ "JOIN FETCH obj.paymentMethod "
			+ "JOIN FETCH obj.store "
			+ "WHERE obj in :sales")
	List<Sale> salesWithOtherEntities(List<Sale> sales);
	
	@Query("SELECT new com.devsuperior.dssales.dto.SalesSummaryDTO(SUM(obj.total), MAX(obj.total), MIN(obj.total), AVG(obj.total), COUNT(obj.id)) "
			+ "FROM Sale AS obj "
			+ "WHERE (CAST(:min AS date) IS NULL OR obj.date >= :min) "
			+ "AND (CAST(:max AS date) IS NULL OR obj.date <= :max) "
			+ "AND (:genderEnum IS NULL OR obj.gender = :genderEnum) ")
	SalesSummaryDTO salesSummary(LocalDate min, LocalDate max, Gender genderEnum);

	@Query("SELECT obj "
			+ "FROM Sale AS obj "
			+ "WHERE (CAST(:min AS date) IS NULL OR obj.date >= :min) "
			+ "AND (CAST(:max AS date) IS NULL OR obj.date <= :max) "
			+ "AND (:genderEnum IS NULL OR obj.gender = :genderEnum) ")
	Page<Sale> searchPage(LocalDate min, LocalDate max, Gender genderEnum, Pageable pageable);
}
