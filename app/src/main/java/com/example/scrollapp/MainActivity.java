package com.example.scrollapp;

import  androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
//import android.widget.toast;

public class MainActivity extends AppCompatActivity {


    private Button button;
    private RecyclerView udhariRv;

    private DbHelper dbHelper;
    private ImageCamera adapterContact;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper=new DbHelper(this);
        button=findViewById(R.id.fabButton);
        udhariRv=findViewById(R.id.udhariRv);


        udhariRv.setHasFixedSize(true);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Add_row_contact.class);
                startActivity(intent);
            }
        });

        loadData();




    }

    private void loadData() {
        // ye tmhara dbhelper se data lene ke liye hai
        adapterContact= new ImageCamera(this,dbHelper.getAllData());
        udhariRv.setAdapter(adapterContact);

    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData();//refresh data
    }
}

//get data from sql and show data in recyclerview by adapter
//to get data we need sql command