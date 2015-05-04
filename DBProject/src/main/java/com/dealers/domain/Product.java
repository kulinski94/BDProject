package com.dealers.domain;

public class Product
{
	private long id;
	
	private String photoUrl;
	
	private String name;
	
	private Category category;

	public Product(long id, String photoUrl, String name, Category category)
	{
		this.category = category;
		this.id = id;
		this.photoUrl = photoUrl;
		this.name = name;
	}

	public Product()
	{
	}

	public Category getCategory()
	{
		return category;
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
