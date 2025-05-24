# CS Java Core Concepts and Object-Oriented Programming

It's a combined list of Java Core Concepts! I'll answer each one concisely with explanations and code samples where
necessary.

### 🔸 **What is Java?**

Java is a high-level, object-oriented programming language developed by Sun Microsystems (now owned by Oracle). It is
designed to be platform-independent, secure, and robust.
Java is widely used for building enterprise applications, mobile applications (Android), and web applications.

---

### 🔸 **What’s the difference between JDK, JRE, and JVM?**

- **JDK (Java Development Kit)**: Includes everything needed for Java development—JRE, compilers, and debugging tools.
- **JRE (Java Runtime Environment)**: Contains JVM and libraries required to run Java applications but does not include
  compilers.
- **JVM (Java Virtual Machine)**: Converts Java bytecode into machine code and executes it.

---

### 🔸 **Why is Java considered platform-independent?**

Java code is compiled into **bytecode** (`.class` files) which is executed by the JVM. Since each OS has its own JVM,
Java programs can run anywhere without modification (Write Once, Run Anywhere).

---

### 🔸 **Difference between an abstract class and an interface?**

| Feature     | Abstract Class                              | Interface                             |
|-------------|---------------------------------------------|---------------------------------------|
| Methods     | Can have both abstract and concrete methods | Only abstract methods (before Java 8) |
| Variables   | Can have instance variables                 | Only static & final variables         |
| Inheritance | Can extend only one abstract class          | Can implement multiple interfaces     |

```java
abstract class Animal {
    abstract void makeSound();
}

interface Pet {
    void play();
}

class Dog extends Animal implements Pet {
    void makeSound() {
        System.out.println("Bark");
    }

    public void play() {
        System.out.println("Playing!");
    }
}
```

---

### 🔸 **What’s the role of `final`, `finally`, and `finalize` in Java?**
- **`final`**: Used for constants (`final int x=10;`), method restriction (`final void show(){}`), and class
  restriction (`final class A{}`).
- **`finally`**: A block that executes after `try-catch`, ensuring cleanup.
- **`finalize`**: A method called by the Garbage Collector before an object is removed.

```java
class Demo {
    protected void finalize() {
        System.out.println("Object destroyed");
    }
}
```

---

### 🔸 **Stack vs. heap memory, what’s the difference?**
- **Stack**: Stores method calls, local variables. Faster access, memory is freed automatically.
- **Heap**: Stores objects, accessible globally. Requires Garbage Collection.

```java
class Demo {
    int a = 10;  // Stored in heap

    void show() {
        int b = 20; // Stored in stack
    }
}
```

---

### 🔸 **Method overloading vs. method overriding?**
- **Overloading**: Same method name, different parameters (compile-time polymorphism).
- **Overriding**: Redefining a method in a subclass (runtime polymorphism).

```java
class A {
    void show(int a) {
        System.out.println(a);
    } // Overloading
}

class B extends A {
    @Override
    void show(int a) {
        System.out.println("Overridden: " + a);
    } // Overriding
}
```

---

### 🔸 **Difference between `private` and `protected` access modifiers?**
- **`private`**: Accessible only within the same class.
- **`protected`**: Accessible within the same package and subclasses.

```java
class A {
    private int x = 10; // Not accessible outside this class
    protected int y = 20; // Accessible in subclasses
}
```

---

### 🔸 **What’s constructor overloading in Java?**
Multiple constructors with different parameters.

```java
class Car {
    Car() {
        System.out.println("Default Constructor");
    }

    Car(String model) {
        System.out.println("Car model: " + model);
    }
}
```

---

### 🔸 **Purpose of the `super` keyword in Java?**
Used to call parent class constructors or methods.

```java
class A {
    A() {
        System.out.println("Parent constructor");
    }
}

class B extends A {
    B() {
        super();
        System.out.println("Child constructor");
    }
}
```

---

### 🔸 **What’s the purpose of static blocks in Java?**
Used to initialize static variables.

```java
class Demo {
    static {
        System.out.println("Static block executed first");
    }
}
```

---

### 🔸 **What is the use of the `this` keyword in constructors?**
Used to call another constructor in the same class.

```java
class A {
    A() {
        this(10);
        System.out.println("Default Constructor");
    }

    A(int x) {
        System.out.println("Parameterized Constructor: " + x);
    }
}
```

---

### 🔸 **What are the Object-Oriented features supported by Java?**
1. Encapsulation
2. Inheritance
3. Polymorphism
4. Abstraction

---

### 🔸 **Difference between composition and inheritance?**
- **Inheritance**: "Is-a" relationship (Dog extends Animal).
- **Composition**: "Has-a" relationship (Car has Engine).

```java
class Engine {
}

class Car {
    Engine engine;
}
```

---

### 🔸 **Explain the diamond problem in Java and its solution.**
When a class inherits from two interfaces that have the same method. Java solves this using default methods.

```java
interface A {
    default void show() {
        System.out.println("A");
    }
}

interface B {
    default void show() {
        System.out.println("B");
    }
}

class C implements A, B {
    public void show() {
        A.super.show();
    } // Explicitly choosing
}
```

---

### 🔸 **Why are Strings immutable in Java?**
- Security (prevents modification)
- Caching (String Pool)
- Thread Safety
- Strings are immutable, meaning once created, they cannot be changed.
- This is done for security, performance, and thread-safety reasons.

```java
String s = "Hello";
s.concat(" World");  // Doesn't modify original string
```

---

### 🔸 **What is the String Pool in Java?**
The String Pool is a special memory area in the heap where Java stores string literals. It helps save memory by reusing
immutable string objects.

```java
String s1 = "Hello";
String s2 = "Hello"; // s1 and s2 point to the same object in the String Pool
```

---

### 🔸 **Difference between `String`, `StringBuilder`, and `StringBuffer`?**

| Feature     | `String` | `StringBuilder` | `StringBuffer` |
|-------------|----------|-----------------|----------------|
| Immutable   | ✅ Yes    | ❌ No            | ❌ No           |
| Thread-Safe | ❌ No     | ❌ No            | ✅ Yes          |
| Performance | Slower   | Faster          | Slower         |

```java
String str = "Hello"; // Immutable
StringBuilder sb = new StringBuilder("Hello"); // Mutable, not thread-safe
StringBuffer sbr = new StringBuffer("Hello"); // Mutable, thread-safe
```

---

### 🔸 **ArrayList vs. LinkedList, key differences?**

| Feature            | ArrayList         | LinkedList            |
|--------------------|-------------------|-----------------------|
| Access Time        | Fast (O(1))       | Slow (O(n))           |
| Insertion/Deletion | Slow (O(n))       | Fast (O(1))           |
| Memory Usage       | Less (contiguous) | More (non-contiguous) |

---

### 🔸 **HashMap vs HashSet**

| Feature        | HashMap            | HashSet                      |
|----------------|--------------------|------------------------------|
| Key-Value Pair | ✅ Yes              | ❌ No                         |
| Duplicates     | ❌ No               | ✅ No                         |
| Null Values    | ✅ Yes (1 null key) | ✅ Yes (multiple null values) |

---

### 🔸 **HashMap Load Factors**
- **Load factor** is a measure that decides when to increase the capacity of the `HashMap` to maintain efficient
  performance.
- **Default load factor** is `0.75`. When the number of entries exceeds `capacity * load factor`, the map is resized (
  rehashing).
- **Lower load factor**: Less memory efficient, but faster lookups.
- **Higher load factor**: More memory efficient, but slower lookups due to more collisions.
- You can set the load factor in the constructor:
  ```java
  HashMap<String, Integer> map = new HashMap<>(16, 0.75f);
  ```

---

### 🔸 **What is an exception in Java?**
An error that occurs at runtime.

```java
try{
int x = 10 / 0;
}catch(
ArithmeticException e){
        System.out.

println("Cannot divide by zero");
}
```

---

### 🔸 **Difference between `throw` and `throws`?**

| Feature | `throw`                               | `throws`                             |
|---------|---------------------------------------|--------------------------------------|
| Purpose | Used to throw an exception explicitly | Declares an exception that may occur |
| Used in | Method body                           | Method signature                     |

```java
void method() throws IOException {
    throw new IOException("Error occurred");
}
```

---

### 🔸 **Checked vs. unchecked exceptions?**
- **Checked**: Must be handled (e.g., `IOException`).
- **Unchecked**: Can be ignored (e.g., `NullPointerException`).

---

### 🔸 **What is a thread, and what are the stages of its lifecycle?**
- New → Runnable → Running → Blocked → Terminated.

```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread running");
    }
}
```

---

### 🔸 **Difference between `synchronized` and `volatile` in Java?**
- **`synchronized`**: Locks code blocks to prevent race conditions.
- **`volatile`**: Ensures visibility of changes to variables across threads.

```java
volatile int x = 10;
```

---

### 🔸 **What is a deadlock? How can it be avoided?**
When two threads wait on each other to release resources.

```java
synchronized(obj1){synchronized(obj2){ /* Deadlock scenario */ }}
```

Avoided by always acquiring locks in the same order.

---

### 🔸 **Use of `wait()` and `notify()` methods in threads?**
These are used for **inter-thread communication** in Java.

- **`wait()`**: Makes the thread wait until another thread calls `notify()`.
- **`notify()`**: Wakes up a single waiting thread.
- **`notifyAll()`**: Wakes up all waiting threads.

#### Example:
```java
class SharedResource {
    synchronized void waitMethod() throws InterruptedException {
        System.out.println("Waiting...");
        wait();  // Releases the lock and waits
        System.out.println("Resumed...");
    }

    synchronized void notifyMethod() {
        System.out.println("Notifying...");
        notify();  // Wakes up a waiting thread
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        SharedResource obj = new SharedResource();

        new Thread(() -> {
            try {
                obj.waitMethod();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(1000);
                obj.notifyMethod();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
```

---

### 🔸 **`synchronized` vs. `volatile` in Java?**

| Feature                 | `synchronized`               | `volatile`                                  |
|-------------------------|------------------------------|---------------------------------------------|
| Usage                   | Locks methods/blocks         | Ensures visibility of changes to a variable |
| Performance             | More overhead due to locking | Faster, no locking                          |
| Prevents Race Condition | ✅ Yes                        | ❌ No                                        |

Example of **`volatile`**:

```java
class Shared {
    volatile boolean flag = false;
}
```
**Use `volatile` only for visibility, not for atomic operations!**

---

### 🔸 **Difference between `notify()` and `notifyAll()`?**
- **`notify()`** wakes up **one** waiting thread.
- **`notifyAll()`** wakes up **all** waiting threads.

