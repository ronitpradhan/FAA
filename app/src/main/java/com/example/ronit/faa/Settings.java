package com.example.ronit.faa;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Calendar;

/**
 * Created by RONIT on 11/1/2016.
 */
public class Settings extends AppCompatActivity {
    EditText edit_Text1,edit_Text2,edit_Text3;
    Button number_button2;
    public static final String MY_PREFS_NAME = "PhonePreferences";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        edit_Text1=(EditText) findViewById(R.id.edit_Text1);
        number_button2 = (Button) findViewById(R.id.number_button2);
        edit_Text2=(EditText) findViewById(R.id.edit_Text2);
        edit_Text3=(EditText) findViewById(R.id.edit_Text3);

        number_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)

            {
                if (edit_Text1.getText().toString().matches("")){
                    Message.message(Settings.this,"Please fill the fields phone number field!");
                    return;
                }
                if (edit_Text2.getText().toString().matches("")){
                    Message.message(Settings.this,"Please fill the hour field!");
                    return;
                }
                if (edit_Text3.getText().toString().matches("")){
                    Message.message(Settings.this,"Please fill the minute field!");
                    return;
                }
                String search1= edit_Text1.getText().toString();
                int search2= Integer.parseInt(edit_Text2.getText().toString());
                int search3= Integer.parseInt(edit_Text3.getText().toString());

                Message.message(Settings.this,"Settings Saved");

                SharedPreferences settings = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
                SharedPreferences.Editor editor = settings.edit();
                editor.clear();
                editor.commit();
                editor.putString("phone",search1);
                editor.putInt("note",search2);
                editor.putInt("note2",search3);
                editor.commit();

                int notify = settings.getInt("note",0);
                int notifymin = settings.getInt("note2",0);

                Calendar cal = Calendar.getInstance();
                cal.set(Calendar.HOUR_OF_DAY,notify);
                cal.set(Calendar.MINUTE,notifymin);

                Intent intent= new Intent(getApplicationContext(),Notification_receiver.class);
                PendingIntent pendingIntent=PendingIntent.getBroadcast(getApplicationContext(),100,intent,PendingIntent.FLAG_UPDATE_CURRENT);

                AlarmManager am=(AlarmManager)getSystemService(ALARM_SERVICE);
                am.setRepeating(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(), AlarmManager.INTERVAL_DAY,pendingIntent);


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
                intent = new Intent(Settings.this, Fitness.class);
                this.startActivity(intent);
                break;
            case R.id.item3:
                intent = new Intent(Settings.this, Help.class);
                this.startActivity(intent);
                break;
            case R.id.item4:
                intent = new Intent(Settings.this, Settings.class);
                this.startActivity(intent);
                break;
            case R.id.item5:
                intent = new Intent(Settings.this, Contact.class);
                this.startActivity(intent);
                break;
            case R.id.item6:
                intent = new Intent(Settings.this, Table.class);
                this.startActivity(intent);
                break;

            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }
}
