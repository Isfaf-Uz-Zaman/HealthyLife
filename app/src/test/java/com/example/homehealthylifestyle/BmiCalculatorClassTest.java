package com.example.homehealthylifestyle;

import org.junit.Test;

import static java.lang.Float.NaN;
import static org.junit.Assert.*;
/**
 * This class is used for unit testing
 */
public class BmiCalculatorClassTest {
    /**
     * This is test case 1 for valid inputs
     */

    @Test
    public void TestCase1() {
        float inputWeight= 82,inputHeight =182;
        float output;
        float expected = (float) 24.73;
        double delta = .1;
        BmiCalculatorClass bmiCalculatorClass = new BmiCalculatorClass();
        output = bmiCalculatorClass.calculateUseBMI(inputHeight,inputWeight);

        assertEquals(expected,output,delta);

    }
    /**
     * This is test case 2 for invalid inputs in weight which is less than 1
     */

    @Test
    public void TestCase2() {
        float inputWeight= 0,inputHeight =182;
        float output;
        float expected = (float) 0;
        double delta = .1;
        BmiCalculatorClass bmiCalculatorClass = new BmiCalculatorClass();
        output = bmiCalculatorClass.calculateUseBMI(inputHeight,inputWeight);

        assertEquals(expected,output,delta);

    }

    /**
     * This is test case 3 for invalid inputs in height which is less than 1
     */

    @Test
    public void TestCase3() {
        float inputWeight= 82,inputHeight =0;
        float output;
        float expected = (float) 1/0;
        double delta = .1;
        BmiCalculatorClass bmiCalculatorClass = new BmiCalculatorClass();
        output = bmiCalculatorClass.calculateUseBMI(inputHeight,inputWeight);

        assertEquals(expected,output,delta);

    }
    /**
     * This is test case 4 for invalid inputs in height and weight which is less than 1
     */

    @Test
    public void TestCase4() {
        
        float inputWeight= 0,inputHeight =0;
        float output;
        float expected = NaN;
        double delta = .1;
        BmiCalculatorClass bmiCalculatorClass = new BmiCalculatorClass();
        output = bmiCalculatorClass.calculateUseBMI(inputHeight,inputWeight);

        assertEquals(expected,output,delta);

    }

}

