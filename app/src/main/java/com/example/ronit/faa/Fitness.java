package com.example.ronit.faa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Created by RONIT on 7/25/2017.
 */

public class Fitness extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitness);

        Button calories= (Button) findViewById(R.id.calories);
        Button bmi= (Button) findViewById(R.id.bmi);
        Button bmr= (Button) findViewById(R.id.bmr);
        Button bodyfat= (Button) findViewById(R.id.bodyfat);
        Button ffmi= (Button) findViewById(R.id.ffmi);

        calories.setOnClickListener(this);
        bmi.setOnClickListener(this);
        bmr.setOnClickListener(this);
        bodyfat.setOnClickListener(this);
        ffmi.setOnClickListener(this);

    }
@Override
public void onClick(View view){
    switch (view.getId()){
        case R.id.calories:
            Intent intent1=new Intent(this,Calories.class);
            startActivity(intent1);
            break;
        case R.id.bmi:
            Intent intent2=new Intent(this,Bmi.class);
            startActivity(intent2);
            break;
        case R.id.bmr:
            Intent intent3=new Intent(this,Bmr.class);
            startActivity(intent3);
            break;
        case R.id.bodyfat:
            Intent intent4=new Intent(this,BodyFat.class);
            startActivity(intent4);
            break;
        case R.id.ffmi:
            Intent intent5=new Intent(this,Ffmi.class);
            startActivity(intent5);
            break;
        case R.id.item6:
            Intent intent6 = new Intent(this, Table.class);
            this.startActivity(intent6);
            break;


        default:
            break;
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
                Intent intent = new Intent(Fitness.this, Home.class);
                this.startActivity(intent);
                break;
            case R.id.item2:
                intent = new Intent(Fitness.this, Fitness.class);
                this.startActivity(intent);
                break;
            case R.id.item3:
                intent = new Intent(Fitness.this, Help.class);
                this.startActivity(intent);
                break;
            case R.id.item4:
                intent = new Intent(Fitness.this, Settings.class);
                this.startActivity(intent);
                break;
            case R.id.item5:
                intent = new Intent(Fitness.this, Contact.class);
                this.startActivity(intent);
                break;
            case R.id.item6:
                intent = new Intent(Fitness.this, Table.class);
                this.startActivity(intent);
                break;

            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}
