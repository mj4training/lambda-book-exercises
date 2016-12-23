/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ribeach.exercise.lambdas.music;

import static com.ribeach.exercise.lambdas.music.MySampleData.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.StringJoiner;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;

/**
 *
 * @author Melissa
 */
public class MyArtistStreamTest {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        List<MyArtist> allArtists = Arrays.asList(u2, theBeatles, vanMorrison);

        /*
         * Three different ways to count Irish artists
         */
        System.out.println("================ TEST 1 - Filter and Reduce ===============");
        int artistCount = 0;
        // Old style list iteration
        for (MyArtist artist : allArtists) {
            if (artist.isFrom("Irish")) {
                artistCount++;
            }
        }
        System.out.println("Irish artist Count: " + artistCount);
        
        artistCount = 0;
        // This was auto-converted to a functional interface by NetBeans
        artistCount = allArtists.stream().filter((artist) -> (artist.isFrom("Irish"))).map((_item) -> 1).reduce(artistCount, Integer::sum);
        System.out.println("Irish artist Count via stream1 " + artistCount);
        
        // This is a simpler variant taken from the book. count() is an eagar method which activates stream result.
        artistCount = (int) allArtists.stream().filter(artist -> (artist.isFrom("Irish"))).count();
        System.out.println("Irish artist Count via stream2: " + artistCount);
        
        /*
         * Print U2 member names in uppercase.
         * Use map() to convert a stream of MyArtist to Strings
         */
        System.out.println("================ TEST 2 - Map ===============");
        List<String> bigMembersOfU2 = u2.getMembers()
                .map(member -> member.getName().toUpperCase())
                .collect(toList());
        System.out.println("Uppercase members of U2: " + bigMembersOfU2);
        
        // Original member names have not been touched
        List<String> originalMembersOfU2 = u2.getMembers()
                .map(member -> member.getName())
                .collect(toList());
        System.out.println("Original case members of U2: " + originalMembersOfU2);
        
        /*
         * Find best artist based on sales of group and their members
         * Use Comparator.comparing with a lambda identifying the comparaon key method in MyArtist
         */
        System.out.println("================ TEST 3 - Comparing ===============");
        // First print out what the artists collectively sold
        allArtists.stream()
                .forEach(artist -> System.out.println("Artist " + artist.getName()
                        + " collectively sold " + artist.getCollectiveSoldUnits() + " units"));
        
        // Now find the artist who collectively sold the most
        MyArtist topArtist = allArtists.stream().max(Comparator.comparing(artist -> artist.getCollectiveSoldUnits())).get();
        System.out.println("Top artist based on sales: " + topArtist.getName());
    
        MyArtist bottomArtist = allArtists.stream().min(Comparator.comparing(artist -> artist.getCollectiveSoldUnits())).get(); 
        System.out.println("Bottom artist based on sales: " + bottomArtist.getName());
        System.out.println();
        
        // First print out what the artists individually sold
        allArtists.stream()
                .forEach(artist -> System.out.println("Artist " + artist.getName()
                        + " individually sold " + artist.getSoldUnits() + " units"));
        
        // Now find the artist who sold the most using a different key method
        topArtist = allArtists.stream().max(Comparator.comparing(artist -> artist.getSoldUnits())).get();
        System.out.println("Top artist based on sales: " + topArtist.getName());
    
        bottomArtist = allArtists.stream().min(Comparator.comparing(artist -> artist.getSoldUnits())).get(); 
        System.out.println("Bottom artist based on sales: " + bottomArtist.getName());
        
        /*
         * Find all solo artists who have individually sold some units.
         * Use flatMap() to transfrom 1 artist into a stream of artists.
         * Notice that getAllSoloMembers() is defined to execute recursively.
         */
        System.out.println("================ TEST 4 - FlatMap & ForEach ===============");
        
        // if you temporarily add Van Morrison as a member of u2, distinct() eliminates any repeats
        System.out.println("Test distinct ......");
        allArtists.stream()
                .flatMap(artist -> artist.getAllSoloMembers()).distinct()
                .forEach(System.out::println);  
        
        System.out.println("\nTest recursion ...... these solo artists are 2 levels deep");
        Arrays.asList(awesomeBand).stream()
                .flatMap(artist -> artist.getAllSoloMembers())
                .forEach(System.out::println);  
        
        System.out.println("\nTest empty stream ......");
        Arrays.asList(adamClayton).stream()
                .flatMap(artist -> artist.getAllSoloMembers()) // this returns an empty stream
                .forEach(System.out::println); 
        
        System.out.println("================ TEST 5 - Optional & Default Method ===============");
        
        System.out.println("Chapter 3 exercise 1b. Return List<String> of artist names & origin ......");        
        
        // getNationality() returns an Optional, so if value is not present, "Unknown" is used
        System.out.println(allArtists.stream()
                .map(artist -> (String)(artist.getName() + " origin is " + artist.getNationality().orElse("Unknown")))
                .collect(toList()));
        
        System.out.println("Chapter 4 exercise 1. Test interface default method getAllMusicians() ......");  
        
        /*
         * awesomeBand is comprised of u2 and theBeatles.
         * getAllMusicians() returns u2 and its members and theBeatles and its members
         */
        awesomeBand.getAllMusicians()
                .map(artist -> artist.getName())
                .forEach(System.out::println);
        
        System.out.println("================ TEST 6 - Partitioning & Grouping ===============");
        
