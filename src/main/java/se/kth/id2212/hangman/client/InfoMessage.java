/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.id2212.hangman.client;

/**
 *
 * @author Anestos
 */
public class InfoMessage {
    public static final String NOT_CONNECTED = "Server unavailable";
    public static final String CONNECTING = "Trying to connect, please wait";
    public static final String UNKNOWN_HOST = "Cannot find host: ";
    public static final String NO_IO_CONNECTION = "Cannot connect to: ";
    public static final String DISCONNECTED_FROM = "Disconnected from: ";
    public static final String GAME_STARTED = "Game started! Good luck. ";
    public static final String NUMBER_OF_LIFES = "Lifes remaining: ";
    public static final String GAME_WON = "Congratulations, you won the game!!";
    public static final String GAME_LOST = "Game lost, but you can try again!";
    public static final String NOT_VALID_PORT = "The port you chose is not valid";
    public static final String FAILED_TO_SEND_MSG = "Failed to send message. ";
    public static final String UNKNOWN_MSG = "Unknown message.";
    public static final String GUESS_CORRECT = "You guessed correctly! ";
    public static final String GUESS_WRONG = "Guess was wrong. ";
}
