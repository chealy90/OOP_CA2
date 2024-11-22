package org.example;

import java.util.ArrayList;

/**
 *  Your Name: Christopher Healy
 *  Class Group: SD2A
 */
public class Question1 {    // Interfaces
    public static void main(String[] args) {
        System.out.println("Question 1");

        //triangular prism
        //side length -> triangle length of equilateral face

        // create container here...
        ContainerManager containerManager = new ContainerManager();
        containerManager.add(new Box(2, 5, 6, 25));
        containerManager.add(new Box(4, 4.5, 4.5, 18.75));
        containerManager.add(new Box(10, 2, 2.34, 16.3));

        containerManager.add(new Cylinder(10, 5, 34));
        containerManager.add(new Cylinder(12.5, 4.78, 19));
        containerManager.add(new Cylinder(11, 7.89, 14.25));

        containerManager.add(new Pyramid(10, 15, 34.6));
        containerManager.add(new Pyramid(12, 10, 15.2));
        containerManager.add(new Pyramid(10, 13.4, 51.3));

        //test the methods
        System.out.printf("Total Weight of Containers: %.2fKg\n", containerManager.totalWeight());
        System.out.printf("Total Volume of Containers: %.2fcm^2\n", containerManager.totalRectangularVolume());

        ArrayList<IMeasurableContainer> allContainers = containerManager.getAllContainers();
        for (IMeasurableContainer ic: allContainers){
            if (ic instanceof Box){
                Box box = (Box) ic;
                System.out.println("Box:");
                System.out.println("Length: " + box.getLength());
                System.out.println("Width: " + box.getWidth());
                System.out.println("Depth: " + box.getDepth());
                System.out.println("Weight: " + box.getWeight());
                System.out.println();
            }
            else if (ic instanceof Cylinder){
                Cylinder cylinder = (Cylinder) ic;
                System.out.println("Cylinder:");
                System.out.println("Height: " + cylinder.getHeight());
                System.out.println("Diameter: " + cylinder.getDiameter());
                System.out.println("Weight: " + cylinder.getWeight());
                System.out.println();
            }
            else {
                Pyramid pyramid = (Pyramid) ic;
                System.out.println("Pyramid:");
                System.out.println("Length: " + pyramid.getLength());
                System.out.println("Side Length: " + pyramid.getSideLength());
                System.out.println("Weight: " + pyramid.getWeight());
                System.out.println();
            }
        }



    }
}


