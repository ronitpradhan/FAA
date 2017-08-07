package com.example.ronit.faa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by RONIT on 7/25/2017.
 */

public class Bmi extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

    }
        public void onClickbmi(View view){
            EditText edit_weight=(EditText) findViewById(R.id.weight);
            EditText edit_ft=(EditText) findViewById(R.id.heightft);
            EditText edit_in=(EditText) findViewById(R.id.heightin);
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
            double weight= Double.parseDouble(edit_weight.getText().toString());
            double ft= Double.parseDouble(edit_ft.getText().toString());
            double in= Double.parseDouble(edit_in.getText().toString());
            double height=((ft*12)+in)*0.0254;
            String bmi= String.valueOf(weight/(height*height));
            TextView bmitext = (TextView) findViewById(R.id.calbmi);
            bmitext.setText(bmi);

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
                Intent intent = new Intent(Bmi.this, Home.class);
                this.startActivity(intent);
                break;
            case R.id.item2:
                intent = new Intent(Bmi.this, Fitness.class);
                this.startActivity(intent);
                break;
            case R.id.item3:
                intent = new Intent(Bmi.this, Help.class);
                this.startActivity(intent);
                break;
            case R.id.item4:
                intent = new Intent(Bmi.this, Settings.class);
                this.startActivity(intent);
                break;
            case R.id.item5:
                intent = new Intent(Bmi.this, Contact.class);
                this.startActivity(intent);
                break;
            case R.id.item6:
                intent = new Intent(Bmi.this, Table.class);
                this.startActivity(intent);
                break;

            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }
}
