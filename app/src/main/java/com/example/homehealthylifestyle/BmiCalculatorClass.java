package com.example.homehealthylifestyle;

import android.widget.Toast;
/**
 * This class represents the BMI calculation cases.
 *  @author Isfaf Uz Zaman,CSE327 project documentation
 */
public class BmiCalculatorClass {
    /**
     * This method will take height and weight and calculate Bmi.
     * @param userProvidedHeight this is the user provided height.
     * @param userProvidedWeight this is the user provided weight.
     * @return returns the calculated BMI.
     */


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
