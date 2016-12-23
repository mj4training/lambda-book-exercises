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
 * @param <R> Result type of function
 * 
 * Not needed because java.util.function has one of these interfaces
 */
@FunctionalInterface
public interface MyFunction<T, R> {

    /**
     *
     * @param t
     * @return
     */
    public R apply(T t);
}
