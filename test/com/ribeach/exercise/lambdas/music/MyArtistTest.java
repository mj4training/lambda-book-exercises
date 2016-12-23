/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ribeach.exercise.lambdas.music;

import java.util.Optional;
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
public class MyArtistTest {
    
    public MyArtistTest() {
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
     * Test of getName method, of class MyArtist.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        MyArtist instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMembers method, of class MyArtist.
     */
    @Test
    public void testGetMembers() {
        System.out.println("getMembers");
        MyArtist instance = null;
        Stream<MyArtist> expResult = null;
        Stream<MyArtist> result = instance.getMembers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllSoloMembers method, of class MyArtist.
     */
    @Test
    public void testGetAllSoloMembers() {
        System.out.println("getAllSoloMembers");
        MyArtist instance = null;
        Stream<MyArtist> expResult = null;
        Stream<MyArtist> result = instance.getAllSoloMembers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNationality method, of class MyArtist.
     */
    @Test
    public void testGetNationality() {
        System.out.println("getNationality");
        MyArtist instance = null;
        String expResult = "";
        Optional<String> result = instance.getNationality();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSoldUnits method, of class MyArtist.
     */
    @Test
    public void testGetSoldUnits() {
        System.out.println("getSoldUnits");
        MyArtist instance = null;
        int expResult = 0;
        int result = instance.getSoldUnits();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCollectiveSoldUnits method, of class MyArtist.
     */
    @Test
    public void testGetCollectiveSoldUnits() {
        System.out.println("getCollectiveSoldUnits");
        MyArtist instance = null;
        int expResult = 0;
        int result = instance.getCollectiveSoldUnits();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isSolo method, of class MyArtist.
     */
    @Test
    public void testIsSolo() {
        System.out.println("isSolo");
        MyArtist instance = null;
        boolean expResult = false;
        boolean result = instance.isSolo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isFrom method, of class MyArtist.
     */
    @Test
    public void testIsFrom() {
        System.out.println("isFrom");
        String nationality = "";
        MyArtist instance = null;
        boolean expResult = false;
        boolean result = instance.isFrom(nationality);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class MyArtist.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        MyArtist instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of copy method, of class MyArtist.
     */
    @Test
    public void testCopy() {
        System.out.println("copy");
        MyArtist instance = null;
        MyArtist expResult = null;
        MyArtist result = instance.copy();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
