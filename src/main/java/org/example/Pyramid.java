package org.example;

public class Pyramid implements IMeasurableContainer {
    private double length;
    private double sideLength;
    private double weight;

    public Pyramid(double length, double sideLength, double weight) {
        this.length = length;
        this.sideLength = sideLength;
        this.weight = weight;
    }

    public Pyramid(){
        this.length = 0;
        this.sideLength = 0;
        this.weight = 0;
    }

    @Override
    public double weight(){
        return this.weight;
    }

    @Override
    public double rectangularVolume(){
        double faceHeight = Math.sqrt(Math.pow(this.sideLength, 2) - Math.pow((this.length / 2), 2));
        double heightFromBase = Math.sqrt(Math.pow(faceHeight, 2) - Math.pow(this.length/2, 2));
        return this.length * this.length * heightFromBase;
    }


    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
