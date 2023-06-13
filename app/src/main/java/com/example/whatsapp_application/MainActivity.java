package com.example.whatsapp_application;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;

import com.example.whatsapp_application.entities.Chat;
import com.example.whatsapp_application.entities.Message;
import com.example.whatsapp_application.repositories.MessageRepository.LoginRepository;
import com.example.whatsapp_application.repositories.MessageRepository.MessageRepository;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MutableLiveData<String> token = new MutableLiveData<>();
        MutableLiveData<List<Message>> messages = new MutableLiveData<>();
        LoginRepository loginRepository = new LoginRepository(this);
        loginRepository.createToken("string", "string", token);
        token.observe(this, s -> {
            MutableLiveData<List<Chat>> chats = new MutableLiveData<>();
            MessageRepository messageRepository = new MessageRepository(this);
            messageRepository.getAllMessages(3, "Bearer " + s, messages);
        });
        messages.observe(this, messages1 -> {
            System.out.println(messages1);
        });



//        ChatDatabase db = ChatDatabase.getInstance(this);
//        ChatDao chatDao = db.chatDao();
//        MessageDao messageDao = db.messageDao();
//        Chat chat = new Chat(1, new User("user1", "user1", "pic"), new User("user2", "user2", "pic"));
//        Chat chat2 = new Chat(2, new User("user1", "user1", "pic"), new User("user3", "user2", "pic"));
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                chatDao.insert(chat);
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                chatDao.insert(chat2);
//            }
//        }).start();
//        Message message = new Message(1, 1, new User("user2","user2","rotem"), "user2", "Hello");
//        Message message2 = new Message(2, 1, new User("user1","user1","rotem"), "user1", "Hello");
//        Message message3 = new Message(3, 1, new User("user2","user2","rotem"), "user2", "How are you?");
//        messageDao.insert(message);
//        messageDao.insert(message2);
//        messageDao.insert(message3);
//        System.out.println(messageDao.getAllMessages(1));
//        System.out.println(chatDao.getAllChats());
//        ChatApi chatApi = new ChatApi();
//        String token = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJDaGF0QXBwIiwianRpIjoiZDBkOGM1YTktZDI3ZS00Zjg2LWI4MjUtZDY5MzY5ZDUzMjM3IiwiaWF0IjoiNi8xMi8yMDIzIDU6MDA6NDkgUE0iLCJVc2VyTmFtZSI6InN0cmluZyIsImV4cCI6MTY4NjU4OTg0OSwiaXNzIjoiQ2hhdFNlcnZlciIsImF1ZCI6IkNoYXRDbGllbnQifQ.jLUwb56GOm7gSBRqfd6Okm4oYIxheCM4hl-WYzoJ438";
//        MutableLiveData<List<ShortChat>> chats = new MutableLiveData<>();
//        chatApi.getAllChats(token, chats);
//        System.out.println(chats.getValue());
    }
}