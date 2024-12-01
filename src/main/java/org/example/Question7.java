package org.example;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
/**
 *  Name: Christopher Healy
 *  Class Group: SD2A
 */
public class Question7  // Shares Tax Calculations (Queue)
{

    /*
    Will repeatedly ask the user to enter the commands in the format
    buy qty price
    or
    sell qty price
    or
    quit
     */
    public static void main(String[] args) {

       Scanner in = new Scanner(System.in);
       Queue<Share> sharesQueue = new ArrayDeque<>();
        String command="";
            do {
            System.out.print(">");
            command = in.next();
            if(command.equalsIgnoreCase("buy"))
            {
                int qty = in.nextInt();
                double price = in.nextDouble();
                sharesQueue.add(new Share(qty, price));


            }
            else if(command.equals("sell"))
            {
                int qty = in.nextInt();
                double price = in.nextDouble();
                //display gain made based on current i.e. selling price
                int qtySold = 0;
                double gain = 0;
                if (sharesQueue.peek()==null){
                    System.out.println("No shares available!");
                    continue;
                }
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
                System.out.printf("Sold %d shares for gain of: $%.2f\n", qtySold, gain);


            }
        }while(!command.equalsIgnoreCase("quit"));
    }
}