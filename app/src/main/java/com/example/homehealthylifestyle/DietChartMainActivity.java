package com.example.homehealthylifestyle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DietChartMainActivity extends AppCompatActivity {

    private Button loseWeight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_chart_main);

        loseWeight = (Button) findViewById(R.id.button_lose_weight);

        loseWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DietChartMainActivity.this, LoseWeightPlan.class);
                startActivity(intent);
            }
        });
    }
}