```java
synchronized(obj) {
    obj.notify();    // Only one waiting thread wakes up
    obj.notifyAll(); // All waiting threads wake up
}
```

---

### 🔸 **What is the `java.util` package?**
The `java.util` package contains utility classes for data structures, collections, and other utility functions.

- **Collections Framework**: `List`, `Set`, `Map`, etc.
- **Date and Time**: `Date`, `Calendar`, `LocalDateTime`.
- **Random Number Generation**: `Random
- **Utility Classes**: `Collections`, `Arrays`.
- **Properties**: For configuration files.
- **Observer Pattern**: `Observable`, `Observer`.
- **Regular Expressions**: `Pattern`, `Matcher`.
- **Concurrency Utilities**: `Timer`, `ThreadPoolExecutor`.
- **Functional Interfaces**: `Function`, `Consumer`, `Supplier`.
- **Stream API**: For functional-style operations on collections.
- **Optional**: For handling optional values.
- **UUID**: For generating unique identifiers.
- **Resource Bundles**: For internationalization (i18n).
- **BitSet**: For manipulating bits.
- **Stack**: For stack operations.
- **Queue**: For queue operations.
- **Deque**: For double-ended queue operations.
- **PriorityQueue**: For priority queue operations.
- **LinkedList**: For linked list operations.
- **Vector**: For dynamic arrays.
- **Hashtable**: For key-value pairs with synchronization.
- **Properties**: For key-value pairs with persistence.
- **Scanner**: For reading input from various sources.
- **Random**: For generating random numbers.
- **Timer**: For scheduling tasks.
- **TimerTask**: For creating tasks to be scheduled by Timer.
- **Locale**: For localization and internationalization.
- **ResourceBundle**: For managing locale-specific objects.

---

### 🔸 **What is the `java.util.concurrent` package used for?**
It provides better performance and **thread-safe** alternatives to `synchronized`:

- **Executors** (`ThreadPoolExecutor`)
- **Locks** (`ReentrantLock`)
- **Concurrent Collections** (`ConcurrentHashMap`)
- **Atomic Variables** (`AtomicInteger`)

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " executing...");
    }
}

public class ThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) executor.submit(new Task());
        executor.shutdown();
    }
}
```

---

### 🔸 **What is the `java.util.stream` package?**
The `java.util.stream` package provides a **functional approach** to processing sequences of elements (collections,
arrays) in a declarative way.

- **Streams**: Represent a sequence of elements.
- **Intermediate Operations**: `filter()`, `map()`, `sorted()`.
- **Terminal Operations**: `collect()`, `forEach()`, `reduce()`.
- **Parallel Streams**: For parallel processing.
- **Collectors**: For collecting results (e.g., `toList()`, `toSet()`).
- **Optional**: For handling optional values.
- **FlatMap**: For flattening nested structures.
- **Distinct**: For removing duplicates.
- **Limit/Skip**: For limiting or skipping elements.
- **Peek**: For debugging.
- **Match**: For checking conditions (e.g., `anyMatch()`, `allMatch()`).
- **Count**: For counting elements.
- **Reduce**: For reducing elements to a single value.
- **GroupingBy**: For grouping elements by a classifier function.
- **PartitioningBy**: For partitioning elements into two groups.
- **Joining**: For joining strings.
- **Summarizing**: For summarizing elements (e.g., `summarizingInt()`).
- **Mapping**: For transforming elements.
- **Boxing/Unboxing**: For converting between primitives and objects.
- **FlatMapToInt/Double/Long**: For flattening and mapping to primitive types.
- **IntStream/DoubleStream/LongStream**: For working with primitive streams.
- **Collectors.toMap()**: For collecting elements into a map.
- **Collectors.toSet()**: For collecting elements into a set.
- **Collectors.toList()**: For collecting elements into a list.
- **Collectors.groupingBy()**: For grouping elements by a classifier function.
- **Collectors.partitioningBy()**: For partitioning elements into two groups.
- **Collectors.teeing()**: For combining two collectors.
- **Collectors.mapping()**: For transforming elements during collection.
- **Collectors.counting()**: For counting elements.
- **Collectors.summingInt()**: For summing integer values.
- **Collectors.averagingInt()**: For averaging integer values.
- **Collectors.summarizingInt()**: For summarizing integer values.
- **Collectors.joining()**: For joining strings.
- **Collectors.groupingByConcurrent()**: For concurrent grouping.
- **Collectors.toConcurrentMap()**: For collecting into a concurrent map.
- **Collectors.toConcurrentSet()**: For collecting into a concurrent set.
- **Collectors.toConcurrentList()**: For collecting into a concurrent list.

---

### 🔸 **Difference between `HashMap` and `TreeMap`?**

| Feature     | `HashMap`    | `TreeMap`                       |
|-------------|--------------|---------------------------------|
| Ordering    | No order     | Sorted order (natural ordering) |
| Performance | O(1) average | O(log n)                        |
| Null Keys   | ✅ Allowed    | ❌ Not allowed                   |

```java
Map<Integer, String> map = new HashMap<>();
map.put(1, "Apple");
map.put(3, "Banana");
map.put(2, "Cherry");

Map<Integer, String> treeMap = new TreeMap<>(map);  // Sorted
```

---

### 🔸 **Difference between `Iterator` and `ListIterator`?**

| Feature     | `Iterator`   | `ListIterator`     |
|-------------|--------------|--------------------|
| Traversal   | Forward only | Forward & Backward |
| Modify List | ❌ No add     | ✅ Can add elements |

```java
List<String> list = new ArrayList<>(List.of("A", "B", "C"));
ListIterator<String> it = list.listIterator();
while (it.hasNext()) 
    System.out.println(it.next());
```

---

### 🔸 **What is the `Comparable` interface?**
Used to define **natural ordering** of objects.

```java
class Student implements Comparable<Student> {
    int age;

    Student(int age) {
        this.age = age;
    }

    public int compareTo(Student s) {
        return this.age - s.age;
    }
}
```

For **custom sorting**, use `Comparator`.

---

### 🔸 **What happens if an exception is not caught?**
The JVM terminates the program, printing the **stack trace**.

```java
public class Main {
    public static void main(String[] args) {
        int x = 10 / 0; // Throws ArithmeticException
    }
}
```
Output:
```
Exception in thread "main" java.lang.ArithmeticException: / by zero
```

---

### 🔸 **How do you create a custom exception?**
Extend `Exception` for checked exceptions or `RuntimeException` for unchecked ones.

```java
class MyException extends Exception {
    MyException(String message) {
        super(message);
    }
}

class Test {
    void check(int age) throws MyException {
        if (age < 18) throw new MyException("Underage!");
    }
}
```

---

### 🔸 **What is a `ThreadLocal` variable in Java?**
A variable that each thread **gets its own copy of**, avoiding race conditions.

```java
ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 1);
System.out.println(threadLocal.get()); // 1
threadLocal.set(100);
System.out.println(threadLocal.get()); // 100
```

---

### 🔸 **What is a daemon thread?**
A **low-priority background thread** (e.g., Garbage Collector).

```java
Thread t = new Thread(() -> System.out.println("Daemon Running"));
t.setDaemon(true);
t.start();
```

---

### 🔸 **What is `volatile` used for?**
It ensures **visibility** of changes to a variable across threads.

```java
class Shared {
    volatile int count = 0;
}
```
It **does not** guarantee atomicity!

---

### 🔸 **How does Java achieve polymorphism?**
- **Method Overloading** (Compile-time polymorphism)
- **Method Overriding** (Runtime polymorphism)

```java
class Animal {
    void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    void sound() {
        System.out.println("Bark");
    }
}
```

---

### 🔸 **Why use the `finally` block?**
To **ensure cleanup**, even if an exception occurs.

```java
try {
    System.out.println(10 / 0);
} catch (Exception e) {
    System.out.println("Exception caught");
} finally {
    System.out.println("Cleanup done");
}
```

---

### 🔸 **What is a `Marker Interface`?**
An interface with **no methods**, used for tagging.

```java
interface Serializable {
}  // Marker Interface
```

---

### 🔸 **What is context switching in threads?**
When the CPU switches execution between multiple threads.

---

### 🔸 **What is a deadlock? How to avoid it?**
Deadlock occurs when two threads **hold locks** and wait for each other.

**Avoid it by**:
1. Always acquiring locks in the **same order**.
2. Using **tryLock()** instead of `synchronized`.

```java
ReentrantLock lock1 = new ReentrantLock();
ReentrantLock lock2 = new ReentrantLock();

if (lock1.tryLock()) {
    if (lock2.tryLock()) {
        // Safe execution
    }
}
```

---

### 🔸 **What is the `volatile` keyword?**

The `volatile` keyword is used to indicate that a variable's value may be changed by different threads. It ensures
visibility of changes to variables across threads.

```java
class Shared {
    volatile int count = 0; // Ensures visibility
}
```

---

### 🔸 **What is the difference between `Collections` and `Collection`?**
- **`Collection`** (interface): The root interface for all collection types (`List`, `Set`, `Queue`).
- **`Collections`** (utility class): Contains static methods like `sort()`, `reverse()`, `synchronizedList()`.

Example:
```java
List<Integer> list = new ArrayList<>(List.of(3, 1, 2));
Collections.sort(list); // Sorts the list
```

---

### 🔸 **Difference between local and instance variables?**

| Feature       | Local Variable     | Instance Variable                  |
|---------------|--------------------|------------------------------------|
| Scope         | Inside a method    | Inside a class but outside methods |
| Default Value | ❌ No default value | ✅ Default value assigned           |
| Stored in     | Stack memory       | Heap memory                        |

Example:
```java
class Example {
    int instanceVar = 10; // Instance variable

    void method() {
        int localVar = 5; // Local variable
    }
}
```

---

### 🔸 **What is the `transient` keyword?**
The `transient` keyword is used to indicate that a field should not be serialized. When an object is serialized,
transient fields are ignored.

```java
class User implements Serializable {
    String username;
    transient String password; // Not serialized
}
```

---

### 🔸 **Explain the diamond problem in Java and its solution.**
The **diamond problem** occurs when multiple inheritance leads to ambiguity.

Example (in C++ but not Java):

```cpp
class A { void display() {} };
class B : public A {};
class C : public A {};
class D : public B, public C {}; // Diamond problem
```

#### **Solution in Java: Use interfaces!**

Java does **not allow multiple class inheritance**, but you can use **interfaces**:

```java
interface A {
    default void show() {
        System.out.println("A");
    }
}

interface B extends A {
}

interface C extends A {
}

class D implements B, C {
} // No ambiguity
```

---

### 🔸 **Purpose of `this` keyword in constructors?**
Used to refer to the **current instance**.  
Example:
```java
class Example {
    int x;

    Example(int x) {
        this.x = x;
    } // 'this' differentiates instance variable from parameter
}
```

