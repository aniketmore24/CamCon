package com.demo.CamCon.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.CamCon.Beans.*;

public interface FeedbackRepositoryImpl extends JpaRepository<Feedback,Integer>{
    
List<Feedback> findBymodule(String module);

}
