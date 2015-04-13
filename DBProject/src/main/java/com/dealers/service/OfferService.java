package com.dealers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dealers.domain.Product;
import com.dealers.domain.dao.OfferDao;

@Service
public class OfferService
{
	@Autowired
	private OfferDao offerDao;

	public List<Product> getOffersByDealer(int dealerID) {
		return offerDao.getOffersByDealer(dealerID);
	}
	
}