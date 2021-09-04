package com.example.homehealthylifestyle;

/**
 * This Class is for Unit testing to set goal in pedometer.
 * @author Md.Tansin Ullah Nabil, CSE327 Project Documentation <br/>
 */
public class SetGoal {
    /**
     * This method is called when a user taps on set goal
     * @param goal this is the input of the users total steps.
     * @return it returns the value of the total steps if that is valid
     * it will check the condition, if the goal is less than zero it will return -1 <br/>
     * And the feature will not set the goal <br/>
     * Otherwise it will return the goal if the condition meets.
     */
    public float SetGoalToPedoMeter(float goal){

        if (goal<=0){
         return goal = -1;
        }
        else {
            return goal;
        }
    }

}
