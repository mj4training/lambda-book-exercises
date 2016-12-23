/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ribeach.exercise.lambdas.music;

import java.util.List;
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
public class MyAlbumTest {
    
    public MyAlbumTest() {
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
     * Test of getName method, of class MyAlbum.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        MyAlbum instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTracks method, of class MyAlbum.
     */
    @Test
    public void testGetTracks() {
        System.out.println("getTracks");
        MyAlbum instance = null;
        Stream<MyTrack> expResult = null;
        Stream<MyTrack> result = instance.getTracks();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTrackList method, of class MyAlbum.
     */
    @Test
    public void testGetTrackList() {
        System.out.println("getTrackList");
        MyAlbum instance = null;
        List<MyTrack> expResult = null;
        List<MyTrack> result = instance.getTrackList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMusicians method, of class MyAlbum.
     */
    @Test
    public void testGetMusicians() {
        System.out.println("getMusicians");
        MyAlbum instance = null;
        Stream<MyArtist> expResult = null;
        Stream<MyArtist> result = instance.getMusicians();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMusicianList method, of class MyAlbum.
     */
    @Test
    public void testGetMusicianList() {
        System.out.println("getMusicianList");
        MyAlbum instance = null;
        List<MyArtist> expResult = null;
        List<MyArtist> result = instance.getMusicianList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMainMusician method, of class MyAlbum.
     */
    @Test
    public void testGetMainMusician() {
        System.out.println("getMainMusician");
        MyAlbum instance = null;
        MyArtist expResult = null;
        MyArtist result = instance.getMainMusician();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of copy method, of class MyAlbum.
     */
    @Test
    public void testCopy() {
        System.out.println("copy");
        MyAlbum instance = null;
        MyAlbum expResult = null;
        MyAlbum result = instance.copy();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
