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
            System.out.print("Enter action: ");
            input = kb.nextInt();

            //add car to driveway
            if (input > 0) {
                driveway.push(input);
                System.out.println("Driveway end -> " + driveway.toString() +" <-start");
                System.out.println();
            }

            //remove car from driveway
            else if (input < 0){
                //temporarily move to street
                while (driveway.peek()!=Math.abs(input)){
                    street.push(driveway.pop());
                }
                //remove car
                driveway.pop();

                //replace cars
                while (!street.isEmpty()){
                    driveway.push(street.pop());
                }
                System.out.println("Driveway end -> " + driveway.toString() +" <-start");
            }

        } while (input != 0);
        System.out.println("Final state of driveway: end -> " + driveway.toString() + " <- start");

    }

    public static void main(String[] args) {
        runSimulation();
    }
}
