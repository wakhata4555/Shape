package com.mycompany.shapes;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) throws InvalidShapeException {
        this(radius, "white", false);
    }

    public Circle(double radius, String color, boolean filled) throws InvalidShapeException {
        super(color, filled);
        if (radius <= 0) {
            throw new InvalidShapeException("Radius must be positive. Got: " + radius);
        }
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public void resize(double factor) throws InvalidShapeException {
        if (factor <= 0) {
            throw new InvalidShapeException("Resize factor must be positive. Got: " + factor);
        }
        this.radius *= factor;
    }

    public double getRadius() { 
        return radius; 
    }
}