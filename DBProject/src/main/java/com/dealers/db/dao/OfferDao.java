package com.dealers.db.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.dealers.db.OfferRowMapper;
import com.dealers.db.ProductRowMapper;
import com.dealers.domain.Offer;
import com.dealers.domain.Product;
@Repository
public class OfferDao extends NamedParameterJdbcDaoSupport
{

	@Autowired
	public OfferDao(DataSource dataSource)
	{
		this.setDataSource(dataSource);
	}
	
	public List<Product> getOffersByDealer(int dealerId)
	{
		String sql = "select id,name,photo,price from offers join products on product_id = id where dealer_id = :id";
		Map<String, Object> params = new HashMap<>();
		params.put("id", dealerId);
		return getNamedParameterJdbcTemplate().query(sql, params,
				new ProductRowMapper());
	}
	
	public List<Offer> getOffersForProduct(int productId)
	{
		String sql = "" 
					+ "SELECT "
					+ "    products.name as productName, "
					+ "    dealers.name as dealerName, "
					+ "    offers.price, "
					+ "    dealers.delivery_cost, "
					+ "    offers.dealer_id, "
					+ "    offers.product_id "
					+ "FROM "
					+ "    offers "
					+ "        JOIN "
					+ "    dealers ON dealers.id = offers.dealer_id "
					+ "        JOIN "
					+ "    products ON products.id = offers.product_id "
					+ "WHERE "
					+ "    product_id = :id;";
		Map<String, Object> params = new HashMap<>();
		params.put("id", productId);
		return getNamedParameterJdbcTemplate().query(sql, params, new OfferRowMapper());
	}

	public void saveOffer(Offer offer)
	{
		String sql = "" 
				+ "INSERT INTO "
				+ "    offers "
				+ "    ("
				+ "    dealer_id,"
				+ "    product_id,"
				+ "    price ) "
				+ "VALUES "
				+ "	   ("
				+ "    :dealerId, "
				+ "    :productId,"
				+ "    :price) ";
		Map<String, Object> params = new HashMap<>();
		params.put("dealerId", offer.getDealer().getId());
		params.put("productId",offer.getProduct().getId());
		params.put("price", offer.getPrice());

		getNamedParameterJdbcTemplate().update(sql, params);
	}
}
