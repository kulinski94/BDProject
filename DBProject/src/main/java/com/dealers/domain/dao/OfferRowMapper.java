package com.dealers.domain.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dealers.domain.Dealer;
import com.dealers.domain.Offer;
import com.dealers.domain.Product;

public class OfferRowMapper implements RowMapper<Offer>
{
	@Override
	public Offer mapRow(ResultSet set, int arg1) throws SQLException
	{
		int dealerId = set.getInt("dealer_id");
		int productId = set.getInt("product_id");
		String productName = set.getString("productName");
		String dealerName = set.getString("dealerName");
		BigDecimal price = set.getBigDecimal("price");
		BigDecimal deliveryCost = set.getBigDecimal("delivery_cost");
		Product product = new Product(productId, null, productName);
		Dealer dealer = new Dealer(dealerId, dealerName, null, deliveryCost);
		return new Offer(product, dealer, price);
	}

}
