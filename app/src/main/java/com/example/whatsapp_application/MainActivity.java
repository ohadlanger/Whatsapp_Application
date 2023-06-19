package com.example.whatsapp_application;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.whatsapp_application.entities.Message;
import com.example.whatsapp_application.entities.User;
import com.example.whatsapp_application.repositories.MessageRepository.LoginRepository;
import com.example.whatsapp_application.repositories.MessageRepository.UserRepository;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
        MutableLiveData<String> token = new MutableLiveData<>();
        MutableLiveData<List<Message>> messages = new MutableLiveData<>();
        LoginRepository loginRepository = new LoginRepository(this);
        loginRepository.createToken("string", "string", token);
        MutableLiveData<User> user = new MutableLiveData<>();
        token.observe(this, s -> {
            UserRepository UserRepository = new UserRepository();
            UserRepository.getUser("string", "Bearer " + s, user);

        });
        messages.observe(this, messages1 -> {
            System.out.println(messages1);
        });
        user.observe(this, user1 -> {
            System.out.println(user1);
        });

        Button signBtn = findViewById(R.id.signupBtn);
        signBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, SignUpActivity.class);
            startActivity(intent);
        });


        EditText usernameEt = findViewById(R.id.usernameEt);
        EditText passwordEt = findViewById(R.id.passwordEt);
        Button registerBtn = findViewById(R.id.registerBtn);

        registerBtn.setOnClickListener(view -> {
            String username = usernameEt.getText().toString();
            String password = passwordEt.getText().toString();
            if (!username.isEmpty() && !password.isEmpty()) {
                MutableLiveData<User> result = new MutableLiveData<>();
                result.setValue(null);

                result.observe(this, new Observer<User>() {
                    @Override
                    public void onChanged(User newValue) {
                        if (newValue != null) {
                            Intent intent1 = new Intent(getApplicationContext(), ContactsActivity.class);
                            startActivity(intent1);
                            finishAffinity();
                        } else {
                            Toast.makeText(getApplicationContext(), "Invalid information. Try again!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                VerifyLogin(username, password, result);
            }
            else {
                Toast.makeText(getApplicationContext(), "Missing requirements. Try again!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    void VerifyLogin(String username, String password, MutableLiveData<User> user) {
        if(!username.isEmpty() && !password.isEmpty()) {
            UserRepository userRepository = new UserRepository();
            LoginRepository loginRepository = new LoginRepository(getApplicationContext());
            MutableLiveData<String> token = new MutableLiveData<>();

            token.observe(this, new Observer<String>() {
                @Override
                public void onChanged(String newValue) {
                    userRepository.getUser(username, newValue, user);
                }
            });

            loginRepository.createToken(username, password, token);
        }
    }
}