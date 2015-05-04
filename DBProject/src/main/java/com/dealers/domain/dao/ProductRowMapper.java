package com.dealers.domain.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dealers.domain.Category;
import com.dealers.domain.Product;

public class ProductRowMapper implements RowMapper<Product>
{

	@Override
	public Product mapRow(ResultSet set, int arg1) throws SQLException
	{
		int id = set.getInt("id");
		String name = set.getString("name");
		String url = set.getString("photo");
		String category = set.getString("category");
		
		Product product = new Product(id, url, name, Category.valueOf(category));
		
		return product;
	}

}
