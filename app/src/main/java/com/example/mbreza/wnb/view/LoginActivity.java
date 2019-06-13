package com.example.mbreza.wnb.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mbreza.wnb.R;
import com.example.mbreza.wnb.presenter.LoginPresenter;
import com.example.mbreza.wnb.service.ContextProvider;

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

        //loginPresenter.register();

        Button buttonLogIn = findViewById(R.id.buttonLogIn);
        Button buttonRegister = findViewById(R.id.buttonRegister);

        buttonRegister.setOnClickListener((View v) -> {
            Intent intentRegister = new Intent(LoginActivity.this , RegisterActivity.class);
            LoginActivity.this.startActivity(intentRegister);
        });

        buttonLogIn.setOnClickListener((View v) -> {
            String username = editTextUsername.getText().toString().trim();
            String password = editTextPassword.getText().toString().trim();
            loginPresenter.logInNoGet(username, password);
        });
    }

    @Override
    public void showNotify(String info) {
        Toast toast = Toast.makeText(ContextProvider.getAppContext(), info, Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    public void redirectHome() {
        Intent intentHome = new Intent(LoginActivity.this ,HomeActivity.class);
        LoginActivity.this.startActivity(intentHome);
    }
}
