package com.example.ex06.adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.ex06.R;

import java.util.List;

public class DashboardListAdapter extends RecyclerView.Adapter<DashboardListAdapter.ViewHolder> {

    protected List<DashboardListItem> dataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final ImageView imageResource;
        public final TextView title;

        public ViewHolder(View v) {
            super(v);
            imageResource = (ImageView) v.findViewById(R.id.imageResource);
            title = (TextView) v.findViewById(R.id.title);
        }
    }

    public DashboardListAdapter(List<DashboardListItem> myDataSet) {
        dataSet = myDataSet;
    }

    @Override
    public DashboardListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_dashboard_list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public int getItemViewType(int position) {
        return (position % 2);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DashboardListItem item = dataSet.get(position);
        holder.imageResource.setImageResource(item.getImageResource());
        holder.title.setText(item.getTitle());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
