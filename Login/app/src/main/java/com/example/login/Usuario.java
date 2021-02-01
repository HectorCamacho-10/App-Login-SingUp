package com.example.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Usuario extends AppCompatActivity {

    TextView tvNombre, tvUsuario, tvEmail, tvPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);


        //Se va a asociar cada elemento con su variable.

        tvNombre =  findViewById(R.id.TextV_nombre);
        tvUsuario = findViewById(R.id.TextV_usuario);
        tvPassword =  findViewById(R.id.TextV_password);
        tvEmail = findViewById(R.id.TextV_email);

        Intent intent = getIntent();
        String name=intent.getStringExtra("name");
        String username=intent.getStringExtra("username");
        String password=intent.getStringExtra("password");
        String email =intent.getStringExtra("email");


        //Se asignan a los edittext que ya se tienen :c

        tvNombre.setText(name);
        tvUsuario.setText(username);
        tvPassword.setText(password);
        tvEmail.setText(email);

        }

    }

