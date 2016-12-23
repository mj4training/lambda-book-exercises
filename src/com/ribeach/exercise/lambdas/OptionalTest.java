/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ribeach.exercise.lambdas;

import java.util.Optional;

/**
 *
 * @author Melissa
 */
public class OptionalTest {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // of(), empty(), ofNullable() are all factory methods
        Optional<String> anOp = Optional.of("a");
        
        Optional<String> emptyOp = Optional.empty();
        
        Optional<String> maybeOp = Optional.ofNullable(null);
        
        System.out.println("================ TEST 1 ===============");
        
        if (anOp.isPresent()) {
            System.out.println("Optional variable anOp has a value: " + anOp.get());
        }
        
        if (!emptyOp.isPresent()) {
            System.out.println("Optional variable emptyOp does not have a value");
        }
        
        if (maybeOp.isPresent()) {
            System.out.println("Optional variable maybeOp has a value: " + maybeOp.get());
        } else {
            System.out.println("Optional variable maybeOp does not have a value, so here is a default: " + maybeOp.orElse("b"));
        }    
    }
}
