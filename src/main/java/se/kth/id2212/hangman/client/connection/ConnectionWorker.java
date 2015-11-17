/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.id2212.hangman.client.connection;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import se.kth.id2212.hangman.client.HangmanClient;
import se.kth.id2212.hangman.client.InfoMessage;

/**
 *
 * @author Anestos
 */
public class ConnectionWorker extends SwingWorker<Void, String> {

    private static final Logger logger = LoggerFactory.getLogger(HangmanClient.class);
    private final String text;
    private final BufferedInputStream in;
    private final BufferedOutputStream out;
    private final HangmanClient gui;
  /**
   * Creates an instance of the worker
   * 
     * @param text
     * @param in
     * @param out
     * @param gui
   */
  public ConnectionWorker(String text, BufferedInputStream in, BufferedOutputStream out, HangmanClient gui) {
    this.text = text; 
    this.in=in;
    this.out=out;
    this.gui=gui;
        
  }

  @Override
  protected Void doInBackground() {
      setProgress(0);
      logger.info("Sending: "+ text);
   String result;
        try {
            byte[] toServer = text.getBytes();
            out.write(toServer, 0, toServer.length);
            out.flush();
            
            setProgress(30);
            
            byte[] msg = new byte[4096];
                int bytesRead = 0;
                int n;
                while ((n = in.read(msg, bytesRead, 256)) != -1) {
                    bytesRead += n;
                    if (bytesRead == 4096) {
                        break;
                    }
                    if (in.available() == 0) {
                        break;
                    }
                }
                
            
            String input = new String(Arrays.copyOfRange(msg, 0, bytesRead));
            result = input;
            
            setProgress(70);
            logger.info("Received Response:" +input);

        } catch (IOException e) {
           
            
            result = InfoMessage.FAILED_TO_SEND_MSG + e.getMessage();
            logger.info(result);
            setProgress(70);
        }
        
        publish(result);
        
      setProgress(100);
    return null;
  }

  @Override
  protected void process(final List<String> chunks) {
      // update the gui
      for (String notif: chunks) {
        gui.showResult(notif);
      }
  }
}