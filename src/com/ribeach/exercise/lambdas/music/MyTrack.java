/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ribeach.exercise.lambdas.music;

/**
 * @author richard
 */
public final class MyTrack {
    
    private final String name;
    private final int length;

    public MyTrack(String name, int length) {
        this.name = name;
        this.length = length;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the length of the track in milliseconds.
     */
    public int getLength() {
        return length;
    }

    public MyTrack copy() {
        return new MyTrack(name, length);
    }

}
