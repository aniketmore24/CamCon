package com.demo.CamCon.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.demo.CamCon.Beans.Notes;

public interface NotesServiceIF {

	Object addFile(MultipartFile file, int id) throws IOException;

	Notes downloadFile(String id) throws IllegalStateException, IOException;

	List<Notes> addAll();

	

	List<Notes> fetchById(int id);

	void removeAll();

}
