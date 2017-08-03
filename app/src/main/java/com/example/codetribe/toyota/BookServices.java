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


public class BookServices extends AppCompatActivity {

    private ProgressDialog pDialog;

        SQLiteDatabase db;

    EditText inputVehicleModel;
    EditText inputVIN;
    EditText inputMileage;
    EditText inputFirstName;
    EditText inputTel;
    EditText inputServiceDate;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_services);

        inputVehicleModel = (EditText) findViewById(R.id.inputVehicleModel);
        inputVIN = (EditText) findViewById(R.id.inputVIN);
        inputMileage = (EditText) findViewById(R.id.inputMileage);
        inputFirstName = (EditText) findViewById(R.id.inputFirstName);
        inputTel = (EditText) findViewById(R.id.inputTel);
        inputServiceDate = (EditText) findViewById(R.id.inputServiceDate);

        Button btnBookService = (Button) findViewById(R.id.btnBookService);

        btnBookService.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (inputVehicleModel.length()==0) {
                    inputVehicleModel.setError("This field can't be empty");
                    inputVehicleModel.requestFocus();
                }
                else if (inputVIN.length()==0 || inputVIN.length()<17) {
                    inputVIN.setError("VIN must be 17 digits");
                    inputVIN.requestFocus();
                }
                else if (inputMileage.length() ==0) {
                    inputMileage.setError("This field can't be empty");
                    inputMileage.requestFocus();
                }
                else if (inputFirstName.length() ==0) {
                    inputFirstName.setError("This field can't be empty");
                    inputFirstName.requestFocus();
                }

                else if (inputTel.length() ==0 || inputTel.length()<10) {
                    inputTel.setError("Tel must be 10 digits");
                    inputTel.requestFocus();
                }
                else if (inputServiceDate.length() ==0) {
                    inputServiceDate.setError("This field can't be empty");
                    inputServiceDate.requestFocus();
                }
                else{
                    createDatabase();
                    BookServices();
            }
        }
    });
    }
    protected void createDatabase(){
        db=openOrCreateDatabase("BookServicesDB", Context.MODE_PRIVATE, null);

        // db=openOrCreateDatabase("PersonsDB",Context.MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS BookServices(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, sname VARCHAR,vin VARCHAR,km INTEGER,fname VARCHAR,cell INTEGER,date VARCHAR );");
    }
    public void BookServices () {


        pDialog = new ProgressDialog(BookServices.this);
        pDialog.setTitle("Booking Services");
        pDialog.setMessage("Please Wait...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(true);
        pDialog.show();
        pDialog.setMax(10000);

        insertIntoDB();


    }



    protected void insertIntoDB(){

        String sname = inputVehicleModel .getText().toString().trim();
        String vin = inputVIN.getText().toString().trim();
        String km = inputMileage.getText().toString().trim();
        String fname = inputFirstName.getText().toString().trim();
        String cell = inputTel.getText().toString().trim();
        String date = inputServiceDate.getText().toString().trim();


        String query = "INSERT INTO BookServices (sname,vin,km,fname,cell,date) VALUES('"+sname+"', '"+vin+"', '"+km+"', '"+fname+"', '"+cell+"', '"+date+"');";
        db.execSQL(query);

        Toast.makeText(getApplicationContext(),"Service Successfully Booked", Toast.LENGTH_LONG).show();
        Diadismiss();
    }
    public void Diadismiss(){
        Intent i = new Intent(getApplication(),Customers.class);
        startActivity(i);
    }

}
