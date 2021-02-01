package com.example.login;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest{

        //Se establece la ip a donde se va acceder ya sea desde un localhots o la ip4 por defecto= http://10.0.0.4/register.php Emulador:10.0.2.2 localhots=http://localhost/register.php
        private static final String LOGIN_REQUEST_URL="http://172.16.12.98/Login.php";
        private Map<String,String> params;
        LoginRequest( String username,  String password, Response.Listener<String> listener){
            super(Method.POST, LOGIN_REQUEST_URL, listener,null);
            params = new HashMap<>();

            params.put("username",username);

            params.put("password",password);

        }

        @Override
        public Map<String, String> getParams() {
            return params;
        }//Habia dos string se quito uno
    }