---

### 🔸 **What is constructor overloading?**
Defining **multiple constructors** with different parameters.

```java
class Example {
    Example() {
        System.out.println("No-arg constructor");
    }

    Example(int x) {
        System.out.println("Parameterized constructor");
    }
}
```

---

### 🔸 **What is the `instanceof` operator?**
The `instanceof` operator checks if an object is an instance of a specific class or interface.

```java
class Animal {
}

class Dog extends
        Animal {
}

Animal a = new Dog();
System.out.

println(a instanceof Dog); // true
System.out.

println(a instanceof Animal); // true
```

---

### 🔸 **What are the object-oriented programming (OOP) features/ 4 Pillars in Java?**
1. **Encapsulation** - Data hiding using private fields.
2. **Inheritance** - One class inherits another.
3. **Polymorphism** - Method overloading & overriding.
4. **Abstraction** - Hiding implementation details via abstract classes/interfaces.

---

### 🔸 **What is the difference between `==` and `.equals()`?**
| Feature       | `==`                     | `.equals()`                |
|---------------|--------------------------|----------------------------|
| Comparison    | Reference comparison     | Value comparison           |
| Used for      | Primitive types & references | Objects (default is reference) |
```java
  String s1 = new String("Hello");
  String s2 = new String("Hello");
  System.out.println(s1 == s2); // false (different references)
  System.out.println(s1.equals(s2)); // true (same value)
```

---

### 🔸 **Why are strings immutable in Java?**
1. **Security** - Prevents unauthorized modifications.
2. **Caching** - Java stores strings in **String Pool** to save memory.
3. **Thread-Safety** - Immutable objects are inherently thread-safe.

Example:
```java
String s = "Hello";
s.

concat(" World"); // Creates a new object; does not modify 's'
```

---

### 🔸 **Difference between `new String("abc")` vs `"abc"`?**
```java
String s1 = "abc"; // Stored in String Pool
String s2 = new String("abc"); // Stored in Heap
```

- `"abc"` goes to the **String Pool**, avoiding duplication.
- `new String("abc")` creates **a new object** in the heap.

---

### 🔸 **Purpose of the `super` keyword?**
Used to call **parent class methods or constructors**.

Example:
```java
class Parent {
    Parent() {
        System.out.println("Parent constructor");
    }
}

class Child extends Parent {
    Child() {
        super();
    } // Calls Parent's constructor
}
```

---

### 🔸 **Purpose of static blocks in Java?**
Used to **initialize static variables** before main execution.

```java
class Example {
    static {
        System.out.println("Static block executed!");
    }
}

public class Test {
    public static void main(String[] args) {
        Example obj = new Example();
    }
}
```
**Output:**
```
Static block executed!
```

---

### 🔸 **What is an exception in Java?**
An **unexpected event** that disrupts program flow.

Example:
```java
try {
    int x = 10 / 0; // ArithmeticException
} catch (Exception e) {
    System.out.println("Exception caught!");
}
```

---

### 🔸 **How does exception propagation work?**
If an exception is not caught, it moves **up the call stack**.

```java
void method1() { method2(); }
void method2() { method3(); }
void method3() { int x = 10 / 0; } // Exception propagates
```

---

### 🔸 **Difference between `throw` and `throws`?**

| Feature | `throw`                  | `throws`          |
|---------|--------------------------|-------------------|
| Purpose | Manually throw exception | Declare exception |
| Used in | Method body              | Method signature  |

Example:
```java
void method() throws IOException {
    throw new IOException("Error");
}
```

---

### 🔸 **What is a checked and unchecked exception?**
Checked exceptions are exceptions that must be either caught or declared in the method signature using `throws`.
Example:
```java
void readFile() throws IOException {
    FileReader fr = new FileReader("file.txt"); // Checked exception
}
```

Unchecked exceptions are runtime exceptions that do not need to be declared or caught.
Example:
```java
void divide(int a, int b) {
    int result = a / b; // Unchecked exception (ArithmeticException)
}
```

---

### 🔸 **What happens if an exception is not caught?**
JVM **terminates the program** and prints the stack trace.

---

### 🔸 **How do you rethrow exceptions?**
```java
try {
    throw new IOException();
} catch (IOException e) {
    throw e; // Rethrowing the same exception
}
```

---

### 🔸 **Difference between a process and a thread?**

| Feature       | Process               | Thread               |
|---------------|-----------------------|----------------------|
| Definition    | Independent execution | Part of a process    |
| Memory        | Own memory space      | Shared memory        |
| Communication | Slow (IPC)            | Fast (shared memory) |

---

### 🔸 **Types of thread priorities in Java?**
- **MIN_PRIORITY (1)**
- **NORM_PRIORITY (5)**
- **MAX_PRIORITY (10)**

Example:
```java
Thread t = new Thread();
t.setPriority(Thread.MAX_PRIORITY);
```

---

### 🔸 **What is context switching in threads?**
The CPU **switches from one thread to another**, saving & restoring execution state.

---

### 🔸 **Purpose of synchronization in Java?**
Prevents **race conditions** by allowing **only one thread** to access a method.

```java
class Example {
    synchronized void method() { /* Critical Section */ }
}
```

---

### 🔸 **What is a deadlock? How to avoid it?**
Deadlock occurs when two threads wait on each other **forever**.

Avoid it by:
1. Locking in **same order**.
2. Using **tryLock()**.
3. Avoiding unnecessary locks.

---

### 🔸 **Synchronized vs. volatile in Java?**

| Feature     | `synchronized` | `volatile` |
|-------------|----------------|------------|
| Locks       | ✅ Yes          | ❌ No       |
| Atomicity   | ✅ Yes          | ❌ No       |
| Performance | ❌ Slower       | ✅ Faster   |

---

### 🔸 **Difference between `notify()` and `notifyAll()`?**
- **`notify()`** wakes up **one** thread.
- **`notifyAll()`** wakes up **all** waiting threads.

---

### 🔸 **What is a thread pool?**
A thread pool is a collection of pre-initialized threads that can be reused for executing multiple tasks, improving
performance and resource management.

Example:
```java
StringBuilder sb = new StringBuilder("Hello");
sb.append(" World");  // Faster, not thread-safe

StringBuffer sbf = new StringBuffer("Hello");
sbf.append(" World"); // Thread-safe but slower
```

---

### 🔸 **What are records in Java? (Java 14+)**
- Introduced in Java **14**.
- Used to create **immutable data classes** without boilerplate code.

Example:
```java
record Person(String name, int age) {}
Person p = new Person("Alice", 25);
System.out.println(p.name()); // Alice
```

---

### 🔸 **What are sealed classes in Java? (Java 17+)**
- Restricts which classes can extend it.

Example:
```java
sealed class Vehicle permits Car, Bike {
}

final class Car extends Vehicle {
}  // Allowed

final class Bike extends Vehicle {
} // Allowed
```

---

### 🔸 **What is a memory leak in Java, and how can you prevent it?**
Memory leaks occur when **objects are no longer needed but remain referenced**.

### **Causes of Memory Leaks**
- **Unclosed resources** (e.g., DB connections, streams).
- **Static collections holding objects**.
- **Listeners not removed properly**.

### **How to Prevent?**
1. Use **WeakReference** for caches.
2. **Close resources** in `try-with-resources`.
3. Remove **event listeners** manually.

Example:
```java
try (FileReader reader = new FileReader("file.txt")) {
    // Use reader
} // Automatically closed
```

---

### 🔸 **How does the `compareTo()` method work?**
- Used for **sorting** with `Comparable` interface.
- Returns:
    - `0` → Equal
    - `< 0` → Less than
    - `> 0` → Greater than

Example:
```java
class Student implements Comparable<Student> {
    int age;

    public Student(int age) {
        this.age = age;
    }

    public int compareTo(Student s) {
        return this.age - s.age;
    } // Ascending
}
```

---

### 🔸 **Difference between `Comparator` and `Comparable`**

| Feature       | `Comparable`         | `Comparator`       |
|---------------|----------------------|--------------------|
| Package       | `java.lang`          | `java.util`        |
| Sorting Logic | **Inside the class** | **Separate class** |
| Method        | `compareTo()`        | `compare()`        |

Example:

```java
Comparator<Student> byAge = (s1, s2) -> Integer.compare(s1.age, s2.age);
```

---

### 🔸 **What is the difference between `synchronized` and `Lock`?**

| Feature            | `synchronized`  | `Lock` (ReentrantLock) |
|--------------------|-----------------|------------------------|
| Flexibility        | ❌ Less flexible | ✅ More flexible        |
| Performance        | ❌ Slower        | ✅ Faster               |
| Explicit Locking   | ❌ No            | ✅ Yes                  |
| Try-Lock Mechanism | ❌ No            | ✅ Yes                  |

Example:

```java
Lock lock = new ReentrantLock();
lock.lock();
try { /* Critical section */ }
finally { lock.unlock(); }
```

---

### 🔸 **What is ThreadLocal in Java?**
- Creates **thread-specific variables**.

Example:
```java
ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);
threadLocal.set(5);
System.out.println(threadLocal.get()); // 5
```

---

### 🔸 **What is the difference between Callable and Runnable?**

| Feature            | `Runnable`              | `Callable`                    |
|--------------------|-------------------------|-------------------------------|
| Return Type        | `void`                  | **Returns a value**           |
| Exception Handling | ❌ No checked exceptions | ✅ Supports checked exceptions |

Example:
```java
Callable<Integer> task = () -> 42;  // Returns 42
Future<Integer> future = executor.submit(task);
```

---

### 🔸 **What is the Fork/Join Framework?**
- Used for **parallel processing** (divide-and-conquer).

Example:

```java
class Task extends RecursiveTask<Integer> {
    protected Integer compute() { return 1; } // Example
}
ForkJoinPool pool = new ForkJoinPool();
pool.invoke(new Task());
```

---

### 🔸 **What is a `ConcurrentHashMap`?**
- A thread-safe variant of `HashMap`.
- Allows concurrent access without locking the entire map.
- Uses **segmented locking** for better performance.
- Supports **null keys** and values.
- Allows **parallel processing** of elements.
- Provides **atomic operations** like `putIfAbsent()`, `remove()`, and `replace()`.
- Supports **bulk operations** like `forEach()`, `reduce()`, and `search()`.
- Allows **iterators** to be weakly consistent.
- Supports **custom concurrency levels**.
- Provides **high scalability** for concurrent applications.
- Supports **stream operations** for parallel processing.
- Allows **bulk updates** using `compute()`, `merge()`, and `forEach()`.
- Supports **custom partitioning** for better performance.
- Provides **thread-safe iterators**.
- Supports **asynchronous operations** using `CompletableFuture`.
- Allows **custom load factors** for better performance.
- Supports **custom hashing** for better distribution.
- Provides **thread-safe bulk operations**.
- Supports **custom serialization** for distributed systems.

