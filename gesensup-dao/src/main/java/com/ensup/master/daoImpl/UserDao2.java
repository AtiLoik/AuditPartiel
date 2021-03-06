package com.ensup.master.daoImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ensup.master.metier.User;

public class UserDao2 implements IUserDao2 {

	
	
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	public UserDao2() {
		super();
		entityManagerFactory = Persistence.createEntityManagerFactory("demojpapartiel");
		entityManager = entityManagerFactory.createEntityManager();	
	}
	
	@Override
	public User getUser(String login, String password) {
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		User user = entityManager.createNamedQuery("getUser", User.class).setParameter("login",login).
					setParameter("password", password).getSingleResult();
			//User user = new User();	
		return user;
	}
	
	
}
