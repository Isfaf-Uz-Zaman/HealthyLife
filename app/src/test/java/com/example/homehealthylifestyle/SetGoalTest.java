package com.example.homehealthylifestyle;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit Testing class
 * @author Md.Tansin Ullah Nabil, CSE327 Project Documentaion.
 */
public class SetGoalTest {
    /**
     * Test Case 1 when user gives a valid input.
     */
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

    /**
     * Test Case 2 when the user give zero as input.
     */
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

    /**
     * Test Case 3 When user gives invalid input (less than zero).
     */
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