## **SOLID Principles:**

### **1️⃣ S - Single Responsibility Principle (SRP)**
The **Single Responsibility Principle** states that a class should have only **one reason to change**, meaning it should have only **one job** or responsibility. This helps in **modularizing code** and making it easier to maintain and update.

#### Example:
```java
// Violating SRP
class User {
    public void saveUserToDatabase() {
        // Save user data to the database
    }

    public void sendUserEmail() {
        // Send email to user
    }
}

// Refactored (Complies with SRP)
class User {
    private String name;
    private String email;
    // User-specific data
}

class UserDatabase {
    public void saveUser(User user) {
        // Save user to the database
    }
}

class EmailService {
    public void sendEmail(String email) {
        // Send email to user
    }
}
```
- **Before**: The `User` class is responsible for saving data and sending emails.
- **After**: The responsibilities are divided among three classes: `User`, `UserDatabase`, and `EmailService`.

### **2️⃣ O - Open/Closed Principle (OCP)**
The **Open/Closed Principle** says that software entities (classes, modules, functions, etc.) should be **open for extension** but **closed for modification**. This means that you should be able to add new functionality to a class without altering its existing code.

#### Example:
```java
// Violating OCP
class Shape {
    public double area() {
        // return area of a shape
        return 0;
    }
}

class AreaCalculator {
    public double calculateArea(Shape shape) {
        if (shape instanceof Circle) {
            return Math.PI * Math.pow(((Circle) shape).getRadius(), 2);
        } else if (shape instanceof Rectangle) {
            return ((Rectangle) shape).getLength() * ((Rectangle) shape).getWidth();
        }
        return 0;
    }
}

// Refactored (Complies with OCP)
interface Shape {
    double area();
}

class Circle implements Shape {
    private double radius;
    public Circle(double radius) { this.radius = radius; }
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }
}

class Rectangle implements Shape {
    private double length, width;
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    public double area() {
        return length * width;
    }
}

class AreaCalculator {
    public double calculateArea(Shape shape) {
        return shape.area();
    }
}
```
- **Before**: The `AreaCalculator` class has a hardcoded check for different shapes.
- **After**: Each shape is now responsible for calculating its own area, making it easier to add new shapes without modifying the `AreaCalculator` class.

### **3️⃣ L - Liskov Substitution Principle (LSP)**
The **Liskov Substitution Principle** states that objects of a superclass should be replaceable with objects of a subclass without affecting the correctness of the program. In simple terms, derived classes must be substitutable for their base class.

#### Example:
```java
// Violating LSP
class Bird {
    public void fly() {
        System.out.println("Flying");
    }
}

class Ostrich extends Bird {
    @Override
    public void fly() {
        // Ostriches can't fly, so this is incorrect.
        throw new UnsupportedOperationException("Ostrich can't fly");
    }
}

// Refactored (Complies with LSP)
abstract class Bird {
    public abstract void move();
}

class Sparrow extends Bird {
    @Override
    public void move() {
        System.out.println("Flying");
    }
}

class Ostrich extends Bird {
    @Override
    public void move() {
        System.out.println("Running");
    }
}
```
- **Before**: The `Ostrich` class extends `Bird` but violates LSP by overriding the `fly()` method incorrectly.
- **After**: Both `Sparrow` and `Ostrich` implement the `move()` method in a way that makes sense for their specific behavior.

### **4️⃣ I - Interface Segregation Principle (ISP)**
The **Interface Segregation Principle** states that no client should be forced to depend on methods it does not use. This principle encourages creating **smaller, more specific interfaces** instead of a large, general-purpose one.

#### Example:
```java
// Violating ISP
interface Worker {
    void work();
    void eat();
}

class Employee implements Worker {
    @Override
    public void work() {
        System.out.println("Employee is working");
    }

    @Override
    public void eat() {
        System.out.println("Employee is eating");
    }
}

class Robot implements Worker {
    @Override
    public void work() {
        System.out.println("Robot is working");
    }

    @Override
    public void eat() {
        // Robots don't eat
        throw new UnsupportedOperationException("Robot can't eat");
    }
}

// Refactored (Complies with ISP)
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

class Employee implements Workable, Eatable {
    @Override
    public void work() {
        System.out.println("Employee is working");
    }

    @Override
    public void eat() {
        System.out.println("Employee is eating");
    }
}

class Robot implements Workable {
    @Override
    public void work() {
        System.out.println("Robot is working");
    }
}
```
- **Before**: The `Robot` class is forced to implement the `eat()` method, which it doesn't need.
- **After**: The interfaces are split into `Workable` and `Eatable`, so `Robot` only implements what it needs.

### **5️⃣ D - Dependency Inversion Principle (DIP)**
The **Dependency Inversion Principle** states that high-level modules should not depend on low-level modules. Both should depend on abstractions (e.g., interfaces). Additionally, **abstractions should not depend on details**; details should depend on abstractions.

#### Example:
```java
// Violating DIP
class LightBulb {
    public void turnOn() {
        System.out.println("Lightbulb turned on");
    }
    public void turnOff() {
        System.out.println("Lightbulb turned off");
    }
}

class Switch {
    private LightBulb bulb;
    public Switch(LightBulb bulb) {
        this.bulb = bulb;
    }

    public void operate() {
        // Direct dependency on the LightBulb class
        bulb.turnOn();
    }
}

// Refactored (Complies with DIP)
interface Switchable {
    void turnOn();
    void turnOff();
}

class LightBulb implements Switchable {
    public void turnOn() {
        System.out.println("Lightbulb turned on");
    }
    public void turnOff() {
        System.out.println("Lightbulb turned off");
    }
}

class Switch {
    private Switchable device;
    public Switch(Switchable device) {
        this.device = device;
    }

    public void operate() {
        device.turnOn();
    }
}
```
- **Before**: The `Switch` class directly depends on `LightBulb`.
- **After**: The `Switch` class depends on an abstraction (`Switchable`), allowing it to work with any device that implements the interface.

---

---

1. **Single Responsibility Principle (SRP)**: A class should have only one reason to change.
2. **Open/Closed Principle (OCP)**: A class should be open for extension but closed for modification.
3. **Liskov Substitution Principle (LSP)**: Subtypes must be substitutable for their base types without altering correctness.
4. **Interface Segregation Principle (ISP)**: Clients should not be forced to implement methods they don’t use.
5. **Dependency Inversion Principle (DIP)**: High-level modules should depend on abstractions, not on concrete classes.

y following the SOLID principles, code becomes more flexible, reusable, and easier to maintain. 
