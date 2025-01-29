package com.example.ex06.adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ex06.R;

import java.text.SimpleDateFormat;
import java.util.List;

public class NotificationListAdapter extends RecyclerView.Adapter<NotificationListAdapter.ViewHolder> {

    protected List<NotificationListItem> dataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView timestamp;
        public final TextView title;
        public final TextView content;

        public ViewHolder(View v) {
            super(v);
            timestamp = (TextView) v.findViewById(R.id.timestamp);
            title = (TextView) v.findViewById(R.id.title);
            content = (TextView) v.findViewById(R.id.content);
        }
    }

    public NotificationListAdapter(List<NotificationListItem> myDataSet) {
        dataSet = myDataSet;
    }

    @Override
    public NotificationListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        @LayoutRes int resource = (viewType == 0) ? R.layout.fragment_notification_list_item0 : R.layout.fragment_notification_list_item1;
        View v = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public int getItemViewType(int position) {
        return (position % 2);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        NotificationListItem item = dataSet.get(position);
        holder.timestamp.setText(sdf.format(item.getTimestamp()));
        holder.title.setText(item.getTitle());
        holder.content.setText(item.getContent());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

}
