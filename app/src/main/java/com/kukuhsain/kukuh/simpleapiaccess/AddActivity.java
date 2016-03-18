package com.kukuhsain.kukuh.simpleapiaccess;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
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

    public void addToList(View view) {

        EditText phoneName = (EditText) findViewById(R.id.input_phone_name);
        EditText phonePrice = (EditText) findViewById(R.id.input_phone_price);

        String stringPhoneName = phoneName.getText().toString();
        String stringPhonePrice = phonePrice.getText().toString();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://qiscusinterview.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestService service = retrofit.create(RequestService.class);

        RequestBody name = RequestBody.create(MediaType.parse("text/plain"), stringPhoneName);

        Call < PhoneList > addList = service.addList(name, Float.parseFloat(stringPhonePrice));
//        Log.d("req", addList.request().body());

        addList.enqueue(new Callback<PhoneList>() {
                            @Override
                            public void onResponse(Call<PhoneList> call, Response<PhoneList> response) {
                                Log.d("success", response.message());
                            }

                            @Override
                            public void onFailure(Call<PhoneList> call, Throwable t) {
                                Log.d("gagalll", "gagallllllll");
                            }
                        }
        );
        finish();
    }

}
