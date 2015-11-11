/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.id2212.hangman.server;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Nikos
 */
public class ServerParser {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(HangmanServer.class);

    private JSONObject json;
    public ServerParser(String input){
        JSONParser parser = new JSONParser();
        Object obj;
        try {
            obj = parser.parse(input);
            this.json = (JSONObject) obj;

        } catch (ParseException ex) {
            logger.info(ex.getMessage());
        }
    }
    
    public JSONObject getJson(){
        return json;
    }
}
