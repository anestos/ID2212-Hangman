package se.kth.id2212.hangman.client;



import se.kth.id2212.hangman.client.connection.ServerConnection;
import javax.swing.*;
import java.awt.*;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import se.kth.id2212.hangman.helpers.CommunicationStatus;
import se.kth.id2212.hangman.helpers.HangmanJsonParser;
/**
 * GUI for the Hangman client.
 */
public class HangmanClient extends JPanel {
    
    private static final Logger logger = LoggerFactory.getLogger(HangmanClient.class);

    private ServerConnection connection;
    private MainPanel mainPanel;
    /**
     * Creates a new instance and builds the gui.
     */
    HangmanClient() {
        buildGui();
    }

    /**
     * The main method of the client. Starts the gui.
     *
     * @param args No command line parameters are used.
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hangman Client");
        HangmanClient client = new HangmanClient();
        frame.setContentPane(client);
        frame.pack();
        client.initFocus();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    private void buildGui() {
        setLayout(new FlowLayout());
        mainPanel = new MainPanel(this);
        add(mainPanel);
    }
    
    public void takeAGuess(String text){
        Request req = new Request(text);
        connection.sendToServer(req.getJson().toJSONString());
    }
    /**
     * Callback method for the network layer. Should be invoked when
     * successfully connected to the server.
     */
    public void connected() {
        SwingUtilities.invokeLater(() -> {
            mainPanel.showGameGui();
        });
    }
    
    public void notConnected(String reason){
        SwingUtilities.invokeLater(() -> {
            mainPanel.notConnected(reason);
        });
    }

    /**
     * Callback method for the network layer. Used to show the result
     * of the call to the reverse server.
     *
     * @param result The result of the reversal attempt. Should contain
     *               either the reversed string or an error message.
     */
    public void showResult(final String result) {
        SwingUtilities.invokeLater(() -> {
            logger.info("server replied: "+result);
            HangmanJsonParser parser = new HangmanJsonParser(result);
            handleResult(parser.getJson());
        });
    }

    public void initFocus() {
        mainPanel.initFocus();
    }
    
    public void connect(String host, int port){
        connection =
                    new ServerConnection(host, port, this, mainPanel);
            new Thread(connection).start();
    }

    void disconnect() {
        connection.disconnect();
    }

    private void handleResult(JSONObject json) { 
        String spaced;
        switch ((String)json.get("status")){

                case CommunicationStatus.GAME_WON:
                    mainPanel.changeInfoLabel(InfoMessage.GAME_WON);
                    mainPanel.disableGuessButton();
                    //game won
                    spaced = ((String)json.get("word")).replace("", " ").trim(); 
                    mainPanel.changeWordHint("Word: " + spaced);
                    break;
                case CommunicationStatus.GAME_LOST:
                    mainPanel.changeInfoLabel(InfoMessage.GAME_LOST);
                    //game lost
                    spaced = ((String)json.get("word")).replace("", " ").trim(); 
                    mainPanel.changeWordHint("Word: " + spaced);
                    mainPanel.disableGuessButton();
                    mainPanel.removeLetterListeners();
                    break;
                case CommunicationStatus.WRONG_LETTER:
                    mainPanel.changeInfoLabel(InfoMessage.GUESS_WRONG+InfoMessage.NUMBER_OF_LIFES+json.get("tries"));
                    // wrong letter
                    mainPanel.setLetterBG((String)json.get("letter"), Color.red);
                    break;
                case CommunicationStatus.WRONG_GUESS:
                    mainPanel.changeInfoLabel(InfoMessage.GUESS_WRONG+InfoMessage.NUMBER_OF_LIFES+json.get("tries"));
                    // wrong guess
                    break;
                case CommunicationStatus.CORRECT_LETTER:
                    mainPanel.changeInfoLabel(InfoMessage.GUESS_CORRECT+InfoMessage.NUMBER_OF_LIFES+json.get("tries"));
                    //correct letter
                    spaced = ((String)json.get("word")).replace("", " ").trim(); 
                    mainPanel.changeWordHint("Hint: "+ spaced);
                    mainPanel.setLetterBG((String)json.get("letter"), Color.green);                    
                    break;
                case CommunicationStatus.NEW_GAME:
                    mainPanel.changeInfoLabel(InfoMessage.GAME_STARTED+InfoMessage.NUMBER_OF_LIFES+json.get("tries"));
                    spaced = ((String)json.get("word")).replace("", " ").trim();
                    mainPanel.changeWordHint("Hint: "+ spaced);
                    break;
                case CommunicationStatus.UNKNOWN:
                default:
                    // unknown message
                    mainPanel.changeInfoLabel(InfoMessage.UNKNOWN_MSG);

        }
    }
}
