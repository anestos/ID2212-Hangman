/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.id2212.hangman.server;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nikos
 */
public class Dictionary {

    private static final Dictionary instance = new Dictionary();
    private List<String> words = new ArrayList<>();

    private Dictionary() {
        Scanner inFile1;
        String token1;
        try {
            inFile1 = new Scanner(new File("words.txt"));
            while (inFile1.hasNext()) {
                token1 = inFile1.nextLine();
                words.add(token1);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Dictionary.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static Dictionary getInstance() {
        return instance;
    }

    protected String randomWord() {
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(words.size());
        return words.get(index);
    }
}
