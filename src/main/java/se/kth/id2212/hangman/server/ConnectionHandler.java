package se.kth.id2212.hangman.server;

import se.kth.id2212.hangman.helpers.HangmanJsonParser;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A connection handler for the reverse server. Sleeps the specified time before
 * returning the reversed string.
 */
public class ConnectionHandler implements Runnable {
    
    private static final Logger logger = LoggerFactory.getLogger(HangmanServer.class);

    private static final int DELAY_TO_MILLISECS = 3000;
    private final Socket clientSocket;
    private Boolean threadAlive = true;
    private String word;
    private final Integer availableTries;
    private Integer myTries;
    private List<String> pastTries = new ArrayList<>();
    /**
     * Creates anew instance.
     *
     * @param clientSocket This socket should be connected to a reverse client.
     */
    ConnectionHandler(Socket clientSocket, Integer availableTries) {
        this.clientSocket = clientSocket;
        this.word = "";
        this.availableTries = availableTries;
        this.myTries = availableTries;
        
    }
    public void close(){
        logger.info("Closing connection");
        threadAlive = false;
    }
    
    public void resetGame(){
        myTries = availableTries;
        pastTries = new ArrayList<>();
        word = Dictionary.getInstance().randomWord();
        logger.info("Starting Game. Word:" + word);

    }
    /**
     * Reads a string from the client, sleeps the specified time and
     * returns the reversed string.
     */
    @Override
    public void run() {
        try {
            BufferedInputStream in = new BufferedInputStream(clientSocket.getInputStream());
            BufferedOutputStream out = new BufferedOutputStream(clientSocket.getOutputStream());
            
            while(threadAlive && !clientSocket.isClosed()){
                byte[] msg = new byte[4096];
                int bytesRead = 0;
                int n;
                while ((n = in.read(msg, bytesRead, 256)) != -1) {
                    logger.info("Received msg!");
                    bytesRead += n;
                    if (bytesRead == 4096) {
                        break;
                    }
                    if (in.available() == 0) {
                        break;
                    }
                }
                
//                Thread.sleep(DELAY_TO_MILLISECS);
                String input = new String(Arrays.copyOfRange(msg, 0, bytesRead));
                logger.info("received"+input);
                HangmanJsonParser parser = new HangmanJsonParser(input);
                ClientRequest req = new ClientRequest(parser.getJson(), word, myTries);
                if (req.isLetterGuess()){
                    pastTries.add(req.getLetter());
                }
                
                ClientReply resp = new ClientReply(req, pastTries);
                myTries = req.getTries();
                if (resp.shouldReset()){
                    resetGame();
                    resp.setWord(word);
                    resp.setTries(myTries);
                }
                
                logger.info("input: "+ parser.getJson().toJSONString());
                out.write(resp.getJson().toJSONString().getBytes());
                logger.info("output: "+ resp.getJson().toJSONString());
                out.flush();
                if (msg[0]==13){
                    close();
                }
            }
            clientSocket.close();
            logger.info("Connection lost");
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }
}