        /*
         * Chapter 5 - try out the Collector partioningBy() method
         * to split a stream into 2 collection - solo and band artists.
         * Begin using method reference notation :: when lambda just calls a method
         */
        Map<Boolean, List<MyArtist>> partionedArtists = awesomeBand.getAllMusicians()
                .collect(partitioningBy(MyArtist::isSolo));
        
        System.out.println("awesomeBand all musicians solo artists ...");
        partionedArtists.get(true).forEach(System.out::println);
        
        System.out.println("awesomeBand all musicians bands ... ");
        partionedArtists.get(false).forEach(System.out::println);
        
        /*
         * Try with a list where it is known there are no solo artists.
         * Members of awesomeBand are u2 and theBeatles
         */
        Map<Boolean, List<MyArtist>> partionedArtists2 = awesomeBand.getMembers()
                .collect(partitioningBy(MyArtist::isSolo));
        
        System.out.println();
        System.out.println("awesomeBand solo artists ... there should be none");
        // ForEach() gracefully handles an empty set of artists
        partionedArtists2.get(true).forEach(System.out::println);
        
        System.out.println("awesomeBand bands ... ");
        partionedArtists2.get(false).forEach(System.out::println);
        
        /*
         * Try collector groupingBy to split artists by nationality.
         * Type if the map key is determined by type that getNationality() returns,
         * in this case it returns Optional<String>.
         */
        Map<Optional<String>, List<MyArtist>> artistByNationality = awesomeBand.getAllMusicians()
                .collect(groupingBy(MyArtist::getNationality));
        
        System.out.println();
        System.out.println("awesomeBand all musicians grouped by nationality ...");
        
        // Notice that Adam Clayton is associated with Optional.empty
        System.out.println(artistByNationality);
        
        /*
         * Print them out using a BiConsumer function which uses key & value of Map.
         * ForEach() could have been passed (k,v) but types were made explicit to avoid casting.
         * This example uses the joining() Collector to produce a comma-separated string
         * in square braces
         */
        System.out.println();
        System.out.println("awesomeBand all musicians grouped by nationality, printed using Map.forEach() and joining()");
        
        artistByNationality.forEach((Optional<String> k,List<MyArtist> v)-> {
            System.out.println("Nationality: "+ k.orElse("Unknown") +"\n"+
                v.stream().map(MyArtist::getName).collect(joining(", ", "[ ", " ]")));
        });
        
        /*
         * Use groupingBy() with a 2nd parameter which is another collector which
         * is applied to each grouped bucket of artists by nationality, mapping
         * bucket to a list of names
         */
        System.out.println();
        System.out.println("awesomeBand all musicians grouped by nationality, mapping to a list of names using downstream collector");
        
        Map<Optional<String>, List<String>> artistByNationalityMapped = awesomeBand.getAllMusicians()
                .collect(groupingBy(MyArtist::getNationality, mapping(MyArtist::getName, toList())));
        
        artistByNationalityMapped.forEach((k, v) -> 
            System.out.println("Nationality: " + k.orElse("Unknown") + " ... mapped to artist names: " + v));
        
        /*
         * Use groupingBy() with a 2nd parameter which is another collector which
         * is applied to each grouped bucket of artists by nationality, reducing
         * the bucket to a count of elements.
         */
        System.out.println();
        System.out.println("awesomeBand all musicians grouped by nationality, processing each bucket using counting() downstream collector");
        
        Map<Optional<String>, Long> artistByNationalityCounted = awesomeBand.getAllMusicians()
                .collect(groupingBy(MyArtist::getNationality, counting()));
        
        artistByNationalityCounted.forEach((k, v) -> 
            System.out.println("Nationality: " + k.orElse("Unknown") + " ... Count of artists: " + v));
        
        /*
         * Use groupingBy() with a 2nd parameter which is custom-built collector
         * StringCombiner which is applied to each grouped bucket of artists by nationality.
         */
        System.out.println();
        System.out.println("awesomeBand all musicians grouped by nationality, processing each bucket using a custom downstream collector");     
        
        // My custom collector based on the StringJoiner class which is the supplier type
        MyStringCollector msc = new MyStringCollector(":", "#", "#");
                
        Map<Optional<String>, String> artistByNationalityReduced = awesomeBand.getAllMusicians()
                .collect(groupingBy(MyArtist::getNationality,
                        mapping(MyArtist::getName, msc)));
        
        artistByNationalityReduced.forEach((k, v) -> 
            System.out.println("Nationality: " + k.orElse("Unknown") + 
                    " ... Custom collected artist names: " + v));
        
        /*
         * This code fragment should do exactly the same thing as prior code block
         * but it is inefficient at scale because of the amount of new objects
         *
         * WIP: Compile error
         */
        /*
        System.out.println();
        System.out.println("Use JDK StringJoiner class directly to produce the same result");
        
        Map<Optional<String>, StringJoiner> artistByNationalitySJoined = awesomeBand.getAllMusicians()
                .collect(groupingBy(MyArtist::getNationality,
                        reducing(new StringJoiner(":", "#", "#"),
                              artist -> new StringJoiner(":", "#", "#").add(artist.getName()))));
        
        artistByNationalitySJoined.forEach((k, v) -> 
            System.out.println("Nationality: " + k.orElse("Unknown") + " ... StringJoiner collected artist names: " + v));
        */
        
    }
}
