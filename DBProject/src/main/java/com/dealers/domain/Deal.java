package com.dealers.domain;

import java.math.BigDecimal;

public class Deal
{

	private long dealId;
	
	private Dealer dealer;
	
	private Product product;
	
	private User client;
	
	private int quantity;
	
	private long timestamp;
	
	private BigDecimal sum;

	public long getDealId()
	{
		return dealId;
	}

	public void setDealId(long dealId)
	{
		this.dealId = dealId;
	}

	public Dealer getDealer()
	{
		return dealer;
	}

	public void setDealer(Dealer dealer)
	{
		this.dealer = dealer;
	}

	public Product getProduct()
	{
		return product;
	}

	public void setProduct(Product product)
	{
		this.product = product;
	}

	public User getClient()
	{
		return client;
	}

	public void setClient(User client)
	{
		this.client = client;
	}

	public int getQuantity()
	{
		return quantity;
	}

	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}

	public long getTimestamp()
	{
		return timestamp;
	}

	public void setTimestamp(long timestamp)
	{
		this.timestamp = timestamp;
	}
	
	public BigDecimal getSum()
	{
		return sum;
	}

	public void setSum(BigDecimal sum)
	{
		this.sum = sum;
	}

	@Override
	public String toString()
	{
		return "Deal [dealId=" + dealId + ", dealer=" + dealer + ", product=" + product + ", client=" + client
				+ ", quantity=" + quantity + ", timestamp=" + timestamp + ", sum=" + sum + "]";
	}

	
	
	
	
}
