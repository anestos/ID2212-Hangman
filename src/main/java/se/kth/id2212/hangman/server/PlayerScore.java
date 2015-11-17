/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.id2212.hangman.server;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anestos
 */
public class PlayerScore {
    private Integer score;
    private Integer gamesWon;
    private Integer gamesLost;
    
    public PlayerScore(){
        this.score = 0;
        this.gamesLost = 0;
        this.gamesWon = 0;
    }
    
    public void playerWon(){
        gamesWon++;
        score++;
    }
    public void playerLost(){
        gamesLost++;
        score--;
    }
    public String getScore(){
        return "Player won " + gamesWon + " matches and lost "+ gamesLost + " matches. Total Score: "+score;
    }
    
    public List<Integer> getTotalScore(){
        List<Integer> scores = new ArrayList<>();
        scores.add(score);
        scores.add(gamesWon);
        scores.add(gamesLost);
        return scores;
    }
}
