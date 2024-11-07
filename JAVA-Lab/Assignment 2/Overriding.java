// Method Overriding: Create a base class Animal with a method makeSound(). Create subclasses Dog and Cat that override the makeSound() method. Write a program to demonstrate method overriding by calling the makeSound() method on objects of Dog and Cat.

class Animal {
    public void makeSound() {
        System.out.println("Animal is speaking.....");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog is speaking.....");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Cat is speaking.....");
    }
}

public class Overriding {
    public static void main(String[] args) {
        Animal animal_obj = new Animal();
        Dog dog_obj = new Dog();
        Cat cat_obj = new Cat();

        System.out.println();
        animal_obj.makeSound();
        dog_obj.makeSound();
        cat_obj.makeSound();
    }
}