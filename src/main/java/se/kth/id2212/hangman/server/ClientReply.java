/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.id2212.hangman.server;

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
    private List<String> pastTries;
    private final ClientRequest req;
    private Boolean shouldReset = false;
    private String word;
    private Boolean keepAlive = true;
    private PlayerScore playerScore;

    public ClientReply(ClientRequest req, List<String> pastTries, PlayerScore playerScore) {
        this.json = new JSONObject();
        this.pastTries = pastTries;
        this.req = req;
        this.word = req.getWord();
        this.playerScore = playerScore;

        json.put("tries", req.getTries());
        switch (req.getStatus()) {
            case CommunicationStatus.GUESSING:
                // guessing
                if (!req.hasTries()) {
                    json.put("status", CommunicationStatus.GAME_LOST);
                    json.put("word", word);
                    json.put("tries", 0);
                    json.put("letter", req.getLetter());
                    req.setTries(0);
                    this.playerScore.playerLost();
                    json.put("score", this.playerScore.getTotalScore());
                    
                } else {
                    if (req.getGuess() != null && !req.getGuess().equals("")) {
                        logger.info("Guessing a word " + req.getGuess());
                        if (req.isGuessCorrect() && req.hasTries()) {
                            this.playerScore.playerWon();                            
                            json.put("status", CommunicationStatus.GAME_WON);
                            json.put("word", word);
                            json.put("letter", "");
                            json.put("score", this.playerScore.getTotalScore());
                        } else {
                            json.put("status", CommunicationStatus.WRONG_GUESS);
                            json.put("word", maskWord());
                            json.put("letter", "");
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
                                this.playerScore.playerWon();
                                json.put("score", this.playerScore.getTotalScore());                                
                            } else {
                                json.put("status", CommunicationStatus.CORRECT_LETTER);
                            }
                        } else {
                            json.put("status", CommunicationStatus.WRONG_LETTER);
                            json.put("word", maskWord());
                            json.put("letter", req.getLetter());
                            req.setTries(req.getTries() - 1);
                        }
                    } else {
                        json.put("status", CommunicationStatus.UNKNOWN);
                        json.put("word", maskWord());
                        json.put("letter", req.getLetter());
                    }
                    json.put("tries", req.getTries());
                }
                break;
            case CommunicationStatus.END_GAME:
                json.put("status", CommunicationStatus.END_GAME);
                keepAlive = false;
                break;
            case CommunicationStatus.NEW_GAME:
                pastTries.clear();
                json.put("word", maskWord());
                json.put("status", CommunicationStatus.NEW_GAME);
                json.put("letter", "");
                json.put("score", this.playerScore.getTotalScore());
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

    public Boolean getKeepAlive() {
        return keepAlive;
    }

}
