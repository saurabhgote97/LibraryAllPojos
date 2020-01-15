package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Users;

@Repository
@Transactional
public class UserDao implements IUserDao 
{
	
	@Autowired
	private SessionFactory sf;
	
	@Override
	public List<Users> getAllUsers() {
		System.out.println("Inside the UserDao");
		String jpql = "select u from Users u";
		return sf.getCurrentSession().createQuery(jpql, Users.class).getResultList();	
	}

}
