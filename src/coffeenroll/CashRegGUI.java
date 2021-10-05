/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeenroll;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javafx.scene.layout.Pane;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class  CashRegGUI{
    
    JPanel panel;
    JPanel cell1Panel;
    JPanel cell2Panel;
    JPanel cell3Panel;
    JPanel cell4Panel;
    JPanel cell5Panel;
    JPanel cell6Panel;
    Label mainLabal;
    Label salePriceLabal;
    Label straightLine1Labal;
    Label straightLine2Labal;
    
    Label qtyLabal;
    Label paidCentsLabal;
    Label changeLabal;
    
    Label errMessage;
    
    JTextField qtyTextField;
    JTextField paidCentsTextField;
    JTextField changeTextField;
    
    ButtonGroup buttonGroup;
    JRadioButton jRadioButton1;
    JRadioButton jRadioButton2;
    JRadioButton jRadioButton3;
    JRadioButton jRadioButton4;
    JRadioButton jRadioButton5;
    
    JButton resetButton;
    JButton doneButton;
    
    JTextArea changeDenominationTextArea;
    JTextArea dailySaleTextArea;
    
    Product[] products;
    Change change;
    DecimalFormat f;
    
    int option;
    int qty;
    float salePrice;
    int amountPaid;


    public CashRegGUI() {
        products = new Product[5];
        change = new Change();
        f = new DecimalFormat("####.00");
        
        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        
        
        products[0] = new Product("Schnitzel Roll", (float)18.80, 0);
        //products[0].setPrice((float)18.80);
        products[1] = new Product("Fish Roll", (float)17.25, 0);
        //products[1].setPrice((float)17.25);
        products[2] = new Product("Lamb Roll", (float)9.60, 0);
        //products[2].setPrice((float)9.60);
        products[3] = new Product("Ice Cream Roll", (float)6.75, 0);
        //products[3].setPrice((float)6.75);
        products[4] = new Product("Cofee Latte", (float)3.40, 0);
        //products[4].setPrice((float)3.40);
        
        createCell1();
        createCell2();
        createCell3();
        createCell4();
        createCell5();
        createCell6();
        
        
        
        
        
        
    
        
        
        
        
    }
    
    private void createCell1(){
        cell1Panel = new JPanel(new GridLayout(2, 1));
        cell1Panel.setBorder(BorderFactory.createLineBorder(Color.black));
        mainLabal = new Label("Cofee and Roll Cash Register");
        salePriceLabal = new Label("Sale Price $0.0");
        salePriceLabal.setSize(50, 50);
        salePriceLabal.setForeground(Color.RED);
        
        cell1Panel.add(mainLabal);
        cell1Panel.add(salePriceLabal);
        panel.add(cell1Panel);
    }
    
    private void createCell2(){
        cell2Panel = new JPanel();
        cell2Panel.setBorder(BorderFactory.createLineBorder(Color.black));
        errMessage = new Label("                     ");
        cell2Panel.add(errMessage);
        panel.add(cell2Panel);
    }
    
    private void createCell3(){
        cell3Panel = new JPanel();
        cell3Panel.setBorder(BorderFactory.createLineBorder(Color.black));
        straightLine1Labal = new Label("_________________________________________");
        straightLine2Labal = new Label("_________________________________________");
        
        
        cell3Panel.add(straightLine1Labal);
        
        jRadioButton1  = new JRadioButton("1. Schnitzel Roll        $18.80");
        jRadioButton1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
              option = 1;
            }
        });
        jRadioButton2  = new JRadioButton("2. Fish Roll                 $17.25 ");
        jRadioButton2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
              option = 2;
            }
        });
        jRadioButton3  = new JRadioButton("3. Lamb Roll             $14.60 ");
        jRadioButton3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
              option = 3;
            }
        });
        jRadioButton4  = new JRadioButton("4. Ice Cream Roll        $6.75 ");
        jRadioButton4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
              option = 4;
            }
        });
        jRadioButton5  = new JRadioButton("5. Coffee Latte           $3.40 ");
        jRadioButton5.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
              option = 5;
            }
        });
        
        buttonGroup = new ButtonGroup();
        buttonGroup.add(jRadioButton1);
        buttonGroup.add(jRadioButton2);
        buttonGroup.add(jRadioButton3);
        buttonGroup.add(jRadioButton4);
        buttonGroup.add(jRadioButton5);
        
        cell3Panel.add(jRadioButton1);
        cell3Panel.add(jRadioButton2);
        cell3Panel.add(jRadioButton3);
        cell3Panel.add(jRadioButton4);
        cell3Panel.add(jRadioButton5);
        cell3Panel.add(straightLine2Labal);
        
        panel.add(cell3Panel);
    }
    
    private void createCell4(){
        cell4Panel = new JPanel();
        cell4Panel.setBorder(BorderFactory.createLineBorder(Color.black));
        changeDenominationTextArea = new JTextArea();
        
        cell4Panel.add(changeDenominationTextArea);
        
        panel.add(cell4Panel);
    }
    private void createCell5(){
        cell5Panel = new JPanel(new GridLayout(4, 2));
        cell5Panel.setBorder(BorderFactory.createLineBorder(Color.black));
        
        qtyLabal = new Label("Quantity ");
        paidCentsLabal = new Label("Paid (cents) ");
        changeLabal = new Label("Change (dollar)");
        
        qtyTextField = new JTextField();
        qtyTextField.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(option>0 && option<6){
                    try {
                        qty = Integer.parseInt(qtyTextField.getText());
                        salePrice = products[option-1].getPrice() * qty;
                        salePriceLabal.setText("Sale Price: $" + f.format(salePrice));
                    } catch (NumberFormatException ex) {
                        errMessage.setText("Enter Quantity !");
                    }
                } else {
                    errMessage.setText("Select Item !");
                }
                
            }
        });
        paidCentsTextField = new JTextField();
        paidCentsTextField.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(option>0 && option<6){
                    try {
                        qty = Integer.parseInt(qtyTextField.getText());
                        try {
                            amountPaid = Integer.parseInt(paidCentsTextField.getText());
                            change.denChange(amountPaid);
                            changeTextField.setText(f.format((amountPaid-salePrice*100)*0.01));
                            products[option-1].addToTotal(salePrice);
                            changeDenominationTextArea.setText(change.getChangeDenominationString());
                        } catch (Exception ex) {
                            errMessage.setText("Enter Cents Only !");
                        }
                    } catch (NumberFormatException ex) {
                        errMessage.setText("Enter Quantity !");
                    }
                } else {
                    
                }
                
                    
              
            }
        });
        changeTextField = new JTextField();
        
        resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
              buttonGroup.clearSelection();
              qtyTextField.setText("");
              paidCentsTextField.setText("");
              changeTextField.setText("");
              dailySaleTextArea.setText("");
              changeDenominationTextArea.setText("");
              
              qty = 0;
              amountPaid = 0;
              option = 0;
              salePrice = 0;
              
              errMessage.setText("Transection Saved !");
            }
        });
        doneButton = new JButton("Done");
        doneButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
              //printing daily sale
                float totalDailySale = (float) 0.0;
                
                for (int i = 0; i < 5; i++) {
                    dailySaleTextArea.setText(dailySaleTextArea.getText() + String.format("%-6s %14s %-5s %10s %n" , "Total ", products[i].getName()," Sales: ", "$" + f.format(products[i].getTotal())));
                    totalDailySale = totalDailySale + products[i].getTotal();
                }
                dailySaleTextArea.setText(dailySaleTextArea.getText() + String.format("%41s %n" ,"__________"));
                dailySaleTextArea.setText(dailySaleTextArea.getText() + String.format("%-6s %23s %10s %n" , "Total ", "Daily Sales: ", "$" + f.format(totalDailySale)));
            }
        });
        
        cell5Panel.add(qtyLabal);
        cell5Panel.add(qtyTextField);
        
        cell5Panel.add(paidCentsLabal);
         cell5Panel.add(paidCentsTextField);
         
        cell5Panel.add(changeLabal);
        cell5Panel.add(changeTextField);
        
       
        
        
        cell5Panel.add(resetButton);
        cell5Panel.add(doneButton);
        panel.add(cell5Panel);
    }
    
    private void createCell6(){
        cell6Panel = new JPanel();
        cell6Panel.setBorder(BorderFactory.createLineBorder(Color.black));
        
        dailySaleTextArea = new JTextArea();
        cell6Panel.add(dailySaleTextArea);
        
        panel.add(cell6Panel);
    }
    
    public JPanel getPanel(){
        return panel;
    }
    
    
    
    
}
