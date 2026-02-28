package com.demo.CamCon.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.CamCon.Beans.Student;

public interface StudentsDaoIF extends JpaRepository<Student, String> {

	Student findByPRN(long id);
}