```java
ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
map.put("A", 1);
map.put("B", 2);
map.putIfAbsent("A", 3); // Does not overwrite
System.out.println(map.get("A")); // 1
```

### 🔸 **What is a `ThreadPoolExecutor`?**
- A class that manages a pool of threads for executing tasks.
- Supports different thread pool types like fixed, cached, and scheduled.
- Allows dynamic resizing of the pool.
- Supports task scheduling with `ScheduledThreadPoolExecutor`.
- Provides methods like `submit()`, `invokeAll()`, and `shutdown()`.
- Allows custom rejection policies for tasks.
- Supports **thread factory** for creating threads.
- Provides **monitoring** and **management** of threads.
- Allows **custom task handling**.
- Supports **asynchronous task execution**.
- Provides **thread lifecycle management**.
- Allows **custom thread naming**.
- Supports **thread priority**.
- Provides **thread pooling** for better performance.
```java
ExecutorService executor = Executors.newFixedThreadPool(3);
executor.submit(() -> {
    System.out.println("Task executed");
});
executor.shutdown();
```

---

### 🔸 **What are ReentrantLock, Semaphore, and CountDownLatch and others?**
- **ReentrantLock**: A lock that allows a thread to re-enter the lock if it already holds it. Provides more flexibility than `synchronized`.
- **Semaphore**: A counting semaphore that controls access to a resource pool. It allows a fixed number of threads to access a resource.
- **CountDownLatch**: A synchronization aid that allows one or more threads to wait until a set of operations being performed in other threads completes.
- **CyclicBarrier**: A synchronization aid that allows a set of threads to all wait for each other to reach a common barrier point.
- **Exchanger**: A synchronization point at which threads can swap elements within pairs.
- **Phaser**: A more flexible version of `CyclicBarrier` and `CountDownLatch` that allows dynamic registration and deregistration of threads.
- **ReadWriteLock**: A lock that allows multiple threads to read or write to a resource concurrently, improving performance for read-heavy workloads.
- **StampedLock**: A lock that provides a way to manage read and write locks with a stamp-based mechanism, allowing for optimistic locking.
- **ThreadFactory**: An interface for creating new threads with custom properties, such as naming and priority.
- **ThreadPoolExecutor**: A class that manages a pool of threads for executing tasks, providing methods for task submission and management.
- **ScheduledExecutorService**: An interface for scheduling tasks to run after a delay or periodically.
- **ForkJoinPool**: A specialized thread pool for parallel processing using the fork/join framework, allowing for efficient task splitting and merging.
- **Future**: A placeholder for a result that will be available in the future, allowing for asynchronous task execution and retrieval of results.
- **CompletableFuture**: A class that represents a future result of an asynchronous computation, allowing for non-blocking operations and chaining of tasks.
- **ExecutorCompletionService**: A service that combines the functionality of an `Executor` and a `BlockingQueue`, allowing for efficient task submission and retrieval of results as they complete.
- **ScheduledFuture**: A future that represents the result of a scheduled task, allowing for retrieval of the result after a delay.
- **ThreadPoolExecutor.AbortPolicy**: A rejection policy that throws an exception when a task cannot be accepted for execution.
- **ThreadPoolExecutor.CallerRunsPolicy**: A rejection policy that runs the task in the calling thread if it cannot be accepted for execution.
- **ThreadPoolExecutor.DiscardPolicy**: A rejection policy that silently discards the task if it cannot be accepted for execution.
- **ThreadPoolExecutor.DiscardOldestPolicy**: A rejection policy that discards the oldest unhandled request and then retries the task.
- **ThreadPoolExecutor**: A class that manages a pool of threads for executing tasks, providing methods for task submission and management.
- **ScheduledThreadPoolExecutor**: A specialized version of `ThreadPoolExecutor` that supports scheduling tasks to run after a delay or periodically.
- **ThreadPoolExecutor**: A class that manages a pool of threads for executing tasks, providing methods for task submission and management.
- **ScheduledThreadPoolExecutor**: A specialized version of `ThreadPoolExecutor` that supports scheduling tasks to run after a delay or periodically.
- **ThreadPoolExecutor**: A class that manages a pool of threads for executing tasks, providing methods for task submission and management.
- **ScheduledThreadPoolExecutor**: A specialized version of `ThreadPoolExecutor` that supports scheduling tasks to run after a delay or periodically.

---

### 🔸 **Difference between `ConcurrentHashMap` and `HashMap`?**

| Feature       | `ConcurrentHashMap`        | `HashMap` |
|---------------|----------------------------|-----------|
| Thread Safety | ✅ Yes                      | ❌ No      |
| Performance   | ✅ Faster (Segmented Locks) | ❌ Slower  |
| Null Keys     | ❌ Not allowed              | ✅ Allowed |

---

### 🔸 **What is a `BlockingQueue`?**
- A thread-safe queue that supports blocking operations.
- Used for **producer-consumer** scenarios.
- Supports operations like `put()`, `take()`, `offer()`, and `poll()`.
- Allows bounded and unbounded queues.
- Supports different implementations like `ArrayBlockingQueue`, `LinkedBlockingQueue`, and `PriorityBlockingQueue`.
- Provides **fairness policies** for thread access.
- Supports **timeout operations**.
- Allows **bulk operations** like `addAll()` and `removeAll()`.
- Supports **iterator** for traversing elements.
- Provides **size limits** for bounded queues.
- Allows **custom capacity** for queues.
- Supports **priority ordering** for elements.
- Provides **thread-safe iterators**.
- Supports **asynchronous operations** using `CompletableFuture`.
- Allows **custom serialization** for distributed systems.
- Supports **custom load factors** for better performance.
- Provides **thread-safe bulk operations**.
- Supports **custom hashing** for better distribution.
- Allows **custom partitioning** for better performance.
- Provides **thread-safe iterators**.
- Supports **custom serialization** for distributed systems.

```java
BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
queue.put(1);  // Blocks if full
queue.take();  // Blocks if empty
```

---

### 🔸 **Difference between `TreeMap`, `HashMap`, and `LinkedHashMap`**

| Feature     | `TreeMap` | `HashMap`  | `LinkedHashMap`   |
|-------------|-----------|------------|-------------------|
| Ordering    | ✅ Sorted  | ❌ No order | ✅ Insertion order |
| Performance | ❌ Slower  | ✅ Fastest  | ✅ Medium          |

---

### 🔸 **What is a `default` method in an interface?**
- Introduced in Java 8.
- Allows **method implementation in interfaces**.

Example:
```java
interface MyInterface {
    default void display() {
        System.out.println("Default Method");
    }
}
```

---

### 🔸 **What is a `static` method in an interface?**

- Introduced in Java 8.
- Allows defining **static methods** in interfaces.
- Can be called without an instance.
- Useful for utility methods.
- Cannot be overridden.
- Example:

```java
interface MyInterface {
    static void staticMethod() {
        System.out.println("Static Method");
    }
}
MyInterface.staticMethod(); // Call without instance
```

---

### 🔸 **What is the difference between `filter()` and `map()` in Streams?**

| Function    | `filter()`       | `map()`             |
|-------------|------------------|---------------------|
| Purpose     | Filters elements | Transforms elements |
| Return Type | `Stream<T>`      | `Stream<R>`         |

Example:

```java
List<Integer> numbers = List.of(1, 2, 3);
numbers.stream().filter(n -> n % 2 == 0).forEach(System.out::println); // 2
numbers.stream().map(n -> n * n).forEach(System.out::println); // 1, 4, 9
```

---

### 🔸 **What is method reference in Java?**
- **Shorthand** for lambda expressions.

Example:
```java
List<String> names = List.of("Alice", "Bob");
names.forEach(System.out::println);
```

---

### 🔸 **What is the `Optional` class in Java?**
- Introduced in Java 8.
- Used to avoid **NullPointerExceptions**.
- Represents a value that may or may not be present.
- Provides methods like `isPresent()`, `ifPresent()`, `orElse()`, and `map()`.
- Example:
```java
Optional<String> name = Optional.ofNullable(null);
name.ifPresent(n -> System.out.println(n)); // Does nothing
String value = name.orElse("Default Name");
System.out.println(value); // Prints "Default Name"
```

---

### 🔸 **What is the Factory Pattern?**
- Creates objects **without exposing the instantiation logic**.

Example:
```java
interface Car {
    void drive();
}

class BMW implements Car {
    public void drive() {
        System.out.println("BMW driving");
    }
}

class CarFactory {
    static Car getCar(String type) {
        return new BMW();
    }
}
```

---

### 🔸 **What is the Observer Pattern?**
- Used for **event-driven programming**.

Example:
```java
class NewsPublisher extends Observable {
    void publish(String news) {
        setChanged();
        notifyObservers(news);
    }
}
```

---

### 🔸 **What is the Java Memory Model (JMM)?**
JMM defines how **threads interact through memory** and ensures:
- Visibility
- Atomicity
- Ordering

#### **Key Concepts:**

| Concept                         | Explanation                                              |
|---------------------------------|----------------------------------------------------------|
| **Happens-before relationship** | Ensures visibility & ordering guarantees across threads. |
| **Volatile variables**          | Ensures visibility but **not atomicity**.                |
| **Synchronization**             | Provides both visibility & atomicity.                    |
| **Final field semantics**       | Ensures safe publication of objects.                     |

Example of **Happens-Before Rule**:
```java
class SharedResource {
    private volatile boolean flag = false;
    
    void writer() { flag = true; } // Happens-before
    
    void reader() {
        if (flag) { // Guaranteed to see true if set in writer()
            System.out.println("Flag is set!");
        }
    }
}
```

---

### 🔸 **What is the ExecutorService?**
- Part of the `java.util.concurrent` package.
- Manages a pool of threads for executing tasks.
- Provides methods like `submit()`, `invokeAll()`, and `shutdown()`.
- Supports **thread pooling** and **task scheduling**.
- Improves performance by reusing threads.
- Handles thread lifecycle management.
- Supports **asynchronous task execution**.
- Can be configured with different thread pool types (fixed, cached, etc.).
- Supports **task prioritization**.
- Provides **error handling** and **task cancellation**.
- Supports **scheduled tasks** with `ScheduledExecutorService`.
- Can be used for **parallel processing**.
- Supports **future results** with `Future<T>`.
- Can be used with **Callable** for tasks that return results.
- Supports **timeout** for task execution.
- Can be used with **ForkJoinPool** for parallel tasks.
- Supports **task queuing** with `BlockingQueue`.
- Supports **task rejection policies**.
- Can be used with **CompletableFuture** for non-blocking tasks.
- Supports **monitoring** and **management** of thread pools.
- Can be used with **ThreadFactory** for custom thread creation.
- Supports **task dependencies** with `CompletionService`.
- Can be used with **CountDownLatch** for synchronization.
- Supports **CyclicBarrier** for coordinating multiple threads.
- Can be used with **Semaphore** for controlling access to resources.
- Supports **Exchanger** for thread communication.
- Can be used with **Phaser** for dynamic thread coordination.
- Supports **ThreadPoolExecutor** for custom thread pool configurations.
- Can be used with **ScheduledThreadPoolExecutor** for scheduled tasks.

