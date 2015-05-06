package com.dealers.domain.dao;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class DealerDao extends NamedParameterJdbcDaoSupport
{

	@Autowired
	public DealerDao(DataSource dataSource)
	{
		this.setDataSource(dataSource);
	}
	
	public void makeDeal(int dealerId, int productId, String name)
	{
		String sql = "" 
				+ "INSERT INTO "
				+ "    deals "
				+ "    ("
				+ "    dealer_id,"
				+ "    product_id,"
				+ "    username ) "
				+ "VALUES "
				+ "	   ("
				+ "    :dealerId, "
				+ "    :productId,"
				+ "    :username) ";
		Map<String, Object> params = new HashMap<>();
		params.put("productId", productId);
		params.put("dealerId", dealerId);
		params.put("username", name);

		getNamedParameterJdbcTemplate().update(sql, params);
	}
	
}
