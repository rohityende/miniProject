package com.ray.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ray.Entity.Product;

public interface IProductRepository extends JpaRepository<Product, Integer>{

}
