package com.example.homehealthylifestyle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * This class represents the buttons for diet chart filtering the days.
 *  @author Isfaf Uz Zaman,CSE327 project documentation
 */

public class LoseWeightPlan extends AppCompatActivity {
    /**
     * These buttons are used to select the desired days of diet chart user wants
     */

    private Button dayOne,eight,dayFifteen;

    /**
     * This method is used for making connection between front end and back end.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose_weight_plan);

        dayOne = (Button) findViewById(R.id.day1);
        eight = (Button) findViewById(R.id.day8);
        dayFifteen = (Button) findViewById(R.id.day15);

        dayOne.setOnClickListener(new View.OnClickListener() {
            /**
             * This method is responsible for transaction between two pages.
             * @param v this is the View(Built in) class object
             */
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoseWeightPlan.this,Day1ToDay7.class);
                startActivity(intent);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            /**
             * This method is responsible for transaction between two pages.
             * @param v this is the View(Built in) class object
             */
            public void onClick(View v) {
                Intent intent = new Intent(LoseWeightPlan.this,Day8ToDay14.class);
                startActivity(intent);
            }
        });
        dayFifteen.setOnClickListener(new View.OnClickListener() {
            @Override
            /**
             * This method is responsible for transaction between two pages.
             * @param v this is the View(Built in) class object
             */
            public void onClick(View v) {
                Intent intent = new Intent(LoseWeightPlan.this,Day15.class);
                startActivity(intent);
            }
        });
    }

}