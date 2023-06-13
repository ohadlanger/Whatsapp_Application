package com.example.whatsapp_application.entities;

public class CompressChat {
    int id;
    User user;

    public CompressChat(int id, User user) {
        this.id = id;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Chat toChat(){
        return new Chat(this.getId(),this.getUser());
    }
}
