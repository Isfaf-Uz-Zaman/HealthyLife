package com.example.homehealthylifestyle;


import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;


public class PedoMeter extends AppCompatActivity {

    TextView timerText;
    Button startStopButton;
    Timer timer;
    TimerTask timerTask;
    double time = 0.0;
    boolean timerStarted = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedo_meter);
    timerText = (TextView) findViewById(R.id.timerTextId);
    startStopButton = (Button) findViewById(R.id.startStopButton);
    timer = new Timer();

    }


    public void resetTapped(View view) {
        AlertDialog.Builder resetAlert = new AlertDialog.Builder(this);
        resetAlert.setTitle("Reset Timer");
        resetAlert.setMessage("Are you sure you want to reset the Steps?");
        resetAlert.setPositiveButton("Reset", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if(timerTask != null)
                {
                    timerTask.cancel();
                    time = 0.0;
                    timerStarted = false;
                    timerText.setText(formatTime(0,0,0));

                }

            }
        });
        resetAlert.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //do nothing
            }
        });
        resetAlert.show();
    }

    public void startStopTapped(View view) {
        if (timerStarted==false){
            timerStarted=true;
            startStopButton.setText("Stop");
            
            startTimer();
        }
        else
        {
            timerStarted=false;
            startStopButton.setText("Start");
            timerTask.cancel();
        }
    }

    private void startTimer()
    {
        timerTask = new TimerTask() {
            @Override
            public void run()
            {
                runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        time++;
                        timerText.setText(getTimerText());
                    }
                });
            }
        };

        timer.scheduleAtFixedRate(timerTask, 0 ,1000);
    }
    private String getTimerText() {
        int rounded = (int) Math.round(time);
        int seconds = ((rounded % 86400) % 3600) % 60;
        int minutes = ((rounded % 86400) % 3600) / 60;
        int hours = ((rounded % 86400) / 3600);

        return formatTime(seconds,minutes,hours);
    }

    private String formatTime(int seconds, int minutes, int hours) {
        return String.format("%d",seconds);
    }

}