package org.example;

import java.util.ArrayList;

public class ContainerManager {
    private ArrayList<IMeasurableContainer> containers;

    public ContainerManager(){
        this.containers = new ArrayList<>();
    }

    public void add(IMeasurableContainer newContainer){
        this.containers.add(newContainer);
    }

    public double totalWeight(){
        double sum = 0;
        for (IMeasurableContainer ic: this.containers){
            sum += ic.weight();
        }

        return sum;
    }

    public double totalRectangularVolume(){
        double sum = 0;
        for (IMeasurableContainer ic: this.containers){
            sum += ic.rectangularVolume();
        }

        return sum;
    }

    public void clearAll(){
        this.containers.clear();
    }

    public ArrayList<IMeasurableContainer> getAllContainers(){
        return this.containers;
    }


}
