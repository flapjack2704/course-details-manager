package com102psa_21;

/**
 * Jack Burnett - B00888824
 * Ryan Butler - B00848940 
 */

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner; 
import java.util.Date;
import java.text.SimpleDateFormat;

public class StudentCollectionManager {
    // Creates an empty array called studentArray and creates a new instance of scanner
    private ArrayList<Student> studentArray = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    
    // Getter method for Student array
    public ArrayList<Student> getStudentArray() {
        return studentArray;
    }

    protected void generateStudentArray(){
        /*
        *   Create array of Student objects using the StudentDetails.txt file
        */
        
        // Creates an instance of a buffer reader which reads the file 
        try{
            BufferedReader br = new BufferedReader(new FileReader("StudentDetails.txt"));
            // Skips the first line to prevent comment line from being read in as data
            String line = br.readLine();  

            // While loop that reads through the file and creates either a FTStudent or a PTStudent object, then adds to the ArrayList
            while((line = br.readLine()) != null){
                String[] arr = line.split(",");
                if(arr[3].equals("ft")){
                    FTStudent student = new FTStudent(arr[0], arr[1], arr[2], arr[3], Integer.parseInt(arr[4]), Integer.parseInt(arr[5]));
                    studentArray.add(student);
                }
                if(arr[3].equals("pt")){
                    PTStudent student = new PTStudent(arr[0], arr[1], arr[2], arr[3], Integer.parseInt(arr[4]), Integer.parseInt(arr[5]));
                    studentArray.add(student);
                }
                
            }
            // Closes the buffer reader to prevent resource leak 
            br.close();
        }
        // Checked error handling, letting the user know what went wrong.
        catch (IOException e) {
            System.out.println("Couldn't find student file");
        }
    }

