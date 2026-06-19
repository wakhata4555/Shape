package com.mycompany.shapes;

public class ShapeDemo {
    
    // (d) Method to print areas using dynamic binding
    public static void printAreas(Shape[] shapes) {
        System.out.println("Areas of all shapes:");
        for (int i = 0; i < shapes.length; i++) {
            System.out.println("Shape " + (i + 1) + ": " + 
                             String.format("%.2f", shapes[i].getArea()));
        }
    }
    
    // (d) Method to find the largest shape
    public static Shape largest(Shape[] shapes) {
        if (shapes == null || shapes.length == 0) {
            return null;
        }
        
        Shape largest = shapes[0];
        for (Shape shape : shapes) {
            if (shape.getArea() > largest.getArea()) {
                largest = shape;
            }
        }
        return largest;
    }
    
    public static void main(String[] args) {
        System.out.println("========== QUESTION 2 - SHAPE DEMO ==========\n");
        
        // (c) Demonstrate creating valid shapes
        System.out.println("=== CREATING VALID SHAPES ===\n");
        
        try {
            Circle circle = new Circle(5.0, "red", true);
            Rectangle rect = new Rectangle(4.0, 6.0, "blue", false);
            Triangle triangle = new Triangle(3, 4, 5, "green", true);
            
            System.out.println("Valid shapes created successfully:");
            System.out.println("1. " + circle);
            System.out.println("2. " + rect);
            System.out.println("3. " + triangle);
            
            // Demonstrate resize
            System.out.println("\n=== DEMONSTRATING RESIZE ===\n");
            System.out.println("Resizing circle by factor 2...");
            circle.resize(2);
            System.out.println("After resize: " + circle);
            
            System.out.println("\nResizing rectangle by factor 0.5...");
            rect.resize(0.5);
            System.out.println("After resize: " + rect);
            
            System.out.println("\nResizing triangle by factor 3...");
            triangle.resize(3);
            System.out.println("After resize: " + triangle);
            
            // (c) Demonstrate catching InvalidShapeException
            System.out.println("\n=== CATCHING INVALID SHAPE EXCEPTIONS ===\n");
            
            // Test 1: Invalid triangle (violates triangle inequality)
            System.out.println("Test 1: Creating invalid triangle (1, 1, 3)...");
            try {
                Triangle invalidTriangle = new Triangle(1, 1, 3);
                System.out.println("This should not print - triangle is invalid");
            } catch (InvalidShapeException e) {
                System.out.println("✓ CAUGHT EXCEPTION: " + e.getMessage());
            }
            
            // Test 2: Invalid radius
            System.out.println("\nTest 2: Creating circle with negative radius...");
            try {
                Circle invalidCircle = new Circle(-5.0);
                System.out.println("This should not print - radius is invalid");
            } catch (InvalidShapeException e) {
                System.out.println("✓ CAUGHT EXCEPTION: " + e.getMessage());
            }
            
            // Test 3: Invalid resize factor
            System.out.println("\nTest 3: Resizing with negative factor...");
            try {
                Circle circle2 = new Circle(3.0);
                circle2.resize(-2);
                System.out.println("This should not print - resize factor is invalid");
            } catch (InvalidShapeException e) {
                System.out.println("✓ CAUGHT EXCEPTION: " + e.getMessage());
            }
            
            // (d) Demonstrate printAreas and largest methods
            System.out.println("\n=== DEMONSTRATING printAreas() AND largest() ===\n");
            
            Shape[] shapes = new Shape[3];
            shapes[0] = new Circle(5.0, "red", true);
            shapes[1] = new Rectangle(4.0, 6.0, "blue", false);
            shapes[2] = new Triangle(3, 4, 5, "green", true);
            
            printAreas(shapes);
            
            System.out.println("\n=== FINDING LARGEST SHAPE ===\n");
            Shape largestShape = largest(shapes);
            System.out.println("The shape with the largest area is:");
            System.out.println(largestShape);
            System.out.println("Area: " + String.format("%.2f", largestShape.getArea()));
            
        } catch (InvalidShapeException e) {
            System.out.println("Error creating shape: " + e.getMessage());
        }
    }
}