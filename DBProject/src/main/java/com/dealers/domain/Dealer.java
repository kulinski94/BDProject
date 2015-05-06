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

	public Dealer()
	{
		// TODO Auto-generated constructor stub
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

	public void setId(long id)
	{
		this.id = id;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public void setDeliveryCost(BigDecimal deliveryCost)
	{
		this.deliveryCost = deliveryCost;
	}

	@Override
	public String toString()
	{
		return "Dealer [id=" + id + ", name=" + name + ", address=" + address
				+ ", deliveryCost=" + deliveryCost + "]";
	}
	
	
	
}
