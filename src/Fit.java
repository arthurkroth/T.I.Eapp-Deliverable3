/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * @author Arthur Kroth  Student Number: x22166971
 * Group 1 - CA1 - Object Oriented Programming
 */
public abstract class Fit {
    
    private double hoursExercised;
    private double hoursOutside;
    private int stepsTaken;
    private String fitGoal;

    
    //Calling the User singleton class in case any information from the user is necessary.
    User user = User.getInstance();
         
    String userName = user.getUserName();
    int userAge = user.getUserAge();
    int userHeigth = user.getUserHeigth();
    double userWeight = user.getUserWeight();
    String userAddress = user.getUserAddress();
    String userFitnessLevel = user.getUserFitnessLevel();
    int userMotivationLevel = user.getMotivationLevel();
   
    
    
    //Constructor to initialize Nutrition with input values
    public Fit(double hoursExercised, double hoursOutside, int stepsTaken, String fitGoal) {
        this.hoursExercised = hoursExercised;
        this.hoursOutside = hoursOutside;
        this.stepsTaken = stepsTaken;
        this.fitGoal = fitGoal;
    }
    
    //Getter methods for retrieving calculated values
    public double getHoursExercised() {
        return hoursExercised;
    }
 
    public double getHoursOutside() {
        return hoursOutside;
    }
 
    public int getStepsTaken() {
        return stepsTaken;
    }
 
    public String getFitGoal() {
        return fitGoal;
    }
    
    @Override
    //Overriding toSting message to display the default information about the class
    public String toString() {
        String message = "Hours Exercised: " + hoursExercised + "\n"
                + "Hours Spent Outside: " + hoursOutside + "\n"
                + "Steps Taken: " + stepsTaken + "\n"
                + "Fitness Goal: " + fitGoal;
        return message;
    }
    
    //Public method to get the total hours exercised
    public double totalHoursExercised(){
        return hoursExercised + hoursOutside;
    }
    
    //Public method to get the total information, method is overridden on subclasses.
    public String getTotalInformation(){
        return "Total information";
    }
    
    //Public method to get if the user reached the total steps goal, minimumSteps is hardcoded to 10k steps.
    public String getEnoughSteps(){
        final int minimumSteps = 10000;
        if (minimumSteps > stepsTaken) {
            return "You have " + stepsTaken + " out of " + minimumSteps + " recommended steps, just more " + Math.abs(stepsTaken - minimumSteps) + " left!";
        } else {
            return "Amazing, keep up the good work! Doctors recommend at least 10k steps per day!";
        }
    }
    
    //Setting up public method to override on my subclasses
    public String suggestExercises() {
        return "";
    }
    
    
}
