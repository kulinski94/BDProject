package com.dealers.domain.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Component;

import com.dealers.domain.Product;

@Component("productDao")
public class ProductDao extends NamedParameterJdbcDaoSupport
{
	@Autowired
	public ProductDao(DataSource dataSource)
	{
		this.setDataSource(dataSource);
	}

	public List<Product> getAllProducts()
	{
		String sql = "select * from products";
		return getJdbcTemplate().query(sql, new ProductRowMapper());
	}

	public void saveNewProduct(Product product)
	{
	}

	public List<Product> getProductsByDealer(String dealerName)
	{
		return null;
	}

	public Integer getOffersCount(long id)
	{
		String sql = "select count(*) from offers where product_id = :id";
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		return getNamedParameterJdbcTemplate().queryForObject(sql, params, Integer.class);
	}
}
