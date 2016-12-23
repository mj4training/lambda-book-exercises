/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ribeach.exercise.lambdas.music;

import java.util.stream.Stream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Melissa
 */
public class MyPerformanceTest {
    
    public MyPerformanceTest() {
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
     * Test of getName method, of class MyPerformance.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        MyPerformance instance = new MyPerformanceImpl();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMusicians method, of class MyPerformance.
     */
    @Test
    public void testGetMusicians() {
        System.out.println("getMusicians");
        MyPerformance instance = new MyPerformanceImpl();
        Stream<MyArtist> expResult = null;
        Stream<MyArtist> result = instance.getMusicians();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllMusicians method, of class MyPerformance.
     */
    @Test
    public void testGetAllMusicians() {
        System.out.println("getAllMusicians");
        MyPerformance instance = new MyPerformanceImpl();
        Stream<MyArtist> expResult = null;
        Stream<MyArtist> result = instance.getAllMusicians();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class MyPerformanceImpl implements MyPerformance {

        public String getName() {
            return "";
        }

        public Stream<MyArtist> getMusicians() {
            return null;
        }
    }
    
}
