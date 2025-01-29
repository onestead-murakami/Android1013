package com.example.ex06.adaptor;

import androidx.annotation.DrawableRes;

public class DashboardListItem {
    private @DrawableRes int imageResource;
    private String title;
    private String content;

    public DashboardListItem(@DrawableRes int imageResource, String title, String content) {
        this.imageResource = imageResource;
        this.title = title;
        this.content = content;
    }

    public @DrawableRes int getImageResource() {
        return imageResource;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
