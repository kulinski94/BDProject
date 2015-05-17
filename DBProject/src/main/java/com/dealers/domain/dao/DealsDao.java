package com.dealers.domain.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.dealers.domain.Deal;
import com.dealers.domain.Dealer;

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
		String sql = "" + "INSERT INTO " + "    deals " + "    (" + "    dealer_id," + "    product_id,"
				+ "    username ) " + "VALUES " + "	   (" + "    :dealerId, " + "    :productId," + "    :username) ";
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

	public List<Deal> getDeals(int dealerId, int productId, String username)
	{
		String sql= ""
				+ "SELECT deals.id       AS dealID, "
				+ "       deals.username AS client, "
				+ "       products.NAME  AS productName, "
				+ "       dealers.NAME   AS dealerName, "
				+ "       deals.quantity, "
				+ "       deals.date, "
				+ "       offers.price "
				+ "FROM   deals "
				+ "       JOIN products "
				+ "         ON deals.product_id = products.id "
				+ "       JOIN dealers "
				+ "         ON dealers.id = deals.dealer_id "
				+ "       JOIN offers "
				+ "         ON offers.product_id = deals.product_id "
				+ "            AND offers.dealer_id = deals.dealer_id "
				+ "WHERE  ( :productId <= 0 "
				+ "          OR deals.product_id = :productId ) "
				+ "       AND ( :dealerId <= 0 "
				+ "              OR deals.dealer_id = :dealerId ) "
				+ "       AND ( :username IS NULL "
				+ "              OR deals.username = :username )"
				+ "order by price desc;";
		System.out.println(sql);
		Map<String, Object> params = new HashMap<>();
		params.put("dealerId", dealerId);
		params.put("productId", productId);
		params.put("username", username);

		return getNamedParameterJdbcTemplate().query(sql, params, new DealRowMapper());
	}
}
