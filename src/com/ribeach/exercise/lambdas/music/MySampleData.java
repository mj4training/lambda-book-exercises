/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ribeach.exercise.lambdas.music;

import java.util.Arrays;
import static java.util.Arrays.asList;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author Melissa
 */
public class MySampleData {
    
    /* Artist data */
    // Van Morrisson's nationality is intended to be null to test Optional
    public static final MyArtist vanMorrison = new MyArtist("Van Morrison", null, 1500000);
    
    public static final MyArtist bono = new MyArtist("Bono", "Irish", 160000);
    public static final MyArtist edge = new MyArtist("Edge", "Irish", 0);
    public static final MyArtist larryMullen = new MyArtist("Larry Mullen", "Irish", 0);
    public static final MyArtist adamClayton = new MyArtist("Adam Clayton", null, 0);

    public static final List<MyArtist> membersOfU2 = Arrays.asList(bono, edge, larryMullen, adamClayton);

    public static final MyArtist u2 = new MyArtist("U2", membersOfU2, "Irish", 1400000);
    
    public static final MyArtist johnLennon = new MyArtist("John Lennon", "British", 500000);
    public static final MyArtist paulMcCartney = new MyArtist("Paul McCartney", "Liverpudlian", 300000);
    public static final MyArtist georgeHarrison = new MyArtist("George Harrison", "British", 0);
    public static final MyArtist ringoStarr = new MyArtist("Ringo Starr", "British", 0);

    public static final List<MyArtist> membersOfTheBeatles = Arrays.asList(johnLennon, paulMcCartney, georgeHarrison, ringoStarr);

    public static final MyArtist theBeatles = new MyArtist("The Beatles", membersOfTheBeatles, "British", 4000000);
    
    public static final List<MyArtist> membersOfAwesomeBand = Arrays.asList(u2, theBeatles);
    
    public static final MyArtist awesomeBand = new MyArtist("Awesome Band", membersOfAwesomeBand, "European", 300000);

    public static final MyArtist bbKing = new MyArtist("B B King", "American", 430000);
    public static final MyArtist bobDylan = new MyArtist("Bob Dylan", "American", 4677000);
    
    /* Ablum data */
    public static final MyAlbum joshuaTree = new MyAlbum("Joshua Tree",
            asList(new MyTrack("Bullet the Blue Sky", 467),
                   new MyTrack("Where Streets Have No Name", 442),
                   new MyTrack("In God's Country", 530)),
            asList(u2));
    
    public static final MyAlbum rattleAndHum = new MyAlbum("Rattle and Hum",
            asList(new MyTrack("When Love Comes to Town", 360),
                   new MyTrack("Love Rescue Me", 432),
                   new MyTrack("Helter Skelter", 530),
                   new MyTrack("Desire", 540)),
            asList(u2, bobDylan, bbKing, paulMcCartney, johnLennon));

    public static final MyAlbum shortAlbum = new MyAlbum("Van's Short Album",
            asList(new MyTrack("short track", 30)),
            asList(vanMorrison));
}
