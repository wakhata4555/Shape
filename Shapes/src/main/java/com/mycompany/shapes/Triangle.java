package com.mycompany.shapes;

public class Triangle extends Shape {
    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1, double side2, double side3) throws InvalidShapeException {
        this(side1, side2, side3, "white", false);
    }

    public Triangle(double side1, double side2, double side3, String color, boolean filled) 
            throws InvalidShapeException {
        super(color, filled);
        
        // Check for positive sides
        if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
            throw new InvalidShapeException("All sides must be positive. Got: " + 
                                           side1 + ", " + side2 + ", " + side3);
        }
        
        // Check triangle inequality: sum of any two sides must be greater than the third
        if (side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1) {
            throw new InvalidShapeException("Invalid triangle: sides " + 
                                           side1 + ", " + side2 + ", " + side3 + 
                                           " violate triangle inequality.");
        }
        
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double getArea() {
        // Heron's formula: area = sqrt(s * (s-a) * (s-b) * (s-c))
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public void resize(double factor) throws InvalidShapeException {
        if (factor <= 0) {
            throw new InvalidShapeException("Resize factor must be positive. Got: " + factor);
        }
        this.side1 *= factor;
        this.side2 *= factor;
        this.side3 *= factor;
    }

    public double getSide1() { 
        return side1; 
    }
    
    public double getSide2() { 
        return side2; 
    }
    
    public double getSide3() { 
        return side3; 
    }
}