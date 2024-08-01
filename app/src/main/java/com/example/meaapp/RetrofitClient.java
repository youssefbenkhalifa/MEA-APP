package com.example.meaapp;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static RetrofitClient instance = null;
    private Retrofit retrofit;
    private UserService userService;
    private BookingService bookingService;

    private RetrofitClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);
        retrofit = new Retrofit.Builder()
                .baseUrl("https://users-api-youssefbks-projects.vercel.app/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
        userService = retrofit.create(UserService.class);
        bookingService = retrofit.create(BookingService.class);
    }
}
    public static synchronized RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }
        return instance;
    }
    public UserService getUserService() {
        return userService;
    }
    public BookingService getBookingService() {
        return bookingService;
    }
}