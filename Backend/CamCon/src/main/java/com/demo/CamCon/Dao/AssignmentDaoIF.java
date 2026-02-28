package com.demo.CamCon.Dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.demo.CamCon.Beans.Assignment;

public interface AssignmentDaoIF extends MongoRepository<Assignment,String> {

}
