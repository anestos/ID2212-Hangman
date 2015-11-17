/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.id2212.hangman.client;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Anestos
 */
public class HangmanPanel extends javax.swing.JPanel {

    private static final Logger logger = LoggerFactory.getLogger(HangmanClient.class);

    private final MainPanel mainPanel;
    private final HangmanClient hangmanClient;

    /**
     * Creates new form HangmanPanel
     *
     * @param client
     * @param mainPanel
     */
    public HangmanPanel(HangmanClient client, MainPanel mainPanel) {
        initComponents();
        this.mainPanel = mainPanel;
        this.hangmanClient = client;
        setLabelListeners();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        wordLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lettersFirstRow = new javax.swing.JPanel();
        labelA = new javax.swing.JLabel();
        labelB = new javax.swing.JLabel();
        labelC = new javax.swing.JLabel();
        labelD = new javax.swing.JLabel();
        labelE = new javax.swing.JLabel();
        labelF = new javax.swing.JLabel();
        labelG = new javax.swing.JLabel();
        labelH = new javax.swing.JLabel();
        labelI = new javax.swing.JLabel();
        labelJ = new javax.swing.JLabel();
        labelK = new javax.swing.JLabel();
        labelL = new javax.swing.JLabel();
        labelM = new javax.swing.JLabel();
        lettersSecondRow = new javax.swing.JPanel();
        labelN = new javax.swing.JLabel();
        labelQ = new javax.swing.JLabel();
        labelP = new javax.swing.JLabel();
        labelU = new javax.swing.JLabel();
        labelR = new javax.swing.JLabel();
        labelT = new javax.swing.JLabel();
        labelZ = new javax.swing.JLabel();
        labelY = new javax.swing.JLabel();
        labelV = new javax.swing.JLabel();
        labelS = new javax.swing.JLabel();
        labelO = new javax.swing.JLabel();
        labelW = new javax.swing.JLabel();
        labelX = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        wordGuessTextField = new javax.swing.JTextField();
        guessButton = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        newGameButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        scoreLabel = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(400, 300));

        wordLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        wordLabel.setToolTipText("");
        wordLabel.setPreferredSize(new java.awt.Dimension(400, 50));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(wordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(wordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel4.setMinimumSize(new java.awt.Dimension(400, 56));
        jPanel4.setPreferredSize(new java.awt.Dimension(400, 70));
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.Y_AXIS));

        lettersFirstRow.setMinimumSize(new java.awt.Dimension(400, 28));

        labelA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelA.setText("A");
        labelA.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labelA.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelA.setOpaque(true);
        labelA.setPreferredSize(new java.awt.Dimension(20, 20));
        lettersFirstRow.add(labelA);

        labelB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelB.setText("B");
        labelB.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labelB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelB.setOpaque(true);
        labelB.setPreferredSize(new java.awt.Dimension(20, 20));
        lettersFirstRow.add(labelB);

        labelC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelC.setText("C");
        labelC.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labelC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelC.setOpaque(true);
        labelC.setPreferredSize(new java.awt.Dimension(20, 20));
        lettersFirstRow.add(labelC);

        labelD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelD.setText("D");
        labelD.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labelD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelD.setOpaque(true);
        labelD.setPreferredSize(new java.awt.Dimension(20, 20));
        lettersFirstRow.add(labelD);

        labelE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelE.setText("E");
        labelE.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labelE.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelE.setOpaque(true);
        labelE.setPreferredSize(new java.awt.Dimension(20, 20));
        lettersFirstRow.add(labelE);

        labelF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelF.setText("F");
        labelF.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labelF.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelF.setOpaque(true);
        labelF.setPreferredSize(new java.awt.Dimension(20, 20));
        lettersFirstRow.add(labelF);

        labelG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelG.setText("G");
        labelG.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labelG.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelG.setOpaque(true);
        labelG.setPreferredSize(new java.awt.Dimension(20, 20));
        lettersFirstRow.add(labelG);

        labelH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelH.setText("H");
        labelH.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labelH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelH.setOpaque(true);
        labelH.setPreferredSize(new java.awt.Dimension(20, 20));
        lettersFirstRow.add(labelH);

        labelI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelI.setText("I");
        labelI.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labelI.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelI.setOpaque(true);
        labelI.setPreferredSize(new java.awt.Dimension(20, 20));
        lettersFirstRow.add(labelI);

        labelJ.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelJ.setText("J");
        labelJ.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labelJ.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelJ.setOpaque(true);
        labelJ.setPreferredSize(new java.awt.Dimension(20, 20));
        lettersFirstRow.add(labelJ);

