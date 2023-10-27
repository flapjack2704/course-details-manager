package com102psa_21;

/**
 * Jack Burnett - B00888824
 * Ryan Butler - B00848940 
 */

public class PTStudent extends Student{
    // PT student constructor, which takes inputted date and calculates tutition with resulting data.
    PTStudent(String name, String dobDDMMYYYY, String gender, String fullOrPartTime, int yearOfStudy, int modulesTaken){
        super(name,dobDDMMYYYY,gender,fullOrPartTime,yearOfStudy,modulesTaken);
        tuitionFee = calcTuition(modulesTaken);
    }
    
    // Default constructor to allow for objects with no input parameters to be used and testing/ validation
    PTStudent(){
        
    }
    
    // Takes the year of study data for PT students and calculates their tuition
    public int calcTuition(int modulesTaken){
        return modulesTaken * 750;
    }
    
    // Test method please ignore
    public void saySomething(){
        System.out.println("I'M A PART TIME STUDENT");
    }  
}
