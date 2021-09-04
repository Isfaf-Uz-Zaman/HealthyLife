package com.example.homehealthylifestyle;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * This is the PedoMeter class where the code emerges.
 * @author Md.Tansin Ullah Nabil, CSE327 Project Documentation.
 */


    public class PedoMeterClass extends AppCompatActivity implements SensorEventListener {

    /**
     * This is the initialization of sensorManager variable to null;
     */
    private SensorManager sensorManager = null;

    /**
     * Here TextView taken as stepcount.
     * and making count = 0
     */
    private TextView stepCount;
    /**
     * Count initialized to zero
     */
        public int count = 0;
    /**
     * Sensor Class object taken as sensor.
     */
    Sensor sensor;
    /**
     * Taking boolean variable running = false <br/>
     * Because it will stop during the app opening
     */
    boolean running = false;

    /**
     * This is where the code has to find the xml layout by finding the id.
     * @param savedInstanceState Bundle class object.
     */
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_pedo_meter);

            //stepCount = (TextView) findViewById(R.id.stepCountId);
            sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        }

    /**
     * onResume method is for checking the sensor's availability in the device <br/>
     * when its called the running variable will be true. <br/>
     * And if the sensor is available then it will register a listener. <br/>
     * And if the sensor is not available it will show a Toast to a user. <br/>
     * That Sensor is not Found!
     */
    @Override
    protected void onResume() {
            super.onResume();
            running = true;
        Sensor countSensor = sensorManager.getDefaultSensor(sensor.TYPE_ACCELEROMETER);
            if(countSensor != null){
                sensorManager.registerListener(this, countSensor, SensorManager.SENSOR_DELAY_UI);
            } else{
                Toast.makeText(this, "Sensor Not Found!",Toast.LENGTH_SHORT).show();
            }
        }

    /**
     * This is onPause method its called when a user go back from this feature <br/>
     * it will make the running false because going back will stop counting the steps.
     */
    @Override
        protected void onPause() {
            super.onPause();
            running=false;
        }

    /**
     * This method is called when e user starts to walk or run
     * @param sensorEvent this parameter gets the even of the sensor
     * When sensorEvent detects walking then it will increment the count and updating the steps.
     */
    @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            //stepCount = (TextView) findViewById(R.id.stepCountId);
            if(running){
                count++;
                stepCount.setText(""+sensorEvent.values[0]);

                Toast.makeText(this, "On Sensor Changed",Toast.LENGTH_SHORT).show();
            }
            //stepCount.setText(""+count);
        }

    /**
     * This method doesn't need to run this feature
     * @param sensor Sensor class object
     * @param i An integer variable
     */
    @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    }
