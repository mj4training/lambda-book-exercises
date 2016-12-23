/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ribeach.exercise.lambdas;

/**
 *
 * @author Melissa
 * @param <T> Type of argument to function
 * 
 * Example of a lambda taking an array argument
 */
@FunctionalInterface
public interface MyTransformArray<T> {

    /**
     *
     * @param t
     */
    public void transform(T[] t);
}
