
 
/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
 
/**
 * @author Arthur Kroth  Student Number: x22166971
 * Group 1 - CA1 - Object Oriented Programming
 */
public class Nutrition {
    
    private int caloriesIntake;
    private int carbsIntake;
    private int proteinIntake;
    private int burnedCalories;
    
    //Calling the User singleton class in case any information from the user is necessary.
    User user = User.getInstance();   
    int userHeigth = user.getUserHeigth();
    double userWeight = user.getUserWeight();
 
    // Add constructor to initialize Nutrition with input values
    public Nutrition(int caloriesIntake, int carbsIntake, int proteinIntake, int burnedCalories) {
        this.caloriesIntake = caloriesIntake;
        this.carbsIntake = carbsIntake;
        this.proteinIntake = proteinIntake;
        this.burnedCalories = burnedCalories;
    }
 
    // Getter methods for retrieving calculated values
    public int getCaloriesIntake() {
        return caloriesIntake;
    }
 
    public int getCarbsIntake() {
        return carbsIntake;
    }
 
    public int getProteinIntake() {
        return proteinIntake;
    }
 
    public int getBurnedCalories() {
        return burnedCalories;
    }
 
    @Override
    //Overriding toSting message to display the default information about the class
    public String toString() {
        String message = "Calories Intake: " + caloriesIntake + "\n"
                + "Carbs Intake: " + carbsIntake + "\n"
                + "Protein Intake: " + proteinIntake + "\n"
                + "Burned Calories: " + burnedCalories;
        return message;
    }
    
    //Method to calculate the user's BMI
    public double calculateBMI() {
    // BMI Formula: weight (kg) / height (m)^2
        double bmi = 0.00;
        double heightInMeters = userHeigth / 100.0; //userHeight is in centimeters
        bmi = userWeight / (heightInMeters * heightInMeters);
        String formattedBMI = String.format("%.2f", bmi); //Parsing to String to be able to uset the format() method.
        return Double.parseDouble(formattedBMI);//Parsinbg back to double.
    }
    
    //Method to calculate the if the protein intake is enough or not.
    public String evaluateProteinIntake() {
        // Protein intake recommendation: depends on various factors, 
        // but let's assume 2.0 grams per kg of body weight.
        double proteinPerKg = 2.0; //Hardcoded Protein per KG.
        double totalProteinIntake = proteinIntake;

        double recommendedProteinIntakeLower = userWeight * 0.8 * proteinPerKg;
        double recommendedProteinIntakeUpper = userWeight * 1.2 * proteinPerKg;

        if (totalProteinIntake < recommendedProteinIntakeLower) {
            return "You are ingesting less protein than recommended.";
        } else if (totalProteinIntake >= recommendedProteinIntakeLower && 
                   totalProteinIntake <= recommendedProteinIntakeUpper) {
            return "Your protein intake is within the recommended range.";
        } else {
            return "You are ingesting more protein than recommended.";
        }
    }
    
    //Method to calculate the if the carbs intake is enough or not.
    public String evaluateCarbsIntake() {
        double totalCarbsIntake = carbsIntake;

        double recommendedCarbsIntake = 250.0; //Hardcodidng a value for recommended carbs intake

        if (totalCarbsIntake < recommendedCarbsIntake) {
            return "You are ingesting fewer carbs than recommended.";
        } else if (totalCarbsIntake == recommendedCarbsIntake) {
            return "Your carbs intake is within the recommended range.";
        } else {
            return "You are ingesting more carbs than recommended.";
        }
    }

    //Method to calculate the weight change trend.
    public String evaluateWeightChangeTrend(String userFitnessLevel) {
        double bmi = calculateBMI();

        if (bmi < 18.5) {
            return "You are underweight. Consider consulting with a healthcare professional.";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            if (userFitnessLevel.equals("Begginer") && bmi >= 22.0) {
                return "Your weight is within the normal range but considering your low fitness level, consult with a fitness expert for guidance.";
            } else {
                return "Your weight is within the normal range.";
            }
        } else if (bmi >= 25.0 && bmi < 29.9) {
            if (userFitnessLevel.equals("Expert") && bmi <= 27.0) {
                return "You are slightly overweight but given your high fitness level, focus on maintaining your fitness routine.";
            } else {
                return "You are overweight. Consider adjusting your diet and exercise routine.";
            }
        } else {
            return "You are obese. It's important to manage your weight for better health.";
        }
    }
    
    //Method to estimate the weight change based on user's details.
    public String estimateWeightChange() {
        //Calculating the net calorie balance
        int netCalories = caloriesIntake - burnedCalories;

        //Calculating the calorie deficit/surplus for weight change
        //1 kilogram = 7700 calories (approx.)
        double caloriesPerKilogram = 7700.0;

        //Assuming 1 week for weight change estimation
        int weeks = 1;

        double weightChangePerWeek = netCalories / (caloriesPerKilogram * weeks);

        //Getting the absolute value of weightChangePerWeek before formatting
        double absoluteWeightChange = Math.abs(weightChangePerWeek);

        //Formatting weight change to display only two decimal places
        String formattedWeightChange = String.format("%.2f", absoluteWeightChange);

        if (weightChangePerWeek < 0) {
            return "Based on your intake and activity, you may lose approximately " + formattedWeightChange + " kilograms per week.";
        } else if (weightChangePerWeek > 0) {
            return "Based on your intake and activity, you may gain approximately " + formattedWeightChange + " kilograms per week.";
        } else {
            return "Based on your intake and activity, your weight might remain stable.";
        }
    }
}
