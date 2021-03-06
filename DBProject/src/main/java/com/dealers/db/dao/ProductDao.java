package com.dealers.db.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Component;

import com.dealers.db.ProductRowMapper;
import com.dealers.domain.Category;
import com.dealers.domain.Product;
import com.dealers.domain.ProductOffersStatistic;

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
		String sql = "" + "INSERT INTO " + "    products " + "    ("
				+ "    name," + "    photo," + "    category ) " + "VALUES "
				+ "	   (" + "    :name, " + "    :photo," + "    :category) ";
		Map<String, Object> params = new HashMap<>();
		params.put("name", product.getName());
		params.put("photo", product.getPhotoUrl());
		params.put("category", product.getCategory().toString());

		getNamedParameterJdbcTemplate().update(sql, params);
	}

	public Integer getProductOffersCount(long id)
	{
		String sql = "select count(*) from offers where product_id = :id";
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		return getNamedParameterJdbcTemplate().queryForObject(sql, params,
				Integer.class);
	}

	public Map<Product, ProductOffersStatistic> getAllProductsWithOffersCount()
	{
		String sql = ""
				+ "SELECT "
				+ "    id, name,photo,category, "
				+ "		COUNT(dealer_id) AS offersCount,"
				+ "		max(price) as maxPrice, "
				+ " 	min(price)  as minPrice,"
				+ "		avg(price) as averagePrice "
				+ "FROM " + "    products " + "        LEFT JOIN "
				+ "    offers ON id = product_id " + "GROUP BY id";
		Map<Product, ProductOffersStatistic> productsWithOfferCount = new HashMap<>();
		getNamedParameterJdbcTemplate().query(sql, new RowCallbackHandler()
		{

			@Override
			public void processRow(ResultSet rs) throws SQLException
			{
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String photo = rs.getString("photo");
				String category = rs.getString("category");
				Product product = new Product(id, photo, name, Category
						.valueOf(category));
				
				ProductOffersStatistic stat = new ProductOffersStatistic();
				stat.setCount(rs.getInt("offersCount"));
				stat.setMaxPrice(rs.getBigDecimal("maxPrice"));
				stat.setMinPrice(rs.getBigDecimal("minPrice"));
				stat.setAveragePrice(rs.getBigDecimal("averagePrice"));
				productsWithOfferCount.put(product, stat);

			}

		});

		return productsWithOfferCount;

	}

	public Map<Product, ProductOffersStatistic> getAllProductsWithOffersStatistics(
			Category category)
	{
		String sql = ""
				+ "SELECT "
				+ "    id, name,photo,category, "
				+ "		COUNT(dealer_id) AS offersCount,"
				+ "		max(price) as maxPrice, "
				+ " 	min(price)  as minPrice,"
				+ "		avg(price) as averagePrice "
				+ "FROM " + "    products " + "        LEFT JOIN "
				+ "    offers ON id = product_id where category = :category "
				+ "GROUP BY id";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("category", category.name());

		Map<Product, ProductOffersStatistic> productsWithOfferCount = new HashMap<>();
		getNamedParameterJdbcTemplate().query(sql, params,new RowCallbackHandler()
		{

			@Override
			public void processRow(ResultSet rs) throws SQLException
			{
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String photo = rs.getString("photo");
				String category = rs.getString("category");
				Product product = new Product(id, photo, name, Category
						.valueOf(category));

				ProductOffersStatistic stat = new ProductOffersStatistic();
				stat.setCount(rs.getInt("offersCount"));
				stat.setMaxPrice(rs.getBigDecimal("maxPrice"));
				stat.setMinPrice(rs.getBigDecimal("minPrice"));
				stat.setAveragePrice(rs.getBigDecimal("averagePrice"));
				productsWithOfferCount.put(product, stat);

			}

		});

		return productsWithOfferCount;
	}
	
	public Map<Product, ProductOffersStatistic> getAllProductsWithOffersStatisticsWithPrice(
			Category category, BigDecimal price)
	{
		String sql = ""
				+ "SELECT "
				+ "    id, name,photo,category, "
				+ "		COUNT(dealer_id) AS offersCount,"
				+ "		max(price) as maxPrice, "
				+ " 	min(price)  as minPrice,"
				+ "		avg(price) as averagePrice "
				+ "FROM " + "    products " + "        LEFT JOIN "
				+ "    offers ON id = product_id where category = :category "
				+ "GROUP BY id HAVING price < :price";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("category", category.name());
		params.put("price", price);

		Map<Product, ProductOffersStatistic> productsWithOfferCount = new HashMap<>();
		getNamedParameterJdbcTemplate().query(sql, params,new RowCallbackHandler()
		{

			@Override
			public void processRow(ResultSet rs) throws SQLException
			{
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String photo = rs.getString("photo");
				String category = rs.getString("category");
				Product product = new Product(id, photo, name, Category
						.valueOf(category));

				ProductOffersStatistic stat = new ProductOffersStatistic();
				stat.setCount(rs.getInt("offersCount"));
				stat.setMaxPrice(rs.getBigDecimal("maxPrice"));
				stat.setMinPrice(rs.getBigDecimal("minPrice"));
				stat.setAveragePrice(rs.getBigDecimal("averagePrice"));
				productsWithOfferCount.put(product, stat);

			}

		});

		return productsWithOfferCount;
	}
}
