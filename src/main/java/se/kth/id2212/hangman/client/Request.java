/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.id2212.hangman.client;

import org.json.simple.JSONObject;
import se.kth.id2212.hangman.helpers.CommunicationStatus;

/**
 *
 * @author Anestos
 */
public class Request {

    private final JSONObject json;

    public Request(String toSend) {
        this.json = new JSONObject();
        this.json.put("status", CommunicationStatus.GUESSING);
        if (toSend.length() > 1) {
            this.json.put("guess", toSend);
            this.json.put("letter", "");
        } else {
            this.json.put("guess", "");
            this.json.put("letter", toSend);
        }
    }
    
     public Request(Integer i) {
        this.json = new JSONObject();
        this.json.put("status", CommunicationStatus.END_GAME);
     }

    public Request() {
        this.json = new JSONObject();
        this.json.put("status", CommunicationStatus.NEW_GAME);
    }
    public JSONObject getJson(){
        return json;
    }
}
