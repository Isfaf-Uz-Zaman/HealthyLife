package com.example.homehealthylifestyle;

import android.widget.Toast;

public class BmiCalculatorClass {


    public float calculateUseBMI(float userProvidedHeight ,float userProvidedWeight){

        float wightValue =  userProvidedWeight;
        float heightValue = userProvidedHeight / 100;


        float calculatedBMI = wightValue/(heightValue * heightValue);

        if(calculatedBMI== Double.NaN)
        {

            return 0;
        }else if(calculatedBMI<0)
        {
            calculatedBMI =0;
            return calculatedBMI;
        }
        else if(calculatedBMI<16)
        {
            return calculatedBMI;
        }
        else if(calculatedBMI<18.4)
        {
            return calculatedBMI;
        }else if(calculatedBMI>=18.5 && calculatedBMI<= 24.9)
        {
            return calculatedBMI;
        }else if(calculatedBMI>=25.0 && calculatedBMI<= 40.0)
        {
            return calculatedBMI;
        }else
        {
            return calculatedBMI;
        }



    }
}
