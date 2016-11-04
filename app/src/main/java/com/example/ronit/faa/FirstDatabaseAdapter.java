package com.example.ronit.faa;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Random;

/**
 * Created by RONIT on 11/2/2016.
 */

public class FirstDatabaseAdapter {
    FirstHelper helper;

    public FirstDatabaseAdapter(Context context) {
        helper = new FirstHelper(context);
    }


    public String getData(String search) {
        SQLiteDatabase db = helper.getWritableDatabase();
        String[] columns = {FirstHelper.NAME, FirstHelper.DETAIL};
        Cursor cursor = db.query(FirstHelper.TABLE_NAME, columns, FirstHelper.NAME+"='"+search+"'", null, null, null, null);
        StringBuffer buffer=new StringBuffer();
        while (cursor.moveToNext()) {
            //int index1 = cursor.getColumnIndex(FirstHelper.NAME);
            int index2 = cursor.getColumnIndex(FirstHelper.DETAIL);
            //String name = cursor.getString(index1);
            String detail = cursor.getString(index2);
            buffer.append(detail);

        }
        return buffer.toString();
    }
    public String getRandomData(){
        Random rand=new Random();
        int r1= rand.nextInt(8-1)+1;
        SQLiteDatabase db = helper.getWritableDatabase();
        String[] columns = {FirstHelper.NAME, FirstHelper.DETAIL};
        Cursor cursor = db.query(FirstHelper.TABLE_NAME, columns, FirstHelper.UID+"='"+r1+"'", null, null, null, null);
        StringBuffer buffer1=new StringBuffer();
        while (cursor.moveToNext()) {
            int index1 = cursor.getColumnIndex(FirstHelper.NAME);
            int index2 = cursor.getColumnIndex(FirstHelper.DETAIL);
            String name = cursor.getString(index1);
            String detail = cursor.getString(index2);
            buffer1.append(name+"\n"+detail);

        }
        return buffer1.toString();
    }
    static class FirstHelper extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "first";
        private static final String TABLE_NAME = "info";
        private static final int DATABASE_VERSION = 4;
        private static final String UID = "_id";
        private static final String NAME = "name";
        private static final String DETAIL = "detail";
        private static final String DROP_TABLE="DROP TABLE IF EXISTS "+TABLE_NAME+";";
        private static final String CREATE_TABLE="CREATE TABLE "+TABLE_NAME+" ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" VARCHAR(255), "+DETAIL+" LONGTEXT);";
        private Context context;

        public FirstHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context = context;
            //Message.message(context, "constructor called");

        }

        @Override
        public void onCreate(SQLiteDatabase db) {

       /* try{
            db.execSQL(CREATE_TABLE);
            Message.message(context, "onCreate called");
        }catch(SQLException e){
            Message.message(context,""+e);
        }*/
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        /*try {
            Message.message(context, "onUpgrade called");
            db.execSQL(DROP_TABLE);
            onCreate(db);
        }catch (SQLException e){
            Message.message(context,""+e);
        }*/
        }
        }
    }
