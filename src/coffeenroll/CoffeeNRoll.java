/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeenroll;

import java.text.DecimalFormat;
import java.util.Scanner;


public class CoffeeNRoll {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        
        Product[] products = new Product[5];
        Change change = new Change();
        DecimalFormat f = new DecimalFormat("##.00");
        
        
        
       
        
        
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
        
        Product product1 = new Product("Schnitzel Roll", (float)18.80, 0);
        Product product2 = new Product("Fish Roll", (float)17.25, 0);
        Product product3 = new Product("Lamb Roll", (float)9.60, 0);
        Product product4 = new Product("Ice Cream Roll", (float)6.75, 0);
        Product product5 = new Product("Cofee Latte", (float)3.40, 0);
        
        Scanner input = new Scanner(System.in);
        
        int option = 0;
        int qty = 0;
        float amountPaid = 0;
        float salePrice = 0;
        
        while (option != 6) {            
            System.out.println("≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡");
            System.out.println("________________________________________");
            System.out.printf ("%-2s %-20s %5s %n" , "51. ", product1.getName(), "$" + product1.getPrice());
            System.out.printf ("%-2s %-20s %5s %n" , "2. ", product2.getName(), "$" + product2.getPrice());
            System.out.printf ("%-2s %-20s %5s %n" , "3. ", product3.getName(), "$" + product3.getPrice());
            System.out.printf ("%-2s %-20s %5s %n" , "4. ", product4.getName(), "$" + product4.getPrice());
            System.out.printf ("%-2s %-20s %5s %n" , "5. ", product5.getName(), "$" + product5.getPrice());
            System.out.printf ("%-2s %-20s %n" , "6. ", "Done");
            System.out.println("________________________________________");
            System.out.println("");
            
            System.out.print("Enter the item number you want to order: "); 
            option = input.nextInt();
            
            if(option <=5 && option >=1) {
                
                
                while (true) {                    
                    System.out.print("Enter quantity ordered: ");
                    qty = input.nextInt();
                    if(qty > -1){
                        break;
                    } else {
                        continue;
                    }
                }
                
                salePrice = products[option-1].getPrice() * qty;
                System.out.print("Sale Price is: " + salePrice);System.out.println("");

                while (true) {     
                    System.out.print("Enter the amount paid in cents [0-1000000]: ");
                    amountPaid = input.nextInt();
                    if (amountPaid >=0 && amountPaid <=1000000 ) {
                        break;
                    }else {
                        continue;
                        
                    }
                }
                
                
                System.out.println("The change is: $" + f.format((amountPaid-(salePrice*100))*0.01));
                
                System.out.println("The change returned to the customer is:");
                
                //calculate denomination of change
                change.denChange((int)(amountPaid-(salePrice*100)));
                
                System.out.println("___________________________________________");
                //printin change
                change.getNotes();
                change.getCoins();
                change.getCents();
                System.out.println("___________________________________________");
                
                products[option-1].addToTotal(salePrice);
                change.clearData();
                
                
                
            } else {
                continue;
            }
            
        }//end of while
        
        //printing daily sale
        float totalDailySale = (float) 0.0;
        System.out.println("");
        for (int i = 0; i < 5; i++) {
             System.out.printf ("%-6s %14s %-5s %10s %n" , "Total ", products[i].getName()," Sales: ", "$" + f.format(products[i].getTotal()));
             totalDailySale = totalDailySale + products[i].getTotal();
        }
        System.out.printf ("%41s %n" ,"__________");
        System.out.printf ("%-6s %23s %10s %n" , "Total ", "Daily Sales: ", "$" + f.format(totalDailySale));
             
        
        
      
    }
    
}
