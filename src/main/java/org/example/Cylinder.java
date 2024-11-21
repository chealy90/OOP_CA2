package org.example;

public class Cylinder implements IMeasurableContainer{
    private double height;
    private double diameter;
    private double weight;

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Cylinder(double height, double diameter, double weight) {
        this.height = height;
        this.diameter = diameter;
        this.weight = weight;
    }

    public Cylinder(){
        this.height = 0;
        this.diameter = 0;
        this.weight = 0;
    }

    @Override
    public double weight(){
        return this.weight;
    }

    @Override
    public double rectangularVolume(){
        return this.diameter * this.diameter * this.height;
    }
}
