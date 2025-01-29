package com.example.ex06.data;

import com.example.ex06.adaptor.NotificationListItem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class NotificationListTestData {
    public static List<NotificationListItem> get() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        final List<NotificationListItem> items = new ArrayList<>();
        try {
            for (int i = 0; i < 10; i++) {
                NotificationListItem item = new NotificationListItem(sdf.parse("2020-10-1" + i), ("タイトル" + i), ("コンテント" + i), ("説明" + i));
                items.add(item);
            }
        } catch (ParseException e) { }
        return items;
    }
}
