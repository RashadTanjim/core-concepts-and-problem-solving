### **1️⃣ Singleton Pattern**
The **Singleton Pattern** ensures that a class has only **one instance** and provides a global point of access to it.

#### Key Features:
- Guarantees only one instance of the class.
- Provides **global access** to the instance.
- **Lazy Initialization**: Instance is created when needed.

#### Example:
```java
public class Singleton {
    private static Singleton instance;

    // Private constructor to prevent instantiation
    private Singleton() {}

    // Lazy initialization - thread-safe
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

#### Thread-Safety Consideration:
- The `synchronized` keyword ensures that the instance is **created only once** even in a multi-threaded environment.
- **Double-Checked Locking** improves performance by avoiding synchronization after the instance is created.

```java
public class Singleton {
    private static volatile Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
```

### **2️⃣ Builder Pattern**
The **Builder Pattern** is used to construct a complex object step by step. It allows you to create an object with various configurations while maintaining readability and immutability.

#### Key Features:
- **Immutability**.
- Provides a fluent API to construct an object.

#### Example:
```java
public class Computer {
    private String CPU;
    private String RAM;
    private String storage;

    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
    }

    @Override
    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", storage=" + storage + "]";
    }

    // Static inner Builder class
    public static class Builder {
        private String CPU;
        private String RAM;
        private String storage;

        public Builder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        public Builder setRAM(String RAM) {
            this.RAM = RAM;
            return this;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
```

#### Usage:
```java
Computer computer = new Computer.Builder()
                        .setCPU("Intel i7")
                        .setRAM("16GB")
                        .setStorage("512GB SSD")
                        .build();
System.out.println(computer);
```

### **3️⃣ Factory Pattern**
The **Factory Pattern** defines an interface for creating objects, but it allows subclasses to alter the type of objects that will be created. It’s particularly useful when the creation logic is complex.

#### Key Features:
- **Object creation is encapsulated**.
- Promotes **loose coupling** between client classes and concrete classes.

#### Example:
```java
// Product interface
interface Vehicle {
    void drive();
}

// Concrete Products
class Car implements Vehicle {
    public void drive() {
        System.out.println("Driving a car.");
    }
}

class Bike implements Vehicle {
    public void drive() {
        System.out.println("Riding a bike.");
    }
}

// Factory Class
class VehicleFactory {
    public static Vehicle getVehicle(String type) {
        if ("car".equalsIgnoreCase(type)) {
            return new Car();
        } else if ("bike".equalsIgnoreCase(type)) {
            return new Bike();
        }
        throw new IllegalArgumentException("Unknown vehicle type.");
    }
}
```

#### Usage:
```java
Vehicle vehicle = VehicleFactory.getVehicle("car");
vehicle.drive();
```

### **4️⃣ Abstract Factory Pattern**
The **Abstract Factory Pattern** provides an interface for creating families of related or dependent objects without specifying their concrete classes.

#### Key Features:
- Factory for creating families of related objects.
- Ensures that a class doesn’t depend on the concrete classes.

#### Example:
```java
// Abstract Factory
interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// Concrete Factory
class WinFactory implements GUIFactory {
    public Button createButton() {
        return new WinButton();
    }

    public Checkbox createCheckbox() {
        return new WinCheckbox();
    }
}

// Abstract Products
interface Button {
    void render();
}

interface Checkbox {
    void render();
}

// Concrete Products
class WinButton implements Button {
    public void render() {
        System.out.println("Rendering WinButton.");
    }
}

class WinCheckbox implements Checkbox {
    public void render() {
        System.out.println("Rendering WinCheckbox.");
    }
}
```

#### Usage:
```java
GUIFactory factory = new WinFactory();
Button button = factory.createButton();
button.render();
```

### **5️⃣ Prototype Pattern**
The **Prototype Pattern** is used to create new objects by cloning existing ones. This is helpful when the cost of creating a new instance is expensive or complicated.

#### Key Features:
- **Object Cloning**.
- Avoids the overhead of new object creation.

#### Example:
```java
interface Prototype {
    Prototype clone();
}

class ConcretePrototype implements Prototype {
    private String name;

    public ConcretePrototype(String name) {
        this.name = name;
    }

    @Override
    public Prototype clone() {
        return new ConcretePrototype(this.name);
    }

    @Override
    public String toString() {
        return "ConcretePrototype [name=" + name + "]";
    }
}
```

#### Usage:
```java
ConcretePrototype prototype1 = new ConcretePrototype("Prototype 1");
ConcretePrototype prototype2 = (ConcretePrototype) prototype1.clone();
System.out.println(prototype2);
```

### **6️⃣ Observer Pattern**
The **Observer Pattern** defines a one-to-many dependency between objects. When one object changes its state, all dependent objects are notified and updated automatically.

#### Key Features:
- **Loose coupling** between subjects and observers.
- Used in **event handling** systems.

#### Example:
```java
interface Observer {
    void update(String message);
}

class ConcreteObserver implements Observer {
    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received: " + message);
    }
}

class Subject {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
```

#### Usage:
```java
Subject subject = new Subject();
Observer observer1 = new ConcreteObserver("Observer 1");
Observer observer2 = new ConcreteObserver("Observer 2");

subject.addObserver(observer1);
subject.addObserver(observer2);

subject.notifyObservers("Hello, Observers!");
```

### **7️⃣ Strategy Pattern**
The **Strategy Pattern** defines a family of algorithms, encapsulates each one, and makes them interchangeable. The strategy allows the algorithm to be selected at runtime.

#### Key Features:
- Algorithms can be swapped at runtime.
- Reduces the need for conditional logic (e.g., `if-else`).

#### Example:
```java
interface Strategy {
    int execute(int a, int b);
}

class Addition implements Strategy {
    @Override
    public int execute(int a, int b) {
        return a + b;
    }
}

class Subtraction implements Strategy {
    @Override
    public int execute(int a, int b) {
        return a - b;
    }
}

class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int a, int b) {
        return strategy.execute(a, b);
    }
}
```

#### Usage:
```java
Context context = new Context(new Addition());
System.out.println(context.executeStrategy(5, 3)); // Output: 8

context = new Context(new Subtraction());
System.out.println(context.executeStrategy(5, 3)); // Output: 2
```

---

---

- **Singleton**: Ensures only one instance of a class.
- **Builder**: A flexible, fluent approach for creating complex objects.
- **Factory**: Encapsulates object creation logic.
- **Abstract Factory**: Creates families of related objects.
- **Prototype**: Uses object cloning to create new instances.
- **Observer**: Implements the publish-subscribe model.
- **Strategy**: Allows interchangeable algorithms at runtime.
