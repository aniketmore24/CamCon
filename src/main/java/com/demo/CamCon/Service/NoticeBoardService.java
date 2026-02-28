package com.demo.CamCon.Service;

import com.demo.CamCon.Beans.*;

import java.util.List;

public interface NoticeBoardService {

    public NoticeBoard saveNotice(NoticeBoard noticeBoard);

    public List<NoticeBoard> getAllNotices();

	public void deleteById(int id);
}
