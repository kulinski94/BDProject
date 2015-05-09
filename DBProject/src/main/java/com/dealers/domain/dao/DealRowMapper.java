package com.dealers.domain.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dealers.dao.User;
import com.dealers.domain.Deal;
import com.dealers.domain.Dealer;
import com.dealers.domain.Product;

public class DealRowMapper implements RowMapper<Deal>
{

	@Override
	public Deal mapRow(ResultSet rs, int arg1) throws SQLException
	{
		Deal deal = new Deal();
		deal.setClient(new User(rs.getString("client")));
		deal.setDealId(rs.getLong("dealId"));
		deal.setQuantity(rs.getInt("quantity"));
		deal.setTimestamp(rs.getTimestamp("date").getTime());
		Product product = new Product();
		product.setName(rs.getString("productName"));
		deal.setProduct(product);
		deal.setDealer(new Dealer(rs.getString("dealerName")));
		
		return deal;
	}
}
