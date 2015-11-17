/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.id2212.hangman.server;

import java.io.*;
import java.net.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 *
 * @author Anestos
 */
public class HangmanServer {
    
    private static final Logger logger = LoggerFactory.getLogger(HangmanServer.class);

    private static final int PORT = 4444;
    private static final Integer AVAILABLE_TRIES = 10;
    
    /**
     * Starts the reverse server.
     *
     * @param args No command line arguments are used.
     */
    public static void main(String[] args) {
        boolean listening = true;
        ServerSocket serverSocket =null;
        Dictionary.getInstance();

        try {
            serverSocket = new ServerSocket(PORT);
            logger.info("Listening port: "+ PORT);
            while (listening) {
                Socket clientSocket = serverSocket.accept();
                logger.info("Incoming Connection, creating new Thread");

                new Thread(new ConnectionHandler(clientSocket, AVAILABLE_TRIES)).start();   
            }
            serverSocket.close();
        } catch (IOException e) {
            logger.info("Could not listen on port: " + PORT);
        } finally {
            try {
                if (serverSocket!=null){
                    serverSocket.close();
                }
            } catch (IOException ex) {
                logger.info(ex.getMessage());
            }
        }
    }
}
