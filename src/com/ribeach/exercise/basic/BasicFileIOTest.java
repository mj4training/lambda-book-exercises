/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ribeach.exercise.basic;

import java.io.*;
import java.util.regex.PatternSyntaxException;

/**
 *
 * @author Melissa
 */
public class BasicFileIOTest {
    
    public static void main(String[] args) {
        
        String inFilePath = "bio_in.txt";
        String outFilePath = "bio_out.txt";
        
        String line;
        String[] words;
        
        switch (args.length) {
            case 1:
                inFilePath = args[0];
                break;
            case 2:
                inFilePath = args[0];
                outFilePath = args[1];
                break;
            default:
                if (args.length > 2) {
                    System.out.println("Incorrect usage. BasicFileIO [inFile] [outFile]"); 
                    return;
                }
        }
        
        try (BufferedReader bfr = new BufferedReader(new FileReader(inFilePath));
                PrintWriter pfw = new PrintWriter(new BufferedWriter(new FileWriter(outFilePath)))) {
            
                do {
                    line = bfr.readLine();
                    if (line != null) {
                        try {
                            words = line.split("\\s+");
                            for (String w: words) {
                                pfw.println(w);
                            }
                        } catch (PatternSyntaxException exc) {
                            System.out.println("Parsing exception op: " + exc.getMessage());
                        }
                    }
                } while (line != null);
                        
        } catch (IOException exc) {
            System.out.println("File exception op: " + exc.getMessage());
        }
    }
}
