package com.example.codetribe.toyota;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class  AndroidDashboardDesignActivity extends AppCompatActivity {
    EditText editTextId;
    EditText inputVehicleModel;
    EditText inputVIN;
    EditText inputMileage;
    EditText inputFirstName;
    EditText inputTel;
    EditText inputServiceDate;

    Button btnPrev;
    Button btnNext;
    Button btnSave;
    Button btnDelete;
    Button menu;

    private static final String SELECT_SQL = "SELECT * FROM BookServices";
    private SQLiteDatabase db;
    private ProgressDialog pDialog;
    private Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_dashboard_design);
        openDatabase();
        editTextId = (EditText) findViewById(R.id.editTextId);
        inputVehicleModel = (EditText) findViewById(R.id.inputVehicleModel);
        inputVIN = (EditText) findViewById(R.id.inputVIN);
        inputMileage = (EditText) findViewById(R.id.inputMileage);
        inputFirstName = (EditText) findViewById(R.id.inputFirstName);
        inputTel = (EditText) findViewById(R.id.inputTel);
        inputServiceDate = (EditText) findViewById(R.id.inputServiceDate);


        btnPrev = (Button) findViewById(R.id.btnPrev);
        btnNext = (Button) findViewById(R.id.btnNext);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        menu= (Button) findViewById(R.id.button4);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveNext();

            }
        });
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movePrev();
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inputVehicleModel.length() == 0) {
                    inputVehicleModel.setError("This field can't be empty");
                    inputVehicleModel.requestFocus();
                    return;
                } else if (inputVIN.length() == 0) {
                    inputVIN.setError("This field can't be empty");
                    inputVIN.requestFocus();
                    return;
                } else if (inputMileage.length() == 0) {
                    inputMileage.setError("This field can't be empty");
                    inputMileage.requestFocus();
                    return;
                } else if (inputFirstName.length() == 0) {
                    inputFirstName.setError("This field can't be empty");
                    inputFirstName.requestFocus();
                    return;
                } else if (inputTel.length() == 0) {
                    inputTel.setError("This field can't be empty");
                    inputTel.requestFocus();
                    return;
                } else if (inputServiceDate.length() == 0) {
                    inputServiceDate.setError("This field can't be empty");
                    inputServiceDate.requestFocus();
                    return;
                }

                else {
                    pDialog = new ProgressDialog(AndroidDashboardDesignActivity.this);
                    pDialog.setTitle("Saving...");
                    pDialog.setMessage("Please Wait...");
                    pDialog.setIndeterminate(false);
                    pDialog.setCancelable(true);
                    pDialog.show();
                    pDialog.setMax(10000);
                    saveRecord();
                }

            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteRecord();
            }
        });
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pDialog = new ProgressDialog(AndroidDashboardDesignActivity.this);
                pDialog.setTitle("Loading menu...");
                pDialog.setMessage("Please Wait...");
                pDialog.setIndeterminate(false);
                pDialog.setCancelable(true);
                pDialog.show();
                pDialog.setMax(10000);
                Intent i = new Intent(getApplicationContext(),AndroidDashboardDesignActivity.class);
                startActivity(i);
            }
        });

        c = db.rawQuery(SELECT_SQL, null);
        c.moveToFirst();
        showRecords();
    }


    protected void openDatabase() {
        db = openOrCreateDatabase("BookServicesDB", Context.MODE_PRIVATE, null);
    }

    protected void showRecords() {

        String id = c.getString(0);
        editTextId.setText(id);

        String c2=c.getString(1);
        inputVehicleModel.setText(c2);


        String name = c.getString(2);
        inputVIN.setText(name);

        String c1 = c.getString(3);
        inputMileage.setText(c1);

        String g = c.getString(4);
        inputFirstName.setText(g);

        String cal = c.getString(5);
        inputTel.setText(cal);

        String gra = c.getString(6);
        inputServiceDate.setText(gra);


    }

    protected void moveNext() {
        if (!c.isLast()) {
            c.moveToNext();

            showRecords();
        }

        else if(c.isLast()){
            Toast.makeText(getApplicationContext(),"This is the last one",Toast.LENGTH_LONG).show();
        }
        else{

        }
    }
    protected void movePrev() {
        if (!c.isFirst()) {
            c.moveToPrevious();
            showRecords();
        }
        else if(c.isFirst()){
            Toast.makeText(getApplicationContext(),"This is the first one",Toast.LENGTH_LONG).show();
        }
        else{

        }

    }


    protected void saveRecord() {

        String id = editTextId.getText().toString().trim();
        String sname = inputVehicleModel.getText().toString().trim();
        String vin = inputVIN.getText().toString().trim();
        String km = inputMileage.getText().toString().trim();
        String fname = inputFirstName.getText().toString().trim();
        String cell = inputTel.getText().toString().trim();
        String date = inputServiceDate.getText().toString().trim();


        // String sql = "UPDATE persons SET sname='" + sname + "', cosc1='" + cosc1 + "', gradecosc='" + gradecosc + "', calculas='" + calculas + "', gradecal='" + gradecal + "', statistics='" + statistics + "', gradesta='" + gradesta + "' WHERE id=" + id + ";";
        //String sql = "UPDATE persons WHERE id=" + id + ";";
        String sql = "UPDATE BookServices SET sname='" +sname + "', vin ='" + vin + "', km='" + km + "', fname ='" + fname + "', cell ='" + cell + "', date ='" + date + "' WHERE id=" + id + ";";
        // String sql = "UPDATE persons SET name='" +g + "', c1 ='" + c1 + "', cal ='" + cal + "', statistic ='" + statistic + "' WHERE id=" + id + ";";

        db.execSQL(sql);
        Toast.makeText(getApplicationContext(), "Records Saved Successfully", Toast.LENGTH_LONG).show();
        c = db.rawQuery(SELECT_SQL, null);
        c.moveToPosition(Integer.parseInt(id));
        Intent my = new Intent(getApplicationContext(),AndroidDashboardDesignActivity.class);
        startActivity(my);

    }

    private void deleteRecord() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Are you sure you want delete this person?");

        alertDialogBuilder.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {


                        String id = editTextId.getText().toString().trim();

                        String sql1 = "DELETE FROM BookServices WHERE id=" + id + ";";
                        db.execSQL(sql1);

                        Toast.makeText(getApplicationContext(), "Record Deleted", Toast.LENGTH_LONG).show();
                        c = db.rawQuery(SELECT_SQL, null);
                    }
                });

        alertDialogBuilder.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                });


        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }


}
