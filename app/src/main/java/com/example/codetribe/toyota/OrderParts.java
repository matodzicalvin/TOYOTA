package com.example.codetribe.toyota;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ProgressDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class OrderParts extends AppCompatActivity {

    // Progress Dialog
    private ProgressDialog pDialog;

    EditText inputFirstName;
    EditText inputMobile;
    EditText inputVIN;
    EditText inputOrder;

    SQLiteDatabase db;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_parts);

        // Edit Text
        inputFirstName = (EditText) findViewById(R.id.inputFirstName);
        inputMobile = (EditText) findViewById(R.id.inputMobile);
        inputVIN = (EditText) findViewById(R.id.inputVIN);
        inputOrder = (EditText) findViewById(R.id.inputOrder);


        // Create button
        Button btnOrderParts = (Button) findViewById(R.id.btnOrderParts);

        // button click event
        btnOrderParts.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (inputFirstName.length() == 0) {
                    inputFirstName.setError("This field can't be empty");
                    inputFirstName.requestFocus();
                } else if (inputMobile.length() == 0 || inputMobile.length() < 10) {
                    inputMobile.setError("Mobile must be 10 digits");
                    inputMobile.requestFocus();
                } else if (inputVIN.length() == 0 || inputVIN.length() < 17) {
                    inputVIN.setError("VIN must be 17 digits");
                    inputVIN.requestFocus();
                } else if (inputOrder.length() == 0) {
                    inputOrder.setError("This field can't be empty");
                    inputOrder.requestFocus();
                } else {
                    createDatabase();
                    CreateOrderParts();

                }
            }
        });
    }

    protected void createDatabase(){
        db=openOrCreateDatabase("OrderPartsDB", Context.MODE_PRIVATE, null);

        // db=openOrCreateDatabase("PersonsDB",Context.MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS OrderParts(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, fname VARCHAR,,cell INTEGER,vin VARCHAR,repair TEXT );");
    }
    public void CreateOrderParts () {


        pDialog = new ProgressDialog(OrderParts.this);
        pDialog.setTitle("Booking Repairs");
        pDialog.setMessage("Please Wait...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(true);
        pDialog.show();
        pDialog.setMax(10000);

        insertIntoDB();


    }



    protected void insertIntoDB(){

        String fname = inputFirstName .getText().toString().trim();
        String cell = inputMobile.getText().toString().trim();
        String vin = inputVIN.getText().toString().trim();
        String repair = inputOrder.getText().toString().trim();



        String query = "INSERT INTO persons (fname,,cell,vin,repair,date) VALUES('"+fname+"', '"+cell+"', '"+vin+"', '"+repair+"');";
        db.execSQL(query);

        Toast.makeText(getApplicationContext(),"Part(s) Successfully Ordered", Toast.LENGTH_LONG).show();
        Diadismiss();
    }
    public void Diadismiss(){
        Intent i = new Intent(getApplication(),Customers.class);
        startActivity(i);
    }

}


