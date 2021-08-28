package com.example.homehealthylifestyle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BmiCalculator extends AppCompatActivity {

    private Button checkBmi;
    private EditText userWeight;
    private EditText userHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_calculator);

        userWeight=findViewById(R.id.editTextTextPersonWeight);
        userHeight=findViewById(R.id.editTextTextPersonHeight);
        checkBmi=findViewById(R.id.checkBmiID);

        checkBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateUseBMI();
            }
        });

    }

    private void calculateUseBMI() {


        String userProvidedWeight = userWeight.getText().toString().trim();
        String userProvidedHeight = userHeight.getText().toString().trim();

        float wightValue = Float.parseFloat(userProvidedWeight);
        float heightValue = Float.parseFloat(userProvidedHeight) / 100;

        float calculatedBMI = wightValue/(heightValue * heightValue);

        Toast.makeText(BmiCalculator.this,""+calculatedBMI,Toast.LENGTH_LONG).show();


    }
}