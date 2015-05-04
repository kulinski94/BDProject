package com.dealers.domain.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Component;

import com.dealers.domain.Category;
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

	public Integer getProductOffersCount(long id)
	{
		String sql = "select count(*) from offers where product_id = :id";
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		return getNamedParameterJdbcTemplate().queryForObject(sql, params,
				Integer.class);
	}

	public Collection<Map.Entry<Product, Integer>> getAllProductsWithOffersCount()
	{
		String sql = ""
				+ "SELECT "
				+ "    id, name,photo,category, COUNT(dealer_id) AS offersCount "
				+ "FROM " + "    products " + "        LEFT JOIN "
				+ "    offers ON id = product_id " + "GROUP BY id";
		return getNamedParameterJdbcTemplate().query(sql,
				new RowMapper<Map.Entry<Product, Integer>>()
				{
					@Override
					public Map.Entry<Product, Integer> mapRow(ResultSet set,
							int arg1) throws SQLException
					{
						int id = set.getInt("id");
						String name = set.getString("name");
						String photo = set.getString("photo");
						Integer count = set.getInt("offersCount");
						String category = set.getString("category");
						Product product = new Product(id, photo, name, Category
								.valueOf(category));

						return new AbstractMap.SimpleEntry<Product, Integer>(
								product, count);
					}
				});
	}

	public Collection<Entry<Product, Integer>> getAllProductsWithOffersCountByCategory(
			Category category)
	{
		String sql = ""
				+ "SELECT "
				+ "    id, name,photo,category, COUNT(dealer_id) AS offersCount "
				+ "FROM " + "    products " + "        LEFT JOIN "
				+ "    offers ON id = product_id where category = :category " + "GROUP BY id";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("category", category.name());
		return getNamedParameterJdbcTemplate().query(sql,params,
				new RowMapper<Map.Entry<Product, Integer>>()
				{
					@Override
					public Map.Entry<Product, Integer> mapRow(ResultSet set,
							int arg1) throws SQLException
					{
						int id = set.getInt("id");
						String name = set.getString("name");
						String photo = set.getString("photo");
						Integer count = set.getInt("offersCount");
						String category = set.getString("category");
						Product product = new Product(id, photo, name, Category
								.valueOf(category));

						return new AbstractMap.SimpleEntry<Product, Integer>(
								product, count);
					}
				});
	}
}
