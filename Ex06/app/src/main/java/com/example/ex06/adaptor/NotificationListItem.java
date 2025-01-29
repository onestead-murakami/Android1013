package com.example.ex06.adaptor;

import java.util.Date;

public class NotificationListItem {

    private Date timestamp;
    private String title;
    private String content;
    private String detail;

    public NotificationListItem(Date timestamp, String title, String content, String detail) {
        this.timestamp = timestamp;
        this.title = title;
        this.content = content;
        this.detail = detail;
    }

    public Date getTimestamp() {
        return timestamp;
    }
    public String getTitle() {
        return title;
    }
    public String getContent() {
        return content;
    }
    public String getDetail() {
        return detail;
    }

}
