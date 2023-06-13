package com.example.whatsapp_application.api;

import com.example.whatsapp_application.entities.User;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserApi {
    Retrofit retrofit;
    WebServiceApi webServiceAPI;

    public UserApi() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:5000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        webServiceAPI = retrofit.create(WebServiceApi.class);
    }

    public void getUser(String username, String token) {
        Call<User> call = webServiceAPI.getUser(username, token);
    }

    public void createUser(User user) {
        Call<User> call = webServiceAPI.createUser(user);
    }
}
