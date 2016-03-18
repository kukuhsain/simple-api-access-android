package com.kukuhsain.kukuh.simpleapiaccess;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListActivity.this, AddActivity.class);
                startActivity(intent);
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://qiscusinterview.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestService service = retrofit.create(RequestService.class);

        Call<List<PhoneList>> result = service.result();
        result.enqueue(new Callback<List<PhoneList>>() {
                           @Override
                           public void onResponse(Call<List<PhoneList>> call, Response<List<PhoneList>> response) {
                               Log.d("success", call.request().url().toString());
                               Log.d("success", response.body().get(0).toString());
                               for (int i = 0; i < response.body().size(); i++) {
                                   Log.d("success", "" + response.body().get(i).name);
                               }
                               PhoneList[] phoneLists = new PhoneList[response.body().size()];
                               response.body().toArray(phoneLists);
                               showList(phoneLists);
                           }

                           @Override
                           public void onFailure(Call<List<PhoneList>> call, Throwable t) {
                               Log.d("gagal", call.request().url().toString());
                               Log.d("user", "Gagalll");
                               Log.e("errorrr", t.getMessage());
                           }
                       }
        );

    }

    public void showList(PhoneList[] phoneLists) {
        /*Gson gson = new Gson();
        String stringPhoneList = getIntent().getStringExtra("response");
        PhoneList[] phoneList = gson.fromJson(stringPhoneList, PhoneList[].class);
        Log.d("success", "yeay");*/

        ListAdapter listAdapter = new ListCustomAdapter(ListActivity.this, phoneLists);
        ListView listView = (ListView) findViewById(R.id.list_phone);
        listView.setAdapter(listAdapter);
    }
}
