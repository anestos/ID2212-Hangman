/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.id2212.hangman.server;

import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONObject;
import org.slf4j.LoggerFactory;
import se.kth.id2212.hangman.helpers.CommunicationStatus;

/**
 *
 * @author Nikos
 */
public class ClientReply {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(HangmanServer.class);

    private final JSONObject json;
    private List<String> pastTries = new ArrayList<>();
    private final ClientRequest req;
    private Boolean shouldReset = false;
    private String word;

    public ClientReply(ClientRequest req, List<String> pastTries) {
        this.json = new JSONObject();
        this.pastTries = pastTries;
        this.req = req;
        this.word = req.getWord();

        json.put("tries", req.getTries());
        switch (req.getStatus()) {
            case CommunicationStatus.GUESSING:
                // guessing
                if (!req.hasTries()) {
                    json.put("status", CommunicationStatus.GAME_LOST);
                    json.put("word", word);
                    json.put("tries", 0);
                    req.setTries(0);
                } else {
                    if (req.getGuess() != null && !req.getGuess().equals("")) {
                        logger.info("Guessing a word " + req.getGuess());
                        if (req.isGuessCorrect() && req.hasTries()) {
                            json.put("status", CommunicationStatus.GAME_WON);
                            json.put("word", word);
                        } else {
                            json.put("status", CommunicationStatus.WRONG_GUESS);
                            json.put("word", maskWord());
                            req.setTries(req.getTries() - 1);
                        }

                    } else if (req.getLetter() != null && !req.getLetter().equals("")) {
                        logger.info("Guessing a letter " + req.getLetter());
                        List<Integer> positions = req.getPositions();
                        if (positions.size() > 0) {
                            json.put("word", maskWord());
                            json.put("letter", req.getLetter());
                            if (!maskWord().contains("_")) {
                                json.put("status", CommunicationStatus.GAME_WON);
                            } else {
                                json.put("status", CommunicationStatus.CORRECT_LETTER);
                            }
                            // check if got all letters
                            //if (got all letters)
                        } else {
                            json.put("status", CommunicationStatus.WRONG_LETTER);
                            json.put("word", maskWord());
                            json.put("letter", req.getLetter());
                            req.setTries(req.getTries() - 1);
                        }
                    } else {
                        json.put("status", CommunicationStatus.UNKNOWN);
                        json.put("word", maskWord());
                    }
                    json.put("tries", req.getTries());
                }
                break;
            case CommunicationStatus.END_GAME:
                // ending game
                break;
            case CommunicationStatus.NEW_GAME:
                pastTries.clear();
                json.put("word", maskWord());
                json.put("status", CommunicationStatus.NEW_GAME);
                shouldReset = true;
                break;
            default:
        }

    }

    public JSONObject getJson() {
        return json;
    }

    private String maskWord() {
        String listString = ".";
        if (!pastTries.isEmpty()) {
            listString = "[^";
            listString = pastTries.stream().map((s) -> s).reduce(listString, String::concat);
            listString += "]";
        }
        return word.replaceAll("(?i)" + listString, "_");
    }

    public Boolean shouldReset() {
        return shouldReset;
    }

    public void setWord(String text) {
        word = text;
        json.put("word",maskWord());
    }
    
    public void setTries(Integer tries) {
        json.put("tries",tries);
    }

}
