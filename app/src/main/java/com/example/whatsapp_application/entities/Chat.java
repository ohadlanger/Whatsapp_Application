package com.example.whatsapp_application.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.whatsapp_application.room.Converters;

@Entity(tableName = "chats")
public class Chat {
    @PrimaryKey()
    private int id;
    @TypeConverters(Converters.class)
    private User user;
    @TypeConverters(Converters.class)
    private Message lastMessage;

    public Chat(int id, User user) {
        this.id = id;
        this.user = user;
    }

    public Chat() {
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }
    public Message getLastMessage() {
        return lastMessage;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public void setLastMessage(Message lastMessage) {
        this.lastMessage = lastMessage;
    }
}

