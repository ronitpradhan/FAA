package com.example.ronit.faa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Home extends AppCompatActivity implements View.OnClickListener {
    FirstHelper firstHelper;
    Button search_button;
    EditText edit_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        search_button= (Button) findViewById(R.id.search_button);
        search_button.setOnClickListener(this);
        edit_search=(EditText) findViewById(R.id.edit_search);
        firstHelper=new FirstHelper(this);

        //SQLiteDatabase db =firstHelper.getReadableDatabase();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
        case R.id.item1:
        Intent intent = new Intent(Home.this, Home.class);
        this.startActivity(intent);
        break;
        case R.id.item2:
            intent = new Intent(Home.this, Settings.class);
        this.startActivity(intent);
        break;
        case R.id.item3:
            intent = new Intent(Home.this, Contact.class);
        this.startActivity(intent);
        break;
        case R.id.item4:
            intent = new Intent(Home.this, Index.class);
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
    @Override
    public void onClick(View v) {
       String search1= edit_search.getText().toString();
        Toast.makeText(Home.this, search1+" "+"was entered.", Toast.LENGTH_SHORT).show();

    }



}
