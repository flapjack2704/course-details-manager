/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
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
 * @author Flapjack
 */
public class FTStudentTest {
    
    public FTStudentTest() {
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
     * Test of calcTuition method, of class FTStudent.
     */
    @Test
    public void testCalcTuition() {
        System.out.println("calcTuition");
        FTStudent student = new FTStudent();
        int expResult1 = 5000;
        int expResult2 = 2500;
        int result1 = student.calcTuition(1);  // Year of study
        int result2 = student.calcTuition(3);  // Year of study
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
    }
    
}
