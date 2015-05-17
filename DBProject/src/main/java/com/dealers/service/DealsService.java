package com.dealers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dealers.db.dao.DealsDao;
import com.dealers.domain.Deal;
import com.dealers.domain.Dealer;
import com.dealers.domain.DealsReportRequest;

@Service
public class DealsService
{
	@Autowired
	private DealsDao dealerDao;

	public void makeDeal(int dealerId, int productId, String name)
	{
		dealerDao.makeDeal(dealerId, productId, name);
	}

	public List<Dealer> getAllDealers()
	{
		return dealerDao.getAllDealers();
	}

	public List<Deal> getDeals(DealsReportRequest request)
	{
		int productId = request.getProductId();
		int dealerId = request.getDealerId();
		String username = request.getClientUsername();
		System.out.println(request);
		return dealerDao.getDeals(dealerId, productId, username);

	}
}
