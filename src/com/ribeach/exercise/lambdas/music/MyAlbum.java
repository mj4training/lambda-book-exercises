/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ribeach.exercise.lambdas.music;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.Collections.unmodifiableList;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author richard
 */
public final class MyAlbum implements MyPerformance {
    
    private String name;
    private List<MyTrack> tracks;
    private List<MyArtist> musicians;

    public MyAlbum(String name, List<MyTrack> tracks, List<MyArtist> musicians) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(tracks);
        Objects.requireNonNull(musicians);

        this.name = name;
        this.tracks = new ArrayList<>(tracks);
        this.musicians = new ArrayList<>(musicians);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the tracks
     */
    public Stream<MyTrack> getTracks() {
        return tracks.stream();
    }

    /**
     * Used in imperative code examples that need to iterate over a list
     */
    public List<MyTrack> getTrackList() {
        return unmodifiableList(tracks);
    }

    /**
     * @return the musicians
     */
    public Stream<MyArtist> getMusicians() {
        return musicians.stream();
    }

    /**
     * Used in imperative code examples that need to iterate over a list
     */
    public List<MyArtist> getMusicianList() {
        return unmodifiableList(musicians);
    }

    public MyArtist getMainMusician() {
        return musicians.get(0);
    }

    public MyAlbum copy() {
        /*
         * MCJ: This looks like a map/reduce example which clones lists
         */
        List<MyTrack> tracks = getTracks().map(MyTrack::copy).collect(toList());
        List<MyArtist> musicians = getMusicians().map(MyArtist::copy).collect(toList());
        return new MyAlbum(name, tracks, musicians);
    }

}