    protected void writeLineToFile(String stringToWrite, String filePath){
        /*
        *   Adds a given string to the end of a given file
        */
        
        // Creates instance of file to be written to.
        File fileName = new File(filePath);
        try{
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)));
            pw.println(stringToWrite);
            pw.close();
        }
        // Checked error handling, letting the user know what went wrong.
        catch (IOException e) {
            System.out.println("Couldn't find designated file");
        }
        
    }

    protected void addStudent(){
        /*
        *   AddStudent method, will be used to add new students to the course attendence register. asking user to input key details to enroll
        *   as a student such as name,dob,gender,mode of study, year of study, modules taken and tutition fee
        */

        // While loop to allow a maximum of 20 students on the course
        while(studentArray.size() < 20){
            String studentName = "";
            String modeOfStudy = "";
            int yearOfStudy = 0;
            int modulesTaken = 0;
            String dob = "";

            // While loop that gets students Date Of Birth and saves it to a variable
            while(true){
                System.out.println("Enter Student name");
                studentName = sc.nextLine();
                if(studentName.indexOf(',') == -1){  // Not finding a comma returns minus 1
                    break;
                }
                else{
                    System.out.println("Comma detected, please try again");
                }
            }

            // While loop that gets students Date Of Birth and saves it to a variable
            while(true){
                System.out.println("Enter Date of Birth in (dd/mm/yyyy) format");
                dob = sc.nextLine();
                if(dateChecker(dob)){
                    break;
                }
                else{
                    System.out.println("Wrong date format");
                }
            }

            // Asks the user to input their gender
            System.out.println("Enter Students gender (Male/Female/Other)");
            // Saves that inputted data to a variable
            String studentGender = sc.nextLine();
            // While loop that gets their mode of study and saves it to a variable
            while(true){
                System.out.println("Enter Students Mode of Study (pt or ft)");
                modeOfStudy = sc.nextLine().toLowerCase();
                if(modeOfStudy.equals("pt") || modeOfStudy.equals("ft")){
                    break;
                }
                else{
                    System.out.println("you have entered an inproper input, try again");
                }
                
            }

            // Asks the user to input their year of study 
            System.out.println("Enter students year of study");
            // Gets their year of study and saves it to a variable
            yearOfStudy = inputInteger(1,4);

            // Asks the user to input their number of modules
            System.out.println("Enter number of modules to be taken this year (1 to 6)");
            // Gets the modules taken and saves it to a variable
            modulesTaken = inputInteger(1,6);
            
            // Creates a Student object based on inputs if FT or PT and adds them to the arrayList to be written to the text file
            if(modeOfStudy.equals("ft")){
                studentArray.add(new FTStudent(studentName, dob, studentGender, modeOfStudy, yearOfStudy, modulesTaken));
            }
            else{
                studentArray.add(new PTStudent(studentName, dob, studentGender, modeOfStudy, yearOfStudy, modulesTaken));
            }
            
            // Gives the user the option to add another student or quit the program
            System.out.println("Student enrolled sucessfully. would you like to enroll another student (yes/no)");
            String finsher = sc.nextLine().toLowerCase();
            // Finishes the add student program if no is selected
            if(finsher.equals("no")){
                break;
            }  
            
        }
        // Error handling letting the user know the maxium students enrolled has been reached
        if(studentArray.size() == 20){
            System.out.println("Maximum number of students (20) already in course, sorry.");
        }

    }

    protected void removeStudent(){
        // Asks user to input the students name they want to remove
        System.out.println("Input the student's name you want to remove: ");
        // Gets inputted name and saves it to a variable
        String inputName = sc.nextLine();
        
        // Searches to see if that student is actually in the system, the function returns null if there isn't any student with the name
        Student student = searchStudent(inputName);
        // If statement to track if we can remove the student or not
        if(student == null){
            System.out.println("Student not found!");
        }
        // If student is in the array, remove them
        else{
            System.out.println(inputName + " removed from student list");
            studentArray.remove(student);
        }
    }

    protected Student searchStudent(String name){
       // Loops through the student array searching for matching name and returning details if found.
        for(int i = 0; i<studentArray.size(); i++){
            if(studentArray.get(i).getName().toLowerCase().equals(name.toLowerCase())){
                return studentArray.get(i);
            }
        }
        // Returns a null object if student isn't found
        return null;
    }

    protected void printStudent(){
        // Asks the user to input the students name they wish to print details of
        System.out.println("Input the student's name you want to print the details of: ");
        // Gets inputted name and saves it to a variable
        String inputName = sc.nextLine();
        
        // Searches to see if that student is actually in the system, that function returns null if there isn't any student with the name
        Student student = searchStudent(inputName);
        // If statement to track if we can remove the student or not
        if(student == null){
            System.out.println("Student not found!");
        }
        else{
            System.out.println(student);
        }
    }

    protected void rewriteCourseFile(){
        /*
         * Rewrites contents of CourseDetails.txt based on the current status of the studentArray.
         * Used as part of printCourseReport() to ensure accurate reporting.
         */
        
        // Uses the text file called CourseDetails and declares the data type of used variables
        File fileName = new File("CourseDetails.txt");
        float noOfMales = 0;
        float noOfFemales = 0;
        float noOfStudents = studentArray.size();
        int noOfFTs = 0;
        int noOfPTs = 0;
        int totalTuition = 0;
        // Formats the percentages to 2 decimal places
        DecimalFormat df = new DecimalFormat("#,###.##");
        
        // Searches through student array size and gets number of Males
        for(int i = 0; i<studentArray.size(); i++){
            if(studentArray.get(i).getGender().toLowerCase().equals("male")){
                noOfMales++;
            }
            // Searches through student array size and gets number of females
            else if(studentArray.get(i).getGender().toLowerCase().equals("female")){
                noOfFemales++;
            }
            // Searches through student array and gets number of full time students
            if(studentArray.get(i).getFullOrPartTime().equals("ft")){
                noOfFTs++;
            }
            // Searches through student array and gets number of part time students
            else{
                noOfPTs++;
            }
            // Calculates total tuition for all students in the course combined
            totalTuition += studentArray.get(i).getTuitionFee();
        }

        try{
            // PrintWriter gives us access to the handy PrintWriter.println() method
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
            // The block below writes to the file
            pw.println("Course Name,Number of PT Students,Number of FT Students,Percentage of male students,Percentage of female students ");
            // Prints the title of course and amount of students and their percentages of male and female
            pw.println("Computer Science," + noOfPTs + "," + noOfFTs + "," + df.format((noOfMales/noOfStudents)*100)+"%,"
                       + df.format((noOfFemales/noOfStudents)*100)+"%\n");
            // Closes the print writer 
            pw.close();
        }
        // Checked error handling, letting the user know if the file cannot be found
        catch (IOException e) {
            System.out.println("Course file not found, please make sure the directory is correct");
        }
        
    }

    protected void printCourseReport(){
        // Updates the file incase something changed during hte running of the program
        rewriteCourseFile();
        
        // Buffered reader, reads through the file and prints details to course report 
        try{
            BufferedReader br = new BufferedReader(new FileReader("CourseDetails.txt"));
            String line = ""; 
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
            // Closes buffered reader
            br.close();
        }
        // Checked error handling, letting user know the file cannot be found
        catch (IOException e) {
            System.out.println("Course file not found, please make sure the directory is correct");
        }
        
    }

    protected void rewriteStudentFile(){
        /*
         * Rewrites contents of StudentDetails.txt based on the current status of the studentArray.
         * Only needs to be done at the end of the program, as all other array-dependent methods don't use this file
         */
        
        // Uses the text file called StudentDetails
        File fileName = new File("StudentDetails.txt");
        
        // Rewrites the contents of the file based on current status of studentArray
        try{
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
            pw.println("name,dd/mm/yyyy,gender,ft/pt,yearOfStudy,no.ofModules,tuition");
            for(int i = 0; i<studentArray.size(); i++){
                pw.println(studentArray.get(i).toString());
            }
            // Closes print writer to prevent reasource drain and unintended data to be writen
            pw.close();
        }
        // Checked error handling, letting user know if the file cannot be found
        catch (IOException e) {
            System.out.println("Student file not found, please make sure the directory is correct");
        }
    }

    protected void closeScanner(){
        /*
         * Only closes the scanner at the end of the program.
         * Closing a scanner that uses System.in closes that System.in input stream, reopening System.in again within the
         * same running of the program will not work.
         */
        sc.close();
    }

    public int inputInteger(){
        /*
        * Validation method to only allow integer data type to be accepted
        */
        
        while(true){
            try{
                //System.out.println("Input an integer:");
                int out = Integer.parseInt(sc.nextLine());
                return out;
            }
            catch(Exception e){
                System.out.println("Not an integer! try again:");
            }
        }
    }

    public int inputInteger(int min, int max){
        /*
        * Validation method to only allow intergers of a certain range to be accepted 
          Uses the zero-param inputInteger() method
        */
        
        while(true){
            int out = inputInteger();
            if(out >= min && out <= max){
                return out;
            }
            else{
                System.out.println("Input was not within the bounds " + min + " and " + max);
            }
        }
    }

    protected boolean dateChecker(String dob){
        /*
        * Validation method to check if Date Of Birth has been formated correctly 
        * when entered and if so make sure the date exists and is not in the future. 
        */
        
        // Defines the date format string
        String dateFormat = "dd/MM/yyyy"; 
        // Create a new object with the given format string
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        // Prevents leniency while parsing
        sdf.setLenient(false); 
        
        try {
            // Parse the date string using the SimpleDateFormat and format it 
            Date date = sdf.parse(dob);
            String parsedDate = sdf.format(date);
            
            // Get the current date and time 
            Date currentDate = new Date(); 

            // Check if input date is equal to parsed date and is not after current date
            if (dob.equals(parsedDate) && date.before(currentDate)){
                // If inputted date is valid print message indiciating so
                System.out.println("Inputted date exists and is not in the future." );
                return true;
            } else {
                // If input is invalid print message indicating reason why
                System.out.println("Inputted date is invalid.");
                return false;
            }
        
        }
        catch (Exception e) {
            // If there is an error while parsing the date, print error message
            System.out.println("Invalid date format.");
            return false;
        }
        
    }
}

