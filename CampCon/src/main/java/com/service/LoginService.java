package com.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.LoginDaoIF;

public class LoginService implements LoginServiceIF {
	
	
	@Autowired
	LoginDaoIF ldao;

	
	
}
