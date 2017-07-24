package com.jdkgroup.contact.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jdkgroup.contact.R;
import com.jdkgroup.contact.model.ContactListModel;
import com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView;

import java.util.List;

/**
 * Created by kamlesh on 7/23/2017.
 */

public class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.UserViewHolder> implements FastScrollRecyclerView.SectionedAdapter {

    private Context mContext;
    private List<ContactListModel> alContact;

    public ContactListAdapter(Context mContext, List<ContactListModel> alContact) {
        this.mContext = mContext;
        this.alContact = alContact;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.contact_list_itemview, null);
        UserViewHolder viewHolder = new UserViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        ContactListModel contactList = alContact.get(position);
        holder.ivAppImage.setBackground(null);
        holder.tvAppName.setText(contactList.getName());
        holder.tvAppCellNo.setText(contactList.getCellno());
    }

    @Override
    public int getItemCount() {
        return alContact.size();
    }

    @NonNull
    @Override
    public String getSectionName(int position) {
        return String.valueOf(alContact.get(position).getName().charAt(0));
    }

    class UserViewHolder extends RecyclerView.ViewHolder {

        private AppCompatImageView ivAppImage;
        private AppCompatTextView tvAppName, tvAppCellNo;

        public UserViewHolder(View itemView) {
            super(itemView);
            ivAppImage = (AppCompatImageView) itemView.findViewById(R.id.ivAppImage);

            tvAppName = (AppCompatTextView) itemView.findViewById(R.id.tvAppName);
            tvAppCellNo = (AppCompatTextView) itemView.findViewById(R.id.tvAppCellNo);
        }
    }
}