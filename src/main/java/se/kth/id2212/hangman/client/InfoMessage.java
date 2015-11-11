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
public interface InfoMessage {
    String NOT_CONNECTED = "Server unavailable, try again later";
    String CONNECTING = "Trying to connect, please wait";
    String UNKNOWN_HOST = "Don't know about host: ";
    String NO_IO_CONNECTION = "Couldn't get I/O for the connection to: ";
    String GAME_STARTED = "Game started! Good luck";
    String NUMBER_OF_LIFES = "Lifes remaining: ";
    String GAME_WON = "Congratulations, you won the game!!";
    String GAME_LOST = "Game lost, but you can try again!";
}
