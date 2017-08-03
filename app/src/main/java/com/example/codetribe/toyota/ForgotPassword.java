package com.example.codetribe.toyota;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotPassword extends AppCompatActivity {

        EditText etSecretCode;
        Button btnView;
        Button btnBack;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_forgot_password);

            etSecretCode = (EditText)findViewById(R.id.etSecretCode);


            btnBack = (Button)findViewById(R.id.btnBack);

            btnBack.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent myIntent = new Intent(view.getContext(), AdministratorLoginPage.class);
                    startActivityForResult(myIntent, 0);
                }
            } );

            btnView = (Button)findViewById(R.id.btnView);

            btnView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(etSecretCode.getText().toString().equals("EPESPVCN")) {
                        Toast.makeText(getApplicationContext(), "Getting Admin Credentials...",Toast.LENGTH_SHORT).show();
                        Intent myIntent = new Intent(view.getContext(), ViewPassWord.class);
                        startActivityForResult(myIntent, 0);

                    }

                    else{
                        Toast.makeText(getApplicationContext(), "You Entered Wrong Secret Code",Toast.LENGTH_SHORT).show();
                    }

                }});}}




