package com.demo.CamCon.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.web.multipart.MultipartFile;

import com.demo.CamCon.Beans.Assignment;

public interface AssignmentServiceIF {

	Object addFile(MultipartFile file) throws IOException;

	Assignment fetchAssignment(String id);

	List<Assignment> getAll();

	List<Assignment> addAll();


	
	//Assignment getAssignment(Integer id);

}
