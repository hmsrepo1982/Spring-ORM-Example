package com.hms.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hms.product.dao.ProductDao;
import com.hms.product.entity.Product;

@Service
public class ProductServiceImpl implements ProductSerrvice {

	@Autowired
	private ProductDao prodDao;


	@Transactional
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return prodDao.findAll();
	}

	@Transactional // Required
	public void saveProduct(Product prod) throws RuntimeException {
		// step -1 - save Product
		prodDao.saveProduct(prod); // step -1
		prodDao.updateProduct(new Product());
	
		System.out.print("Do more Transactional Testing .... ");
	}


	@Transactional
	public Product findById(int id) {
		// TODO Auto-generated method stub
		return prodDao.findById(id);
	}


	@Transactional
	public List<Product> findByName(String productName) {
		// TODO Auto-generated method stub
		return prodDao.findByName(productName);
	}


	@Transactional // Required
	public Object updateProduct(Product newProduct) throws RuntimeException {
		
		return prodDao.updateProduct(newProduct);
	}


	@Transactional
	public void deleteById(int id) {
		prodDao.deleteById(id);
	}

}
