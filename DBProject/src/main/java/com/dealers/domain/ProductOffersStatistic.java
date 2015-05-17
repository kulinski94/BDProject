package com.dealers.domain;

import java.math.BigDecimal;

public class ProductOffersStatistic
{
	@Override
	public String toString()
	{
		return "ProductOffersStatistic [count=" + count + ", maxPrice=" + maxPrice + ", minPrice=" + minPrice
				+ ", averagePrice=" + averagePrice + "]";
	}

	private int count;
	private BigDecimal maxPrice;
	private BigDecimal minPrice;
	private BigDecimal averagePrice;

	public int getCount()
	{
		return count;
	}

	public void setCount(int count)
	{
		this.count = count;
	}

	public BigDecimal getMaxPrice()
	{
		return maxPrice;
	}

	public void setMaxPrice(BigDecimal maxPrice)
	{
		this.maxPrice = maxPrice;
	}

	public BigDecimal getMinPrice()
	{
		return minPrice;
	}

	public void setMinPrice(BigDecimal minPrice)
	{
		this.minPrice = minPrice;
	}

	public BigDecimal getAveragePrice()
	{
		return averagePrice;
	}

	public void setAveragePrice(BigDecimal averagePrice)
	{
		this.averagePrice = averagePrice;
	}
	
	

}
