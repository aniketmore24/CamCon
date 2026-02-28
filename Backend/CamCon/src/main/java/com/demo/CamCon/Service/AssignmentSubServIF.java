package com.demo.CamCon.Service;

import org.springframework.web.multipart.MultipartFile;

public interface AssignmentSubServIF {

	Object addFile(MultipartFile file, long id, int assId);

}
