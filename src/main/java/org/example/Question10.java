package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 *  Name: Christopher Healy
 *  Class Group: SD2A
 */

public class Question10 {
    public static void main(String[] args){
        int[][] image = new int[8][8];
        populateMaze(image);
        image[5][1] = 8;
        display(image);
        solve(5, 1, DIRECTION.NORTH, image);
    }

    public static void display(int[][] image) {
        for (int x = 0; x < image.length; x++) {
            for (int y = 0; y < image[0].length; y++) {
                System.out.printf("%4d", image[x][y]);
            }
            System.out.println();
        }
    }

    public static void solve(int x, int y, DIRECTION dir, int[][] image) {
        //set up
        Deque<PathPoint> paths = new ArrayDeque<>();
        boolean solved = false;
        System.out.printf("Starting at\n X: %d, Y: %d\n", x, y);

        //push all paths from current point
        if (x != 0 && image[x-1][y]!=1){paths.push(new PathPoint(x-1, y, DIRECTION.NORTH));}
        if (x != image.length-1 && image[x+1][y]!=1){paths.push(new PathPoint(x+1, y, DIRECTION.SOUTH));}
        if (y != 0 && image[x][y-1] != 1){paths.push(new PathPoint(x, y-1, DIRECTION.WEST));}
        if (y!=image[0].length-1 && image[x][y+1]!=1){paths.push(new PathPoint(x, y+1, DIRECTION.EAST));}


        while(!paths.isEmpty() && !solved){
            PathPoint path = paths.pop();
            int xPos = path.x;
            int yPos = path.y;

            System.out.println("X: " + xPos +  ", Y: "+yPos);
            switch (path.direction){
                case DIRECTION.NORTH:
                    //check for solved;
                    if (xPos==0){
                        solved = true;
                        System.out.printf("X: %d, Y: %d\n", xPos, yPos);
                        break;
                    }

                    while (image[xPos][yPos] != 1){
                        //intersections - east and west
                        if (image[xPos][yPos-1] == 0){
                            paths.push(new PathPoint(xPos, yPos - 1, DIRECTION.WEST));
                        }
                        if (image[xPos][yPos+1]==0){
                            paths.push(new PathPoint(xPos, yPos + 1, DIRECTION.EAST));
                        }
                        //check that it wont cause an IndexOutOfBounds
                        //move along if not at edge
                        if (xPos!=0)xPos--;


                    }
                    break;

                case DIRECTION.SOUTH:
                    //check for solved;
                    if (xPos==image.length-1){
                        solved = true;
                        System.out.printf("X: %d, Y: %d\n", xPos, yPos);
                        break;
                    }
                    while (image[xPos][yPos] != 1){
                        //intersections - east and west
                        if (image[xPos][yPos-1] == 0){
                            paths.push(new PathPoint(xPos, yPos - 1, DIRECTION.WEST));
                        }
                        if (image[xPos][yPos+1]==0){
                            paths.push(new PathPoint(xPos, yPos + 1, DIRECTION.EAST));
                        }
                        //move along if not at edge
                        if (xPos!=image.length-1)xPos++;
                    }
                    break;


                case DIRECTION.WEST:
                    while (image[xPos][yPos] != 1){
                        //check for solved;
                        if (yPos==0){
                            solved = true;
                            System.out.printf("X: %d, Y: %d\n", xPos, yPos);
                            break;
                        }

                        //intersections - north and south
                        if (image[xPos - 1][yPos] == 0){
                            paths.push(new PathPoint(xPos - 1, yPos, DIRECTION.NORTH));
                        }
                        if (image[xPos + 1][yPos]==0){
                            paths.push(new PathPoint(xPos + 1, yPos, DIRECTION.SOUTH));
                        }
                        //move along if not at edge
                        if (yPos!=0)yPos--;

                    }
                    break;

                case DIRECTION.EAST:
                    //check for solved;
                    if (yPos==0){
                        solved = true;
                        System.out.printf("X: %d, Y: %d\n", xPos, yPos);
                        break;
                    }
                    while (image[xPos][yPos] != 1){
                        //intersections - north and south
                        if (image[xPos - 1][yPos] == 0){
                            paths.push(new PathPoint(xPos - 1, yPos, DIRECTION.NORTH));
                        }
                        if (image[xPos + 1][yPos]==0){
                            paths.push(new PathPoint(xPos + 1, yPos, DIRECTION.SOUTH));
                        }
                        //move along if not at edge
                        if (yPos!=image[0].length-1)yPos++;
                    }
                    break;
            }
        }
        System.out.println("Finished");
    }

    public static void populateMaze(int[][] maze){
        final String mazeFile = "./map.txt";
        try {
            //populate maze
            Scanner in = new Scanner(new File(mazeFile));
            int x = 0;
            int y = 0;
            while (in.hasNextInt()) {
                int val = in.nextInt();
                maze[x][y] = val;
                y++;
                //new line
                if (y == 8) {
                    y = 0;
                    x++;
                }
            }
        } catch (FileNotFoundException e){
            System.out.println("Error reading file");
        }
    }



}
