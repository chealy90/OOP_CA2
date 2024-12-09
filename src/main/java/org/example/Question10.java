package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

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
        Deque<PathPoint> paths = new ArrayDeque<>();
        //start point
        PathPoint currentPoint = new PathPoint(x, y, dir);
        boolean solved = false;

        //push all paths from current point
        paths.push(new PathPoint(x, y, DIRECTION.NORTH));



/*
        if (x != 0 && image[x-1][y]!=0){paths.push(new PathPoint(x-1, y, DIRECTION.NORTH));}
        if (x != image.length-1 && image[x+1][y]!=0){paths.push(new PathPoint(x+1, y, DIRECTION.SOUTH));}
        if (y != 0 && image[x][y-1] != 0){paths.push(new PathPoint(x, y-1, DIRECTION.WEST));}
        if (y!=image[0].length-1 && image[x][y+1]!=0){paths.push(new PathPoint(x, y+1, DIRECTION.EAST));}


 */
        while(!paths.isEmpty() && !solved){
            PathPoint path = paths.pop();
            int xPos = path.x;
            int yPos = path.y;
            System.out.println("Xpos " + xPos +  " yPos: "+yPos);
            switch (path.direction){
                case DIRECTION.NORTH:
                    //check for solved;
                    if (xPos==0){
                        solved = true;
                    }

                    while (image[xPos][yPos] != 1){
                        //intersections - east and west
                        if (image[xPos][yPos-1] == 0){
                            paths.push(new PathPoint(xPos, yPos, DIRECTION.WEST));
                        }
                        if (image[xPos][yPos+1]==0){
                            paths.push(new PathPoint(xPos, yPos, DIRECTION.EAST));
                        }
                        xPos--;
                    }
                    break;

                case DIRECTION.SOUTH:
                    //check for solved;
                    if (xPos==image.length-1){
                        solved = true;
                        break;
                    }
                    while (image[xPos][yPos] != 1){
                        //intersections - east and west
                        if (image[xPos][yPos-1] == 0){
                            paths.push(new PathPoint(xPos, yPos, DIRECTION.WEST));
                        }
                        if (image[xPos][yPos+1]==0){
                            paths.push(new PathPoint(xPos, yPos, DIRECTION.EAST));
                        }
                        xPos++;
                    }
                    break;


                case DIRECTION.WEST:
                    //check for solved;
                    if (yPos==0){
                        solved = true;
                    }
                    while (image[xPos][yPos] != 1){
                        //intersections - north and south
                        if (image[xPos - 1][yPos] == 0){
                            paths.push(new PathPoint(xPos, yPos, DIRECTION.NORTH));
                        }
                        if (image[xPos + 1][yPos]==0){
                            paths.push(new PathPoint(xPos, yPos, DIRECTION.SOUTH));
                        }

                        yPos--;
                    }
                    break;

                case DIRECTION.EAST:
                    //check for solved;
                    if (yPos==0){
                        solved = true;
                        break;
                    }
                    while (image[xPos][yPos] != 1){
                        //intersections - north and south
                        if (image[xPos - 1][yPos] == 0){
                            paths.push(new PathPoint(xPos, yPos, DIRECTION.NORTH));
                        }
                        if (image[xPos + 1][yPos]==0){
                            paths.push(new PathPoint(xPos, yPos, DIRECTION.SOUTH));
                        }

                        yPos++;
                    }
                    break;
            }
        }

        System.out.printf("Solution starting at x=%d, y=%d", x, y);
        System.out.println(paths.toString());
    }

    public static void populateMaze(int[][] maze){
        final String mazeFile = "./map.txt";
        final int mazeHeight = maze.length;
        final int mazeWidth = maze[0].length;
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
