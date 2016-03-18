package com.kukuhsain.kukuh.simpleapiaccess;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
    }

    public void goToNext(View view) {

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

                               Gson gson = new Gson();
                               Intent intent = new Intent(MainActivity.this, ListActivity.class);
                               intent.putExtra("response", gson.toJson(response.body()));
                               startActivity(intent);

                           }

                           @Override
                           public void onFailure(Call<List<PhoneList>> call, Throwable t) {
                               Log.d("gagal", call.request().url().toString());
                               Log.d("user", "Gagalll");
                               Log.e("errorrr", t.getMessage());
                           }
                       }
        );

        /*Intent intent = new Intent(MainActivity.this, ListActivity.class);
        startActivity(intent);*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
