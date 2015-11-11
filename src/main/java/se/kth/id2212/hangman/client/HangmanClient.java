package se.kth.id2212.hangman.client;



import javax.swing.*;
import java.awt.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * GUI for the Hangman client.
 */
public class HangmanClient extends JPanel {
    
    private static final Logger logger = LoggerFactory.getLogger(HangmanClient.class);

    private JButton connectButton;
    private JButton reverseButton;
    private JLabel resultLabel = new JLabel();
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
        frame.setContentPane(new HangmanClient());
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void buildGui() {
        setLayout(new FlowLayout());
        mainPanel = new MainPanel(this);
        add(mainPanel);
        add(resultLabel);
    }

    /**
     * Callback method for the network layer. Should be invoked when
     * successfully connected to the server.
     */
    void connected() {
        SwingUtilities.invokeLater(() -> {
            logger.info("Connected to server");
            mainPanel.showGameGui();
        });
    }
    
    void notConnected(){
        SwingUtilities.invokeLater(() -> {
            mainPanel.notConnected();
        });
    }

    /**
     * Callback method for the network layer. Used to show the result
     * of the call to the reverse server.
     *
     * @param result The result of the reversal attempt. Should contain
     *               either the reversed string or an error message.
     */
    void showResult(final String result) {
        SwingUtilities.invokeLater(() -> {
            logger.info(result);
        });
    }
}
