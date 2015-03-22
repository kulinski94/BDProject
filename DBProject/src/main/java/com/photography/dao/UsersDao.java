package com.photography.dao;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Component("usersDao")
public class UsersDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session session() {
		return sessionFactory.getCurrentSession();
	}
	
	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	@Transactional
	public void create(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		session().save(user);
	}

	public boolean exists(String username) {
		return jdbc.queryForObject(
				"select count(*) from users where username=:username",
				new MapSqlParameterSource("username", username), Integer.class) > 0;
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		Criteria crit = session().createCriteria(User.class);
		crit.add(Restrictions.eq("authority", "ROLE_USER"));
		return crit.list();
	}

	public User getUser(String username) {
			Criteria crit = session().createCriteria(User.class);
			crit.add(Restrictions.idEq(username));
			return (User)crit.uniqueResult();
	}
}
