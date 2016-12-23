/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ribeach.exercise.basic;

/**
 *
 * @author Melissa
 */
public class ExceptionTestMyException extends Exception {
    
    @Override
    public String toString(){
        return("This is my exception");
    }
}