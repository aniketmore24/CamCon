package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beans.User;

public interface LoginDaoIF extends JpaRepository<User, Integer> {

}
