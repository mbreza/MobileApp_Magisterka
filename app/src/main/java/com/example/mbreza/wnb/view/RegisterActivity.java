package com.example.mbreza.wnb.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

import com.example.mbreza.wnb.R;

public class RegisterActivity extends AppCompatActivity {

    private TextView textViewOne;
    private EditText editTextOne;

    private TextView textViewTwo;
    private EditText editTextTwo;

    private boolean finalStage = false;
    private String emial;
    private String username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        textViewOne = findViewById(R.id.textViewOne);
        editTextOne = findViewById(R.id.editTextOne);

        textViewTwo = findViewById(R.id.textViewTwo);
        editTextTwo = findViewById(R.id.editTextTwo);

        Button buttonMain = findViewById(R.id.buttonMain);
        Button buttonBack = findViewById(R.id.buttonBack);

        buttonMain.setOnClickListener((View view) -> {

            if(finalStage){
                //wywolanie logowania;
            } else {
                textViewOne.setText("Password");
                textViewTwo.setText("Confirm Password");
                buttonMain.setText("sign up");

                emial = editTextOne.getText().toString().trim();
                username = editTextTwo.getText().toString().trim();

                finalStage = true;
            }
        });

        buttonBack.setOnClickListener((View view) -> {
            if(finalStage){
                textViewOne.setText("Email");
                textViewTwo.setText("Username");
                buttonMain.setText("next");
                finalStage = false;
            } else {
                Intent intentLogin = new Intent(RegisterActivity.this , LoginActivity.class);
                RegisterActivity.this.startActivity(intentLogin);
            }
        });


    }
}
