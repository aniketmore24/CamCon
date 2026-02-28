package com.demo.CamCon.Dao;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.CamCon.Beans.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Integer>{

}
