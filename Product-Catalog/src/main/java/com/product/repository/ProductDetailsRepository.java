package com.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.model.ProductDetails;

@Repository
public interface ProductDetailsRepository extends JpaRepository<ProductDetails, Long>{

	public List<ProductDetails> findByPrice(double price);
	public List<ProductDetails> findByColor(String color);
	public List<ProductDetails> findBySize(String size);
	
	 
}
