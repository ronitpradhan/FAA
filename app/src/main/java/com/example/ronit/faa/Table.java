package com.example.ronit.faa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by RONIT on 7/25/2017.
 */

public class Table extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Intent intent = new Intent(Table.this, Home.class);
                this.startActivity(intent);
                break;
            case R.id.item2:
                intent = new Intent(Table.this, Fitness.class);
                this.startActivity(intent);
                break;
            case R.id.item3:
                intent = new Intent(Table.this, Help.class);
                this.startActivity(intent);
                break;
            case R.id.item4:
                intent = new Intent(Table.this, Settings.class);
                this.startActivity(intent);
                break;
            case R.id.item5:
                intent = new Intent(Table.this, Contact.class);
                this.startActivity(intent);
                break;
            case R.id.item6:
                intent = new Intent(Table.this, Table.class);
                this.startActivity(intent);
                break;

            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }
}
