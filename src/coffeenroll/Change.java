/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeenroll;


public class Change {
    
    // define ypur denominations
    private int[] denominationsNotes = {100, 50, 20, 10, 5};
    private int[] noOfNotes = {0, 0, 0, 0, 0};
    private int[] denominationsCoins = {2, 1};
    private int[] noOfCoins = {0, 0};
    private int[] denominationsCents = {50, 20, 10, 5, 2};
    private int[] noOfCents = {0, 0, 0, 0, 0};
    
    private int cents;
    private int dollars;
    
    public Change() {
    }
    
    public void denChange(int amount) {
        seprateDollarAndCents(amount);
        
        int count = 0;
        int temp_dollars = this.dollars;
        int temp_cents = this.cents;
        
        //calculating no of Notes
        for(int i = 0; i < denominationsNotes.length; i++){
            if(this.dollars >= denominationsNotes[i]) {
                count = temp_dollars/denominationsNotes[i];
                temp_dollars = temp_dollars%denominationsNotes[i];
                noOfNotes[i] = count;
            }
        }
        
        //calculating no of Coins
        count = 0;
        for(int i = 0; i < denominationsCoins.length; i++){
            if(this.dollars >= denominationsCoins[i]) {
                count = temp_dollars/denominationsCoins[i];
                temp_dollars = temp_dollars%denominationsCoins[i];
                noOfCoins[i] = count;
            }
        }
        
        //calculating no of Cents
        count = 0;
        for(int i = 0; i < denominationsCents.length; i++){
            if(this.dollars >= denominationsCents[i]) {
                count = temp_cents/denominationsCents[i];
                temp_cents = temp_cents%denominationsCents[i];
                noOfCents[i] = count;
            }
        }
    }
    
    public int[] getNotes() {
        for (int i = 0; i < noOfNotes.length; i++) {
            if(noOfNotes[i] > 0){
                System.out.printf ("%-2s %-10s %5d %-7s %5d %2s %n" , "|", "Number of", denominationsNotes[i], "dollar Notes:", + noOfNotes[i], "|");
            }
        }
        return noOfNotes;
    }
    
    public int[] getCoins() {
        for (int i = 0; i < noOfCoins.length; i++) {
            if(noOfCoins[i] > 0){
                System.out.printf ("%-2s %-10s %5d %-7s %5d %2s %n" , "|", "Number of", denominationsCoins[i], "dollar Coins:", + noOfCoins[i], "|");
            }
        }
        return noOfCoins;
    }
    
    public int[] getCents() {
        for (int i = 0; i < noOfCents.length; i++) {
            if(noOfCents[i] > 0){
                System.out.printf ("%-2s %-10s %5d %13s %5d %2s %n" , "|", "Number of", denominationsCents[i], "Cents:", + noOfCents[i], "|");
            }
        }
        return noOfCents;
    }
    
    public String getChangeDenominationString(){
        //building string
        StringBuilder sb = new StringBuilder();
        //adding notes
        for (int i = 0; i < noOfNotes.length; i++) {
            if(noOfNotes[i] > 0){
                sb.append(String.format("%-2s %-10s %5d %7s %5d %2s %n" , "|", "Number of", denominationsNotes[i], "dollar Notes:", + noOfNotes[i], "|"));
            }
        }
        //adding cons
        for (int i = 0; i < noOfCoins.length; i++) {
            if(noOfCoins[i] > 0){
                sb.append(String.format("%-2s %-10s %5d %7s %5d %2s %n" , "|", "Number of", denominationsCoins[i], "  dollar Coins:", + noOfCoins[i], "|"));
            }
        }
        //adding centts
        for (int i = 0; i < noOfCents.length; i++) {
            if(noOfCents[i] > 0){
                sb.append(String.format("%-2s %-10s %5d %13s %5d %2s %n" , "|", "Number of", denominationsCents[i], "  Cents:", + noOfCents[i], "|"));
            }
        }
        
        return sb.toString();
    }
    
    private void seprateDollarAndCents(int amount){
        this.cents = amount%100;
        this.dollars = (int) (0.01 * (amount - this.cents));
    }
    
    public void clearData(){
        for (int i = 0; i < noOfNotes.length; i++) {
            noOfNotes[i] = 0;
        }
        
        for (int i = 0; i < noOfCoins.length; i++) {
            noOfCoins[i] = 0;
        }
        for (int i = 0; i < noOfCents.length; i++) {
            noOfCents[i] = 0;
        }
        
        this.dollars = 0;
        this.cents = 0;
    }
}
