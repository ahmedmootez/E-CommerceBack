package com.youtube.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youtube.jwt.dao.ProductDao;
import com.youtube.jwt.entity.Product;



@Service
public class ProductService {
	@Autowired
	private ProductDao productDao;
public Product addNewProduct(Product product) {
	return productDao.save(product);
}

public List<Product> getAllProducts(){
	return productDao.findAll();
}

public void deleteProductDetails(Integer productId ) {
	productDao.deleteById(productId);
}

public Product getProductDetailsById(Integer productId) {
	return productDao.findById(productId).get();
}



}
