package com.demo.CamCon.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.demo.CamCon.Beans.LoadFile;
import com.demo.CamCon.Beans.Notes;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;


@Service
public class NotesServiceImpl implements NotesServiceIF{

	 @Autowired
	    private GridFsTemplate template;

	    @Autowired
	    private GridFsOperations operations;

	    public String addFile(MultipartFile upload, int id) throws IOException {
	    	String notes="notes";
	        DBObject metadata = new BasicDBObject();
	        metadata.put("fileSize", upload.getSize());
	        metadata.put("moduleId", id);
	        metadata.put("type", notes);
	        

	        Object fileID = template.store(upload.getInputStream(), upload.getOriginalFilename(), upload.getContentType(), metadata);
	       // upload.
	        return fileID.toString();
	    }

	@Override
	public Notes downloadFile(String id) throws IllegalStateException, IOException {
		
		 GridFSFile gridFSFile = template.findOne( new Query(Criteria.where("_id").is(id)) );

	        Notes notes=new Notes();
	        
	        if (gridFSFile != null && gridFSFile.getMetadata() != null) {
	        	notes.setNotesName( gridFSFile.getFilename() );

	        	notes.setFileType( gridFSFile.getMetadata().get("_contentType").toString() );

	        	notes.setFileSize( gridFSFile.getMetadata().get("fileSize").toString() );

	        	notes.setFile( IOUtils.toByteArray(operations.getResource(gridFSFile).getInputStream()) );
	        }

	        return notes;
		
	}

	@Override
	public List<Notes> addAll() {
		
		String notes="notes";
		List<GridFSFile> nlist = new ArrayList<GridFSFile>();
		template.find(new Query(Criteria.where("metadata.type").is(notes).and("metadata.moduleId"))).into(nlist);
		//Notes notes=new Notes();
		
		//List<LoadFile> alist=adao.findAll();
		List<Notes> updList=new ArrayList();
		//String s=alist.get(0).getId();
		int i=0;
		for (GridFSFile gfs : nlist) {
			if(!nlist.isEmpty())
			updList.add(new Notes(nlist.get(i).getObjectId().toString(),nlist.get(i).getFilename(),nlist.get(i).getUploadDate()));
			i++;
		}
		
		return updList;
		
		
	}

	

	@Override
	public List<Notes> fetchById(int id) {
		List<GridFSFile> nlist = new ArrayList<GridFSFile>();
		String notes="notes";
	
	   // Criteria criteria = Criteria.where("_id").is(fileId).and(fieldName).exists(true);
		template.find(new Query(Criteria.where("metadata.moduleId").is(id).and("metadata.type").is("notes"))).into(nlist);
		//Notes notes = new Notes();
		
		System.out.println(nlist);
		List<Notes> updList=new ArrayList();
		//String s=alist.get(0).getId();
		int i=0;
		for (GridFSFile gfs : nlist) {
			if(!nlist.isEmpty())
			{
			updList.add(new Notes(nlist.get(i).getObjectId().toString(),nlist.get(i).getFilename(),nlist.get(i).getUploadDate()));
			i++;
			}
			System.out.println("for loop");
		
	}
		System.out.println(updList);
		
		return updList;


	}

	@Override
	public void removeAll() {
		
		String notes="notes";
		template.delete(new Query(Criteria.where("metadata.type").is(notes)));
	
		
	}
	
	
	
	
}
