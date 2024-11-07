// Polymorphism: Define a base class Shape with a method draw(). Create two subclasses, Circle and Rectangle, that override the draw() method. Demonstrate polymorphism by calling the draw() method on an array of Shape objects that include instances of Circle and Rectangle.

// Base class Shape
class Shape {
    // Method to be overridden by subclasses
    public void draw() {
        System.out.println("Drawing a Shape......");
    }
}

// Subclass Circle that overrides the draw() method
class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle......");
    }
}

// Subclass Rectangle that overrides the draw() method
class Rectangle extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle......");
    }
}

// Main class to demonstrate polymorphism
public class Polymorphism {
    public static void main(String[] args) {
        // Creating an array of Shape objects containing Circle and Rectangle
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle();     // Instance of Circle
        shapes[1] = new Rectangle();  // Instance of Rectangle
        shapes[2] = new Circle();     // Another instance of Circle

        // Demonstrating polymorphism by calling draw() on each shape
        for (Shape shape : shapes) {
            shape.draw();  // Calls the overridden draw() method based on the object type
        }
    }
}