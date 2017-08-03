package com.example.codetribe.toyota;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainMenu extends AppCompatActivity {

    Button btnCusPromo;
    Button btnCusCamp;
    Button btnCust;
    Button btnAboutUs;
    Button btnContactUs;
    Button btnDealership;
    Button btnHelp;
    Button btnAdministratorPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        btnCusPromo = (Button)findViewById(R.id.btnCusPromo);

        btnCusPromo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Promotions.class);
                startActivityForResult(myIntent, 0);
            }
        } );

        btnCusCamp = (Button)findViewById(R.id.btnCusCamp);

        btnCusCamp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Campaigns.class);
                startActivity(myIntent);
            }
        } );

        btnCust = (Button)findViewById(R.id.btnCust);

//        btnCust.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                Intent myIntent = new Intent(getApplicationContext(), Customers.class);
//                startActivity(myIntent);
//            }
//        } );
        btnCust.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainMenu.this,Customers.class);
                startActivity(i);
            }
        });

        btnAboutUs = (Button)findViewById(R.id.btnAboutUs);

        btnAboutUs.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), AboutUs.class);
                startActivity(myIntent);
            }
        } );

        btnContactUs = (Button)findViewById(R.id.btnContactUs);

        btnContactUs.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), ContactUs.class);
                startActivity(myIntent);
            }
        } );

        btnDealership = (Button)findViewById(R.id.btnDealership);

        btnDealership.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "RESTART APP BEFORE USING THIS BUTTON AGAIN", Toast.LENGTH_LONG).show();
                Intent myIntent = new Intent(view.getContext(), Dealership.class);
                startActivity(myIntent);
            }
        } );

        btnHelp = (Button)findViewById(R.id.btnHelp);

        btnHelp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Help.class);
                startActivity(myIntent);
            }
        } );

        btnAdministratorPage = (Button)findViewById(R.id.btnAdministratorPage);

        btnAdministratorPage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), AdministratorLoginPage.class);
                startActivity(myIntent);
            }
        } );

    }
}
