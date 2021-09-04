package com.example.homehealthylifestyle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {
    ImageView pedoMeter, doctorDetails;

    private ImageView dietChartButton;
    private ImageView dietStoreButton;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    pedoMeter = (ImageView) findViewById(R.id.pedoMeterId);
    doctorDetails = (ImageView) findViewById(R.id.doctorDetails);
    pedoMeter.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this,PedoMeter.class);
            startActivity(intent);
        }
    });

    doctorDetails.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this,DoctorDetails.class);
            startActivity(intent);
        }
    });


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

                Intent intent = new Intent(MainActivity.this,BmiCalculator.class);
                startActivity(intent);

            }
        });
    }
}