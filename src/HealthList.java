/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Arthur Kroth  Student Number: x22166971
 * Group 1 - CA1 - Object Oriented Programming
 */
public class HealthList {
    //ArrayList to store smoker tips
    private ArrayList<String> smokerTipsList;

    //Constructor to initialize HealthList and populate smokerTipsList from a file or hardcoded values
    public HealthList() {
        this.smokerTipsList = new ArrayList<>();
        try {
            //Attempt to read smoker tips from a file
            String absolutePath = new File("src").getAbsolutePath() + "/smoker_tips.txt";
            this.initializeSmokerTipsFromFile(absolutePath);
        } catch (IOException e) {
            //If file reading fails, use hardcoded tips
            System.err.println("Error reading file: " + e.getMessage());
            this.initializeHardcodedSmokerTips();
        }
    }
   //Method to initialize smoker tips from a file
    private void initializeSmokerTipsFromFile(String filename) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
        while ((line = br.readLine()) != null) {
            smokerTipsList.add(line);
        }
        }   
    }
    //Method to initialize smoker tips with hardcoded values
    private void initializeHardcodedSmokerTips() {
        smokerTipsList.add("Consider joining a support group to quit smoking.");
        smokerTipsList.add("Identify your reasons for quitting and remind yourself of them regularly.");
        smokerTipsList.add("Create a plan to gradually reduce smoking or set a quit date.");
        smokerTipsList.add("Use nicotine replacement therapy or other medications to help manage cravings.");
        smokerTipsList.add("Practice deep breathing or mindfulness to reduce stress without smoking.");
        smokerTipsList.add("Reward yourself for milestones reached in your journey to quit smoking.");
        smokerTipsList.add("Keep yourself busy with activities that distract you from smoking.");
        smokerTipsList.add("Avoid places or situations where you used to smoke.");
        smokerTipsList.add("Drink plenty of water and eat healthy snacks to curb cravings.");
        smokerTipsList.add("Get support from friends, family, or a quit-smoking helpline.");
        smokerTipsList.add("Remember that quitting is a process, and it's okay to ask for help or start over if needed.");
        smokerTipsList.add("Find alternative ways to cope with stress, such as exercise, meditation, or hobbies.");
        smokerTipsList.add("Visualize a smoke-free life and the benefits it brings to your health and well-being.");
        smokerTipsList.add("Dispose of all smoking paraphernalia to remove triggers from your environment.");
        smokerTipsList.add("Track your progress and celebrate each day without smoking as a personal achievement.");
        smokerTipsList.add("Consider the financial savings from quitting smoking and use it as motivation for other goals.");
    }
    
    //Method to retrieve a random smoker tip from the list
    public String getRandomSmokerTip() {
        if (smokerTipsList.isEmpty()) {
            //Default value if for some reason the file fails and the hardcoded code fails.
            return "No tips available.";
        }

        Random random = new Random();
        int randomIndex = random.nextInt(smokerTipsList.size());
        return smokerTipsList.get(randomIndex);
    }
}