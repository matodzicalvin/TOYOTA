package com.example.codetribe.toyota;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminPostDeleteMenu extends Activity {

    Button btnPOST;
    Button btnDelete;
    Button btnLogOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_post_delete_menu);

//        btnPOST = (Button)findViewById(R.id.btnPOST);
//        btnPOST.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                Intent myIntent = new Intent(view.getContext(), AndroidDashboardDesignActivity.class);
//                startActivityForResult(myIntent, 0);
//            }
//        });

        btnDelete = (Button)findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), AdminDeletePost.class);
                startActivityForResult(myIntent, 0);
            }
        });

        btnLogOut = (Button)findViewById(R.id.btnLogOut);
        btnLogOut.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), AdministratorLoginPage.class);
                startActivityForResult(myIntent, 0);
            }
        });

    }
}