---

### 🔸 **Why use `ExecutorService` instead of manually creating threads?**
- **Efficient thread reuse** 🏎
- **Better resource management**
- **Avoids thread explosion**

Example:
```java
ExecutorService executor = Executors.newFixedThreadPool(10);
executor.submit(() -> System.out.println("Task executed"));
executor.shutdown();
```

---

### 🔸 **Thread Pool Types**

| Pool Type                | Description                                        |
|--------------------------|----------------------------------------------------|
| **FixedThreadPool**      | Fixed number of threads. Best for CPU-bound tasks. |
| **CachedThreadPool**     | Dynamically grows. Best for short-lived tasks.     |
| **SingleThreadExecutor** | Ensures tasks execute sequentially.                |
| **WorkStealingPool**     | Uses **ForkJoinPool** for parallelism.             |

---

### 🔸 **JVM Architecture Components**

- **ClassLoader** (Loads `.class` files)
- **Runtime Memory Areas**:
    - **Heap** (Objects stored)
    - **Stack** (Method calls & local vars)
    - **Metaspace** (Stores class metadata)
- **Execution Engine**
- **Garbage Collector (GC)**

---

### 🔸 **Garbage Collection (GC) Strategies**

| GC Type            | Best For          | Key Mechanism                             |
|--------------------|-------------------|-------------------------------------------|
| **Serial GC**      | Small apps        | Single-threaded, simple.                  |
| **Parallel GC**    | High throughput   | Uses multiple threads.                    |
| **G1 GC**          | Large heaps       | Predictable pause times.                  |
| **ZGC** (Java 11+) | Ultra-low latency | Handles **very large** heaps efficiently. |

Example: **Tuning GC with JVM Flags**
```sh
java -XX:+UseG1GC -Xms512m -Xmx4g -XX:MaxGCPauseMillis=200
```

---

### 🔸 **Why use Reflection?**
- Access private fields/methods at runtime.
- Used in **frameworks** like Spring, Hibernate.

Example:
```java
import java.lang.reflect.*;

class Person {
    private String name = "John Doe";
}

public class ReflectionExample {
    public static void main(String[] args) throws Exception {
        Person p = new Person();
        Field field = p.getClass().getDeclaredField("name");
        field.setAccessible(true);
        System.out.println(field.get(p)); // Prints "John Doe"
    }
}
```

---

### 🔸 **What is a Proxy in Java?**
- A class that **acts as an intermediary** for another class.
- Used in **AOP** (Aspect-Oriented Programming).
- Dynamic proxies can be created using `java.lang.reflect.Proxy`.
- Can intercept method calls.
- Useful for logging, security, etc.
- Example:
  ```java
  import java.lang.reflect.*;
  import java.util.*; 
  
  class RealClass {
      public void doSomething() { System.out.println("Doing something!"); }
  }
  
  class ProxyHandler implements InvocationHandler {
      private final Object target;
  
      public ProxyHandler(Object target) {
          this.target = target;
      }
  
      @Override
      public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
          System.out.println("Before method call");
          Object result = method.invoke(target, args);
          System.out.println("After method call");
          return result;
      }
  }
  
  public class ProxyExample {
      public static void main(String[] args) {
          RealClass real = new RealClass();
          RealClass proxy = (RealClass) Proxy.newProxyInstance(
              real.getClass().getClassLoader(),
              new Class[]{RealClass.class},
              new ProxyHandler(real)
          );
          proxy.doSomething();
      }
  }
  ```

---

### 🔸 **Dynamic Proxy Example (Used in Spring AOP)**:
```java
InvocationHandler handler = (proxy, method, args) -> {
    System.out.println("Before method call");
    Object result = method.invoke(new RealClass(), args);
    System.out.println("After method call");
    return result;
};
```

---

### 🔸 **What is AOP?**
- **Aspect-Oriented Programming**.
- Allows separation of cross-cutting concerns (e.g., logging, security).
- Uses **aspects**, **join points**, and **advice**.
- Spring AOP uses **proxies** to implement AOP.
- Example:
  ```java
  @Aspect
  public class LoggingAspect {
      @Before("execution(* com.example.service.*.*(..))")
      public void logBefore(JoinPoint joinPoint) {
          System.out.println("Before method: " + joinPoint.getSignature());
      }
  }
  ```

---

### 🔸 **What is Dependency Injection (DI)?**
- A design pattern used to implement **Inversion of Control (IoC)**.
- Allows a class to receive its dependencies from an external source rather than creating them itself.
- Promotes **loose coupling** and **testability**.
- Commonly used in frameworks like **Spring**.
- Example:
  ```java
  @Component
  public class UserService {
      private final UserRepository userRepository;

      @Autowired
      public UserService(UserRepository userRepository) {
          this.userRepository = userRepository;
      }
  }
  ```
  
---

### 🔸 **Java Security**
- **Java Security Manager**: Controls access to resources.
- **Java Cryptography Architecture (JCA)**: Provides cryptographic operations.
- **Java Authentication and Authorization Service (JAAS)**: For user authentication.
- **Java Secure Socket Extension (JSSE)**: For secure network communication.
- **Java Naming and Directory Interface (JNDI)**: For directory services.
- **Java Policy Files**: Define permissions for code execution.
- **Java KeyStore (JKS)**: For storing cryptographic keys and certificates.
- **Java Secure Coding Guidelines**: Best practices for secure coding.
- **Java Security APIs**: For secure random number generation, encryption, etc.
- **Java Access Control**: Using `public`, `private`, `protected`, and package-private access modifiers.
- **Java Exception Handling**: For handling security-related exceptions.
- **Java Security Auditing**: Tools for auditing and monitoring security.
- **Java Security Updates**: Regular updates for vulnerabilities.
- **Java Security Libraries**: Third-party libraries for enhanced security.
- **Java Security Frameworks**: Spring Security, Apache Shiro, etc.
- **Java Security Annotations**: For securing methods and classes.
- **Java Security Context**: For managing security context in applications.

---

### 🔸 **What is Functional Interface?**
- An interface with **exactly one abstract method**.
- Can have multiple default/static methods.
- Used as the basis for **lambda expressions**.
- Example:
  ```java
  @FunctionalInterface
  interface MyFunctionalInterface {
      void myMethod();
      default void myDefaultMethod() {
          System.out.println("Default method");
      }
  }
  
  MyFunctionalInterface obj = () -> System.out.println("Lambda expression");
  obj.myMethod(); // Calls the lambda expression
  ```
  
---

### 🔸 **Java Socket**
- A socket is an **endpoint for communication** between two machines.
- Used for **network programming**.
- Supports both **TCP** and **UDP** protocols.
- Example:
  ```java
  import java.io.*;
  import java.net.*;

  public class SocketExample {
      public static void main(String[] args) throws IOException {
          Socket socket = new Socket("localhost", 8080);
          PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
          out.println("Hello Server!");
          socket.close();
      }
  }
  ```
  
---

### 🔸 **Java NIO (New I/O)**
- Provides **non-blocking I/O** operations.
- Supports **buffer-oriented** and **channel-based** I/O.
- Improves performance for large data transfers.
- Example:
  ```java
  import java.nio.*;
  import java.nio.channels.*;
  import java.io.*;

  public class NIOExample {
      public static void main(String[] args) throws IOException {
          FileChannel fileChannel = FileChannel.open(Paths.get("file.txt"), StandardOpenOption.READ);
          ByteBuffer buffer = ByteBuffer.allocate(1024);
          fileChannel.read(buffer);
          buffer.flip();
          System.out.println(new String(buffer.array()));
          fileChannel.close();
      }
  }
  ```
  
---

### 🔸 **What is Functional Programming in Java?**
- **Immutability**
- **Higher-order functions**
- **Pure functions**
- **Lazy evaluation**

Example:
```java
Function<Integer, Integer> square = x -> x * x;
System.out.println(square.apply(5)); // 25
```

---

### 🔸 **Reactive Programming & Project Reactor (Spring WebFlux)**
- **Asynchronous, non-blocking programming** model.
- **Uses `Flux<T>` and `Mono<T>` instead of List/Future**.

Example:
```java
Flux<Integer> numbers = Flux.just(1, 2, 3, 4)
    .map(n -> n * 2)
    .filter(n -> n > 5);
numbers.subscribe(System.out::println);
```

---

### 🔸 **Parallel Streams vs. Normal Streams**

| Feature       | Normal Stream       | Parallel Stream               |
|---------------|---------------------|-------------------------------|
| Execution     | Sequential          | Concurrent                    |
| Performance   | Slow for large data | Fast for large data           |
| Best Use Case | Small dataset       | Large dataset (CPU-intensive) |

Example:
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
numbers.parallelStream().forEach(System.out::println);
```

---

### 🔸 **How to encrypt passwords securely?**
Use **PBKDF2**, **BCrypt**, or **Argon2**.

Example using **BCrypt**:
```java
String hash = BCrypt.hashpw("password123", BCrypt.gensalt());
boolean matched = BCrypt.checkpw("password123", hash);
```

---

### 🔸 **How to design scalable Microservices?**
- **Stateless services**
- **Load balancing (Netflix Ribbon, Spring Cloud LoadBalancer)**
- **Service discovery (Eureka, Consul)**
- **Circuit breakers (Resilience4J, Hystrix)**

Example: **Spring Cloud Feign for API Calls**
```java
@FeignClient(name = "order-service", url = "http://orders.com")
public interface OrderClient {
    @GetMapping("/orders")
    List<Order> getOrders();
}
```

- **Blue-Green Deployments**
- **Canary Releases**
- **Rolling Updates**

Example: **Kubernetes Rolling Update**
```yaml
strategy:
  type: RollingUpdate
  rollingUpdate:
    maxUnavailable: 1
    maxSurge: 1
