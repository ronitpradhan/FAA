package com.example.ronit.faa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by RONIT on 7/25/2017.
 */

public class Bmr extends AppCompatActivity {
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmr);
    }
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_male:
                if (checked)
                    i=1;
                    break;
            case R.id.radio_female:
                if (checked)
                    i=2;
                    break;
        }
    }

    public void onClickbmr(View view) {
        EditText edit_weight = (EditText) findViewById(R.id.weight);
        EditText edit_ft = (EditText) findViewById(R.id.heightft);
        EditText edit_in = (EditText) findViewById(R.id.heightin);
        EditText edit_age = (EditText) findViewById(R.id.agevalue);

        if (edit_weight.getText().toString().matches("")){
            Toast.makeText(this, "You did not enter the weight!", Toast.LENGTH_SHORT).show();
        return;
        }
        if (edit_ft.getText().toString().matches("")){
            Toast.makeText(this, "You did not enter the height(in ft)!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (edit_in.getText().toString().matches("")){
            Toast.makeText(this, "You did not enter the height(in inches)!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (edit_age.getText().toString().matches("")){
            Toast.makeText(this, "You did not enter the age!", Toast.LENGTH_SHORT).show();
            return;
        }
        double weight = Double.parseDouble(edit_weight.getText().toString());
        double ft = Double.parseDouble(edit_ft.getText().toString());
        double in = Double.parseDouble(edit_in.getText().toString());
        double age = Double.parseDouble(edit_age.getText().toString());
        double height = ((ft * 12) + in) * 2.54;
        if(i==1) {
            String bmr = String.valueOf(10 * weight + 6.25 * height - 5 * age + 5)+"calories/day";
            TextView bmrtext = (TextView) findViewById(R.id.calbmr);
            bmrtext.setText(bmr);
        }
        else if (i==2) {
            String bmr = String.valueOf(10 * weight + 6.25 * height - 5 * age -161)+"calories/day";
            TextView bmrtext = (TextView) findViewById(R.id.calbmr);
            bmrtext.setText(bmr);
        }
        else{
            String bmr = "Select if male or female!";
            TextView bmitext = (TextView) findViewById(R.id.calbmr);
            bmitext.setText(bmr);
        }

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
                Intent intent = new Intent(Bmr.this, Home.class);
                this.startActivity(intent);
                break;
            case R.id.item2:
                intent = new Intent(Bmr.this, Fitness.class);
                this.startActivity(intent);
                break;
            case R.id.item3:
                intent = new Intent(Bmr.this, Help.class);
                this.startActivity(intent);
                break;
            case R.id.item4:
                intent = new Intent(Bmr.this, Settings.class);
                this.startActivity(intent);
                break;
            case R.id.item5:
                intent = new Intent(Bmr.this, Contact.class);
                this.startActivity(intent);
                break;
            case R.id.item6:
                intent = new Intent(Bmr.this, Table.class);
                this.startActivity(intent);
                break;

            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }
}
