package com.dealers.domain;

public class Product
{
	private long id;
	
	private String photoUrl;
	
	private String name;

	public Product(long id, String photoUrl, String name)
	{
		this.id = id;
		this.photoUrl = photoUrl;
		this.name = name;
	}

	public Product()
	{
	}

	public long getId()
	{
		return id;
	}

	public String getPhotoUrl()
	{
		return photoUrl;
	}

	public String getName()
	{
		return name;
	}
	
	@Override
	public String toString()
	{
		return "Product [id=" + id + ", photoUrl=" + photoUrl + ", name="
				+ name + "]";
	}
	
}
