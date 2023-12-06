/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * @author Arthur Kroth  Student Number: x22166971
 * Group 1 - CA1 - Object Oriented Programming
 */
public class User extends UserGUI{
    
    //Singleton instance of the User class
    private static User instance;
    
    //User attributes
    private String userName;
    private int userAge;
    private int userHeight;
    private double userWeight;
    private String userAddress;
    private String userFitnessLevel;
    private int motivationLevel;
    
    //Constructor with all parameters.
    public User(String userName, int userAge, int userHeight, double userWeight, String userAddress, String userFitnessLevel, int motivationLevel){
        //Initializing user attributes
        this.userName = userName;
        this.userAge = userAge;
        this.userHeight = userHeight;
        this.userWeight = userWeight;
        this.userAddress = userAddress;
        this.userFitnessLevel = userFitnessLevel;
        this.motivationLevel = motivationLevel;
    }
    
    //Default Constructor
    public User(){
        //Initializing user attributes with default values
        userName = "";
        userAge = 0;
        userHeight = 0;
        userWeight = 0.0;
        userAddress = "";
        userFitnessLevel = "";
        motivationLevel = 0;
    }
    
    //Singleton method to get the instance of User
    public static User getInstance() {
        if (instance == null) {
            instance = new User();
        }
        return instance;
    }
    

    //Setters
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public void setUserHeigth(int userHeigth) {
        this.userHeight = userHeigth;
    }

    public void setUserWeight(double userWeight) {
        this.userWeight = userWeight;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public void setUserFitnessLevel(String userFitnessLevel) {
        this.userFitnessLevel = userFitnessLevel;
    }
    
    public void setMotivationLevel(int motivationLevel){
        this.motivationLevel = motivationLevel;
    }
    
    //Getters

    public String getUserName() {
        return userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public int getUserHeigth() {
        return userHeight;
    }

    public double getUserWeight() {
        return userWeight;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public String getUserFitnessLevel() {
        return userFitnessLevel;
    }

    public int getMotivationLevel(){
        return motivationLevel;
    }    
}
