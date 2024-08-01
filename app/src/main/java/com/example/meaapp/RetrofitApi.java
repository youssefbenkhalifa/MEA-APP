package com.example.meaapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface RetrofitApi {
    @GET
    Call<MsgModal> getMessage(@Url String url);
}
