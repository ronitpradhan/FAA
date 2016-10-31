package com.example.ronit.faa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Home extends AppCompatActivity implements View.OnClickListener {

    Button search_button;
    EditText edit_search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        search_button= (Button) findViewById(R.id.search_button);
        search_button.setOnClickListener(this);
        edit_search=(EditText) findViewById(R.id.edit_search);

    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        String search= edit_search.getText().toString();
        Toast.makeText(Home.this, search+" "+"was entered.", Toast.LENGTH_SHORT).show();
    }
}
