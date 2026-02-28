package com.demo.CamCon.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.CamCon.Beans.User;
import com.demo.CamCon.Dao.LogInDaoIF;

@Service
public class LogInServiceImpl implements LogInServiceIF {

	
	@Autowired
	LogInDaoIF ldao;

	@Override
	public User Auth(User user) {
		
		User verUser=ldao.findByusername(user.getUsername());
		if((verUser!=null) && (user.getPassword().equals(verUser.getPassword())))
		return verUser;
		
		return null;
	}
	
}
