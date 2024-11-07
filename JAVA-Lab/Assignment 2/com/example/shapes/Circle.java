package com.example.shapes;

public class Circle {

    public void calculateCircumference(double radius) {
        System.out.println("The Circumference of Circle with radius " + radius + " is " + 2 * Math.PI * radius);
    }
    
    public void calculateArea(double radius) {
        System.out.println("The Area of Circle with radius " + radius + " is " + Math.PI * Math.pow(radius, 2));
    }
}