package com.ribeach.exercise.lambdas.music;

import java.util.List;
import java.util.Optional;

public final class MyArtists {

    private final List<MyArtist> artists;

    public MyArtists(List<MyArtist> artists) {
        this.artists = artists;
    }

    public Optional<MyArtist> getArtist(int index) {
        if (index < 0 || index >= artists.size()) {
            return Optional.empty();
        }
        return Optional.of(artists.get(index));
    }

    public String getArtistName(int index) {
        Optional<MyArtist> artist = getArtist(index);
        
        // Optional supports a map
        return artist.map(MyArtist::getName)
                     .orElse("unknown");
    }
}
