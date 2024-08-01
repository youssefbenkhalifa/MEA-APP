package com.example.meaapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UserService {
    @GET("/users")
    Call<List<User>> getUsers();
    @POST("/users")
    Call<User> createUser(@Body User user);
    @GET("/users/{user_id}")
    Call<User> getUser(@Path("user_id") int userId);
    @PUT("/users/{user_id}")
    Call<User> updateUser(@Path("user_id") int userId, @Body User user);
    @DELETE("/users/{user_id}")
    Call<User> deleteUser(@Path("user_id") int userId);
}
