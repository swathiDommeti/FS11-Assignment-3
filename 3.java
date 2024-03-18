abstract class Shape {
    abstract void draw(); // Abstract method
    
    void display() { // Non-abstract method
        System.out.println("Displaying shape...");
    }
}

class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing circle...");
    }
}

class Rectangle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing rectangle...");
    }
}

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape rectangle = new Rectangle();
        
        circle.draw();
        rectangle.draw();
        
        circle.display();
        rectangle.display();
    }
}