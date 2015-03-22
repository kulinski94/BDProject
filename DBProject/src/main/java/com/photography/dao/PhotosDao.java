package com.photography.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Transactional
@Component("photosDao")
public class PhotosDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Session session() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<Photo> getPhotos(String username) {
		Criteria crit = session().createCriteria(Photo.class);
		crit.createAlias("user", "u");
		crit.add(Restrictions.eq("u.enabled", true));
		crit.add(Restrictions.eq("u.username", username));
		return crit.list();
	}

	@Transactional
	public void selectPhotos(List<Integer> selectedIds) {
		for (Integer id: selectedIds) {
			Photo photo = (Photo) session().get(Photo.class, id);
			photo.setSelected(true);
			session().update(photo);
		}
	}
	public void uploadPhotos(String username, List<Photo> photos) {
		for (Photo photo : photos) {
			photo.setUser(new User());
			photo.getUser().setUsername(username);
			photo.setSelected(false);
			session().save(photo);
		}
	}
}
