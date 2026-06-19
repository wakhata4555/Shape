package com.mycompany.shapes;

public class InvalidShapeException extends Exception {
    public InvalidShapeException(String message) {
        super(message);
    }
}