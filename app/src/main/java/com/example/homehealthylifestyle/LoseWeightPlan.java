package com.example.homehealthylifestyle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoseWeightPlan extends AppCompatActivity {
    private Button dayOne;
    private Button eight;
    private Button dayFifteen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose_weight_plan);

        dayOne = (Button) findViewById(R.id.day1);
        eight = (Button) findViewById(R.id.day8);
        dayFifteen = (Button) findViewById(R.id.day15);

        dayOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoseWeightPlan.this,Day1ToDay7.class);
                startActivity(intent);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoseWeightPlan.this,Day8ToDay14.class);
                startActivity(intent);
            }
        });
        dayFifteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoseWeightPlan.this,Day15.class);
                startActivity(intent);
            }
        });
    }

}