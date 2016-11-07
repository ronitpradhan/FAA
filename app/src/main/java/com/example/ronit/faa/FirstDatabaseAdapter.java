package com.example.ronit.faa;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
            buffer.append("\t\t\t\t\t"+detail);

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
            buffer1.append("Today's Help:"+"\n\n"+name+"\n"+"\t\t\t\t\t"+detail);

        }
        return buffer1.toString();
    }
     class FirstHelper extends SQLiteOpenHelper {
        private static final String DB_PATH = "/data/data/com.example.ronit.faa/databases/";
        private static final String DATABASE_NAME = "first.sqlite";
        private static final String TABLE_NAME = "info";
        private static final int DATABASE_VERSION = 4;
        private static final String UID = "_id";
        private static final String NAME = "name";
        private static final String DETAIL = "detail";
        private static final String DROP_TABLE="DROP TABLE IF EXISTS "+TABLE_NAME+";";
        private static final String CREATE_TABLE="CREATE TABLE "+TABLE_NAME+" ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" VARCHAR(255), "+DETAIL+" LONGTEXT);";
        private SQLiteDatabase myDataBase;
        private Context context;

        public FirstHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context = context;
            //Message.message(context, "constructor was called");

        }
        public void createDataBase() throws IOException {

            boolean dbExist = checkDataBase();

            if (dbExist) {

            } else {


                this.getWritableDatabase();

                try {

                    copyDataBase();

                } catch (IOException e) {

                    throw new Error("Error copying database");

                }
            }

        }

        private boolean checkDataBase() {

            SQLiteDatabase checkDB = null;

            try {
                String myPath = DB_PATH + DATABASE_NAME;
                File file = new File(myPath);
                if (file.exists() && !file.isDirectory())
                    checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

            } catch (SQLiteException e) {


            }

            if (checkDB != null) {

                checkDB.close();

            }

            return checkDB != null ? true : false;
        }


        private void copyDataBase() throws IOException {


            InputStream myInput = context.getAssets().open(DATABASE_NAME);
            String outFileName = DB_PATH + DATABASE_NAME;
            System.out.println(outFileName+ " " );
            OutputStream myOutput = new FileOutputStream(outFileName);


            byte[] buffer = new byte[1024];
            int length;
            while ((length = myInput.read(buffer)) > 0) {
                myOutput.write(buffer, 0, length);
            }


            myOutput.flush();
            myOutput.close();
            myInput.close();

        }

        public void openDataBase() throws SQLException {


            String myPath = DB_PATH + DATABASE_NAME;
            File file = new File(myPath);
            if (file.exists() && !file.isDirectory())
                myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

        }

        @Override
        public synchronized void close() {

            if (myDataBase != null)
                myDataBase.close();

            super.close();

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
