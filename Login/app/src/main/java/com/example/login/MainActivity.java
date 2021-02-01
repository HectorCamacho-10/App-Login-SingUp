package com.example.login;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import org.json.JSONObject;
import org.json.JSONException;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;


public class MainActivity extends AppCompatActivity {

    TextView tv_registrar;//Usuario asesor
    TextView tv_usuarionormal;//Usuario normal

    Button btn_log;
    EditText et_usuario;
    EditText et_password;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_usuario =  findViewById(R.id.Tv_Usu);
        et_password =  findViewById(R.id.Tv_pas);

        btn_log = findViewById(R.id.Btn_Inicio);

        tv_registrar =  findViewById(R.id.tv_registrar);//tv_registrar

        tv_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentReg = new Intent(MainActivity.this, Registro.class);
                MainActivity.this.startActivity(intentReg);
            }
        });

        btn_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String username = et_usuario.getText().toString();
                final String password = et_password.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success){

                                String name = jsonResponse.getString("name");
                                String email = jsonResponse.getString("email");

                                Intent intent = new Intent(MainActivity.this, Usuario.class);

                                intent.putExtra("name", name);//Se almacena el dato llamado name. atraves de el nombre save a que dato pertenece XD
                                intent.putExtra("username", username);
                                intent.putExtra("Password", password);
                                intent.putExtra("email", email);

                                MainActivity.this.startActivity(intent);





                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                builder.setMessage("Usuario o contraseña incorrectos")
                                        .setNegativeButton("Retry",null)
                                        .create().show();

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                LoginRequest loginRequest = new LoginRequest(username, password, responseListener);

                RequestQueue queue= Volley.newRequestQueue(MainActivity.this);
                queue.add(loginRequest);




            }
        });


/*
        //Conectanndo de la principal al registro de usuario asesor
        tv_registrar = findViewById(R.id.tv_registrar);

        tv_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentReg = new Intent(MainActivity.this,Registro.class);
                MainActivity.this.startActivity(intentReg);
            }
        });

       */

        //Conectanndo de la principal al registro de usuario normal
        tv_usuarionormal = findViewById(R.id.tv_usuarionormal);

        tv_usuarionormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentReg = new Intent(MainActivity.this,Registro_Normal.class);
                MainActivity.this.startActivity(intentReg);
            }
        });



    }
}


