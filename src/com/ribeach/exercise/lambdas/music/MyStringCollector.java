/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ribeach.exercise.lambdas.music;

import java.util.Collections;
import java.util.Set;
import java.util.StringJoiner;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 *
 * @author Melissa
 */
public class MyStringCollector implements Collector<String, StringJoiner, String>{
    
    String delim, prefix, suffix;
    
    MyStringCollector(String delim, String prefix, String suffix) {
        this.delim = delim;
        this.prefix = prefix;
        this.suffix = suffix;
    }
    
    @Override
    public Supplier<StringJoiner> supplier() {
        return () -> new StringJoiner(delim, prefix, suffix);
    }

    @Override
    public BiConsumer<StringJoiner, String> accumulator() {
        return (stringJoiner, newElement) -> stringJoiner.add(newElement);
    }

    @Override
    public BinaryOperator<StringJoiner> combiner() {
        return (stringJoiner, other) -> stringJoiner.merge(other);
    }

    @Override
    public Function<StringJoiner, String> finisher() {
        return (stringJoiner) -> stringJoiner.toString();
    }

    @Override
    public Set<Characteristics> characteristics() {
        // throw new UnsupportedOperationException("Not supported yet.");
        return (Collections.EMPTY_SET);
    }
}
