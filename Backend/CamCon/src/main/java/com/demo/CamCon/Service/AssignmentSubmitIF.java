package com.demo.CamCon.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.demo.CamCon.Beans.AssignmentSubmit;
import com.demo.CamCon.Beans.Student;


public interface AssignmentSubmitIF {

	List<AssignmentSubmit> fetchSubStud( String assId);

	String addFile(MultipartFile upload, long id, String id2) throws IOException;
	

}
