package com.example.laba6serega;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.yandex.mapkit.MapKitFactory;

import model.User;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        MapKitFactory.setApiKey("1f12526d-c202-4a1c-9c94-07acc131b468");
    }

    public void OnLoginClick(View view)
    {
        String nameText = ((EditText)findViewById(R.id.loginText)).getText().toString();
        String passText = ((EditText)findViewById(R.id.passwordText)).getText().toString();
        String emailText = ((EditText)findViewById(R.id.emailText)).getText().toString();

        if(nameText.isEmpty() || passText.isEmpty() || emailText.isEmpty()) {
            Toast.makeText(this, "Некорректно заполнены поля", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("user_log", nameText ).putExtra("user_pass", passText).putExtra("user_email", emailText);
        startActivity(intent);
    }
}