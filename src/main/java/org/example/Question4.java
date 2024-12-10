package org.example;

import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 *  Name: Christopher Healy
 *  Class Group: SD2A
 */

public class Question4  // Flood Fill (Stack, 2D Array)
{

    public static void main(String[] args) {
        start();
    }
    public static void start()
    {
        int[][] arr = floodFillStart();
        Scanner kb = new Scanner(System.in);

        System.out.print("Enter start row:");
        int startRow = kb.nextInt();
        System.out.print("Enter start column:");
        int startColumn = kb.nextInt();

        fill(startRow, startColumn, arr);
        display(arr);


    }

    /*
        Starter function to create the 2D array and populate it with zeros
     */
    public static int[][]  floodFillStart() {
        Scanner kb = new Scanner(System.in);
        final int ROWS = 10;
        final int COLUMNS = 10;
        int[][] arr = new int[ROWS][COLUMNS];
        for (int x = 0; x < ROWS; x++)
        {
            for (int y = 0; y < COLUMNS; y++)
            {
                arr[x][y] = 0;
            }
        }
        return arr;
    }
    /*
        Helper function to display the image
     */
    public static void display(int[][] arr)
    {
        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 10; y++)
            {
                System.out.printf("%4d", arr[x][y]);
            }
            System.out.println();
        }
    }
    private static void fill(int r, int c, int[][] arr)
    {
        //create initial conditions
        Cell c1 = new Cell(r, c);
        Deque<Cell> cellStack = new ArrayDeque<>();
        cellStack.push(c1);
        int iterationNumber = 1;

        //main loop
        while (!cellStack.isEmpty()){
            Cell topCell = cellStack.pop();
            int x = topCell.getX();
            int y = topCell.getY();

            if (arr[x][y] != 0){
                continue;
            }
            arr[x][y] = iterationNumber;

            //check neighbors
            if (y!=0 && arr[x][y-1]==0){cellStack.push(new Cell(x, y-1));} //N
            if (y!=9 && arr[x][y+1]==0){cellStack.push(new Cell(x, y+1));} //S
            if (x!=9 && arr[x+1][y]==0){cellStack.push(new Cell(x+1, y));} //E
            if (x!=0 && arr[x-1][y]==0){cellStack.push(new Cell(x-1, y));} //W

            iterationNumber++;
        }

    }

}
