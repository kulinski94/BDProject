package com.dealers.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dealers.domain.Category;
import com.dealers.domain.Product;
import com.dealers.domain.dao.ProductDao;

@Service
public class ProductService
{
	@Autowired
	private ProductDao productDao;

	public List<Product> getAllProducts()
	{
		return productDao.getAllProducts();
	}

	public Map<Product, Integer> getAllProductsOffers()
	{
		return productDao.getAllProductsWithOffersCount();
	}

	public Map<Product, Integer> getAllProductsOffers(Category category)
	{
		return productDao.getAllProductsWithOffersCountByCategory(category);
	}

	public void saveProduct(Product product)
	{
		productDao.saveNewProduct(product);
	}
}
