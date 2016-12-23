/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ribeach.exercise.lambdas;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 *
 * @author Melissa
 */
public class MyTransformArrayTest {
    public static void main(String[] args) {

        System.out.println("================ TEST 1 ===============");
        MyTransformArray<Double> sqrts = (d) -> {
            for(int i=0; i < d.length; i++) {
                d[i] = Math.sqrt(d[i]);
            }
        };
        
        Double[] dbls = {1.0, 2.0, 3.0, 4.0};
        
        System.out.println("Before transform: " + Arrays.toString(dbls));
        
        sqrts.transform(dbls);
        
        System.out.println("After transform: " + Arrays.toString(dbls));
        
        System.out.println("================ TEST 2 ===============");
        /*
         * Alternative ways to sum up array of values
         * (1) Use reduce()
         * (2) Use Double.sum()
         */
        Double[] myDbls = {2.0, 3.0, 4.0, 5.0};
        
        Double sumOfDbls = Arrays.stream(myDbls).reduce(0.0, (sum, element) -> sum + element);
        
        System.out.println("Sum of array of doubles 1st way: " + sumOfDbls.toString());
       
        // This works because there is a static method sum() for Double
        Double sumOfDbls2 = Arrays.stream(myDbls).reduce(0.0, Double::sum);
        
        System.out.println("Sum of array of doubles 2nd way: " + sumOfDbls2.toString());
        
        System.out.println("================ TEST 3 ===============");
        
        System.out.println("Chapter 3 exercise 1a. Call method to add up numbers ......");
        
        System.out.println("Add up 3, 4, 5. Total is: " + addupNums(Arrays.asList(3,4,5).stream()));
    }
    
    static int addupNums(Stream<Integer> numbers) {
        return(numbers.reduce(0,(sum, element) -> sum + element));
    }
}
