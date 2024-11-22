package org.example;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 *  Name: Christopher Healy
 *  Class Group: SD2A
 */
public class Question2  // Car Parking - Stack
{
    public static void runSimulation()
    {
        Scanner kb = new Scanner(System.in);
        Deque<Integer> driveway = new ArrayDeque<>();
        Deque<Integer> street = new ArrayDeque<>();
        int input;

        do {
            input = kb.nextInt();
            if (input > 0) {
                driveway.push(input);
            }

            else if (input > 0){
                while (driveway.peek()!=Math.abs(input)){
                    street.push(driveway.pop());
                }
                while (!street.isEmpty()){
                    driveway.push(street.pop());
                }
            }
            //print driveway
            //print stack
            //deal with adding car already being in there
            //deal with removing car not already in there

        } while (input != 0);

    }

    public static void main(String[] args) {
        runSimulation();
    }
}
