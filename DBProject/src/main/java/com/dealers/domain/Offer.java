package com.dealers.domain;

import java.math.BigDecimal;

public class Offer
{
	private Product product;

	private Dealer dealer;

	private BigDecimal price;

	public Offer()
	{
	}

	public Offer(Product product, Dealer dealer, BigDecimal price)
	{
		this.product = product;
		this.dealer = dealer;
		this.price = price;
	}

	public Product getProduct()
	{
		return product;
	}

	public Dealer getDealer()
	{
		return dealer;
	}

	public BigDecimal getPrice()
	{
		return price;
	}

	@Override
	public String toString()
	{
		return "Offer [product=" + product + ", dealer=" + dealer + ", price="
				+ price + "]";
	}

}
