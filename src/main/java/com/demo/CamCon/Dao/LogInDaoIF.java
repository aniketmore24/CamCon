package com.demo.CamCon.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.CamCon.Beans.User;

public interface LogInDaoIF extends JpaRepository<User,Integer>{

	User findByusername(String username);
}
