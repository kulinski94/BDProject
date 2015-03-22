package com.photography.dao;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.photography.validation.ValidLink;

public class Album {

	
	@NotBlank(groups={PersistenceValidationGroup.class, FormValidationGroup.class})
	@Size(min=8, max=60, groups={PersistenceValidationGroup.class, FormValidationGroup.class})
	private String name;
	
	@ValidLink(groups={PersistenceValidationGroup.class, FormValidationGroup.class})
	private String link;
	
	@NotBlank(groups={PersistenceValidationGroup.class, FormValidationGroup.class})
	@Size(min=5, max=15,groups={PersistenceValidationGroup.class, FormValidationGroup.class})
	@Pattern(regexp="^\\w{8,}$",groups={PersistenceValidationGroup.class, FormValidationGroup.class})
	private String username;

	
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLink() {
		return link;
	}

	
	public void setLink(String link) {
		this.link = link;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	@Override
	public String toString() {
		return "Album [name=" + name + ", link=" + link + ", username="
				+ username + "]";
	}

	
	
}
