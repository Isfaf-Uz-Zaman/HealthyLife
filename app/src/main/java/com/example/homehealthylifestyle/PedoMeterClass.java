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



    public class PedoMeterClass extends AppCompatActivity implements SensorEventListener {
        private SensorManager sensorManager = null;
        private TextView stepCount;
        public int count = 0;
        Sensor sensor;
        boolean running = false;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_pedo_meter);

            //stepCount = (TextView) findViewById(R.id.stepCountId);
            sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        }

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

        @Override
        protected void onPause() {
            super.onPause();
            running=false;
        }

        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            //stepCount = (TextView) findViewById(R.id.stepCountId);
            if(running){
                //count++;
                stepCount.setText(""+sensorEvent.values[0]);

                Toast.makeText(this, "On Sensor Changed",Toast.LENGTH_SHORT).show();
            }
            //stepCount.setText(""+count);
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    }
