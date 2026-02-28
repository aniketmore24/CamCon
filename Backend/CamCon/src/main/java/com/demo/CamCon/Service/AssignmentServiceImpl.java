package com.demo.CamCon.Service;

import java.io.IOException;
import java.util.*;
import java.util.Optional;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.demo.CamCon.Beans.Assignment;
import com.demo.CamCon.Dao.AssignmentDaoIF;

@Service
public class AssignmentServiceImpl implements AssignmentServiceIF {
	
	@Autowired
	AssignmentDaoIF adao;
	
	@Override
	public Object addFile(MultipartFile file) throws IOException {
		Assignment ass = new Assignment("Assignment Java", new Binary(BsonBinarySubType.BINARY, file.getBytes())); 
        System.out.println(ass);
        ass = adao.insert(ass); 
        return ass;
	}

	@Override
	public Assignment fetchAssignment(String id) {	 
	        return adao.findById(id).get(); 
	}

	@Override
	public List<Assignment> getAll() {
		return adao.findAll();
	}
	
	@Override
	public List<Assignment> addAll() {
		
		List<Assignment> alist=adao.findAll();
		List<Assignment> updList=new ArrayList();
		int i=0;
		for (Assignment assignment : alist) {
			if(!alist.isEmpty())
			updList.add(new Assignment(alist.get(i).getId(),alist.get(i).getDescription(),alist.get(i).getDate()));
			i++;
		}
		
		return updList;
	}
	
}
