package com.ray.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ray.Entity.Product;
import com.ray.repository.IProductRepository;

@Service("prodService")
public class ProductServiceImpl implements IProductService{
	
	@Autowired
	private IProductRepository prodRepo;

	@Override
	public String addProduct(Product product) {
		int id = prodRepo.save(product).getPid();
		return "Product added having id "+id;
	}

	@Override
	public List<Product> showAllProduct() {
		return prodRepo.findAll();
	}

	@Override
	public Product getProductById(Integer id) {
		return prodRepo.findById(id).orElseThrow(()->new IllegalArgumentException("invalid id "+id));
	}

	@Override
	public String updateProduct(Product product) {
		Optional<Product> opt = prodRepo.findById(product.getPid());
		if(opt.isPresent()) {
			prodRepo.save(product);
			return "Product is updated successfully id "+product.getPid();
		}
		return "Product not found for updation";
	}

	@Override
	public String deleteProductById(Integer id) {
		Optional<Product> opt = prodRepo.findById(id);
		if(opt.isPresent()) {
			prodRepo.deleteById(id);
			return "Product deleted successfully with id "+id;
		}
		return "Product not found for deletion";
	}

	@Override
	public String updatePriceById(Integer id, Double price) {
		Optional<Product> opt = prodRepo.findById(id);
		if(opt.isPresent()) {
			Product product = opt.get();
			product.setPrice(price);
			prodRepo.save(product);
			return "Product price is altered to "+price+" Rs.";
		}
		return "Product not found for updation with id "+id;
	}

}
