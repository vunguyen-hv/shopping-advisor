package com.example.seminarmobileprojectexam.API.client;

import com.example.seminarmobileprojectexam.API.client.APIService;

public class APIUtils {
    private APIUtils() {}
    public  static final String BASE_URL="https://androidserver-production.up.railway.app/";
    public  static APIService getAPIService(){
        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
