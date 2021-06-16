package com.example.json1;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface myinterface {
    @GET("dayone/country/{input}")
    Call<String>getValue(@Path("input")String i);
}
