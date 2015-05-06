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
		Deal deal = new Deal();
		deal.setClient(new User("Tseko", null, null, null, false, null));
		deal.setDealer(new Dealer(2, "Ivan", "", BigDecimal.ONE));
		deal.setProduct(new Product(2, "BMW", "BMW",Category.ALCOHOL));
		deal.setDealId(12);
		deal.setQuantity(2);
		deal.setTimestamp(120010012223L);
		return Collections.singletonList(deal);
	}

}
