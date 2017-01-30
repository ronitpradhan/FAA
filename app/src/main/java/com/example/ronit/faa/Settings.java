package com.example.ronit.faa;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by RONIT on 11/1/2016.
 */
public class Settings extends AppCompatActivity {
    EditText edit_Text2;
    Button number_button;
    public static final String MY_PREFS_NAME = "PhonePrefs";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        number_button = (Button) findViewById(R.id.number_button);
        edit_Text2=(EditText) findViewById(R.id.edit_Text2);

        number_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String search= edit_Text2.getText().toString();
                Message.message(Settings.this,"Phone Number Submitted");
                SharedPreferences settings = getSharedPreferences(MY_PREFS_NAME, 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putString("phone",search);
                editor.commit();

            }
        });
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
                Intent intent = new Intent(Settings.this, Home.class);
                this.startActivity(intent);
                break;
            case R.id.item2:
                intent = new Intent(Settings.this, Settings.class);
                this.startActivity(intent);
                break;
            case R.id.item3:
                intent = new Intent(Settings.this, Contact.class);
                this.startActivity(intent);
                break;
            case R.id.item4:
                intent = new Intent(Settings.this, Help.class);
                this.startActivity(intent);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }
}
