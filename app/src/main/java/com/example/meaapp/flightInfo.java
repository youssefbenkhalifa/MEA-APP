package com.example.meaapp;

public class flightInfo {
    private String dep_air;
    private String dep_time;
    private String dep_day;
    private String flight_time;
    private String arr_air;
    private String arr_time;
    private String arr_day;
    private float price;
    public flightInfo(String dep_air,String dep_time, String dep_day, String flight_time, String arr_air, String arr_time, String arr_day, float price){
        this.dep_air = dep_air;
        this.dep_time = dep_time;
        this.dep_day = dep_day;
        this.flight_time = flight_time;
        this.arr_air = arr_air;
        this.arr_time = arr_time;
        this.arr_day = arr_day;
        this.price = price;
    }

}
