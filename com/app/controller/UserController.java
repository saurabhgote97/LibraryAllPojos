package com.app.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IUserDao;
import com.app.pojos.Users;

@RestController
@CrossOrigin//(origins="http://localhost:4200")
@RequestMapping("/users")
public class UserController 
{
	@Autowired
	private IUserDao dao;
	
	@PostConstruct
	public void init() 
	{
		System.out.println("in init " + dao);
	}

	// REST request handling method to get list of Users
	@GetMapping("/list")
	public ResponseEntity<?> listEmps() 
	{
		System.out.println("in list Users");
		
		List<Users> allUsers = dao.getAllUsers();
		
		if (allUsers.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Users>>(allUsers, HttpStatus.OK);
	}

	
	
}
