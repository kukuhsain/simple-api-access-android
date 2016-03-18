package com.kukuhsain.kukuh.simpleapiaccess;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by kukuh on 18/03/16.
 */
public interface RequestService {
    @GET("/products")
    Call<List<PhoneList>> result();
}
