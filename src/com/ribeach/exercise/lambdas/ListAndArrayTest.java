/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ribeach.exercise.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 *
 * @author Melissa
 */
public class ListAndArrayTest {
    public static void main(String[] args) {

        /*
         * Use asList() and toArray() to convert between List and an Array
         */
        System.out.println("================ TEST 1 ===============");
        List<String> stooges = Arrays.asList("Larry", "Moe", "Curly");
        
        System.out.println("Stooges list: " + stooges);
         
        String[] stoogeItems = (String[])stooges.toArray();
        
        System.out.println("Stooges array: " + Arrays.toString(stoogeItems));
        /*
         * Use Iterable default foreach() method to consume each element with a lambda I provide
         */
        System.out.println("================ TEST 2 ===============");
        
        Consumer<String> printStooge = stooge -> System.out.println(stooge);
                
        stooges.forEach(printStooge);
        
        Consumer<String> bigStooges = stooge -> System.out.println(stooge.toUpperCase());
        
        Arrays.asList(stoogeItems).forEach(bigStooges);
    }
}
