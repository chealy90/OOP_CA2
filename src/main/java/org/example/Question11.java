package org.example;

import java.io.File;
import java.util.*;

/**
 *  Name: Christopher Healy
 *  Class Group: SD2A
 */
public class Question11
{

    public static void main(String[] args) {
        Map<String, TreeSet<DistanceTo>> directConnections = new HashMap<>();
        //populate map with distances from txt file, and set starting point as first city in text file
        String startingPoint = populateMap(directConnections);
        System.out.println("Starting Point: "+ startingPoint);

        //start algorithm
        String from = startingPoint;
        Queue<DistanceTo> distancesQueue = new PriorityQueue<>();
        distancesQueue.add(new DistanceTo(from, 0));
        Map<String, DistanceTo> shortestKnownDistance = new HashMap<>();

        while (!distancesQueue.isEmpty()){
            //pull from top of queue then eval its shortest distance
            DistanceTo minDistance = distancesQueue.poll();
            String target = minDistance.getTarget();
            int dist = minDistance.getDistance();
            if (shortestKnownDistance.get(target)==null){
                //add shortest dist of new cities
                shortestKnownDistance.put(target, new DistanceTo(target, dist));

                //check if target has direct connections
                if (directConnections.get(target)!=null){
                    //check the connections from each city, if their shortest dist not found, push them to q to be evaluated next
                    for (DistanceTo dt: directConnections.get(target)){
                        if (shortestKnownDistance.get(dt.getTarget())==null){
                           distancesQueue.add(new DistanceTo(dt.getTarget(), dist + dt.getDistance()));
                        }
                    }
                }
            }
        }

        System.out.println("Results:");
        for (Map.Entry entry: shortestKnownDistance.entrySet()){
            DistanceTo distTo = (DistanceTo) entry.getValue();
            int distance = distTo.getDistance();
            System.out.println(entry.getKey() + ": " + distance + "mi");
        }
    }

    public static String populateMap(Map<String, TreeSet<DistanceTo>> map){
        try {
            Scanner kb = new Scanner(new File("./citiesData.txt"));
            String startingPoint = "";
            boolean startSet = false;
            while (kb.hasNextLine()){
                String name = kb.next();
                String dest = kb.next();
                int distance = kb.nextInt();

                //set start point to first line
                if (!startSet){
                    startingPoint = name;
                    startSet = true;
                }

                //first occurance
                if (map.get(name)==null){
                    map.put(name, new TreeSet());
                    map.get(name).add(new DistanceTo(dest, distance));
                }
                else {
                    map.get(name).add(new DistanceTo(dest, distance));
                }
            }

            return startingPoint;

        } catch (Exception e){
            System.out.println("Error while retrieving file");
        }
        return null;

    }
}
