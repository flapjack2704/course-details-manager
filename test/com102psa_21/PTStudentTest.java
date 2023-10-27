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
public class PTStudentTest {
    
    public PTStudentTest() {
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
     * Test of calcTuition method, of class PTStudent.
     */
    @Test
    public void testCalcTuition() {
        System.out.println("calcTuition");
        PTStudent student = new PTStudent();
        int expResult1 = 4500;
        int expResult2 = 2250;
        int result1 = student.calcTuition(6);  // No. of modules
        int result2 = student.calcTuition(3);  // No. of modules
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
    }
}
