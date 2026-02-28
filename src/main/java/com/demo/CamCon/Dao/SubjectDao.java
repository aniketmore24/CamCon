package com.demo.CamCon.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.CamCon.Beans.Subject;


@Repository
public interface SubjectDao extends JpaRepository<Subject, Integer> {

}
