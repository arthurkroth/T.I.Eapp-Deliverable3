
import java.util.ArrayList;
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * @author Arthur Kroth  Student Number: x22166971
 * Group 1 - CA1 - Object Oriented Programming
 */
public class FitMuscleGain extends Fit{
    
    private double hoursExercised;
    private double hoursOutside;
    private int stepsTaken;
    private String fitGoal;
    
    //Constructor to gather information from the superclass.
    public FitMuscleGain(double hoursExercised, double hoursOutside, int stepsTaken, String fitGoal) {
        super(hoursExercised, hoursOutside, stepsTaken, fitGoal);
        this.hoursExercised = hoursExercised;
        this.hoursOutside = hoursOutside;
        this.stepsTaken = stepsTaken;
        this.fitGoal = fitGoal;
    }
    
    
    @Override
    public String toString() {
        // Perform your nutrition calculations here using the stored input values
        // For demonstration purposes, let's say we are just printing a message
        String message = "Hours Exercised: " + hoursExercised + "\n"
                + "Hours Spent Outside: " + hoursOutside + "\n"
                + "Steps Taken: " + stepsTaken + "\n"
                + "Fitness Goal: " + fitGoal + "\n"
                + "Muscle Gain";
        return message;
    }
    
    
    @Override
    public double totalHoursExercised(){
        return hoursExercised + hoursOutside;
    }
    
    //Overridden method to get the total information, logic conditions applied to decide if the user is over exercising.    
    @Override
    public String getTotalInformation() {
        if (totalHoursExercised() < 3 && fitGoal.equals("Muscle Gain")) {
            return "Focus on heavy resistance training and consume a surplus of calories to build muscle effectively!";
        } else if (totalHoursExercised() >= 3 && totalHoursExercised() <= 6 && fitGoal.equals("Muscle Gain")) {
            return "Ensure a mix of compound and isolation exercises along with adequate protein intake for muscle growth!";
        } else if (totalHoursExercised() > 6 && fitGoal.equals("Muscle Gain")) {
            return "Limit the duration of workouts, prioritize recovery, and maintain a balanced diet for muscle growth!";
        } else {
            return "Consistency is key. Make sure to progressively overload and focus on a proper diet for muscle gain!";
        }
    }
    
    
    //Method to suggest specific muscle groups to focus on
    //ArrayList
    @Override
    public String suggestExercises() {
        ArrayList<String> muscleGroups = new ArrayList<>();
        muscleGroups.add("Focus on targeting your back and biceps during your workouts.");
        muscleGroups.add("Incorporate exercises that emphasize your chest and triceps.");
        muscleGroups.add("Try compound movements like squats and deadlifts to target multiple muscle groups.");
        muscleGroups.add("Include shoulder and leg workouts for a balanced strength training routine.");
        muscleGroups.add("Engage core muscles with planks, crunches, and leg raises.");

        Random random = new Random();
        int randomIndex = random.nextInt(muscleGroups.size());
        
        return muscleGroups.get(randomIndex);
    }
    
    //Overridden method to get if the user reached the total steps goal, minimumSteps is hardcoded to 10k steps.
    @Override
    public String getEnoughSteps(){
        int minimumSteps = 10000;
        if (minimumSteps > stepsTaken) {
            return "You have " + stepsTaken + " out of " + minimumSteps + " recommended steps, just more " + Math.abs(stepsTaken - minimumSteps) + " left!";
        } else {
            return "Amazing, keep up the good work! Doctors recommend at least 10k steps per day!";
        }
    }
    

}
