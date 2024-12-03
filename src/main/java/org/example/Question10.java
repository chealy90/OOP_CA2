package org.example;

import java.util.ArrayDeque;
import java.util.Deque;

public class Question10 {
    public static void display(int[][] image) {
        for (int x = 0; x < image.length; x++) {
            for (int y = 0; y < image[0].length; y++) {
                System.out.printf("%4d", image[x][y]);
            }
            System.out.println();
        }
    }

    public void solve(int x, int y, DIRECTION dir) {
        Deque<PathPoint> paths = new ArrayDeque<>();
        PathPoint currentPoint = new PathPoint(x, y, dir);
        //push all paths from current point
        //paths.push(new PathPoint()));

    }
}
