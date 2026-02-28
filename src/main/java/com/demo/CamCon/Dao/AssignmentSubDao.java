package com.demo.CamCon.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.CamCon.Beans.AssignmentSubmit;

public interface AssignmentSubDao extends JpaRepository<AssignmentSubmit, Integer> {

}