        labelK.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelK.setText("K");
        labelK.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labelK.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelK.setOpaque(true);
        labelK.setPreferredSize(new java.awt.Dimension(20, 20));
        lettersFirstRow.add(labelK);

        labelL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelL.setText("L");
        labelL.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labelL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelL.setOpaque(true);
        labelL.setPreferredSize(new java.awt.Dimension(20, 20));
        lettersFirstRow.add(labelL);

        labelM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelM.setText("M");
        labelM.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labelM.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelM.setOpaque(true);
        labelM.setPreferredSize(new java.awt.Dimension(20, 20));
        lettersFirstRow.add(labelM);

        jPanel4.add(lettersFirstRow);

        lettersSecondRow.setMaximumSize(null);
        lettersSecondRow.setMinimumSize(new java.awt.Dimension(400, 28));
        lettersSecondRow.setPreferredSize(new java.awt.Dimension(400, 28));

        labelN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelN.setText("N");
        labelN.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labelN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelN.setOpaque(true);
        labelN.setPreferredSize(new java.awt.Dimension(20, 20));
        lettersSecondRow.add(labelN);

        labelQ.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelQ.setText("Q");
        labelQ.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labelQ.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelQ.setOpaque(true);
        labelQ.setPreferredSize(new java.awt.Dimension(20, 20));
        lettersSecondRow.add(labelQ);

        labelP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelP.setText("P");
        labelP.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labelP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelP.setOpaque(true);
        labelP.setPreferredSize(new java.awt.Dimension(20, 20));
        lettersSecondRow.add(labelP);

        labelU.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelU.setText("U");
        labelU.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labelU.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelU.setOpaque(true);
        labelU.setPreferredSize(new java.awt.Dimension(20, 20));
        lettersSecondRow.add(labelU);

        labelR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelR.setText("R");
        labelR.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labelR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelR.setOpaque(true);
        labelR.setPreferredSize(new java.awt.Dimension(20, 20));
        lettersSecondRow.add(labelR);

        labelT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelT.setText("T");
        labelT.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labelT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelT.setOpaque(true);
        labelT.setPreferredSize(new java.awt.Dimension(20, 20));
        lettersSecondRow.add(labelT);

        labelZ.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelZ.setText("Z");
        labelZ.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labelZ.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelZ.setOpaque(true);
        labelZ.setPreferredSize(new java.awt.Dimension(20, 20));
        lettersSecondRow.add(labelZ);

        labelY.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelY.setText("Y");
        labelY.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labelY.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelY.setOpaque(true);
        labelY.setPreferredSize(new java.awt.Dimension(20, 20));
        lettersSecondRow.add(labelY);

        labelV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelV.setText("V");
        labelV.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labelV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelV.setOpaque(true);
        labelV.setPreferredSize(new java.awt.Dimension(20, 20));
        lettersSecondRow.add(labelV);

        labelS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelS.setText("S");
        labelS.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labelS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelS.setOpaque(true);
        labelS.setPreferredSize(new java.awt.Dimension(20, 20));
        lettersSecondRow.add(labelS);

        labelO.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelO.setText("O");
        labelO.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labelO.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelO.setOpaque(true);
        labelO.setPreferredSize(new java.awt.Dimension(20, 20));
        lettersSecondRow.add(labelO);

        labelW.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelW.setText("W");
        labelW.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labelW.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelW.setOpaque(true);
        labelW.setPreferredSize(new java.awt.Dimension(20, 20));
        lettersSecondRow.add(labelW);

        labelX.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelX.setText("X");
        labelX.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labelX.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelX.setOpaque(true);
        labelX.setPreferredSize(new java.awt.Dimension(20, 20));
        lettersSecondRow.add(labelX);

        jPanel4.add(lettersSecondRow);

