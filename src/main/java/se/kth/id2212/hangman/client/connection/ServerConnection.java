package se.kth.id2212.hangman.client.connection;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import se.kth.id2212.hangman.client.HangmanClient;
import se.kth.id2212.hangman.client.InfoMessage;
import se.kth.id2212.hangman.client.MainPanel;
import se.kth.id2212.hangman.client.Request;

/**
 * Handles all communication with the Hangman server.
 */
public class ServerConnection implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(HangmanClient.class);

    private final String host;
    private final Integer port;
    private final HangmanClient gui;
    private final LinkedBlockingQueue<String> strings
            = new LinkedBlockingQueue<>();
    private BufferedInputStream in;
    private BufferedOutputStream out;
    private final MainPanel mainPanel;
    private Socket clientSocket;

    /**
     * Creates a new instance. Does not connect to the server.
     *
     * @param gui The client gui object.
     * @param host The reverse server host name.
     * @param port The reverse server port number.
     * @param mainPanel
     */
    public ServerConnection(String host, Integer port, HangmanClient gui, MainPanel mainPanel) {
        this.host = host;
        this.port = port;
        this.gui = gui;
        this.mainPanel = mainPanel;
    }

    /**
     * The run method of the communication thread. First connects to the server
     * using the host name and port number specified in the constructor. Second
     * waits to receive a string from the gui and sends that to the reverse
     * server. This is done once, then the thread dies.
     */
    @Override
    public void run() {
        connect();
    }

    /**
     * Connects to the server using the host name and port number specified in
     * the constructor.
     */
    void connect() {
        mainPanel.changeInfoLabel(InfoMessage.CONNECTING);
        try {
            clientSocket = new Socket(host, port);
            in = new BufferedInputStream(clientSocket.getInputStream());
            out = new BufferedOutputStream(clientSocket.getOutputStream());
            gui.connected(); 
            Request req = new Request();
            sendToServer(req.getJson().toJSONString());
            logger.info("Sending new game request");
        } catch (UnknownHostException e) {
            mainPanel.changeInfoLabel(InfoMessage.UNKNOWN_HOST + host);
            logger.info(InfoMessage.UNKNOWN_HOST + host);
            gui.notConnected(InfoMessage.UNKNOWN_HOST + host);
        } catch (IOException e) {
            mainPanel.changeInfoLabel(InfoMessage.NO_IO_CONNECTION + host);
            logger.info(InfoMessage.NO_IO_CONNECTION + host);
            gui.notConnected(InfoMessage.NO_IO_CONNECTION + host);
        }
    }

    public void disconnect() {
        Request req = new Request(1);
        sendToServer(req.getJson().toJSONString());
    }

    public Socket getSocket() {
        return clientSocket;
    }

    public BufferedInputStream getInput() {
        return in;
    }

    public BufferedOutputStream getOutput() {
        return out;
    }

    /**
     *
     * @param text The json string to send to the server.
     */
    public void sendToServer(String text) {
       ConnectionWorker worker = new ConnectionWorker(text, in, out, gui);
       worker.execute();
    }

    /**
     * Waits to receive a string from the gui and sends that to the reverse
     * server.
     */
}
