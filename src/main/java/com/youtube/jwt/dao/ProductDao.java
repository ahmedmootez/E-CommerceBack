package com.youtube.jwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youtube.jwt.entity.Product;


@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
	
}
