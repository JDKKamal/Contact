package com.jdkgroup.contact.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jdkgroup.contact.R;

import java.util.List;

public class SpeedDialAdapter extends RecyclerView.Adapter<SpeedDialAdapter.ViewHolder> {

    private Context mContext;
    private List<String> mItems;

    private final TypedArray mColors;

    public SpeedDialAdapter(Context context, List<String> items) {
        mContext = context;
        mItems = items;
        final Resources mRes = context.getResources();
        mColors = mRes.obtainTypedArray(R.array.letter_tile_colors);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.speeddial_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String text = mItems.get(position);
        holder.itemView.setBackgroundColor(getColor(text));
        holder.tvAppContact.setText(text);
    }

    private int getColor(String key) {
        final int color = Math.abs(key.hashCode()) % mColors.length();
        return mColors.getColor(color, Color.BLUE);
    }

    @Override
    public int getItemCount() {
        return mItems == null ? 0 : mItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public View itemView;
        public AppCompatTextView tvAppContact;

        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            tvAppContact = (AppCompatTextView)itemView.findViewById(R.id.tvAppContact);
        }
    }
}
