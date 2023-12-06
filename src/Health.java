
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * @author Arthur Kroth  Student Number: x22166971
 * Group 1 - CA1 - Object Oriented Programming
 */
public class Health {
    
    private double alcoholConsumed;
    private double waterConsumed;
    private double hoursOfSleep;
    private boolean isSmoker;
    
    //Declaring an instace variable to hold a reference to an object of type HealthList
    private HealthList healthList;
    
    //Calling the User singleton class in case any information from the user is necessary.
    User user = User.getInstance();
    double userWeight = user.getUserWeight();
    
    
    //Add constructor to initialize Nutrition with input values
    public Health(double alcoholConsumed, double waterConsumed, double hoursOfSleep, boolean isSmoker) {
        this.alcoholConsumed = alcoholConsumed;
        this.waterConsumed = waterConsumed;
        this.hoursOfSleep = hoursOfSleep;
        this.isSmoker = isSmoker;
        
        // Instantiate the HealthList
        this.healthList = new HealthList();
        
    }
    
    // Getter methods for retrieving calculated values
    public double getAlcoholConsumed() {
        return alcoholConsumed;
    }
 
    public double getWaterConsumed() {
        return waterConsumed;
    }
 
    public double getHoursOfSleep() {
        return hoursOfSleep;
    }
 
    public boolean getIsSmoker() {
        return isSmoker;
    }
 
    
    @Override
    //Overriding toSting message to display the default information about the class
    public String toString() {
        String message = "Alcohol Consumed: " + alcoholConsumed + "\n"
                + "Water Consumed: " + waterConsumed + "\n"
                + "Hours Of Sleep: " + hoursOfSleep + "\n"
                + "Smoker? " + isSmoker;
        return message;
    }
    
    //Method to provide the random tip from the arraylist(HealthList) if the user selects that is smoker.
    public String getRandomSmokerTip() {
        if (isSmoker) {
            return healthList.getRandomSmokerTip();
        }
        return "I'm really glad to know that you're not a smoker! Well done!";
    }
    
    //Method to calculate the minimum recomended ingestion of water based on user's body weight
    public double calculateRecommendedWaterIntake() {
        //Typical recommendation: 30-35 milliliters per kilogram of body weight
        double waterIntakePerKg = 30; // Default value in milliliters

        //Calculate recommended water intake based on user's weight
        double recommendedWaterIntake = waterIntakePerKg * userWeight;
        return recommendedWaterIntake/1000;
    }
    
    //Method to get the result of the recommended water intake method and append it to a String to show it back to the user.
    public String recommendedWaterIntake(){
        
        if (waterConsumed < calculateRecommendedWaterIntake()) {
            return "Based on your weight, you should consume at least " + calculateRecommendedWaterIntake() + "L, " + waterConsumed + "L is not enough for good health!";
        } else {
            return "Well done, the minumum recomended for your weight is " + calculateRecommendedWaterIntake() + "L";
        }
    }
    
    //Method to check if the user is getting enough sleep time.
    public String generateSleepMessage(double hoursOfSleep) {
        final double recommendedSleepHours = 7.0; //Hard coded recommended hours of sleep

        if (hoursOfSleep >= recommendedSleepHours) {
            return "You're getting enough sleep. Keep it up!";
        } else {
            return "Consider getting more sleep for better health.";
        }
    }
    
    //Method to vertify if the user is consuming more alcohol than 0.5l per day, it only gives advice if the user is consuming more than 0.5l
    public String generateAlcoholMessage(){
        if (alcoholConsumed > 0.5) {
            return "Life is tough, but drinking alcohol everyday will not help, mind yourself";
        } else {
            return "";
        }
    }
}
