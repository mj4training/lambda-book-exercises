/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ribeach.exercise.lambdas.music;

import static com.ribeach.exercise.lambdas.music.MySampleData.*;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

/**
 *
 * @author Melissa
 */
public class MyAlbumStreamTest {
        public static void main(String[] args) {
        
        List<MyAlbum> u2Albums = Arrays.asList(joshuaTree, rattleAndHum);

        System.out.println("================ TEST 1 ===============");
        
        System.out.println("Chapter 3 exercise 1c. Return albums with at most 3 tracks ......"); 
        
        u2Albums.stream().filter(album -> album.getTracks().count() <= 3)
                .map(album -> (String) album.getName() + " has at most 3 tracks")
                .forEach(System.out::println);
        
        /*
         * Chapter 4. Use specialization IntStream via mapToInt() for better performance
         */
        System.out.println("================ TEST 2 ===============");
        
        int albumLength = rattleAndHum.getTracks()
                .mapToInt(track -> track.getLength())
                .reduce(0, (totalTime, trackLen) -> totalTime + trackLen);
        
        System.out.println(rattleAndHum.getName() + " total track length is " + albumLength);
        
        /*
         * Specialization streams support summaryStatistics() which support
         * min, max, average and sum
         */
        IntSummaryStatistics trackLengthStats = rattleAndHum.getTracks()
               .mapToInt(track -> track.getLength())
               .summaryStatistics();

        System.out.printf("Max: %d, Min: %d, Average: %f, Sum: %d \n",
                      trackLengthStats.getMax(),
                      trackLengthStats.getMin(),
                      trackLengthStats.getAverage(),
                      trackLengthStats.getSum());
        }
}
