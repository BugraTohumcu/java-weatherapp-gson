package com.bugratohumcu;


import com.google.gson.Gson;
import com.bugratohumcu.countryApi.CountryResponse;
import com.bugratohumcu.weatherApi.WeatherResponse;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class WeatherApp {
    public static void main(String[] args) {
        try{

            String city;
            Scanner scanner = new Scanner(System.in);

            while (true){
                System.out.print("Enter city name or say No to quit: ");
                city = scanner.nextLine();
                if (city.equalsIgnoreCase("No")){ break;}

                String cityLocation =   getLocation(city);

                Gson gson = new Gson();

                CountryResponse respond = gson.fromJson(cityLocation,  CountryResponse.class);

                double latitude = respond.getResultsList().getFirst().getLatitude();
                double longitude = respond.getResultsList().getFirst().getLongitude();

                displayWeatherData(latitude ,longitude);

            }


        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private static void displayWeatherData(double latitude, double longitude){
        try{
            String url = "https://api.open-meteo.com/v1/forecast?latitude="
                    +latitude+"&longitude="+longitude+"&current=temperature_2m,relative_humidity_2m,wind_speed_10m";

            HttpURLConnection apiConnection = getConnection(url);
            if(apiConnection.getResponseCode() !=200){
                System.out.println("Cannot connect to the API");
                return;
            }

            String jsonResponse = getJsonResponse(apiConnection);

            Gson gson = new Gson();
            WeatherResponse response = gson.fromJson(jsonResponse, WeatherResponse.class);

            System.out.println("Time: "+response.getCurrent().getTime());
            System.out.println("Temperature: "+ response.getCurrent().getTemperature_2m());
            System.out.println("Wind Speed: "+ response.getCurrent().getWind_speed_10m());
        }catch (IOException e){
            e.printStackTrace();
        }


    }

    private static String getLocation(String city){
        String cityForUrl = city.replaceAll(" ", "+");
        try {

           String url="https://geocoding-api.open-meteo.com/v1/search?name="+cityForUrl+"&count=1&language=en&format=json";

           HttpURLConnection apiConnection = getConnection(url);

           if(apiConnection.getResponseCode() != 200){
               System.out.println("Cannot connect to the server");
               return null;
           }

           String jsonResponse = getJsonResponse(apiConnection);

           return  jsonResponse;



       }catch (Exception e){
           e.printStackTrace();
       }
    return null;
    }

    private static HttpURLConnection getConnection(String urlString){
       try{
           URL url = new URL(urlString);

           HttpURLConnection conn = (HttpURLConnection) url.openConnection();

           conn.setRequestMethod("GET");

           return conn;

       }catch (IOException e){
           e.printStackTrace();
       }
    return null;
    }

    private static String getJsonResponse(HttpURLConnection conn){

        try{
            StringBuilder jsonResponse = new StringBuilder();
            Scanner scanner = new Scanner(conn.getInputStream());
            while (scanner.hasNextLine()){
                jsonResponse.append(scanner.nextLine());
            }
            return jsonResponse.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
    return null;
    }

}