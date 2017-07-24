package com.jdkgroup.contact.adapter;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jdkgroup.contact.R;

import java.util.List;

public class RecentDialAdapter extends RecyclerView.Adapter<RecentDialAdapter.ViewHolder> {

    private Context mContext;
    private List<String> mItems;

    public RecentDialAdapter(Context context, List<String> items) {
        mContext = context;
        mItems = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.recentdial_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvAppLetter.setText(mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mItems != null ? mItems.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public AppCompatTextView tvAppLetter;

        public ViewHolder(View itemView) {
            super(itemView);
            tvAppLetter = (AppCompatTextView)itemView.findViewById(R.id.tvAppLetter);
        }
    }
}