```

---

### 🔸 **How to Deploy Java Apps as Serverless Functions?**
- Use **AWS Lambda** with **Spring Boot**.
- Use `AWS Lambda Java Runtime`.

Example:
```java
public class MyLambdaHandler implements RequestHandler<String, String> {
    public String handleRequest(String input, Context context) {
        return "Hello, " + input;
    }
}
```

---

### 🔸 **Java Performance Profiling Tools**
- **JProfiler**
- **VisualVM**
- **Java Mission Control (JMC)**

---

### 🔸 **Optimizing Java Applications**
- Avoid **autoboxing/unboxing**
- Use **StringBuilder instead of String concatenation**
- Profile using **Flight Recorder**

---

### 🔸 **How Does GC Work in Java?**
- Java GC **automates memory management** by reclaiming objects that are no longer reachable.
- Works with **Generational Garbage Collection**:
    - **Young Generation (Eden, Survivor S1 & S2)**: For short-lived objects.
    - **Old (Tenured) Generation**: For long-lived objects.
    - **Metaspace**: Stores class metadata (replaced **PermGen** in Java 8).

---

### 🔸 **Garbage Collectors in Java**

| GC Type                              | Best Use Case               | Key Features                                   |
|--------------------------------------|-----------------------------|------------------------------------------------|
| **Serial GC (-XX:+UseSerialGC)**     | Small apps, single-threaded | Simple, stop-the-world, single-threaded.       |
| **Parallel GC (-XX:+UseParallelGC)** | High-throughput apps        | Multi-threaded GC, **default until Java 8**.   |
| **G1 GC (-XX:+UseG1GC)**             | Large heaps (>4GB)          | Region-based, **predictable pause times**.     |
| **ZGC (-XX:+UseZGC)**                | Ultra-low-latency apps      | Handles **very large heaps** (up to **16TB**). |

---

### 🔸 **How to Tune GC for Performance?**
Example:
```sh
java -XX:+UseG1GC -Xms2g -Xmx4g -XX:MaxGCPauseMillis=200
```

- `-Xms` and `-Xmx` **set heap size**.
- `-XX:MaxGCPauseMillis=200` **limits GC pause time**.

---

### 🔸 **GC Logs for Debugging**
```sh
java -Xlog:gc
```

---

### 🔸 **JVM Components**
1. **ClassLoader**: Loads `.class` files.
2. **Runtime Memory Areas**:
   - **Heap** (Objects, GC-managed)
   - **Stack** (Method calls, local vars)
   - **Metaspace** (Class metadata)
3. **Execution Engine**:
   - **Interpreter** (executes bytecode line-by-line)
   - **JIT Compiler** (converts bytecode to native code for performance)

---

### 🔸 **Class Loading in JVM**
- **Bootstrap ClassLoader** → Loads `java.lang.*`
- **Extension ClassLoader** → Loads `ext` libraries
- **Application ClassLoader** → Loads app classes

**Example: Custom ClassLoader**
```java
class MyClassLoader extends ClassLoader {
    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }
}
```

---

### 🔸 **Why Use Generics?**
- **Type safety** (Compile-time error instead of runtime `ClassCastException`).
- **Eliminates redundancy**.

**Example: Generic Class**
```java
class Box<T> {
    private T value;
    public void set(T value) { this.value = value; }
    public T get() { return value; }
}
Box<Integer> intBox = new Box<>();
intBox.set(10);
System.out.println(intBox.get()); // 10
```

---

### 🔸 **Generics Wildcards (`? extends`, `? super`)**

| Wildcard      | Use Case                          |
|---------------|-----------------------------------|
| `? extends T` | Accepts T or **subtypes** of T.   |
| `? super T`   | Accepts T or **supertypes** of T. |

Example:
```java
List<? extends Number> list = new ArrayList<Integer>(); // ✅ Works
List<? super Integer> list2 = new ArrayList<Number>(); // ✅ Works
```

---

### 🔸 **Types of Locks in Java**

| Lock Type                            | Feature                                 |
|--------------------------------------|-----------------------------------------|
| **Intrinsic Locks (`synchronized`)** | Implicit, locks entire object/class.    |
| **Explicit Locks (`ReentrantLock`)** | More control, supports fairness policy. |
| **ReadWriteLock**                    | Allows multiple readers, one writer.    |

---

### 🔸 **ReentrantLock vs. ReadWriteLock**

| Lock Type        | Feature                                 |
|------------------|-----------------------------------------|
| **ReentrantLock** | Allows reentrant locking.               |
| **ReadWriteLock** | Multiple readers, one writer.           |

- **ReentrantLock**: Allows a thread to acquire the lock multiple times.
- **ReadWriteLock**: Allows multiple threads to read simultaneously but only one to write.
- **Example**:
- **ReentrantLock**
  ```java
  ReentrantLock lock = new ReentrantLock();
  lock.lock();
  try {
      // Critical section
  } finally {
      lock.unlock();
  }
  ```
- **ReadWriteLock**
  ```java
  ReadWriteLock rwLock = new ReentrantReadWriteLock();
  rwLock.readLock().lock();
  try {
      // Read operation
  } finally {
      rwLock.readLock().unlock();
  }
  ```

---

### 🔸 **`synchronized` vs `ReentrantLock`**

| Feature       | `synchronized`        | `ReentrantLock`                         |
|---------------|-----------------------|-----------------------------------------|
| Locking       | Implicit              | Explicit (must `lock()` and `unlock()`) |
| Fairness      | No fairness guarantee | Supports fairness (`true` param)        |
| Interruptible | No                    | Yes (`lockInterruptibly()`)             |

Example: **Using `ReentrantLock`**
```java
Lock lock = new ReentrantLock();
try {
    lock.lock();
    System.out.println("Critical section");
} finally {
    lock.unlock();
}
```

---

### 🔸 **Creating Threads**
**Using `Thread` class**
```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread running");
    }
}
new MyThread().start();
```

**Using Runnable (Preferred)**
```java
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Runnable running");
    }
}
new Thread(new MyRunnable()).start();
```

---

### 🔸 **Thread States & Lifecycle**

| State             | Description                                         |
|-------------------|-----------------------------------------------------|
| **NEW**           | Created but not started.                            |
| **RUNNABLE**      | Ready to run, scheduled by CPU.                     |
| **BLOCKED**       | Waiting for a lock.                                 |
| **WAITING**       | Waiting indefinitely for another thread (`wait()`). |
| **TIMED_WAITING** | Waiting for a fixed time (`sleep()`, `join()`).     |
| **TERMINATED**    | Execution finished.                                 |

---

### 🔸 **Thread Safety Techniques**

| Technique             | Example                |
|-----------------------|------------------------|
| **Synchronization**   | `synchronized` methods |
| **Locks**             | `ReentrantLock`        |
| **Atomic Variables**  | `AtomicInteger`        |
| **ThreadLocal**       | Per-thread storage     |
| **Immutable Objects** | `final` fields         |

Example: **Using `AtomicInteger`**

```java
AtomicInteger counter = new AtomicInteger(0);
counter.incrementAndGet();
```

---

### 🔸 **Types of Thread Pools**

| Pool Type                | Description                   |
|--------------------------|-------------------------------|
| **FixedThreadPool(n)**   | Fixed number of threads.      |
| **CachedThreadPool**     | Dynamically grows/shrinks.    |
| **SingleThreadExecutor** | Ensures sequential execution. |

Example:

```java
ExecutorService executor = Executors.newFixedThreadPool(5);
executor.submit(() -> System.out.println("Task running"));
executor.shutdown();
```

---

### 🔸 **What is a Deadlock?**
Occurs when two threads **hold locks and wait for each other**.

Example:
```java
synchronized (lock1) {
    synchronized (lock2) { // 🚨 Deadlock risk!
        System.out.println("Deadlock!");
    }
}
```
**Fix:** **Always acquire locks in the same order**.

---

### 🔸 **Race Condition**
Happens when multiple threads access shared data **without synchronization**.

Example:
```java
counter++; // Not thread-safe 🚨
```

---

### 🔸 **`CompletableFuture` and `ExecutorService`**

```java
int result = solve(text1, text2);
```

### ✅ A. **Using `CompletableFuture` (Modern, Elegant)**

```java
import java.util.concurrent.CompletableFuture;

public int computeWithCompletableFuture(String text1, String text2) {
    try {
        return CompletableFuture.supplyAsync(() -> solve(text1, text2))
                .exceptionally(ex -> 0) // if exception, return 0
                .get(); // block until result is ready
    } catch (Exception e) {
        return 0;
    }
}
```

* ✅ `supplyAsync`: runs `solve` in a separate thread (common fork-join pool).
* ✅ `exceptionally`: handles exceptions like try-catch.
* ✅ `.get()`: blocks and gets result. You can also use `.join()` (unchecked exceptions) or `.orTimeout(...)`.

### ✅ B. **Using `ExecutorService` (Explicit Thread Pool)**

```java
import java.util.concurrent.*;

public int computeWithExecutor(String text1, String text2) {
    ExecutorService executor = Executors.newSingleThreadExecutor();
    try {
        Future<Integer> future = executor.submit(() -> solve(text1, text2));
        return future.get(); // block and get result
    } catch (Exception e) {
        return 0;
    } finally {
        executor.shutdown(); // shut down the thread pool
    }
}
```

* Good for managing **custom thread pools**.
* Use `shutdown()` to avoid thread leaks.

---

### 🔸 **Concurrency Use Cases**

| Use Case                             | Description                                    | Tools                                                         |
|--------------------------------------|------------------------------------------------|---------------------------------------------------------------|
| **Parallel Data Processing**         | Speed up heavy computations by dividing tasks. | `ForkJoinPool`, `parallelStream`, `CompletableFuture`         |
| **Asynchronous I/O**                 | Don't block on DB/Network/file calls.          | `CompletableFuture`, `AsyncRestTemplate`                      |
| **Web Scraping / API Calls**         | Launch parallel HTTP requests.                 | `ExecutorService`, `CompletableFuture`                        |
| **Real-Time Systems**                | Process sensor data or messages in parallel.   | `BlockingQueue`, `ExecutorService`, `Kafka`                   |
| **Scheduled Jobs**                   | Run background tasks at intervals.             | `ScheduledExecutorService`, `Quartz`                          |
| **Rate Limiting / Timeout Handling** | Avoid overloading services.                    | `Semaphore`, `TimeoutExecutor`, `CompletableFuture.timeout()` |
| **Thread-safe Counters**             | High-frequency concurrent updates.             | `AtomicInteger`, `LongAdder`                                  |

---

### 🔸 **Parallel API Call**

```java
CompletableFuture<String> callA = CompletableFuture.supplyAsync(() -> apiCall("A"));
CompletableFuture<String> callB = CompletableFuture.supplyAsync(() -> apiCall("B"));

