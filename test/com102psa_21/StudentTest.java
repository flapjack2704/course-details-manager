/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com102psa_21;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author b00848940
 */
public class StudentTest {
    
    public StudentTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getName method, of class Student.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Student instance = new Student("Tammy Acorn","01/01/1996","Female","FT",3,6);
        
        String expResult = "Tammy Acorn";
        String result = instance.getName();
        
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDobDDMMYYYY method, of class Student.
     */
    @Test
    public void testGetDobDDMMYYYY() {
        System.out.println("getDobDDMMYYYY");
        Student instance = new Student("Tammy Acorn","01/01/1996","Female","FT",3,6);
        
        String expResult = "01/01/1996";
        String result = instance.getDobDDMMYYYY();
        
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getGender method, of class Student.
     */
    @Test
    public void testGetGender() {
        System.out.println("getGender");
        Student instance = new Student("Tammy Acorn","01/01/1996","Female","FT",3,6);
        
        String expResult = "Female";
        String result = instance.getGender();
        
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getFullOrPartTime method, of class Student.
     */
    @Test
    public void testGetFullOrPartTime() {
        System.out.println("getFullOrPartTime");
        Student instance = new Student("Tammy Acorn","01/01/1996","Female","FT",3,6);
        
        String expResult = "FT";
        String result = instance.getFullOrPartTime();
        
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getYearOfStudy method, of class Student.
     */
    @Test
    public void testGetYearOfStudy() {
        System.out.println("getYearOfStudy");
        Student instance = new Student("Tammy Acorn","01/01/1996","Female","FT",3,6);
        
        int expResult = 3;
        
        int result = instance.getYearOfStudy();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getModulesTaken method, of class Student.
     */
    @Test
    public void testGetModulesTaken() {
        
        System.out.println("testing getModulesTaken");
        Student instance = new Student("Tammy Acorn","01/01/1996","Female","FT",3,6);
   
        int expResult = 6;
        
        int actualResult = instance.getModulesTaken();
        
        assertEquals(expResult, actualResult);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getTuitionFee method, of class Student.
     */
    @Test
    public void testGetTuitionFee() {
        System.out.println("getTuitionFee");
        Student instance = new Student("Tammy Acorn","01/01/1996","Female","FT",3,6);
        
        int expResult = 0;
        int result = instance.getTuitionFee();
        
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setTuitionFee method, of class Student.
     */
    @Test
    public void testSetTuitionFee() {
        System.out.println("setTuitionFee");
        int tuitionFee = 0;
        Student instance = new Student();
        instance.setTuitionFee(tuitionFee);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }


 
}
