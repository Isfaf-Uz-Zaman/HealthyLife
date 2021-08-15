package com.example.homehealthylifestyle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class PedoMeter extends AppCompatActivity implements SensorEventListener {
    SensorManager sensorManager;
    TextView stepCount;
    boolean running = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedo_meter);

        stepCount = (TextView) findViewById(R.id.stepCountId);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        running = true;
        Sensor countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if(countSensor != null){
            sensorManager.registerListener(this, countSensor, SensorManager.SENSOR_DELAY_UI);
        } else{
            Toast.makeText(this, "Sensor Not Found!",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        running=false;
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
    if(running){
        stepCount.setText(String.valueOf(sensorEvent.values[0]));

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}