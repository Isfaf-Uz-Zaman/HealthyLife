package com.example.homehealthylifestyle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This class represents the BMI calculation.
 *  @author Isfaf Uz Zaman,CSE327 project documentation
 */

public class BmiCalculator extends AppCompatActivity {
    /**
     * This is a button for checking BMI.
     */

    private Button checkBmi;
    /**
     * This is a edit text which will take height and weight from user.
     */
    private EditText userWeight,userHeight;

    /**
     * This is a text view which will give result based on BMI.
     */
    public TextView yourBmiIs,tipsForUser;
    /**
     * This is a button for redirecting to lose weight diet plan.
     */
    public Button checkTheLoseWeightPlan;

    /**
     * This method is used for making connection between front end and back end.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_calculator);

        userWeight=(EditText)findViewById(R.id.editTextTextPersonWeight);
        userHeight=(EditText) findViewById(R.id.editTextTextPersonHeight);
        checkBmi=(Button) findViewById(R.id.checkBmiID);
        yourBmiIs = (TextView) findViewById(R.id.yourBmiID);
        tipsForUser = (TextView)findViewById(R.id.suggestUserChart);
        checkTheLoseWeightPlan =(Button) findViewById(R.id.checkDietChart);


        checkTheLoseWeightPlan.setOnClickListener(new View.OnClickListener() {
            /**
             * This is an onclick listener which will redirect user to lose wight diet plan page.
             */
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BmiCalculator.this,LoseWeightPlan.class);
                startActivity(intent);
            }
        });


        checkBmi.setOnClickListener(new View.OnClickListener() {
            /**
             * This button will generate the BMI
             */
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(userWeight.getText().toString()))
                {
                    Toast.makeText(BmiCalculator.this,"Please provide Weight",Toast.LENGTH_LONG).show();
                }else if(TextUtils.isEmpty(userHeight.getText().toString()))
                {
                    Toast.makeText(BmiCalculator.this,"Please provide Height",Toast.LENGTH_LONG).show();
                }else {
                    calculateUseBMI();
                }


            }
        });

    }
    /**
     * This method will do the calculation of BMi and set the text based on that.
     */

    private void calculateUseBMI() {

        String userProvidedWeight = userWeight.getText().toString().trim();
        String userProvidedHeight = userHeight.getText().toString().trim();

        float wightValue = Float.parseFloat(userProvidedWeight);
        float heightValue = Float.parseFloat(userProvidedHeight) / 100;


        float calculatedBMI = wightValue/(heightValue * heightValue);

        if(calculatedBMI<0)
        {
            yourBmiIs.setText("Your BMI is="+calculatedBMI);
            tipsForUser.setText("Invalid");

            Toast.makeText(BmiCalculator.this," with BMI="+calculatedBMI,Toast.LENGTH_LONG).show();
        }
        else if(calculatedBMI<16)
        {
            yourBmiIs.setText("Your BMI is="+calculatedBMI);
            tipsForUser.setText("You are too much Underweight");

            Toast.makeText(BmiCalculator.this," with BMI="+calculatedBMI,Toast.LENGTH_LONG).show();
        }
        else if(calculatedBMI<18.4)
        {
            yourBmiIs.setText("Your BMI is="+calculatedBMI);
            tipsForUser.setText("You are a bit Underweight");
            Toast.makeText(BmiCalculator.this,"You are Underweight with BMI="+calculatedBMI,Toast.LENGTH_LONG).show();
        }else if(calculatedBMI>=18.5 && calculatedBMI<= 24.9)
        {
            yourBmiIs.setText("Your BMI is="+calculatedBMI);
            tipsForUser.setText("You are in perfect shape");
            Toast.makeText(BmiCalculator.this,"You are in perfect weight with BMI="+calculatedBMI,Toast.LENGTH_LONG).show();
        }else if(calculatedBMI>=25.0 && calculatedBMI<= 40.0)
        {
            yourBmiIs.setText("Your BMI is="+calculatedBMI);
            tipsForUser.setText("You are overweight.Please check the diet plan to lose weight");
            Toast.makeText(BmiCalculator.this,"You are in over weight with BMI="+calculatedBMI,Toast.LENGTH_LONG).show();
        }else
        {
            yourBmiIs.setText("Your BMI is="+calculatedBMI);
            tipsForUser.setText("You are too much overweight.");
            Toast.makeText(BmiCalculator.this,"You are obese with BMI="+calculatedBMI,Toast.LENGTH_LONG).show();
        }




    }
}