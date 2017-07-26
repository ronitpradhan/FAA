package com.example.ronit.faa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by RONIT on 7/25/2017.
 */

public class Calories extends AppCompatActivity {
    int i, j;
    double mul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calories);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_male:
                if (checked)
                    i = 1;
                break;
            case R.id.radio_female:
                if (checked)
                    i = 2;
                break;
        }
    }


    public void onClickcal(View view) {
        EditText edit_weight = (EditText) findViewById(R.id.weight);
        EditText edit_ft = (EditText) findViewById(R.id.heightft);
        EditText edit_in = (EditText) findViewById(R.id.heightin);
        EditText edit_age = (EditText) findViewById(R.id.agevalue);
        if (edit_weight.getText().toString().matches("")) {
            Toast.makeText(this, "You did not enter the weight!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (edit_ft.getText().toString().matches("")) {
            Toast.makeText(this, "You did not enter the height(in ft)!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (edit_in.getText().toString().matches("")) {
            Toast.makeText(this, "You did not enter the height(in inches)!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (edit_age.getText().toString().matches("")) {
            Toast.makeText(this, "You did not enter the age!", Toast.LENGTH_SHORT).show();
            return;
        }
        double weight = Double.parseDouble(edit_weight.getText().toString());
        double ft = Double.parseDouble(edit_ft.getText().toString());
        double in = Double.parseDouble(edit_in.getText().toString());
        double age = Double.parseDouble(edit_age.getText().toString());

        double height = ((ft * 12) + in) * 2.54;

        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.lifestyle, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int Selected = parent.getSelectedItemPosition();
                if (Selected == 0) j = 1;
                else if (Selected == 1) j = 2;
                else if (Selected == 2) j = 3;
                else if (Selected == 3) j = 4;
                else if (Selected == 4) j = 5;
                else if (Selected == 5) j = 6;
                else if (Selected == 6) j = 7;
                else j=0;

//               String Selected = parent.getItemAtPosition(position).toString();
//
//                if (Selected == "0") j = 1;
//                else if (Selected == "1") j = 2;
//                else if (Selected == "2") j = 3;
//                else if (Selected == "3") j = 4;
//                else if (Selected == "4") j = 5;
//                else if (Selected == "5") j = 6;
//                else if (Selected == "6") j = 7;


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
//        int Selected = spinner.getSelectedItemPosition();
//        if (Selected == 0) j = 1;
//        else if (Selected == 1) j = 2;
//        else if (Selected == 2) j = 3;
//        else if (Selected == 3) j = 4;
//        else if (Selected == 4) j = 5;
//        else if (Selected == 5) j = 6;
//        else if (Selected == 6) j = 7;
//        else j=0;
//


        if (j == 1) mul = 1.2000;
        else if (j == 2) mul = 1.3751;
        else if (j == 3) mul = 1.41870;
        else if (j == 4) mul = 1.5500;
        else if (j == 5) mul = 1.6376;
        else if (j == 6) mul = 1.7252;
        else if (j == 7) mul = 1.9100;
        else mul = 0.0;

        if (i == 1) {
            if (j == 0) {
                TextView cal = (TextView) findViewById(R.id.calcal);
                cal.setText("Please select the Lifestyle you live!");
            } else {
                String bmr = String.valueOf((10 * weight + 6.25 * height - 5 * age - 5) * mul) + " calories/day";
                TextView bmitext = (TextView) findViewById(R.id.calcal);
                bmitext.setText(bmr);
            }

        }
        else if (i == 2) {
            if (j == 0) {
                TextView cal = (TextView) findViewById(R.id.calcal);
                cal.setText("Please select the Lifestyle you live!");
            } else {
                String bmr = String.valueOf((10 * weight + 6.25 * height - 5 * age - 161) * mul) + " calories/day";
                TextView bmitext = (TextView) findViewById(R.id.calcal);
                bmitext.setText(bmr);
            }
        }
        else {
            String bmr = "Select if male or female!";
            TextView bmitext = (TextView) findViewById(R.id.calcal);
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
                Intent intent = new Intent(Calories.this, Home.class);
                this.startActivity(intent);
                break;
            case R.id.item2:
                intent = new Intent(Calories.this, Fitness.class);
                this.startActivity(intent);
                break;
            case R.id.item3:
                intent = new Intent(Calories.this, Help.class);
                this.startActivity(intent);
                break;
            case R.id.item4:
                intent = new Intent(Calories.this, Settings.class);
                this.startActivity(intent);
                break;
            case R.id.item5:
                intent = new Intent(Calories.this, Contact.class);
                this.startActivity(intent);
                break;
            case R.id.item6:
                intent = new Intent(Calories.this, Table.class);
                this.startActivity(intent);
                break;

            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }
}