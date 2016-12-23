package com.ribeach.exercise.lambdas.music;

import java.util.stream.Stream;

import static java.util.stream.Stream.concat;

public interface MyPerformance {

    public String getName();

    public Stream<MyArtist> getMusicians();

    /*
     * This only works to concatenate artists and any members one level below
     */
    public default Stream<MyArtist> getAllMusicians() {
        return getMusicians().flatMap(artist -> concat(Stream.of(artist), artist.getMembers()));
    }
}
