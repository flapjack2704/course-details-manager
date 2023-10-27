package com102psa_21;

/**
 * Jack Burnett - B00888824
 * Ryan Butler - B00848940 
 */

public class Student {
    // Class variables 
    protected String name;
    protected String dobDDMMYYYY;
    protected String gender;
    protected String fullOrPartTime;
    protected int yearOfStudy;
    protected int modulesTaken;
    protected int tuitionFee;

    // Default constructor to allow for objects with no input parameters to be used and testing/ validation
    public Student(){ 
        
    }
    
    // Student Constructor which takes in parameters and makes a student object
    public Student(String name, String dobDDMMYYYY, String gender, String fullOrPartTime, int yearOfStudy,
                   int modulesTaken) 
    {
        
        this.name = name;
        this.dobDDMMYYYY = dobDDMMYYYY;
        this.gender = gender;
        this.fullOrPartTime = fullOrPartTime;
        this.yearOfStudy = yearOfStudy;
        this.modulesTaken = modulesTaken;
    }

    // Getter method that returns name
    public String getName() {
        return name;
    }
    // Getter method that returns the date of birth
    public String getDobDDMMYYYY() {
        return dobDDMMYYYY;
    }
    // Getter method that returns the students gender
    public String getGender() {
        return gender;
    }
    // Getter method that retuns the students mode of study
    public String getFullOrPartTime() {
        return fullOrPartTime;
    }
    // Getter method that retuns the students year of study
    public int getYearOfStudy() {
        return yearOfStudy;
    }
    // Getter method that retuns the students amount of module
    public int getModulesTaken() {
        return modulesTaken;
    }
    // Getter method that retuns the students tuition fee
    public int getTuitionFee() {
        return tuitionFee;
    }
    // Getter method that retuns set tuition fee
    public void setTuitionFee(int tuitionFee) {
        this.tuitionFee = tuitionFee;
    }

    // Test method
    public void saySomething(){
        // Abstract method
    }
    
    // Formats the objects to a string
    public String toString(){
        return name+","+dobDDMMYYYY+","+gender+","+fullOrPartTime+","+yearOfStudy+","+modulesTaken+","+tuitionFee;
    }
}
