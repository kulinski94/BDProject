package com.dealers.domain;

import java.math.BigDecimal;

public class Offer
{
	private Product product;

	private Dealer dealer;

	private BigDecimal price;

	public Offer()
	{
		dealer = new Dealer();
		product = new Product();
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

	public void setProduct(Product product)
	{
		this.product = product;
	}
	
	public void setProductId(long productId)
	{
		this.product.setId(productId);
	}
	
	public void setDealerId(long dealerId)
	{
		this.dealer.setId(dealerId);
	}

	public long getProductId()
	{
		return product.getId();
	}

	public long getDealerId()
	{
		return dealer.getId();
	}
	
	public void setDealer(Dealer dealer)
	{
		this.dealer = dealer;
	}

	public void setPrice(BigDecimal price)
	{
		this.price = price;
	}

	@Override
	public String toString()
	{
		return "Offer [product=" + product + ", dealer=" + dealer + ", price="
				+ price + "]";
	}

}
