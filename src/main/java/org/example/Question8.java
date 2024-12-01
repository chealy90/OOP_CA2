package org.example;

import java.util.*;
/**
 *  Name: Christopher Healy
 *  Class Group: SD2A
 */
public class Question8  // Multi-company (Queue)
{
    /*
   Will repeatedly ask the user to enter the commands in the format
   buy company qty price
   or
   sell company qty price
   or
   quit
    */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String command="";
        Map<String, Queue> sharesLedger = new HashMap<>();
        do {
            System.out.print(">");
            command = in.next();
            if(command.equalsIgnoreCase("buy"))
            {
                String company = in.next();
                int qty = in.nextInt();
                double price = in.nextDouble();
                // Code to buy shares here
                //deal with first time company is bought
                if (sharesLedger.get(company)==null){
                    Queue<Share> sharesQueue = new ArrayDeque<>();
                    sharesQueue.add(new Share(qty, price));
                    sharesLedger.put(company, sharesQueue);
                }
                //buy more of previously bought stock
                else {
                    Queue<Share> sharesQueue = sharesLedger.get(company);
                    sharesQueue.add(new Share(qty, price));
                }
            }
            else if(command.equals("sell"))
            {
                String company = in.next();
                int qty = in.nextInt();
                double price = in.nextDouble();
                // Code to sell shares and calculate profit here
                //stock not owned
                if (sharesLedger.get(company)==null){
                    System.out.println("No shares of "+company+" owned.");
                }
                //stock is owned
                else {
                    int qtySold = 0;
                    double gain = 0;
                    Queue<Share> sharesQueue = sharesLedger.get(company);

                    //code adapted from Q7
                    while (qtySold < qty){
                        Share queueTopShare = sharesQueue.peek();
                        if (queueTopShare==null){
                            System.out.println("Not enough shares to complete order!");
                            break;
                        }
                        //block is less than required (take whole block)
                        if (queueTopShare.getQuantity() < (qty - qtySold)){
                            queueTopShare = sharesQueue.remove();
                            qtySold += queueTopShare.getQuantity();
                            gain += (price - queueTopShare.getPrice()) * queueTopShare.getQuantity();
                        }
                        //block is more than required (take part of block)
                        else {
                            int sharesRequired = qty - qtySold;
                            queueTopShare.setQuantity(queueTopShare.getQuantity() - sharesRequired);

                            qtySold += sharesRequired;
                            gain += (price - queueTopShare.getPrice()) * sharesRequired;
                        }
                    }
                    //display gain
                    System.out.printf("%d shares of %s sold for gain of: $%.2f", qtySold, company, gain);
                }
            }
        }while(!command.equalsIgnoreCase("quit"));
    }
}
