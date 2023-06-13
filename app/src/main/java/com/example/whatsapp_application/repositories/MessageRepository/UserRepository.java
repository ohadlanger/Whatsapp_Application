package com.example.whatsapp_application.repositories.MessageRepository;

import com.example.whatsapp_application.api.UserApi;
import com.example.whatsapp_application.entities.User;

public class UserRepository {
    private UserApi userApi;

    public UserRepository() {
        this.userApi = new UserApi();
    }

    public void getUser(String username, String token) {
        userApi.getUser(username, token);
    }

    public void createUser(User user) {
        userApi.createUser(user);
    }
}
