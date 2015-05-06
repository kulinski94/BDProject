package com.dealers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dealers.domain.dao.DealerDao;

@Service
public class DealerService
{
	@Autowired
	private DealerDao dealerDao;
	
	public void makeDeal(int dealerId, int productId, String name)
	{
		dealerDao.makeDeal(dealerId,productId,name);
	}
}
