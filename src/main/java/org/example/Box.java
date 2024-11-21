package org.example;

public class Box implements IMeasurableContainer {
    private double length;
    private double width;
    private double depth;
    private double weight;

    public Box(double length, double width, double depth, double weight){
        this.length = length;
        this.width = width;
        this.depth = depth;
        this.weight = weight;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Box(){
        this.length = 0;
        this.width = 0;
        this.depth = 0;
        this.weight = 0;
    }

    @Override
    public double weight(){
        return this.weight;
    }

    @Override
    public double rectangularVolume(){
        return this.length * this.width * this.depth;
    }
}
