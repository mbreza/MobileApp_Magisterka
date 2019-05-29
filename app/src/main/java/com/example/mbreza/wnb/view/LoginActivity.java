package com.example.mbreza.wnb.view;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mbreza.wnb.R;
import com.example.mbreza.wnb.presenter.LoginPresenter;


public class LoginActivity extends AppCompatActivity implements LoginPresenter.View{

    private EditText editTextUsername;
    private EditText editTextPassword;

    private LoginPresenter loginPresenter;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);

        loginPresenter = new LoginPresenter(this);




        Button buttonLogIn = findViewById(R.id.buttonLogIn);

        View.OnClickListener buttonLogInListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextUsername.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                Log.e("username", username);
                Log.e("password", password);
                loginPresenter.logIn(username, password);
            }
        };

        buttonLogIn.setOnClickListener(buttonLogInListener);

    }
}
