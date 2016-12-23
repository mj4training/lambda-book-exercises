/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ribeach.exercise.lambdas;

import java.text.SimpleDateFormat;

/**
 *
 * @author Melissa
 */
public class SafeDateFormatter {
   
    /*
     * Declaring a thread-safe date formatter variable.
     * Factory functional interface Supplier<T> instantiates the non-thread-safe class
     * which is used to initialize a TreadLocal date formatter.
     * 
     * static method withInitial is new in JRE 8
     */
    public static ThreadLocal<SimpleDateFormat> formatter
            = ThreadLocal.withInitial(() -> new SimpleDateFormat("dd-MMM-yyyy"));
            
}
