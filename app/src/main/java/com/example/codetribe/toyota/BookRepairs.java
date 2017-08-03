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

public class BookRepairs extends AppCompatActivity {

    SQLiteDatabase db;
    private ProgressDialog pDialog;


    EditText inputFirstName;
    EditText inputMobile;
    EditText inputVIN;
    EditText inputRepair;
    EditText inputRepairDate;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_repairs);

        inputFirstName = (EditText) findViewById(R.id.inputFirstName);
        inputMobile = (EditText) findViewById(R.id.inputMobile);
        inputVIN = (EditText) findViewById(R.id.inputVIN);
        inputRepair = (EditText) findViewById(R.id.inputRepair);
        inputRepairDate = (EditText) findViewById(R.id.inputRepairDate);

        Button btnBookRepair = (Button) findViewById(R.id.btnBookRepair);

        btnBookRepair.setOnClickListener(new View.OnClickListener() {

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
                } else if (inputRepair.length() == 0) {
                    inputRepair.setError("This field can't be empty");
                    inputRepair.requestFocus();
                } else if (inputRepairDate.length() == 0) {
                    inputRepairDate.setError("This field can't be empty");
                    inputRepairDate.requestFocus();
                } else {
                    CreateBookRepairs();
                    createDatabase();
                }
            }
        });

    }
 protected void createDatabase(){
    db=openOrCreateDatabase("BookRepairsDB", Context.MODE_PRIVATE, null);

    // db=openOrCreateDatabase("PersonsDB",Context.MODE_PRIVATE,null);
    db.execSQL("CREATE TABLE IF NOT EXISTS BookRepairs(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, fname VARCHAR,,cell INTEGER,vin VARCHAR,repair TEXT,date VARCHAR );");
}
    public void CreateBookRepairs () {


        pDialog = new ProgressDialog(BookRepairs.this);
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
        String repair = inputRepair.getText().toString().trim();
        String date = inputRepairDate.getText().toString().trim();


        String query = "INSERT INTO BookRepairs (fname,,cell,vin,repair,date) VALUES('"+fname+"', '"+cell+"', '"+vin+"', '"+repair+"','"+date+"');";
        db.execSQL(query);

        Toast.makeText(getApplicationContext(),"Repair Successfully Booked", Toast.LENGTH_LONG).show();
        Diadismiss();
    }
    public void Diadismiss(){
        Intent i = new Intent(getApplication(),Customers.class);
        startActivity(i);
    }

}
