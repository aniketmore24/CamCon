package com.demo.CamCon.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.CamCon.Beans.Subject;
import com.demo.CamCon.Dao.SubjectDao;

@Service
public class SubjectService implements SubjectServiceIF {

	
	@Autowired
	SubjectDao subdao;
	
	
	
	@Override
	public List<Subject> getSubjects() {
		// TODO Auto-generated method stub
		return subdao.findAll();
	}



	@Override
	public Subject add(Subject sub) {
		// TODO Auto-generated method stub
		return subdao.save(sub);
	}

}
