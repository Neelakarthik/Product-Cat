package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.product.model.Product;
import com.product.model.ProductDetails;
import com.product.model.ProductReqResponse;
import com.product.service.ProductService;

@RestController
public class SearchController {
	
	private ProductService productService;

	@Autowired
	public SearchController(ProductService service) {
	
		this.productService = service;
	}
	
	/* This method is used to retrive the price information based on the user input price
	 * 
	 */
	
	@RequestMapping("/findByPrice/{price}")
	public List<ProductDetails> findByPrice(@PathVariable("price") String price) {
	
		return  productService.findByPrice(Double.parseDouble(price));
						
	}
	
	/* This method is used to retrive the brand information based on the user input brand name
	 * 
	 */
	@RequestMapping("/findByBrand/{brandName}")
	public Product findByBrand(@PathVariable("brandName") String brandName) {
	
		
		return  productService.findByBrand(brandName);
				
	}
	
	@RequestMapping("/findByColor/{color}")
	public List<ProductDetails> findByColor(@PathVariable("color") String color) {
	
		
		return  productService.findByColor(color);
		
	}
	@RequestMapping("/findBySize/{size}")
	public List<ProductDetails> findBySize(@PathVariable("size") String size) {
	
		
		return  productService.findBySize(size);
		
	}
	
	
	/* This method is used to insert the Product and Product details information. This end point can be called by supplier
	 * 
	 */
	@RequestMapping(value="/insertProductData", method = RequestMethod.POST)
	public void postProductDetails(@RequestBody ProductReqResponse productRequest ) throws Exception {
	
		try {
			
			productService.postProductDetails(productRequest);
									
		}catch (Exception e) {
			throw new Exception(e);
		}
		
	}
	
	/* This method is used to insert the Product and Product details information. This end point can be called by supplier
	 * 
	 */
	@RequestMapping(value="/bulkProductDetailsInsert", method = RequestMethod.POST)
	public void bulkProductDetailsInsert(@RequestBody ProductReqResponse[] productRequest ) throws Exception {
	
		try {
			for (ProductReqResponse productReqResponse : productRequest) {
				productService.postProductDetails(productReqResponse);
			}
			
									
		}catch (Exception e) {
			throw new Exception(e);
		}
		
	}
	
	

}
