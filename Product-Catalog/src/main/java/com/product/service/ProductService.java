package com.product.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.model.Product;
import com.product.model.ProductDetails;
import com.product.model.ProductReqResponse;
import com.product.repository.ProductDetailsRepository;
import com.product.repository.ProductRepository;

@Service
@Transactional
public class ProductService {

	private ProductRepository productRepository;
	private ProductDetailsRepository productDetailsRepository;
	@Autowired
	public ProductService(ProductRepository productRepository, ProductDetailsRepository productDetailsRepository) {

		this.productRepository = productRepository;
		this.productDetailsRepository = productDetailsRepository;
	}



	public void	postProductDetails(ProductReqResponse productRequest) throws Exception{
		try {

			Product product=null;
			product=productRepository.findByBrand(productRequest.getBrand());

			if(product==null)
			{
				product=new Product();
				product.setBrand(productRequest.getBrand());				
				productRepository.save(product);
			}


			ProductDetails prodDetails=new ProductDetails();
			prodDetails.setSize(productRequest.getSize());
			prodDetails.setColor(productRequest.getColor());
			prodDetails.setPrice(productRequest.getPrice());
			prodDetails.setGender(productRequest.getGender());
			prodDetails.setSeller(productRequest.getSeller());
			prodDetails.setProductType(productRequest.getProductType());
			prodDetails.setProduct(product);
			productDetailsRepository.save(prodDetails);


		}catch (Exception e) {
			throw new Exception(e);
		}


	}

	public Product findByBrand(String brandName) {

		return productRepository.findByBrand(brandName);
	}

	public List<ProductDetails> findByPrice(double price) {

		return productDetailsRepository.findByPrice(price);
	}

	public List<ProductDetails> findByColor(String color) {

		return productDetailsRepository.findByColor(color);
	}


	public List<ProductDetails> findBySize(String size) {
		return productDetailsRepository.findBySize(size);
	}


}
