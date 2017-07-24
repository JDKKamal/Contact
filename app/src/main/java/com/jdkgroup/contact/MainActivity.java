package com.jdkgroup.contact;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.jdkgroup.contact.activity.ContactListActivity;
import com.jdkgroup.contact.activity.ContactsActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Context context;
    private Intent intent;

    private AppCompatTextView tvAppContactList = null, tvAppContactDesign = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        tvAppContactList = (AppCompatTextView) findViewById(R.id.tvAppContactList);
        tvAppContactDesign = (AppCompatTextView) findViewById(R.id.tvAppContactDesign);

        tvAppContactList.setOnClickListener(this);
        tvAppContactDesign.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvAppContactList:
                intent = new Intent(context, ContactListActivity.class);
                startActivity(intent);
                break;

            case R.id.tvAppContactDesign:
                intent = new Intent(context, ContactsActivity.class);
                startActivity(intent);
                break;
        }
    }
}

