package com.example.codetribe.toyota;

import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;


public class AdminDeletePost extends ActionBarActivity implements android.view.View.OnClickListener {


    Button Services;
    Button Repair;
    Button Order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_delete_post);

        Services= (Button) findViewById(R.id.button2);
        Repair= (Button) findViewById(R.id.button3);
        Order= (Button) findViewById(R.id.button4);

        Services.setOnClickListener(this);
        Repair.setOnClickListener(this);
        Order.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v==Services){
            Intent i = new Intent(getApplicationContext(),AndroidDashboardDesignActivity.class);
            startActivity(i);
        }
        else if(v==Repair){
            Intent i = new Intent(getApplicationContext(),Repairclass.class);
            startActivity(i);
        }
        else if(v==Order) {
            Intent i = new Intent(getApplicationContext(),Orderclass.class);
            startActivity(i);
        }
        else{

        }
    }
}