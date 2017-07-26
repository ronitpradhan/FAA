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

public class Ffmi extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ffmi);
    }
    public void onClickffmi(View view){
        EditText edit_weight=(EditText) findViewById(R.id.weight);
      EditText edit_ft=(EditText) findViewById(R.id.heightft);
     EditText edit_in=(EditText) findViewById(R.id.heightin);
        EditText edit_bf=(EditText) findViewById(R.id.bfvalue);
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
        if (edit_bf.getText().toString().matches("")){
            Toast.makeText(this, "You did not enter the body fat%!", Toast.LENGTH_SHORT).show();
            return;
        }
        double weight= Double.parseDouble(edit_weight.getText().toString());
        double ft= Double.parseDouble(edit_ft.getText().toString());
        double in= Double.parseDouble(edit_in.getText().toString());
        double bf= Double.parseDouble(edit_bf.getText().toString());
        double height=((ft*12)+in)*0.0254;
        double lean=weight*(1.0-(bf/100));
        String lean_mass= "Lean= "+String.valueOf(lean)+"kg";
        double ffmi_value=(lean/2.2)/(height*height)*2.20462;
        String ffmi= "FFMI= "+String.valueOf(ffmi_value);
        String adj_ffmi= "Adj FFMI= "+String.valueOf(ffmi_value+(6.0*(height-1.8)));
        String result=lean_mass+"\n"+ffmi+"\n"+adj_ffmi;
        TextView leantext = (TextView) findViewById(R.id.callean);
        leantext.setText(result);



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
                Intent intent = new Intent(Ffmi.this, Home.class);
                this.startActivity(intent);
                break;
            case R.id.item2:
                intent = new Intent(Ffmi.this, Fitness.class);
                this.startActivity(intent);
                break;
            case R.id.item3:
                intent = new Intent(Ffmi.this, Help.class);
                this.startActivity(intent);
                break;
            case R.id.item4:
                intent = new Intent(Ffmi.this, Settings.class);
                this.startActivity(intent);
                break;
            case R.id.item5:
                intent = new Intent(Ffmi.this, Contact.class);
                this.startActivity(intent);
                break;
            case R.id.item6:
                intent = new Intent(Ffmi.this, Table.class);
                this.startActivity(intent);
                break;

            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }
}