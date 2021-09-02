package com.example.homehealthylifestyle;

import org.junit.Test;

import static java.lang.Float.NaN;
import static org.junit.Assert.*;

public class BmiCalculatorClassTest {

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

