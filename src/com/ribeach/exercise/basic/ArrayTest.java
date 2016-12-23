/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ribeach.exercise.basic;

import java.util.Arrays;

/**
 *
 * @author Melissa
 */
public class ArrayTest {
    
    public static void main(String args[]) {
        
        try {
            // TEST 1 - Use Arrays class to print
            int nums[] = {1,2,3,4,5};
            // Prints a comma-separated list of numbers
            System.out.println("nums: " + Arrays.toString(nums));

            // TEST 2 - Use Arrays class to sort
            Integer wrappernums[] = {7,6,5,8,9}; // auto-box conversion
            try {
                Arrays.sort(wrappernums);
            } catch(Exception e) {
                System.err.println("Exception: " + e.getMessage());
            }
            // Prints sorted list of numbers
            System.out.println("wrappernums: " + Arrays.toString(wrappernums));

            // TEST 3 - Integer array
            Integer inums[] = new Integer[5];
            int i = inums.length;
            for (Integer n: inums) {
                n = new Integer(i--); // Initializes n but not array element
            }
            // Prints list of nulls whether or not inums is cast
            System.out.println("inums: " + Arrays.toString(inums));
            for (i = 0; i < inums.length; i++) {
                inums[i] = i+1;
            }
            // Prints a list of numbers
            System.out.println("inums: " + Arrays.toString(inums));

            // TEST 4 - Object array
            Object onums[] = new Object[5];
            for (i = 0; i < onums.length; i++) {
                onums[i] = i+1;
            }
            // Prints a list of numbers
            System.out.println("onums: " + Arrays.deepToString(onums));
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
