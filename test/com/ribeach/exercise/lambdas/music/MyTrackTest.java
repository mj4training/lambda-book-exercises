/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ribeach.exercise.lambdas.music;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Melissa
 */
public class MyTrackTest {
    
    public MyTrackTest() {
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
     * Test of getName method, of class MyTrack.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        MyTrack instance = new MyTrack("Hey Jude", 530);
        String expResult = "Hey Jude";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLength method, of class MyTrack.
     */
    @Ignore
    @Test
    public void testGetLength() {
        System.out.println("getLength");
        MyTrack instance = null;
        int expResult = 0;
        int result = instance.getLength();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of copy method, of class MyTrack.
     */
    @Ignore
    @Test
    public void testCopy() {
        System.out.println("copy");
        MyTrack instance = null;
        MyTrack expResult = null;
        MyTrack result = instance.copy();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
