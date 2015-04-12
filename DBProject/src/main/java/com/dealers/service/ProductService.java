package com.dealers.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public boolean addNewProduct(Product product)
	{
		return false;
	}
	
	public List<Product> getProductsByDealer(String dealerName) {
		return productDao.getProductsByDealer(dealerName);
	}

	public Map<Product, Integer> getAllProductsOffers()
	{
		Map<Product, Integer> productOffers = new HashMap<>();
		List<Product> allProducts = getAllProducts();
		for (Product product : allProducts)
		{
			int countOffers = productDao.getOffersCount(product.getId());
			productOffers.put(product, countOffers);
		}
		return productOffers;
	}
}
