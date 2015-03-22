package com.photography.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="photos")
public class Photo {

	@GeneratedValue
	@Id
	private int id;
	
	@NotBlank(groups={PersistenceValidationGroup.class, FormValidationGroup.class})
	private String title;
	
	@NotBlank(groups={PersistenceValidationGroup.class, FormValidationGroup.class})
	private String url;
	
	@ManyToOne
	@JoinColumn(name="username")
	private User user;

	private boolean selected = false;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	
}
