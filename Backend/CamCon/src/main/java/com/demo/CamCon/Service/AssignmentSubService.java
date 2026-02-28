package com.demo.CamCon.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.IOUtils;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.demo.CamCon.Beans.Student;
import com.demo.CamCon.Dao.AssignmentSubDao;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;



@Service
public class AssignmentSubService implements AssignmentSubServIF {

	@Autowired
	AssignmentSubDao adao;
	
	 @Autowired
	    private GridFsTemplate template;

	    @Autowired
	    private GridFsOperations operations;

	@Override
	public Object addFile(MultipartFile file, long id, int assId) {
		
		
    	
        DBObject metadata = new BasicDBObject();
       // metadata.put("fileSize", upload.getSize());
        metadata.put("moduleId", id);
        metadata.put("type", "assignment");
        metadata.put("AssignmentId", assId);
        metadata.put("StudentId", id);
       // metadata.put("StudentName", s.getName());
        

        Object fileID = template.store(upload.getInputStream(), upload.getOriginalFilename(), upload.getContentType(), metadata);
       // upload.
        return fileID.toString();
		
		return null;
	}
	
}
