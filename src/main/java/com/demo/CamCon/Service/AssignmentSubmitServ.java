package com.demo.CamCon.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.demo.CamCon.Beans.AssignmentSubmit;
import com.demo.CamCon.Beans.Notes;
import com.demo.CamCon.Beans.Student;
import com.demo.CamCon.Dao.StudentsDaoIF;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;

@Service
public class AssignmentSubmitServ implements AssignmentSubmitIF {

	
	/*
	 * @Autowired StudentsDaoIF studDao;
	 */
	
	 @Autowired
	    private GridFsTemplate template;

	    @Autowired
	    private GridFsOperations operations;


	    @Override
	    public String addFile(MultipartFile upload, long prn,String assId) throws IOException {
	    	
	    	String ass="assignment";
	    	
	    	//Students s=studDao.findByPRN(id);
	        DBObject metadata = new BasicDBObject();
	        metadata.put("fileSize", upload.getSize());
	        //metadata.put("moduleId", id);
	        metadata.put("type", ass);
	        metadata.put("AssignmentId", assId);
	        metadata.put("PRN", prn);
	       // metadata.put("StudentName", s.getName());
	        

	        Object fileID = template.store(upload.getInputStream(), upload.getOriginalFilename(), upload.getContentType(), metadata);
	       // upload.
	        return fileID.toString();
	    }

	@Override
	public List<AssignmentSubmit> fetchSubStud( String assId) {
		
		
		List<GridFSFile> slist = new ArrayList<GridFSFile>();
		template.find(new Query(Criteria.where("metadata.AssignmentId").is(assId).and("metadata.PRN").exists(true))).into(slist);
		//Notes notes=new Notes();
		
		//List<LoadFile> alist=adao.findAll();
	
		List<AssignmentSubmit> updList=new ArrayList();
		//String s=alist.get(0).getId();
		int i=0;
		for (GridFSFile gfs : slist) {
			
			if(!slist.isEmpty())
			{
				gfs.getMetadata().get("PRN");
			updList.add(new AssignmentSubmit(gfs.getMetadata().get("PRN"),
					slist.get(i).getUploadDate(),slist.get(i).getObjectId().toString()));
			//System.out.println(updList);
			i++;
			}
			}
		//System.out.println(updList);
		return updList;
	}

	
	
}
