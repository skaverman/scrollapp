package com.example.scrollapp;

import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

//import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
//import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
//import android.widget.Toast;

import java.util.ArrayList;
//// crete adapter for data show in recyclerview

 class ImageCamera extends RecyclerView.Adapter<ImageCamera.ContactViewHolder> {

    private final Context context;
    private final ArrayList<ModelContact>  dataList;
    private final LayoutInflater layoutInflater;

    //add constructor
    //alt + ins


    public ImageCamera(Context context, ArrayList<ModelContact> dataList) {
        this.context = context;
        this.dataList = dataList;
        this.layoutInflater = LayoutInflater.from(context); // Initialize the layoutInflater
    }

    public class Viewholder extends RecyclerView.ViewHolder{

        public Viewholder(View itemView){
            super(itemView);
        }
    }
    @NonNull
    @Override
    //jo xml mai banaya hai wo dikhne ke liiye samajha
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= layoutInflater.from(context).inflate(R.layout.activity_image_camera,parent,false);
        ContactViewHolder vh= new ContactViewHolder(view);

        return vh;
    }

//    @NonNull
//    @Override
//    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return null;
//    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        ModelContact modelContact= dataList.get(position);
        //get data
       // String id= modelContact.getId();
        String image=modelContact.getImage();
        String name=modelContact.getName();
        String amount=modelContact.getAmount();
        String phoneNumber= modelContact.getPhone();

        //set dta in view

//            holder.Name.setText(name);
//          holder.contactImg.setImageResource(Integer.parseInt(image));
//          holder.Amount.setText(amount);
//
//          holder.PhoneNumber.setText(phoneNumber);
//   //}
        //handle click listener

        holder.contactDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public int getItemCount() {

        return dataList.size();
    }

    // text mai dhikne ke liye
    public static class ContactViewHolder extends RecyclerView.ViewHolder {
        ImageView contactImg, contactDial;
        TextView Name, PhoneNumber, Amount;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            // Initialize the views here using itemView.findViewById()
           contactImg = itemView.findViewById(R.id.ContactImg); // Replace imageViewContact with the actual ID of the ImageView in your XML
            contactDial = itemView.findViewById(R.id.Dial); // Replace imageViewDial with the actual ID of the ImageView in your XML
            Name = itemView.findViewById(R.id.Name); // Replace textViewName with the actual ID of the TextView in your XML
            PhoneNumber = itemView.findViewById(R.id.PhoneNumber); // Replace textViewPhoneNumber with the actual ID of the TextView in your XML
            Amount = itemView.findViewById(R.id.Amount);
           contactDial=itemView.findViewById(R.id.Dial);
        }
        // Object itemView;
        //  contactImage= itemView.findViewById


        //
//        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
//        ImageView imageView=findViewById(R.id.ImageCap);

    }
}
