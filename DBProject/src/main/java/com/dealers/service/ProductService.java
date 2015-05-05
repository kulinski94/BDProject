package com.dealers.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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

	public boolean addNewProduct(Product product)
	{
		return false;
	}

	public Map<Product, Integer> getAllProductsOffers()
	{
		Collection<Map.Entry<Product, Integer>> productsOffers = productDao
				.getAllProductsWithOffersCount();
		Map<Product, Integer> productsMap = new HashMap<Product, Integer>();
		for (Entry<Product, Integer> entry : productsOffers)
		{
			productsMap.put(entry.getKey(), entry.getValue());
		}
		return productsMap;
	}

	public Map<Product, Integer> getAllProductsOffers(Category category)
	{
		Collection<Map.Entry<Product, Integer>> productsOffers = productDao
				.getAllProductsWithOffersCountByCategory(category);
		Map<Product, Integer> productsMap = new HashMap<Product, Integer>();
		for (Entry<Product, Integer> entry : productsOffers)
		{
			productsMap.put(entry.getKey(), entry.getValue());
		}
		return productsMap;
	}

	public void saveProduct(Product product)
	{
		productDao.saveNewProduct(product);
	}
}
