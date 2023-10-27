package com102psa_21;

/**
 * Jack Burnett - B00888824
 * Ryan Butler - B00848940 
 */

public class FTStudent extends Student {
    // FT student constructor, which takes inputted date and calculates tutition with resulting data.
    FTStudent(String name, String dobDDMMYYYY, String gender, String fullOrPartTime, int yearOfStudy, int modulesTaken){
        super(name,dobDDMMYYYY,gender,fullOrPartTime,yearOfStudy,modulesTaken);
        tuitionFee = calcTuition(yearOfStudy);
    }
    
    // Default constructor to allow for objects with no input parameters to be used and testing/ validation
    FTStudent(){
        
    }
    
    // Takes the year of study data for FT students and calculates their tuition
    public int calcTuition(int yearOfStudy){
        if(yearOfStudy==3){
            return 2500;
        }
        else{
            return 5000;
        }
    }
    
    // Test method please ignore
    public void saySomething(){
        System.out.println("I'M A FULL TIME STUDENT");
    }
}
