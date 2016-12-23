/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ribeach.exercise.lambdas;

/**
 *
 * @author Melissa
 */
public class CalculateTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // First example using Function<T, R>
        MyFunction<Float, Integer> roundIt = x -> Math.round(x);
        
        float fraction = 35.6f;
        System.out.println("Rounding of " + fraction + " = " + roundIt.apply(fraction)); 
        
        // Second example using Function<T, R>
        MyFunction<Double, String> squareRootOf = x -> {
            Double root = Math.sqrt(x);
            return root.toString();
        };

        double number = 16.0;
        System.out.println("Square root of " + number + " = " + calculateAsString(number, squareRootOf)); 
    }
    
    /**
     * Example method which takes a functional interfaces as an argument
     */
    static String calculateAsString(double inputNo, MyFunction<Double,String> function) {
        
        return(function.apply(inputNo));
    }
    
}
