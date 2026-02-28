package com.demo.CamCon.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.demo.CamCon.Beans.Notes;
import com.demo.CamCon.Beans.Student;
import com.demo.CamCon.Beans.User;
import com.demo.CamCon.Dao.LogInDaoIF;
import com.demo.CamCon.Dao.StudentsDaoIF;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;

@Service
public class StudentService implements StudentServiceIF {

	
	@Autowired
	StudentsDaoIF studDao;
	
	@Autowired
	LogInDaoIF ldao;
	
	 @Autowired
	    private GridFsTemplate template;

	    @Autowired
	    private GridFsOperations operations;


	    @Override
	    public String addFile(MultipartFile upload, long id,int assId) throws IOException {
	    	
	    	String ass="assignment";
	    	
	    	Student s=studDao.findByPRN(id);
	        DBObject metadata = new BasicDBObject();
	        metadata.put("fileSize", upload.getSize());
	        metadata.put("moduleId", id);
	        metadata.put("type", ass);
	        metadata.put("AssignmentId", assId);
	        metadata.put("StudentId", id);
	        metadata.put("StudentName", s.getName());
	        

	        Object fileID = template.store(upload.getInputStream(), upload.getOriginalFilename(), upload.getContentType(), metadata);
	       // upload.
	        return fileID.toString();
	    }

	@Override
	public List<Student> fetchSubStud( int assId) {
		
		
		List<GridFSFile> slist = new ArrayList<GridFSFile>();
		template.find(new Query(Criteria.where("metadata.AssignmentId").is(assId).and("metadata.StudentId").exists(true))).into(slist);
		//Notes notes=new Notes();
		
		//List<LoadFile> alist=adao.findAll();
		System.out.println(slist.get(0).getMetadata().get("StudentName"));
		List<Student> updList=new ArrayList();
		//String s=alist.get(0).getId();
		int i=0;
		for (GridFSFile gfs : slist) {
			
			if(!slist.isEmpty())
			{
			//updList.add(new Students(slist.get(i).getObjectId().toString(),slist.get(i).getFilename(),slist.get(i).getUploadDate(),gfs.getMetadata().get("StudentName"),(long) gfs.getMetadata().get("StudentId")));
			//System.out.println(updList);
			i++;
			}
			}
		System.out.println(updList);
		return updList;
	}
	/*
	@Override


	 * public Student addStudent(Student student) { // student.setPRN("1114");
	 * 
	 * 
	 * User u = new User(); u.setRole("Student"); u.setUsername(student.getPRN());
	 * u.setPassword(student.getPRN()); // u.setStudent(student);
	 * student.setUser(u); System.out.println(student); System.out.println(u);
	 * return studDao.save(student);
	 }
*/
	
	@Override
	public Student addStudent(Student student) {
		
		Student s1=studDao.save(student);
		User u=new User();
		u.setUsername(student.getPRN());
		u.setPassword(student.getPRN());
		u.setRole("Student");
		u.setStudent(s1);
		ldao.save(u);
		
		return s1;
		
		
		
	}
	
	
	
	@Override
	public void deleteStudent(int id) {
		
		String id1 = String.valueOf(id);
		Optional<Student> st = studDao.findById(id1);
		st.get().getUser().setStudent(null);
		st.get().setUser(null);
		
		
		studDao.deleteById(id1);
	}

	
	@Override
	public List<Student> getAll() {
		
		List<Student> slist=studDao.findAll();
		System.out.println(slist);
		
		return studDao.findAll();
	}

	
	// DECIDE whether prn is int or string
	/*
	 * @Override public Students findById(int id) { // TODO Auto-generated method
	 * stub return studDao.findBy }
	 */
}
