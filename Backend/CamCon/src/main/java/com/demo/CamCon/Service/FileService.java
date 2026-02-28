package com.demo.CamCon.Service;



	



import com.demo.CamCon.Beans.*;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileService {

    @Autowired
    private GridFsTemplate template;

    @Autowired
    private GridFsOperations operations;

    public String addFile(MultipartFile upload, int id) throws IOException {
    	
    	String ass="assignment";
        DBObject metadata = new BasicDBObject();
        metadata.put("fileSize", upload.getSize());
        metadata.put("moduleId", id);
        metadata.put("type", ass);
        

        Object fileID = template.store(upload.getInputStream(), upload.getOriginalFilename(), upload.getContentType(), metadata);
       // upload.
        return fileID.toString();
    }
  

    public LoadFile downloadFile(String id) throws IOException {

        GridFSFile gridFSFile = template.findOne( new Query(Criteria.where("_id").is(id)) );
        
        //template.find(new Query());

        LoadFile loadFile = new LoadFile();

        if (gridFSFile != null && gridFSFile.getMetadata() != null) {
            loadFile.setFileName( gridFSFile.getFilename() );

            loadFile.setFiletype( gridFSFile.getMetadata().get("_contentType").toString() );

            loadFile.setFileSize( gridFSFile.getMetadata().get("fileSize").toString() );

            loadFile.setFile( IOUtils.toByteArray(operations.getResource(gridFSFile).getInputStream()) );
        }

        return loadFile;
    }


	public List<LoadFile> addAll() {
		
		List<GridFSFile> alist = new ArrayList<GridFSFile>();
		template.find(new Query(Criteria.where("metadata.type").is("assignment"))).into(alist);
		LoadFile loadFile = new LoadFile();
		
		//List<LoadFile> alist=adao.findAll();
		List<LoadFile> updList=new ArrayList();
		//String s=alist.get(0).getId();
		int i=0;
		for (GridFSFile gfs : alist) {
			if(!alist.isEmpty())
			updList.add(new LoadFile(alist.get(i).getObjectId().toString(),alist.get(i).getFilename(),alist.get(i).getUploadDate()));
			i++;
		}
		
		return updList;
	}


	public List<LoadFile> fetchById(int id) {
		List<GridFSFile> alist = new ArrayList<GridFSFile>();
		String type="type";
		//template.find(new Query()).into(alist);
		template.find(new Query(Criteria.where("metadata.moduleId").is(id).and("metadata.type").is("assignment"))).into(alist);
		LoadFile loadFile = new LoadFile();
		
		//List<LoadFile> alist=adao.findAll();
		List<LoadFile> updList=new ArrayList();
		//String s=alist.get(0).getId();
		int i=0;
		for (GridFSFile gfs : alist) {
			if(!alist.isEmpty())
			updList.add(new LoadFile(alist.get(i).getObjectId().toString(),alist.get(i).getFilename(),alist.get(i).getUploadDate()));
			i++;
		}
		
		
		return updList;
		
		
		//return null;
	}
	
	public void removeAll() {
		
		String ass="assignment";
		template.delete(new Query(Criteria.where("metadata.type").is(ass)));
		
	
		
	}


}