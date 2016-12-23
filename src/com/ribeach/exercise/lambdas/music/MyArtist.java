/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ribeach.exercise.lambdas.music;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Domain class for a popular music artist.
 * 
 * @author Richard Warburton
 */
public final class MyArtist implements MyPerformance {
    
    private String name;
    private List<MyArtist> members;
    private String nationality;
    private Integer soldUnits;
    
    public MyArtist(String name, String nationality, int soldUnits) {
        this(name, Collections.emptyList(), nationality, soldUnits);
    }

    public MyArtist(String name, List<MyArtist> members, String nationality, Integer soldUnits) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(members);
        /* 
         * Allow nationality to be null to test Optional type
         */
        //Objects.requireNonNull(nationality);
        this.name = name;
        this.members = new ArrayList<>(members);
        this.nationality = nationality;
        this.soldUnits = soldUnits;
    }

    /**
     * @return the name
     */
    @Override
    public String getName() {
        return name;
    }
    
    /**
     * @return a stream of members. All members are assumed to be musicians.
     */
    @Override
    public Stream<MyArtist> getMusicians() {
        return getMembers();
    }

    /**
     * @return the members
     */
    public Stream<MyArtist> getMembers() {
        return members.stream();
    }
    
    /**
     * @return all members who are solo artists and have sold units (recursive execution)
     */
    public Stream<MyArtist> getAllSoloMembers() {  
        
        if (soldUnits == 0 && isSolo()) return Stream.empty();
        else if (isSolo()) return (Stream.of(this));
        else return (members.stream().flatMap(artist -> artist.getAllSoloMembers()));
    }

    /**
     * @return the nationality if it is known
     */
    public Optional<String> getNationality() {
        return Optional.ofNullable(nationality);
    }
    
    /**
     * @return the soldUnits for this artist
     */
    public int getSoldUnits() {
        return soldUnits;
    }
    
     /**
     * @return the soldUnits including sales of individual members
     */
    public int getCollectiveSoldUnits() {
        return (soldUnits + (int)members.stream()
                .map(member -> member.getSoldUnits())
                .reduce(0, (acc, element) -> acc + element));
    }

    public boolean isSolo() {
        return members.isEmpty();
    }

    public boolean isFrom(String nationality) {
        
        if (this.nationality != null) {
            return this.nationality.equals(nationality);
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return getName();
    }

    public MyArtist copy() {
        List<MyArtist> members = getMembers().map(MyArtist::copy).collect(toList());
        return new MyArtist(name, members, nationality, soldUnits);
    }
}
