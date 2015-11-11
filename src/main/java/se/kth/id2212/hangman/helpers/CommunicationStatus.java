/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.id2212.hangman.helpers;

/**
 *
 * @author Nikos
 */
public class CommunicationStatus {
    public static final String NEW_GAME = "new_game";
    public static final String GUESSING = "guessing";
    public static final String END_GAME = "end_game";
    public static final String GAME_WON = "game_won";
    public static final String GAME_LOST = "game_lost";
    public static final String WRONG_GUESS = "wrong_guess";
    public static final String WRONG_LETTER = "wrong_letter";
    public static final String CORRECT_LETTER = "correct_letter";
    public static final String UNKNOWN = "unknown";
}
