package com.example.homehealthylifestyle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView dietChartButton;
    private ImageView dietStoreButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dietChartButton = (ImageView) findViewById(R.id.dietChartButtonID);
        dietStoreButton = (ImageView) findViewById(R.id.dietStoreButtonID);

        dietStoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DietStore.class);
                startActivity(intent);
            }
        });


        dietChartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,DietChartMainActivity.class);
                startActivity(intent);

            }
        });
    }
}