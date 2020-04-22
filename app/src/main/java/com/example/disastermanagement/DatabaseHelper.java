package com.example.disastermanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "disastermanagement";
    private static final String TABLE_LOGIN = "login";
    private static final String TABLE_DISASTER = "disaster";
    private static final String KEY_NAME = "name";
    private static final String KEY_PASSWORD= "password";
    private static final String ID ="id" ;
    private static final String LAT ="lat" ;
    private static final String LON ="lon" ;
    private static final String MAG ="mag" ;
    private static final String LOS ="los" ;
    ///private static final String KEY_STATUS = "status";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //3rd argument to be passed is CursorFactory instance

    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_EMPLOYEE_TABLE = "CREATE TABLE " + TABLE_LOGIN + "("

                + KEY_NAME + " TEXT PRIMARY KEY,"
                + KEY_PASSWORD + " TEXT"



                +")";
        db.execSQL(CREATE_EMPLOYEE_TABLE);

        //
        String CREATE_DISASTER = "CREATE TABLE " + TABLE_DISASTER + "("
                +ID    +"INT PRIMARY KEY,"
                +LAT  + " DOUBLE ,"
                +LON  + " DOUBLE ,"
                +MAG  + " DOUBLE ,"
                + LOS + " INT"

                +")";
        db.execSQL(CREATE_DISASTER);

    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOGIN);

        // Create tables again
        onCreate(db);
    }

    // code to add the new contact
    void addContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getName()); // Contact Name
        values.put(KEY_PASSWORD, contact.get_password()); // Contact Phone

        //0 contact is not verified yet

        // Inserting Row
        try{
            long a=  db.insert(TABLE_LOGIN, null, values);
            if(a==1){

            }
            Log.d("exception","hvb");
        }

        catch(Exception e){
            Log.d("exception",e.toString());
        }

        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    void addDisaster(double lat,double lon,double mag,int los) {
        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues values = new ContentValues();
        values.put(LAT,lat); // Contact Name
        values.put(LON,lon); // Contact Phone
        values.put(MAG,mag);
        values.put(LOS,los);

        //0 contact is not verified yet

        // Inserting Row
        try{
            long a=  db.insert(TABLE_DISASTER, null, values);
            if(a==1){

            }
            Log.d("exception","hvb");
        }

        catch(Exception e){
            Log.d("exception",e.toString());
        }

        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }


    boolean searchContact(Contact contact) {
        List<Contact> contactList = new ArrayList<Contact>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_LOGIN;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                String name=cursor.getString(0);
                String paswd=cursor.getString(1);
                if(name.equals(contact.getName()) && paswd.equals(contact.get_password())){
                    return  true;
                }

                //}
            } while (cursor.moveToNext());
        }

        // return contact list
        return false;

    }

    DisasterModel getData() {
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_DISASTER;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        DisasterModel disasterModel;
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {

          disasterModel=new DisasterModel(cursor.getDouble(1),cursor.getDouble(2),cursor.getDouble(3),cursor.getInt(4));
          return  disasterModel;
                //}

        }

        return  null;

    }
    boolean searchContactForRegister(Contact contact) {
        List<Contact> contactList = new ArrayList<Contact>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_LOGIN;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                String name=cursor.getString(0);
                String paswd=cursor.getString(1);
                if(name.equals(contact.getName())){
                    return  true;
                }

                //}
            } while (cursor.moveToNext());
        }

        // return contact list
        return false;

    }


}