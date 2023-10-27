/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com102psa_21;

import java.util.ArrayList;
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
public class StudentCollectionManagerTest {
    
    public StudentCollectionManagerTest() {
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
     * Test of dateChecker method, of class StudentCollectionManager.
     */
    @Test
    public void testDateChecker() {
        System.out.println("dateChecker");
        String dob1 = "27/4/2000";
        String dob2 = "27/04/2000";
        String dob3 = "45/44/6969";
        StudentCollectionManager instance = new StudentCollectionManager();
        boolean result1 = instance.dateChecker(dob1);
        assertEquals(false, result1);
        
        boolean result2 = instance.dateChecker(dob2);
        assertEquals(true, result2);
        
        boolean result3 = instance.dateChecker(dob3);
        assertEquals(false, result3);
        // TODO review the generated test code and remove the default call to fail.
    }
    @Test
    public void testWriteLineToFile() {
        System.out.println("writeLineToFile");
        String stringToWrite = "";
        String filePath = "";
        StudentCollectionManager instance = new StudentCollectionManager();
        instance.writeLineToFile(stringToWrite, filePath);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
 
    
    
}
