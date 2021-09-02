package com.example.homehealthylifestyle;

import org.junit.Test;

import static org.junit.Assert.*;

public class SetGoalTest {

    @Test
    public void TestCase1() {
        float input = 1000;
        float output;
        float expected = 1000;
        double delta = .1;

        SetGoal setGoal = new SetGoal();
        output = setGoal.SetGoalToPedoMeter(input);
        assertEquals(expected,output,delta);

    }

    @Test
    public void TestCase2() {
        float input = 0;
        float output;
        float expected = -1;
        double delta = .1;

        SetGoal setGoal = new SetGoal();
        output = setGoal.SetGoalToPedoMeter(input);
        assertEquals(expected,output,delta);

    }

    @Test
    public void TestCase3() {
        float input = -1;
        float output;
        float expected = -1;
        double delta = .1;

        SetGoal setGoal = new SetGoal();
        output = setGoal.SetGoalToPedoMeter(input);
        assertEquals(expected,output,delta);

    }
}