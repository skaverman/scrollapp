package com.example.scrollapp;

public class Constant {
    public static final String DATABASE_NAME="CONTACT_DB";
    public static final int  DATABASE_VERSION= 1;
    //TABLE NAME
    public static final  String TABLE_NAME="CONTACT_TABLE";
    //TABLE COLOUM
    public static final String C_ID="ID";
    public static final String C_IMAGE="IMAGE";
    public static final String C_NAME ="NAME";
    public static final  String C_PHONE="PHONE";
    public static final String C_AMOUNT="AMOUNT";
    public static final String C_TIME ="TIME";
    public static final String C_UPDATE_TIME="UPDATE_TIME";

    // query for create table
    public static final String CREATE_TABLE="CREATE TABLE " + TABLE_NAME + "( "
            + C_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + C_IMAGE + " TEXT, "
            + C_NAME + " TEXT, "
            + C_PHONE + " TEXT, "
            + C_AMOUNT + " TEXT,"
            + C_TIME + " TEXT, "
            + C_UPDATE_TIME + " TEXT"
            + " );";


    // CREATE DATABASE HELPER CLASS

}


