package com.example.messageappjava.RestApi;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestService {

    private static String baseUrl="http://192.168.1.100:32768/";

    private static Retrofit retrofit = null;

/*
    private static Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();

    public static <T> T createService(Class<T> serviceClass)
    {
        return retrofit.create(serviceClass);
    }

 */
    public static Retrofit getClient(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
