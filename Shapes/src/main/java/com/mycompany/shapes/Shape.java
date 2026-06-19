package com.mycompany.shapes;

public abstract class Shape {
    protected String color;
    protected boolean filled;

    public Shape() {
        this.color = "white";
        this.filled = false;
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public abstract double getArea();
    public abstract double getPerimeter();
    public abstract void resize(double factor) throws InvalidShapeException;

    @Override
    public String toString() {
        return "Shape[color: " + color + ", filled: " + filled + 
               ", area: " + String.format("%.2f", getArea()) + 
               ", perimeter: " + String.format("%.2f", getPerimeter()) + "]";
    }
}