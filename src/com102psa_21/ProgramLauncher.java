package com102psa_21;

/**
 * Jack Burnett - B00888824
 * Ryan Butler - B00848940 
 */

import java.util.Scanner;

public class ProgramLauncher {
    // Creates instance of manager class
    StudentCollectionManager scm = new StudentCollectionManager();

    public static void main(String[] args){
        // Creates instance of main launcher class.
        ProgramLauncher launcher = new ProgramLauncher();
        // Calls the start method for the program
        launcher.start();
    }

    private void start(){
        // Start method calls menu
        System.out.println("Welcome to the Computer Science module student enrolment portal.");
        menu();
    }

    protected void menu(){
        // Populates arraylist of students for the program
        scm.generateStudentArray();  

        // Creates scanner labbled input
        Scanner input = new Scanner(System.in);
        // Loops menu
        while(true){
            System.out.println("\nPlease select an option from the menu below:");
            System.out.println("[1] Add a student ");
            System.out.println("[2] Search for a student");
            System.out.println("[3] Remove Student ");
            System.out.println("[4] Print Course Report");
            System.out.println("[5] Exit Program");
            System.out.println("input:");

            
            // If-else statement selection block for uster input choice
            int option = scm.inputInteger(1, 5);
            if(option == 1){
                scm.addStudent();
            }else if (option == 2){
                scm.printStudent();
            }else if (option == 3){
                scm.removeStudent();
            }else if (option == 4){
                scm.printCourseReport();
            }else if (option == 5){
                System.out.println("Exiting...");
                break;
            }
        }
        
        // Closes input scanner
        input.close();
        // Rewrites the Student File after inputted option is concluded
        scm.rewriteStudentFile();
        // Rewrites the course file after inputted option is concluded
        scm.rewriteCourseFile();
        // Closes Student Collection Manager scanner
        scm.closeScanner();   
    }
}
