/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeenroll;

import javax.swing.JFrame;
import oracle.jrockit.jfr.JFR;

public class CNR_GUI {
    
    JFrame frame;
    CashRegGUI cashRegGUI;
    
    public CNR_GUI() {
        frame = new JFrame("CashNRoll");
        cashRegGUI = new CashRegGUI();
        frame.setSize(600, 640);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.getContentPane().add(cashRegGUI.getPanel());
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        CNR_GUI g = new CNR_GUI();
    }

    
    
}
