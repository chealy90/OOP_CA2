package org.example;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;

/**
 *  Name: Christopher Healy
 *  Class Group: SD2A
 */

public class Question6      // Flight take-off (Queue)
{

    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        Queue<String> landingQueue = new ArrayDeque<>();
        Queue<String> takeoffQueue = new ArrayDeque<>();
        String command = "";

        do {
            System.out.print(">");
            command = kb.nextLine();
            String[] commandParts = command.split(" ");

            //add to takeoff queue
            if (commandParts[0].equals("takeoff")){
                takeoffQueue.add(commandParts[1]);
            }

            //add to landing queue
            else if (commandParts[0].equals("land")){
                landingQueue.add(commandParts[1]);
            }

            //carry out next operation
            else if (commandParts[0].equals("next")){
                //land planes first
                if (!landingQueue.isEmpty()){
                    String flightNumber = landingQueue.remove();
                    System.out.println("Landed: " + flightNumber);
                }
                //then take off planes
                else if (!takeoffQueue.isEmpty()){
                    String flightNumber = takeoffQueue.remove();
                    System.out.println("Took off:" + flightNumber);
                }
                //deal with empty queues
                else {
                    System.out.println(">No flights in system.");
                }
            }

            else if (commandParts[0].equals("quit")){
                continue;
            }
            else {
                System.out.println(">Invalid input");
            }
        } while (!command.equals("quit"));
        System.out.println("--Session Finished--");

    }
}
