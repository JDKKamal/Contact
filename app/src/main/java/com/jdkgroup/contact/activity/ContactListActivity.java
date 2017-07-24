package com.jdkgroup.contact.activity;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import com.jdkgroup.contact.R;
import com.jdkgroup.contact.adapter.ContactListAdapter;
import com.jdkgroup.contact.model.ContactListModel;
import com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ContactListActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private Context context;

    private AppCompatTextView tvAppContact = null;
    private FastScrollRecyclerView fastScrollRecyclerView;

    private List<ContactListModel> alContactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);

        context = this;
        alContactList = new ArrayList<>();

        tvAppContact = (AppCompatTextView) findViewById(R.id.tvAppContact);
        fastScrollRecyclerView = (FastScrollRecyclerView) findViewById(R.id.fastScrollRecyclerView);

        fastScrollRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        getSupportLoaderManager().initLoader(1, null, this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int arg0, Bundle arg1) {
        Uri CONTENT_URI = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        return new CursorLoader(this, CONTENT_URI, null, null, null, null);
    }

    public void onLoadFinished(Loader<Cursor> arg0, Cursor cursor) {
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String name,  cellno;
            name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
             cellno = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

            alContactList.add(new ContactListModel(null, name, cellno, null));
            cursor.moveToNext();
        }
        fastScrollRecyclerView.setAdapter(new ContactListAdapter(context, alContactList));
    }

    public void onLoaderReset(Loader<Cursor> loader) {
    }
}
