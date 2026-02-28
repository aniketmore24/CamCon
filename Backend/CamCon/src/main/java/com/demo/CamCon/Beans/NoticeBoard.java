package com.demo.CamCon.Beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
public class NoticeBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int noticeId;
    private String title;
    private String content;
    private LocalDateTime date;

    // Date and time is assigned to date parameter at the time of object of notice is created
    public NoticeBoard() {
    }

    // If notice have no attachments.
    public NoticeBoard( String content, String title) {
        this.noticeId = noticeId;
        this.content = content;
        this.title=title;
        this.date = LocalDateTime.now();
    }
	/*
	 * //If notice have some attchments in terms of word file, pdf file public
	 * NoticeBoard( String content) { this.noticeId = noticeId; this.content =
	 * content; this.date = LocalDateTime.now();
	 * 
	 * }
	 */

    public int getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(int noticeId) {
        this.noticeId = noticeId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

	/*
	 * public byte[] getData() { return data; }
	 * 
	 * public void setData(byte[] data) { this.data = data; }
	 */

    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
    public String toString() {
        return "NoticeBoard{" +
                "noticeId=" + noticeId +
                ", content='" + content + '\'' +
                ", date=" + date +
                '}';
    }
}
