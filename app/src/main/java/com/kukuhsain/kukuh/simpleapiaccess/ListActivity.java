package com.kukuhsain.kukuh.simpleapiaccess;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.gson.Gson;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Gson gson = new Gson();
        String stringPhoneList = getIntent().getStringExtra("response");
        PhoneList[] phoneList = gson.fromJson(stringPhoneList, PhoneList[].class);
        Log.d("success", "yeay");

        ListAdapter listAdapter = new ListCustomAdapter(ListActivity.this, phoneList);
        ListView listView = (ListView) findViewById(R.id.list_phone);
        listView.setAdapter(listAdapter);

    }
}
