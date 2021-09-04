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

/**
 * This class represents the coding for Start and stop time <br/> according to Step counting.
 * @author Md.Tansin Ullah Nabil, CSE327 Project Documentation.
 */

public class PedoMeter extends AppCompatActivity {

    /**
     * TextView for counting the timer which uses timerText variable
     */
    TextView timerText;
    /**
     * A button for Start and Stop
     */
    Button startStopButton;
    /**
     * timer variable for counting time.
     */
    Timer timer;
    /**
     * Completing timer task the timerTask variable will help.
     */
    TimerTask timerTask;
    /**
     * time variable is initialized to zero as the time will start from zero.
     */
    double time = 0.0;
    /**
     * A boolean variable to make the time stop from the initialization state
     */
    boolean timerStarted = false;

    /**
     * This is where the code will find the xml layout by finding the id.
     * @param savedInstanceState Bundle class Object which helps to save the state.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedo_meter);
    timerText = (TextView) findViewById(R.id.timerTextId);
    startStopButton = (Button) findViewById(R.id.startStopButton);
    timer = new Timer();

    }


    /**
     * This method is for Reset buttons Alert Dialog
     * @param view this object will show the alert dialog box
     */
    public void resetTapped(View view) {
        AlertDialog.Builder resetAlert = new AlertDialog.Builder(this);
        resetAlert.setTitle("Reset Timer");
        resetAlert.setMessage("Are you sure you want to reset the Steps?");
        resetAlert.setPositiveButton("Reset", new DialogInterface.OnClickListener() {
            /**
             * This method of alert dialog will call after tapping the reset button <br/>
             * And show the cancel button. <br/>
             * and timer sets to minimal which is zero.
             * @param dialogInterface this object uses for Showing the dialogue
             * @param i An integer variable.
             */
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

    /**
     * <p>This method is for Start button</p> <br/>
     * After tapping the start button it will set the text to stop <br/>
     * so that it can be pressed as stop button
     * @param view View class object
     */
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

    /**
     * <p>This method is Timer starting thread.</p> <br/>
     * It will increment the time to the textView of xml layout.
     */
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

    /**
     * This method is for the mathematical term of the time
     * @return it returns the time format.
     */
    private String getTimerText() {
        int rounded = (int) Math.round(time);
        int seconds = ((rounded % 86400) % 3600) % 60;
        int minutes = ((rounded % 86400) % 3600) / 60;
        int hours = ((rounded % 86400) / 3600);

        return formatTime(seconds,minutes,hours);
    }

    /**
     * This formatTime method catches the return from getTimerText method.
     * @param seconds For getting the seconds as input.
     * @param minutes For getting the minutes as input.
     * @param hours For getting the hours as input.
     * @return this returns the seconds.
     */

    private String formatTime(int seconds, int minutes, int hours) {
        return String.format("%d",seconds);
    }

}