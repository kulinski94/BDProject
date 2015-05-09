package com.dealers.domain.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.dealers.dao.User;
import com.dealers.domain.Category;
import com.dealers.domain.Deal;
import com.dealers.domain.Dealer;
import com.dealers.domain.Product;

@Repository
public class DealsDao extends NamedParameterJdbcDaoSupport
{

	@Autowired
	public DealsDao(DataSource dataSource)
	{
		this.setDataSource(dataSource);
	}

	public void makeDeal(int dealerId, int productId, String name)
	{
		String sql = "" + "INSERT INTO " + "    deals " + "    ("
				+ "    dealer_id," + "    product_id," + "    username ) "
				+ "VALUES " + "	   (" + "    :dealerId, " + "    :productId,"
				+ "    :username) ";
		Map<String, Object> params = new HashMap<>();
		params.put("productId", productId);
		params.put("dealerId", dealerId);
		params.put("username", name);

		getNamedParameterJdbcTemplate().update(sql, params);
	}

	public List<Dealer> getAllDealers()
	{
		String sql = "select * from dealers";
		return getJdbcTemplate().query(sql, new RowMapper<Dealer>()
		{

			@Override
			public Dealer mapRow(ResultSet rs, int arg1) throws SQLException
			{
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String address = rs.getString("address");
				BigDecimal delivery = rs.getBigDecimal("delivery_cost");
				return new Dealer(id, name, address, delivery);
			}
		});
	}

	public List<Deal> getAllDeals()
	{
		String sql = ""
				+ "select deals.id as dealID, deals.username as client, products.name as productName, "
				+ " dealers.name as dealerName,deals.quantity, deals.date, offers.price "
				+ "from deals "
				+ "join products "
				+ " on deals.product_id = products.id "
				+ "join dealers "
				+ " on dealers.id = deals.dealer_id "
				+ "join offers "
				+ "on offers.product_id = deals.product_id and offers.dealer_id = deals.dealer_id order by deals.date desc;";
		
		return getJdbcTemplate().query(sql,new DealRowMapper());
	}
	
	public List<Deal> getAllDealsByDealerId(int dealerId)
	{
		String sql = ""
				+ "select deals.id as dealID, deals.username as client, products.name as productName, "
				+ " dealers.name as dealerName,deals.quantity, deals.date, offers.price "
				+ "from deals "
				+ "join products "
				+ " on deals.product_id = products.id "
				+ "join dealers "
				+ " on dealers.id = deals.dealer_id "
				+ "join offers "
				+ "on offers.product_id = deals.product_id and offers.dealer_id = deals.dealer_id"
				+ "where deals.dealer_id = :dealerId;";
		
		Map<String,Object> params = new HashMap<>();
		params.put("dealerId", dealerId);
		
		return getJdbcTemplate().query(sql,new DealRowMapper());
	}
	
	public List<Deal> getAllDealsByDealerIdFromInPeriod(int dealerId, long from, long to)
	{
		String sql = ""
				+ "select deals.id as dealID, deals.username as client, products.name as productName, "
				+ " dealers.name as dealerName,deals.quantity, deals.date, offers.price "
				+ "from deals "
				+ "join products "
				+ " on deals.product_id = products.id "
				+ "join dealers "
				+ " on dealers.id = deals.dealer_id "
				+ "join offers "
				+ "on offers.product_id = deals.product_id and offers.dealer_id = deals.dealer_id"
				+ "where deals.dealer_id = :dealerId;";
		
		Map<String,Object> params = new HashMap<>();
		params.put("dealerId", dealerId);
		
		return getJdbcTemplate().query(sql,new DealRowMapper());
	}

}
