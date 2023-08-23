package com.example.scrollapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;


import androidx.annotation.Nullable;

    //class ffor database helper
    public class DbHelper extends SQLiteOpenHelper {


      //  public static long insertContact;

        public DbHelper(@Nullable Context context)  {
            super(context, Constant.DATABASE_NAME, null, Constant.DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db){
            //create table on database
            db.execSQL(Constant.CREATE_TABLE);

        }












        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            //upgrade table if any changes in db

            db.execSQL("DROP TABLE IF EXISTS " + Constant.TABLE_NAME);
            //create table again
            onCreate(db);

            //

        }
        public long insertContact(String image, String name, String phone, String amount, String time, String update_time) {
            SQLiteDatabase db = this.getWritableDatabase();
            // Rest of the method code...


            //create content value class
            ContentValues contentValues= new ContentValues();
            contentValues.put(Constant.C_IMAGE,image);
            contentValues.put(Constant.C_NAME,name);
            contentValues.put(Constant.C_PHONE,phone);
            contentValues.put(Constant.C_TIME,time);
            contentValues.put(Constant.C_UPDATE_TIME,update_time);
            // insrt data in row , it will return id of record
            long id=db.insert(Constant.TABLE_NAME,null,contentValues);

            //close db
            db.close();
            //return id
            return id;


        }
        //get data
        public ArrayList<ModelContact> getAllData(){
            //create arraylist
            ArrayList<ModelContact> arrayList= new ArrayList<>();
            //sql commmand query
            String selectQuery= "SELECT * FROM "+Constant.TABLE_NAME;
            //get readable dp
            SQLiteDatabase db =getReadableDatabase();
            Cursor cursor =db.rawQuery(selectQuery,null);
            if (cursor.moveToFirst()){
                do{
                    ModelContact modelContact=new ModelContact(
                            ""+cursor.getInt(cursor.getColumnIndexOrThrow(Constant.C_ID)),
                            ""+cursor.getString(cursor.getColumnIndexOrThrow(Constant.C_NAME)),
                            ""+cursor.getString(cursor.getColumnIndexOrThrow(Constant.C_IMAGE)),
                            ""+cursor.getString(cursor.getColumnIndexOrThrow(Constant.C_AMOUNT)),
                            ""+cursor.getString(cursor.getColumnIndexOrThrow(Constant.C_PHONE)),
                            ""+cursor.getString(cursor.getColumnIndexOrThrow(Constant.C_TIME)),
                            ""+cursor.getString(cursor.getColumnIndexOrThrow(Constant.C_UPDATE_TIME))



                    );
                    arrayList.add(modelContact);
                }while(cursor.moveToNext());

            }
            db.close();
            return arrayList;
        }
    }




