package com.dealers.domain;

import java.sql.Date;

import com.mysql.jdbc.StringUtils;

import freemarker.template.utility.StringUtil;

public class DealsReportRequest
{
	private int dealerId;

	private String clientUsername;

	private int productId;

	private Date from;

	private Date to;

	public int getDealerId()
	{
		return dealerId;
	}

	public void setDealerId(int dealerId)
	{
		this.dealerId = dealerId;
	}

	public String getClientUsername()
	{
		return clientUsername;
	}

	public void setClientUsername(String clientUsername)
	{
		if (clientUsername.equals(""))
			this.clientUsername = null;
		else
			this.clientUsername = clientUsername;
	}

	public int getProductId()
	{
		return productId;
	}

	public void setProductId(int productId)
	{
		this.productId = productId;
	}

	public Date getFrom()
	{
		return from;
	}

	public void setFrom(Date from)
	{
		this.from = from;
	}

	public Date getTo()
	{
		return to;
	}

	public void setTo(Date to)
	{
		this.to = to;
	}

	@Override
	public String toString()
	{
		return "DealsReportRequest [dealerId=" + dealerId + ", clientUsername=" + clientUsername + ", productId="
				+ productId + ", from=" + from + ", to=" + to + "]";
	}

}
