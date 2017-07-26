package com.example.ronit.faa;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by RONIT on 11/3/2016.
 */

public class Help extends AppCompatActivity{
    public static final String MY_PREFS_NAME = "PhonePreferences";
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        ImageButton imageButton;
        imageButton=(ImageButton)findViewById(R.id.imageButton);



        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //String message="Hello";
                //Message.message(Help.this,message);
                String messageToSend = "Help!!! Its an emergency!!! Call an ambulance!!! I am injured!!! Call me!!!";
                SharedPreferences settings = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
                String number = settings.getString("phone","");
               //String number = "9849471112";

                //SmsManager.getDefault().sendTextMessage(number, null, messageToSend, null,null);
//                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
//                sendIntent.putExtra("address",number);
//                sendIntent.putExtra("sms_body", messageToSend);
//                sendIntent.setType("vnd.android-dir/mms-sms");
//                startActivity(sendIntent);
                try {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(number, null, messageToSend, null, null);
                    Toast.makeText(getApplicationContext(), "SMS sent.", Toast.LENGTH_LONG).show();
                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(),"SMS failed, please enable SMS permission for the application or enter a mobile number in SETTINGS",
                            Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
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
                Intent intent = new Intent(Help.this, Home.class);
                this.startActivity(intent);
                break;
            case R.id.item2:
                intent = new Intent(Help.this, Fitness.class);
                this.startActivity(intent);
                break;
            case R.id.item3:
                intent = new Intent(Help.this, Help.class);
                this.startActivity(intent);
                break;
            case R.id.item4:
                intent = new Intent(Help.this, Settings.class);
                this.startActivity(intent);
                break;
            case R.id.item5:
                intent = new Intent(Help.this, Contact.class);
                this.startActivity(intent);
                break;
            case R.id.item6:
                intent = new Intent(Help.this, Table.class);
                this.startActivity(intent);
                break;

            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }
}
