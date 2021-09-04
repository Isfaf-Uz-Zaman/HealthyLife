package com.example.homehealthylifestyle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
/**
 * This class represents the order confirmation.
 *  @author Isfaf Uz Zaman,CSE327 project documentation
 */

public class ThankYouForOrdering extends AppCompatActivity {
    /**
     * This is a button for exiting the store after completing order.
     */
    private  Button goHome;

    /**
     * This method is used for making connection between front end and back end.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thank_you_for_ordering);

        goHome =(Button) findViewById(R.id.homeFromStoreID);

        goHome.setOnClickListener(new View.OnClickListener() {
            /**
             * This method is responsible for transaction between two pages.
             * @param v this is the View(Built in) class object
             */
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThankYouForOrdering.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}