package com.example.meaapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface BookingService {
    @GET("/items")
    Call<List<Booking>> getBookings();
    @POST("/users/{user_id}/items")
    Call<Booking> createBookingForUser(@Path("user_id") int userId, @Body Booking
            item);
}