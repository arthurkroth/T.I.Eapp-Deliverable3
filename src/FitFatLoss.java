
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
public class FitFatLoss extends Fit{
    
    private double hoursExercised;
    private double hoursOutside;
    private int stepsTaken;
    private String fitGoal;
    
    public FitFatLoss(double hoursExercised, double hoursOutside, int stepsTaken, String fitGoal) {
        super(hoursExercised, hoursOutside, stepsTaken, fitGoal);
        this.hoursExercised = hoursExercised;
        this.hoursOutside = hoursOutside;
        this.stepsTaken = stepsTaken;
        this.fitGoal = fitGoal;
    }
    
    //Overriding toSting message to display the default information about the class + "Fit Fat Loss".
    @Override
    public String toString() {
        String message = "Hours Exercised: " + hoursExercised + "\n"
                + "Hours Spent Outside: " + hoursOutside + "\n"
                + "Steps Taken: " + stepsTaken + "\n"
                + "Fitness Goal: " + fitGoal + "\n"
                + "Fit Fat Loss";
        return message;
    }
    
    //Overridden Public method to get the total hours exercised
    @Override
    public double totalHoursExercised(){
        return hoursExercised + hoursOutside;
    }
    
    //Overridden method to get the total information, logic conditions applied to decide if the user is over exercising.  
    @Override
    public String getTotalInformation() {
        if (totalHoursExercised() < 4 && fitGoal.equals("Fat Loss")) {
            return "Include HIIT workouts and monitor calorie intake for effective fat burning!";
        } else if (totalHoursExercised() >= 4 && totalHoursExercised() <= 7 && fitGoal.equals("Fat Loss")) {
            return "Incorporate a mix of cardio and strength training for steady fat loss!";
        } else if (totalHoursExercised() > 7 && fitGoal.equals("Fat Loss")) {
            return "Prioritize active recovery days and maintain a calorie deficit for consistent fat loss!";
        } else {
            return "Consistency in workouts and a balanced diet are crucial for sustainable fat loss!";
        }
    }
    
    // Method to suggest effective fat-burning exercises
    @Override
    public String suggestExercises() {
        ArrayList<String> fatBurningExercises = new ArrayList<>();
        fatBurningExercises.add("Try high-intensity interval training (HIIT) for effective fat burning.");
        fatBurningExercises.add("Consider adding plyometric exercises to your routine for fat loss.");
        fatBurningExercises.add("Incorporate jumping rope as a cardio exercise for burning calories.");
        fatBurningExercises.add("Combine strength training with cardio for optimal fat burning results.");
        fatBurningExercises.add("Include rowing or boxing workouts for a full-body fat-burning workout.");

        Random random = new Random();
        int randomIndex = random.nextInt(fatBurningExercises.size());
        
        return fatBurningExercises.get(randomIndex);
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
