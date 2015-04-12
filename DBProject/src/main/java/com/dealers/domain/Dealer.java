package com.dealers.domain;

import java.math.BigDecimal;

public class Dealer
{
	private long id;
	
	private String name;
	
	private String address;
	
	private BigDecimal deliveryCost;

	
	public Dealer(long id, String name, String address, BigDecimal deliveryCost)
	{
		this.id = id;
		this.name = name;
		this.address = address;
		this.deliveryCost = deliveryCost;
	}

	public long getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public String getAddress()
	{
		return address;
	}

	public BigDecimal getDeliveryCost()
	{
		return deliveryCost;
	}

	@Override
	public String toString()
	{
		return "Dealer [id=" + id + ", name=" + name + ", address=" + address
				+ ", deliveryCost=" + deliveryCost + "]";
	}
	
	
	
}
