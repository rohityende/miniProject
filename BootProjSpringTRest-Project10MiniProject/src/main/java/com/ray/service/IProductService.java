package com.ray.service;

import java.util.List;

import com.ray.Entity.Product;

public interface IProductService {
	
	public String addProduct(Product product);
	
	public List<Product> showAllProduct();
	
	public Product getProductById(Integer id);
	
	public String updateProduct(Product product);
	
	public String deleteProductById(Integer id);
	
	public String updatePriceById(Integer id, Double price);

}
