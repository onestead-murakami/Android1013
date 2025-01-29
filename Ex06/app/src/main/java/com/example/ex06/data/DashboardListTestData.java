package com.example.ex06.data;


import com.example.ex06.R;
import com.example.ex06.adaptor.DashboardListItem;
import com.example.ex06.adaptor.NotificationListItem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DashboardListTestData {

    private static final int[] icons = {
            android.R.drawable.alert_dark_frame
            ,android.R.drawable.arrow_down_float
            ,android.R.drawable.bottom_bar
            ,android.R.drawable.btn_default_small
            ,android.R.drawable.btn_dropdown
            ,android.R.drawable.btn_plus
            ,android.R.drawable.btn_star
            ,android.R.drawable.checkbox_on_background
            ,android.R.drawable.dark_header
            ,android.R.drawable.divider_horizontal_bright
    };
    public static List<DashboardListItem> get() {
        final List<DashboardListItem> items = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DashboardListItem item = new DashboardListItem(icons[i], ("タイトル" + i), ("コンテント" + i));
            items.add(item);
        }
        return items;
    }
}
