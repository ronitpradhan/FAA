package com.example.ronit.faa;

import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

public class Home extends AppCompatActivity{
    FirstDatabaseAdapter secondHelper;
    FirstDatabaseAdapter.FirstHelper firstHelper;
    Button search_button;
    EditText edit_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        secondHelper = new FirstDatabaseAdapter(this);
        firstHelper  = new FirstDatabaseAdapter(this).new FirstHelper(this);

        try {

            firstHelper.createDataBase();

        } catch (IOException ioe) {

            throw new Error("Unable to Create Database");

        }

        try {

            firstHelper.openDataBase();

        }catch(SQLException sqle){

            throw sqle;

        }

        String randText = secondHelper.getRandomData();
        TextView tt1 = (TextView) findViewById(R.id.randomText);
        tt1.setText(randText);

        search_button= (Button) findViewById(R.id.search_button);
        edit_search=(EditText) findViewById(R.id.edit_search);



        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String search= edit_search.getText().toString().toUpperCase();
                Intent intent = new Intent(Home.this, Info.class);
                String data= secondHelper.getData(search);
                //Message.message(Home.this,data);
                intent.putExtra("keyHead", search);
                intent.putExtra("key", data);
                startActivity(intent);
            }
        });
            //SQLiteDatabase sqLiteDatabase=firstHelper.getWritableDatabase();
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Intent intent = new Intent(Home.this, Home.class);
                this.startActivity(intent);
                break;
            case R.id.item2:
                intent = new Intent(Home.this, Fitness.class);
                this.startActivity(intent);
                break;
            case R.id.item3:
                intent = new Intent(Home.this, Help.class);
                this.startActivity(intent);
                break;
            case R.id.item4:
                intent = new Intent(Home.this, Settings.class);
                this.startActivity(intent);
                break;
            case R.id.item5:
                intent = new Intent(Home.this, Contact.class);
                this.startActivity(intent);
                break;
            case R.id.item6:
                intent = new Intent(Home.this, Table.class);
                this.startActivity(intent);
                break;

            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    /*@Override
    public void onClick(View v) {
        //String search= edit_search.getText().toString();
        //Toast.makeText(Home.this, search+" "+"was entered.", Toast.LENGTH_SHORT).show();
        firstHelper=new FirstDatabaseAdapter(this);
        String data= firstHelper.getAllData();
        Message.message(this,data);

    }*/
}