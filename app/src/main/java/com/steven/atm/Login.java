package com.steven.atm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    private EditText ed_username;
    private EditText ed_password;
    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void Login(View view){
        ed_username = findViewById(R.id.ed_username);
        ed_password = findViewById(R.id.ed_password);
        username = ed_username.getText().toString();
        password = ed_password.getText().toString();
        if("Steven".equals(username) && "123456789".equals(password)){
            setResult(RESULT_OK);
            finish();
        }else {
            setResult(RESULT_CANCELED);
            finish();
        }
    }
}