String combined = callA.thenCombine(callB, (a, b) -> a + "-" + b).get();
```

### Tips

| Ask                                    | Clarify                                    |
|----------------------------------------|--------------------------------------------|
| “Are these tasks CPU or I/O bound?”    | Helps decide between thread pools vs async |
| “Should results be ordered or merged?” | Determines need for coordination           |
| “Any timeout or fallback?”             | Helps show fault tolerance                 |

* Use `CompletableFuture` for **elegant async logic**, especially with chaining and fallback.
* Use `ExecutorService` for **manual thread control**.

---

### 🔸 **Real-World Use Cases for Java Concurrency**

### A. **Parallel API Aggregation**

**Use Case**: Microservice receives a request → fetches data from multiple APIs → aggregates result.

```java
CompletableFuture<String> user = CompletableFuture.supplyAsync(() -> fetchUser());
CompletableFuture<String> orders = CompletableFuture.supplyAsync(() -> fetchOrders());

String result = user.thenCombine(orders, (u, o) -> u + " has " + o).get();
```
**Why concurrency?** Parallel I/O reduces total latency.

### B. **Timeout and Fallback for Resilience**

```java
CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> slowAPI())
        .orTimeout(2, TimeUnit.SECONDS)
        .exceptionally(ex -> 0); // fallback
```

### C. **Heavy Data Processing (CPU-Bound Work)**

```java
ForkJoinPool pool = new ForkJoinPool();
int[] nums = IntStream.range(0, 1_000_000).toArray();

int sum = pool.submit(() -> Arrays.stream(nums).parallel().sum()).get();
```

**When?** Great for CPU-intensive batch jobs like ML, analytics, log parsing.

### D. **Background Task Processing with Thread Pools**

```java
ExecutorService pool = Executors.newFixedThreadPool(5);
for (Task t : tasks) {
    pool.submit(() -> processTask(t));
}
```

### E. **Scheduled Jobs (Periodic Tasks)**

```java
ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
scheduler.scheduleAtFixedRate(() -> checkHealth(), 0, 10, TimeUnit.SECONDS);
```
Example: Monitoring, caching, health checks.

**Benchmark Thoughts**
| Scenario           | Sequential (ms) | Parallel (ms) | Tools               |
|--------------------|-----------------|---------------|---------------------|
| 3 API calls        | \~900ms (300x3) | \~300ms       | `CompletableFuture` |
| 1M record sum      | \~200ms         | \~40ms        | `parallelStream`    |
| File parsing (4GB) | \~1.5s          | \~0.7s        | `ExecutorService`   |

✅ **Important**: Parallelizing only helps if:

* Tasks are **independent**
* CPU or IO can be overlapped

| Concept                       | What to Say                                                          |
|-------------------------------|----------------------------------------------------------------------|
| **Thread safety**             | Use `ConcurrentHashMap`, `AtomicInteger`                             |
| **Deadlock**                  | Avoid nested locks, use timeouts                                     |
| **Asynchrony vs Parallelism** | Asynchrony = non-blocking; Parallel = multiple threads               |
| **Backpressure**              | Use queues or reactive streams                                       |
| **Design choice**             | “I chose `CompletableFuture` for async chaining and fallback logic.” |
| **Metrics**                   | “I monitored thread pool queue sizes and timeouts using Prometheus.” |

---

### 🔸 **Visual Diagram (Async with Fallback Logic)**

```plaintext
         ┌────────────┐
         │  Client    │
         └────┬───────┘
              │
              ▼
    ┌──────────────────────┐
    │ CompletableFuture    │
    │ supplyAsync()        │
    └────────┬─────────────┘
             ▼
        ┌──────────┐
        │   API A  │ ←─────┐
        └──────────┘       │
             │             │ Timeout / error
             ▼             │
         Result            ▼
             │       ┌──────────────┐
             └─────► │ Exceptionally│
                     └────┬─────────┘
                          ▼
                      Return fallback
```

Why not just use plain threads?
> Threads are heavyweight and low-level. `CompletableFuture` or `ExecutorService` are preferable for better scalability,
> error handling, and clean API chaining.

---

### 🔸 **Sync vs Async**

| Feature           | Synchronous (Sync)         | Asynchronous (Async)                       |  
|-------------------|----------------------------|--------------------------------------------|
| Blocking          | Yes                        | No                                         |
| Execution         | Sequential                 | Concurrent                                 |
| Callbacks         | No                         | Yes                                        |
| Error Handling    | Try-catch                  | Callbacks or Futures                       |
| Performance       | Slower for I/O-bound tasks | Faster for I/O-bound tasks                 |
| Complexity        | Simpler                    | More complex                               |
| Use Cases         | Simple tasks, CPU-bound    | I/O-bound tasks, parallel processing       |
| Libraries         | Java standard libraries    | CompletableFuture, RxJava, Project Reactor |
| Examples          | File I/O, DB calls         | Web scraping, API calls                    |
| Threading         | Single-threaded            | Multi-threaded                             |
| Scalability       | Limited                    | High                                       |
| Resource Usage    | Higher                     | Lower                                      |
| Debugging         | Easier                     | More complex                               |
| Testing           | Easier                     | More complex                               |
| Error Propagation | Simple                     | Complex                                    |
| Performance       | Slower                     | Faster                                     |

---

### 🔸 **What is a Virtual Thread?**

- **Virtual threads** are lightweight threads managed by the JVM.
- **Project Loom** introduces **virtual threads** for lightweight concurrency.
- **Benefits**:
    - **Scalability**: Handle thousands of concurrent tasks.
    - **Simplicity**: Easier to write and maintain async code.
    - **Performance**: Reduced overhead compared to traditional threads.

---

### 🔸 **What is a Thread Pool?**

- A **thread pool** is a collection of pre-initialized threads that can be reused for executing tasks.
- It helps manage resources efficiently and reduces the overhead of creating new threads.
- **Benefits**:
    - **Improved performance**: Reuses threads instead of creating new ones.
    - **Resource management**: Limits the number of concurrent threads.
    - **Task scheduling**: Can schedule tasks for future execution.
- **Types**:
    - **Fixed Thread Pool**: A fixed number of threads.
    - **Cached Thread Pool**: Creates new threads as needed, but will reuse previously constructed threads when they are
      available.
    - **Single Thread Executor**: A single thread to execute tasks sequentially.
    - **Scheduled Thread Pool**: Can schedule tasks to run after a delay or periodically.
- **Example**:
    ```java
    ExecutorService executor = Executors.newFixedThreadPool(5);
    executor.submit(() -> {
        // Task code here
    });
    executor.shutdown();
    ```
- **Best Practices**:
    - Use appropriate thread pool size based on the workload.
    - Avoid using too many threads to prevent context switching overhead.
    - Use `try-with-resources` to ensure proper shutdown of the executor.
    - Monitor thread pool metrics to adjust the size dynamically.
    - Use `ScheduledExecutorService` for periodic tasks.
    - Use `ThreadPoolExecutor` for more control over thread pool behavior.
    - Use `ForkJoinPool` for parallel processing of tasks.
    - Use `CompletableFuture` for async tasks with thread pools.
    - Use `Executors.newWorkStealingPool()` for parallel processing of tasks.
    - Use `Executors.newSingleThreadExecutor()` for sequential task execution.

---

### 🔸 **What is a ForkJoinPool?**
- A specialized thread pool for parallel processing in Java.
- Part of the **Fork/Join Framework** introduced in Java 7.
- Designed for **divide-and-conquer** algorithms.
- Uses a work-stealing algorithm to balance the load among threads.
- Threads can "steal" tasks from other threads to keep busy.
- Ideal for CPU-bound tasks that can be broken into smaller subtasks.
- Example:
  ```java
    ForkJoinPool pool = new ForkJoinPool(); 
    int result = pool.invoke(new RecursiveTask<Integer>() {
        @Override
        protected Integer compute() {
            // Divide task and invoke subtasks
            return 0; // Combine results
        }
    });
    ```

---

### 🔸 **What is JNI (Java Native Interface)?**
- **JNI** allows Java code to interact with native applications and libraries written in C, C++, or other languages.
- Used for **performance-critical tasks**, accessing **system-level resources**, or using **legacy native code**.
- **Native Method**: Declared in Java using the `native` keyword, implemented in C/C++.
  - **`System.loadLibrary()`**: Loads the native library (.dll, .so).
  - **Header Generation**: Use `javac` and `javah` (or `javac -h`) to generate C headers from Java classes.
- **Example**
```java
public class NativeExample {
    static {
        System.loadLibrary("nativeLib");
    }

    public native int add(int a, int b);
}
```
**C Implementation (nativeLib.c):**
```c
#include <jni.h>
#include "NativeExample.h"