        wordGuessTextField.setPreferredSize(new java.awt.Dimension(200, 20));
        wordGuessTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                wordGuessTextFieldFocusGained(evt);
            }
        });
        jPanel3.add(wordGuessTextField);

        guessButton.setText("Guess");
        guessButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guessButtonActionPerformed(evt);
            }
        });
        jPanel3.add(guessButton);

        newGameButton.setText("New Game");
        newGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameButtonActionPerformed(evt);
            }
        });
        jPanel6.add(newGameButton);

        exitButton.setText("Exit");
        exitButton.setToolTipText("");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        jPanel6.add(exitButton);

        scoreLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        scoreLabel.setPreferredSize(new java.awt.Dimension(400, 30));
        jPanel2.add(scoreLabel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        mainPanel.disconnect();
    }//GEN-LAST:event_exitButtonActionPerformed

    private void guessButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guessButtonActionPerformed
        if (wordGuessTextField.getText().length() > 0) {
            logger.info("Guessing word: " + wordGuessTextField.getText());
            hangmanClient.takeAGuess(wordGuessTextField.getText());
        }
    }//GEN-LAST:event_guessButtonActionPerformed

    private void wordGuessTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_wordGuessTextFieldFocusGained
        ((JTextField) evt.getComponent()).setText("");

    }//GEN-LAST:event_wordGuessTextFieldFocusGained

    private void newGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameButtonActionPerformed
        mainPanel.newGame();
    }//GEN-LAST:event_newGameButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitButton;
    private javax.swing.JButton guessButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel labelA;
    private javax.swing.JLabel labelB;
    private javax.swing.JLabel labelC;
    private javax.swing.JLabel labelD;
    private javax.swing.JLabel labelE;
    private javax.swing.JLabel labelF;
    private javax.swing.JLabel labelG;
    private javax.swing.JLabel labelH;
    private javax.swing.JLabel labelI;
    private javax.swing.JLabel labelJ;
    private javax.swing.JLabel labelK;
    private javax.swing.JLabel labelL;
    private javax.swing.JLabel labelM;
    private javax.swing.JLabel labelN;
    private javax.swing.JLabel labelO;
    private javax.swing.JLabel labelP;
    private javax.swing.JLabel labelQ;
    private javax.swing.JLabel labelR;
    private javax.swing.JLabel labelS;
    private javax.swing.JLabel labelT;
    private javax.swing.JLabel labelU;
    private javax.swing.JLabel labelV;
    private javax.swing.JLabel labelW;
    private javax.swing.JLabel labelX;
    private javax.swing.JLabel labelY;
    private javax.swing.JLabel labelZ;
    private javax.swing.JPanel lettersFirstRow;
    private javax.swing.JPanel lettersSecondRow;
    private javax.swing.JButton newGameButton;
    private javax.swing.JLabel scoreLabel;
    private javax.swing.JTextField wordGuessTextField;
    private javax.swing.JLabel wordLabel;
    // End of variables declaration//GEN-END:variables
    private void letterLabelClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        JLabel lbl = (JLabel) evt.getComponent();
        lbl.setCursor(null);
        logger.info("Selected letter: " + lbl.getText());
        hangmanClient.takeAGuess(lbl.getText());
        lbl.removeMouseListener(lbl.getMouseListeners()[0]);
    }

    private void setLabelListeners() {
        for (Component c : lettersFirstRow.getComponents()) {
            if (c instanceof JLabel) {
                c.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        letterLabelClicked(e);
                    }
                });
            }
        }
        for (Component c : lettersSecondRow.getComponents()) {
            if (c instanceof JLabel) {
                c.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        letterLabelClicked(e);
                    }
                });
            }
        }
    }

    public void setLabelText(String text) {
        wordLabel.setText(text);
    }

    public void setLetterBG(String string, Color color) {
        for (Component c : lettersFirstRow.getComponents()) {
            if (c instanceof JLabel) {
                if (((JLabel) c).getText().equals(string.toUpperCase())) {
                    c.setBackground(color);
                    MouseListener[] ar = c.getMouseListeners();
                    if (ar.length > 0) {
                        MouseListener mlist = ((JLabel) c).getMouseListeners()[0];
                        c.removeMouseListener(mlist);
                        c.setCursor(null);
                    }
                }
            }
        }
        for (Component c : lettersSecondRow.getComponents()) {
            if (c instanceof JLabel) {
                if (((JLabel) c).getText().equals(string.toUpperCase())) {
                    c.setBackground(color);
                    MouseListener[] ar = c.getMouseListeners();
                    if (ar.length > 0) {
                        MouseListener mlist = ((JLabel) c).getMouseListeners()[0];
                        c.removeMouseListener(mlist);
                        c.setCursor(null);
                    }
                }
            }
        }
    }

    public void disableGuessButton() {
        guessButton.setEnabled(false);
    }

    public void removeLetterListeners() {
        removeFromComp(lettersFirstRow);
        removeFromComp(lettersSecondRow);
        
    }
    
    public void removeFromComp(JPanel comp){
        for (Component c : comp.getComponents()) {
            if (c instanceof JLabel) {
                MouseListener[] ar = c.getMouseListeners();
                if (ar.length > 0) {
                    MouseListener mlist = ((JLabel) c).getMouseListeners()[0];
                    c.removeMouseListener(mlist);
                    c.setCursor(null);
                }
            }
        }
    }

    public void setScore(String text) {
        scoreLabel.setText(text);
    }
}
