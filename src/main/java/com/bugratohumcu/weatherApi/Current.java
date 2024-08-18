package com.bugratohumcu.weatherApi;

import com.google.gson.JsonObject;

public class Current {
    String time;
    double temperature_2m;
    double wind_speed_10m;

    public String getTime() {
        return time;
    }

    public double getTemperature_2m() {
        return temperature_2m;
    }

    public double getWind_speed_10m() {
        return wind_speed_10m;
    }



}