JNIEXPORT jint JNICALL Java_NativeExample_add(JNIEnv *env, jobject obj, jint a, jint b) {
    return a + b;
}
```

#### **Steps to Use JNI**
1. Write Java class with `native` methods.
2. Compile Java and generate header: `javac -h . NativeExample.java`
3. Implement native code in C/C++.
4. Compile native code to shared library.
5. Load and use in Java.

#### **When to Use JNI?**
- Integrating with platform-specific features.
- Reusing existing native libraries.
- Performance optimization (rarely needed for most apps).

---

### 🔸 **What is JIT Compilation?**
- **JIT (Just-In-Time)** compilation optimizes Java bytecode into native machine code at runtime.
- Improves performance by compiling frequently executed code paths.
- Part of the JVM's **HotSpot** compiler.
- Two modes: **client** (quick startup) and **server** (optimized performance).
- Adaptive optimization: JVM monitors code execution and optimizes hot paths.
- Reduces overhead of interpreting bytecode.
- Can be tuned with flags like `-XX:CompileThreshold` to control when methods are compiled.
- Supports **Tiered Compilation**: combines both client and server modes for better startup and throughput.
- Example:
```sh
java -XX:+TieredCompilation -Xms512m -Xmx4g MyApp
```

---

### 🔸 **JIT Compilation vs AOT Compilation**

| Feature          | JIT Compilation             | AOT Compilation          |
|------------------|-----------------------------|--------------------------|
| Compilation Time | At runtime                  | At build time            |
| Execution Speed  | Faster (optimized)          | Slower (less optimized)  |
| Memory Usage     | Higher (due to native code) | Lower (no native code)   |
| Portability      | Less portable (native code) | More portable (bytecode) |
| Use Case         | Long-running apps           | Short-lived apps         |

---

### 🔸 **JIT Compilation Process**
1. **Bytecode Loading**: JVM loads `.class` files.
2. **Bytecode Execution**: JVM interprets bytecode.
3. **Hotspot Detection**: JVM identifies frequently executed methods (hot spots).
4. **Compilation**: JIT compiler compiles hot spots to native code.
5. **Execution**: Native code is executed directly by the CPU.
6. **Optimization**: JIT compiler applies optimizations (inlining, loop unrolling).
7. **Adaptive Optimization**: JVM monitors performance and re-optimizes if needed.
8. **Garbage Collection**: JIT-compiled code is managed by the JVM's garbage collector.
9. **Deoptimization**: If optimizations are no longer valid, JIT can revert to interpreted mode.
10. **Tiered Compilation**: Combines client and server modes for better performance.
11. **Profiling**: JVM collects runtime data for further optimizations.
12. **Feedback Loop**: JIT compiler uses profiling data to improve future compilations.
13. **Native Code Caching**: JIT-compiled code can be cached for reuse.
14. **Runtime Monitoring**: JVM monitors performance and adjusts compilation strategies.
15. **Dynamic Recompilation**: JIT can recompile methods based on runtime behavior.
16. **Thread Safety**: JIT-compiled code is thread-safe and synchronized with the JVM.
17. **Native Code Execution**: JIT-compiled code is executed directly by the CPU.
18. **Performance Tuning**: JIT compiler can be tuned with JVM flags for specific use cases.
19. **Profiling Feedback**: JIT compiler uses profiling feedback to optimize code paths.
20. **Runtime Adaptation**: JIT compiler adapts to changing runtime conditions for optimal performance.
21. **Garbage Collection Interaction**: JIT-compiled code interacts with the JVM's garbage collector for memory
    management.
22. **Native Code Optimization**: JIT compiler applies various optimizations to native code for better performance.
23. **Hotspot Recompilation**: JIT compiler can recompile hot spots based on runtime profiling data.
24. **Performance Monitoring**: JIT compiler monitors performance metrics to adjust compilation strategies.
25. **Runtime Profiling**: JIT compiler collects runtime profiling data for further optimizations.
26. **Adaptive Inlining**: JIT compiler can inline methods based on runtime profiling data.
27. **Dynamic Optimization**: JIT compiler applies dynamic optimizations based on runtime behavior.
28. **Native Code Generation**: JIT compiler generates native code for execution on the CPU.
29. **Runtime Adaptation**: JIT compiler adapts to changing runtime conditions for optimal performance.
30. **Performance Profiling**: JIT compiler collects performance profiling data for further optimizations.
31. **Adaptive Optimization**: JIT compiler applies adaptive optimizations based on runtime profiling data.
32. **Runtime Monitoring**: JIT compiler monitors runtime performance to adjust compilation strategies.
33. **Native Code Execution**: JIT-compiled code is executed directly by the CPU.
34. **Performance Tuning**: JIT compiler can be tuned with JVM flags for specific use cases.

---

### 🔸 **Java Memory Management**
- **Heap Memory**: Where Java objects are stored.
- **Stack Memory**: Where method calls and local variables are stored.
- **Metaspace**: Stores class metadata (replaced PermGen in Java 8).
- **Garbage Collection (GC)**: Automatic memory management to reclaim memory from unreachable objects.
- **Generational GC**: Divides heap into Young, Old, and Permanent generations.
- **Young Generation**: Where new objects are allocated.
- **Old Generation**: Where long-lived objects are moved.

---

### 🔸 **Garbage Collection Phases**:
- **Mark**: Identify reachable objects.
- **Sweep**: Reclaim memory from unmarked objects.
- **Compact**: Move objects to reduce fragmentation.

---

### 🔸 **Garbage Collection Tuning**:
- **Heap Size**: `-Xms` (initial size), `-Xmx` (maximum size).
- **GC Algorithm**: `-XX:+UseG1GC`, `-XX:+UseParallelGC`, etc.
- **Pause Time Goals**: `-XX:MaxGCPauseMillis`.
- **GC Logging**: `-Xlog:gc*` for detailed GC logs.

---

### 🔸  **Garbage Collector Types**:
- **Serial GC**: Single-threaded, simple.
- **Parallel GC**: Multi-threaded, high throughput.
- **G1 GC**: Region-based, predictable pause times.
- **ZGC**: Low-latency, handles large heaps.
- **Shenandoah GC**: Low-pause time, concurrent.
- **Epsilon GC**: No-op, for performance testing.
- **CMS GC**: Concurrent Mark-Sweep, low pause times.
- **JEP 394**: Pattern Matching for `instanceof`.
- **JEP 395**: Records.
- **JEP 396**: Sealed Classes.
- **JEP 397**: Sealed Interfaces.
- **JEP 398**: Pattern Matching for `switch`.
- **JEP 399**: Foreign Function & Memory API.
- **JEP 400**: Vector API.

---

### 🔸 **Garbage Collection Algorithms**:
- **Mark and Sweep**: Marks reachable objects, sweeps unmarked ones.
- **Copying**: Copies live objects to a new space.
- **Generational**: Divides heap into generations for efficiency.
- **Concurrent Mark-Sweep (CMS)**: Concurrently marks and sweeps.
- **G1 GC**: Region-based, minimizes pause times.
- **ZGC**: Low-latency, handles large heaps.
- **Shenandoah GC**: Concurrent, low-pause time.
- **Epsilon GC**: No-op, for performance testing.
- **Garbage Collection Tuning**:
- **Heap Size**: `-Xms` (initial size), `-Xmx` (maximum size).
- **GC Algorithm**: `-XX:+UseG1GC`, `-XX:+UseParallelGC`, etc.
- **Pause Time Goals**: `-XX:MaxGCPauseMillis`.
- **GC Logging**: `-Xlog:gc*` for detailed GC logs.

---

### 🔸 **Garbage Collection Monitoring**:
- **JVisualVM**: Visualize memory usage and GC activity.
- **Java Mission Control**: Advanced profiling and monitoring.
- **JConsole**: Monitor memory usage and GC activity.
- **JMX (Java Management Extensions)**: Monitor and manage Java applications.
- **JFR (Java Flight Recorder)**: Low-overhead profiling.

---

### 🔸 **Garbage Collection Best Practices**:
- Use appropriate GC algorithm based on application needs.
    - **G1 GC** for low pause times.
    - **Parallel GC** for high throughput.
    - **ZGC** for low-latency applications.
    - Monitor and tune heap size based on application behavior.
    - Use `-Xms` and `-Xmx` to set initial and maximum heap sizes.
- Avoid excessive object creation and use object pooling where possible.
- Use weak references for caches to allow GC to reclaim memory.
- Profile and monitor memory usage regularly.
- Use tools like JVisualVM, Java Mission Control, and JFR for monitoring.

---

### 🔸 **Garbage Collection FAQs**:
- **Q: What is the difference between minor and major GC?**
    - A: Minor GC collects garbage from the Young Generation, while major GC collects from the Old Generation.
- **Q: How can I force garbage collection?**
    - A: Use `System.gc()`, but it's not guaranteed to run immediately.
- **Q: What is a memory leak in Java?**
    - A: A memory leak occurs when objects are no longer needed but are still referenced, preventing GC from reclaiming
      memory.
- **Q: How do I identify memory leaks?**
    - A: Use profiling tools like JVisualVM or Java Mission Control to analyze heap dumps and identify unreachable
      objects.

---

### 🔸 **Java 8 Features**
- **Lambda Expressions**: Anonymous functions for functional programming.
- **Streams API**: Process collections in a functional style.
- **Optional Class**: Handle null values gracefully.
- **Default Methods**: Add methods to interfaces without breaking existing implementations.
- **Method References**: Shorten lambda expressions.
- **Functional Interfaces**: Interfaces with a single abstract method.
- **Nashorn JavaScript Engine**: Execute JavaScript code in Java applications.
- **Date and Time API**: New date/time classes for better date handling.
- **CompletableFuture**: Asynchronous programming with futures.
- **Type Annotations**: Annotations can be applied to types.
- **Repeatable Annotations**: Multiple annotations of the same type on a single element.
- **New APIs**: New APIs for I/O, networking, and concurrency.
- **JavaFX**: New GUI framework for building rich client applications.

---

### 🔸 **JVM Languages: Java vs Kotlin vs Groovy**

| Feature             | Java                          | Kotlin                        | Groovy                       |
|---------------------|-------------------------------|-------------------------------|------------------------------|
| Syntax              | Verbose                       | Concise                       | Dynamic                      |
| Null Safety         | No                            | Yes                           | No                           |
| Type Inference      | Limited                       | Yes                           | Yes                          |
| Functional Style    | Limited                       | Yes                           | Yes                          |
| Interoperability    | Java only                     | Fully interoperable with Java | Groovy can call Java classes |
| Compilation         | Compiled to bytecode          | Compiled to bytecode          | Interpreted or compiled      |
| Lambdas             | Yes                           | Yes                           | Yes                          |
| Extension Functions | No                            | Yes                           | No                           |
| Coroutines          | No                            | Yes                           | No                           |
| DSL Support         | Limited                       | Excellent                     | Good                         |
| IDE Support         | Excellent (Eclipse, IntelliJ) | Excellent (IntelliJ)          | Good (Eclipse, IntelliJ)     |
| Community           | Large                         | Growing                       | Large                        |
| Use Cases           | Enterprise apps, Android      | Android, Web, Server-side     | Scripting, Testing, DSLs     |
| Performance         | High                          | High                          | Moderate                     |
| Learning Curve      | Moderate                      | Easy                          | Easy                         |
| Libraries           | Extensive                     | Extensive                     | Extensive                    |
| Ecosystem           | Mature                        | Growing                       | Mature                       |
| Tooling             | Excellent (Maven, Gradle)     | Excellent (Gradle)            | Good (Grails)                |
| Community Support   | Large                         | Growing                       | Large                        |
| Adoption            | High                          | Growing                       | Moderate                     |
| Popularity          | High                          | Growing                       | Moderate                     |

---

### 🔸 **What is GraalVM & what are the purposes of it?**
- **GraalVM** is a high-performance runtime that provides support for multiple languages and execution modes.
- It is designed to run applications written in Java, JavaScript, Python, Ruby, R, and other languages.
- It includes a just-in-time (JIT) compiler, an ahead-of-time (AOT) compiler, and a polyglot runtime.
- GraalVM is designed to improve the performance of applications by optimizing the execution of code at runtime.
- It also provides support for native image generation, which allows applications to be compiled into native executables
  for faster startup times and lower memory usage.
- GraalVM is used in various scenarios, including:
    - Running polyglot applications that use multiple languages.
    - Optimizing the performance of Java applications.
    - Generating native images for faster startup times and lower memory usage.
    - Running applications in a serverless environment.
    - Running applications in a containerized, cloud-native environment.
- GraalVM is compatible with existing Java applications and libraries, making it easy to integrate into existing
  projects.
- It is also designed to be extensible, allowing developers to create custom languages and tools that can run on the
  GraalVM runtime.


