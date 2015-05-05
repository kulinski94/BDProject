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
	
	
	public void setId(long id)
	{
		this.id = id;
	}

	public void setPhotoUrl(String photoUrl)
	{
		this.photoUrl = photoUrl;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setCategory(String category)
	{
		this.category = Category.valueOf(category);
	}

	@Override
	public String toString()
	{
		return "Product [id=" + id + ", photoUrl=" + photoUrl + ", name="
				+ name + ", category=" + category + "]";
	}

	
}
