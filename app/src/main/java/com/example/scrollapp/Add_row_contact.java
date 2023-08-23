package com.example.scrollapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.sql.Time;

        public class  Add_row_contact extends AppCompatActivity {

    private Button back, Add;
    private DbHelper dbHelper;

    private EditText EdtName, EdtPhoneNumber, EdtAmount,dialNo;
    String Name,PhoneNumber,Amount,Time,UpdateTime;

    //camera ke liye
    private final int CAMERA_REQ_CODE=100;
    private final int GALLERY_REQ_CODE=1000;
    ImageView imageView;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_row_contact);


            // Initialize dbHelper
            dbHelper = new DbHelper(this);
        EdtName = findViewById(R.id.Name);
        EdtPhoneNumber = findViewById(R.id.PhoneNumber);
        EdtAmount = findViewById(R.id.Amount);
        Add = findViewById(R.id.Add);

        imageView=findViewById(R.id.ImageCap);
        dialNo= findViewById(R.id.Dial);


        back = findViewById(R.id.Back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Add_row_contact.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //saving data
       Add.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               saveData();
           Intent intent= new Intent(Add_row_contact.this,ImageCamera.class);
          startActivity(intent);

           }
       });


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showImagePickerDialog();
            }
        });


    }

    private void showImagePickerDialog() {
        //option fordialog
        String options[]={"Camera","Gallery"};
        //dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //set tilte in alert
        builder.setTitle("Choose an option");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                //handle item click
                if(which==0){
                    //camera selected
                    if(!checkCameraPermission()){
                        //request camera
                        requestCameraPermission();
                    }else{
                        pickFromCamera();
                    }

                } else if (which==1) {
                    //gallery selected
                    if(!checkStoragePermission()){
                        requestStoragePermission();
                    }else{
                        pickFromGallery();
                    }


                }

            }
        }).create().show();

    }

    private void pickFromGallery() {
    }

    private void requestStoragePermission() {
        Intent iGallery=new Intent(Intent.ACTION_PICK);
        iGallery.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(iGallery,GALLERY_REQ_CODE);
    }

    private boolean checkStoragePermission() {
        return true;
        
    }

    private void pickFromCamera() {
    }

    private void requestCameraPermission() {
    }

    private boolean checkCameraPermission() {
        Intent iCamera=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(iCamera,CAMERA_REQ_CODE);
                Toast.makeText(Add_row_contact.this, "hi sandeep", Toast.LENGTH_SHORT).show();
                return true;
           }



    /////CAPTURING IMAGE;
//        imageView=findViewById(R.id.ImageCap);
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent iCamera=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(iCamera,CAMERA_REQ_CODE);
//                Toast.makeText(Add_row_contact.this, "hi sandeep", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//
//    }
    private void saveData() {
        Name=EdtName.getText().toString();
        PhoneNumber=EdtPhoneNumber.getText().toString();
        Amount=EdtAmount.getText().toString();
        //checkField data
        if(!Name.isEmpty() && !PhoneNumber.isEmpty() && !Amount.isEmpty()){
            //save data
            // function for save data in sqlite database
            Long id= dbHelper.insertContact(
                    ""+imageView,
                    ""+Name,
                    ""+PhoneNumber,
                    ""+Amount,
                    ""+Time,
                    ""+UpdateTime
            );
            //to check data is store
            Toast.makeText(getApplicationContext(), "Inserted"+id, Toast.LENGTH_SHORT).show();




        }else{
            Toast.makeText(this, "Enter require field🤷‍♂️🤷‍♂️", Toast.LENGTH_SHORT).show();




        }

    }
//


    //Image capture from camera

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){

            if(requestCode==CAMERA_REQ_CODE){
                //for camera
               Bitmap img=(Bitmap)(data.getExtras().get("data"));
                imageView.setImageBitmap(img);

            }
           // capture image from gallery
            if(resultCode==RESULT_OK){

                if(requestCode==GALLERY_REQ_CODE) {
                    // for gallery
                    imageView.setImageURI(data.getData());

                }
            }
        }


    }
}