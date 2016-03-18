package com.kukuhsain.kukuh.simpleapiaccess;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by kukuh on 18/03/16.
 */
public interface RequestService {
    @GET("/products")
    Call<List<PhoneList>> result();

    @Multipart
    @POST("/products")
    Call<PhoneList> addList(@Part("product[name]") RequestBody name, @Part("product[price]") Float price);
}
