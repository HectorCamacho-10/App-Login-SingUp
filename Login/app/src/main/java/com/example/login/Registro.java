package com.example.login;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Registro extends AppCompatActivity implements View.OnClickListener {

    EditText etnombre, etusuario, etpassword, etcorreo;
    Button btn_registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        etnombre =  findViewById(R.id.EditT_Nombre);
        etusuario =  findViewById(R.id.EditT_Usuario);
        etpassword =  findViewById(R.id.EditT_Password);
        etcorreo=  findViewById(R.id.EditT_Correo);


        btn_registrar =  findViewById(R.id.Btn_Registrar);
        btn_registrar.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {

        final String name= etnombre.getText().toString();
        final String username= etusuario.getText().toString();
        final String password= etpassword.getText().toString();
        final String email =  etcorreo.getText().toString();

        Response.Listener<String> respoListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean succes = jsonResponse.getBoolean("success");

                    if(succes)
                    {
                        Intent intent= new Intent(Registro.this, MainActivity.class);
                        Registro.this.startActivity(intent);
                        startActivity(intent);
                    }
                    else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(Registro.this);
                        builder.setMessage("Error de Registro")
                                .setNegativeButton("Retry", null)
                                .create().show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        };

        RegisterRequest registerRequest= new RegisterRequest(name, username,email, password, respoListener);
        RequestQueue queue = Volley.newRequestQueue(Registro.this);
        queue.add(registerRequest);

    }
}

