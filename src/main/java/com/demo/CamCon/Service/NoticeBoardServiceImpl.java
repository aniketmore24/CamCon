package com.demo.CamCon.Service;

import com.demo.CamCon.Beans.*;
import com.demo.CamCon.Dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeBoardServiceImpl implements NoticeBoardService {

    @Autowired
    NoticeBoardRepository noticeBoardRepository;

    @Override
    public NoticeBoard saveNotice(NoticeBoard noticeBoard) {
        return noticeBoardRepository.save(noticeBoard);
    }

    @Override
    public List<NoticeBoard> getAllNotices() {
        return noticeBoardRepository.findAll();
    }

	@Override
	public void deleteById(int id) {
				
		noticeBoardRepository.deleteById(id);
	}

	
}
