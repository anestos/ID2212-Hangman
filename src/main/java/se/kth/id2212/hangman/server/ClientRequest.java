/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.id2212.hangman.server;

import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONObject;

/**
 *{"status":"guessing","guess":"","letter":"l"}
 * @author Nikos
 */
public class ClientRequest {
    private final String status;
    private final String letter;
    private final String word;
    private final String guess;
    private Integer myTries;
    
    ClientRequest(JSONObject json, String word, Integer myTries) {
        this.status = (String) json.get("status");
        this.letter = (String) json.get("letter");
        this.guess = (String) json.get("guess");
        this.word = word;
        this.myTries = myTries;
    }
    
    public Boolean isGuessCorrect(){
        return guess.equalsIgnoreCase(word);
    }
    
    public Boolean hasTries(){
        return myTries > 0;
    }
    
    public Integer getTries(){
        return myTries;
    }
    
     public String getLetter(){
        return letter;
    }
     
    public String getGuess(){
        return guess;
    }
    
    public String getWord(){
        return word;
    }
    
    public String getStatus(){
        return status;
    }
    public List<Integer> getPositions(){
        List<Integer> list = new ArrayList<>();
        Integer index = word.toLowerCase().indexOf(letter.toLowerCase());
        while(index >= 0) {
           list.add(index);
           index = word.toLowerCase().indexOf(letter.toLowerCase(), index+1);
        }
        return list;
    }
    
    public boolean isLetterGuess(){
        return letter != null;
    }

    void setTries(int i) {
        myTries = i;
    }
}
