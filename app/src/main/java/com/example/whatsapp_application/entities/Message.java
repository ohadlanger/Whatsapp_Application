package com.example.whatsapp_application.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.whatsapp_application.room.Converters;

@Entity(tableName = "messages")
public class Message {
    @PrimaryKey()
    private int id;

    private String created;
    @TypeConverters(Converters.class)
    private User sender;

    private String content;
    private int chatId;

    public Message(int id, int chatId, User sender, String content, String created) {
        this.id = id;
        this.chatId = chatId;
        this.sender = sender;
        this.content = content;
        this.created = created;
    }

    public int getId() {
        return id;
    }

    public int getChatId() {
        return chatId;
    }

    public User getSender() {
        return sender;
    }

    public String getContent() {
        return content;
    }

    public String getCreated() {
        return created;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}
