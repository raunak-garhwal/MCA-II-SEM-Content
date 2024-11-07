// Interfaces: Define an interface Vehicle with methods start() and stop(). Create two classes Car and Bike that implement this interface. Write a program to demonstrate the use of the interface by calling the methods on objects of Car and Bike. 

// Define the Vehicle interface with start() and stop() methods
interface Vehicle {
    void start();
    void stop();
}

// Implementing the Vehicle interface in the Car class
class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car is starting...");
    }

    @Override
    public void stop() {
        System.out.println("Car is stopping...");
    }
}

// Implementing the Vehicle interface in the Bike class
class Bike implements Vehicle {
    @Override
    public void start() {
        System.out.println("Bike is starting...");
    }

    @Override
    public void stop() {
        System.out.println("Bike is stopping...");
    }
}

// Main class to demonstrate the use of the interface
public class Interfaces {
    public static void main(String[] args) {
        // Creating objects of Car and Bike
        Vehicle myCar = new Car();
        Vehicle myBike = new Bike();

        // Calling start and stop methods on Car object
        myCar.start();
        myCar.stop();

        // Calling start and stop methods on Bike object
        myBike.start();
        myBike.stop();
    }
}