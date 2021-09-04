package com.example.homehealthylifestyle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * This class Represent the home page of the project app.
 * @author Isfaf Uz Zaman, Md. Tansin Ullah Nabil
 */

public class MainActivity extends AppCompatActivity {

    /**
     * These are the Imageview from the home activity it will use as button.
     */
    ImageView pedoMeter, doctorDetails, dietChartButton, dietStoreButton;

    /**
     * This is where the code will find the xml layout by finding the id.
     * @param savedInstanceState Bundle class Object which helps to save the state.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    pedoMeter = (ImageView) findViewById(R.id.pedoMeterId);
    doctorDetails = (ImageView) findViewById(R.id.doctorDetails);
    pedoMeter.setOnClickListener(new View.OnClickListener() {
        /**
         * This method is responsible for going homepage to pedometer feature.
         * @param view this is the View(Built in) class object
         */
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this,PedoMeter.class);
            startActivity(intent);
        }
    });

    doctorDetails.setOnClickListener(new View.OnClickListener() {
        /**
         * This method is responsible for going homepage to Doctor Details feature.
         * @param view this is the View(Built in) class object
         */
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this,DoctorDetails.class);
            startActivity(intent);
        }
    });


        dietChartButton = (ImageView) findViewById(R.id.dietChartButtonID);
        dietStoreButton = (ImageView) findViewById(R.id.dietStoreButtonID);

        dietStoreButton.setOnClickListener(new View.OnClickListener() {
            /**
             * This method is responsible for going homepage to Diet Store feature.
             * @param v this is the View(Built in) class object
             */
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DietStore.class);
                startActivity(intent);
            }
        });


        dietChartButton.setOnClickListener(new View.OnClickListener() {
            /**
             * This method is responsible for going homepage to Diet Chart feature.
             * @param v this is the View(Built in) class object
             */
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,BmiCalculator.class);
                startActivity(intent);

            }
        });
    }
}