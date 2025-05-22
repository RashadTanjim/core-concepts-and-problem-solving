# CS Java Core Concepts and Object-Oriented Programming

It's a combined list of Java Core Concepts! I'll answer each one concisely with explanations and code samples where necessary.

---

### 🔸 **What’s the difference between JDK, JRE, and JVM?**
- **JDK (Java Development Kit)**: Includes everything needed for Java development—JRE, compilers, and debugging tools.
- **JRE (Java Runtime Environment)**: Contains JVM and libraries required to run Java applications but does not include compilers.
- **JVM (Java Virtual Machine)**: Converts Java bytecode into machine code and executes it.

---

### 🔸 **Why is Java considered platform-independent?**
Java code is compiled into **bytecode** (`.class` files) which is executed by the JVM. Since each OS has its own JVM, Java programs can run anywhere without modification (Write Once, Run Anywhere).

---

### 🔸 **Difference between an abstract class and an interface?**
| Feature           | Abstract Class | Interface |
|------------------|---------------|-----------|
| Methods         | Can have both abstract and concrete methods | Only abstract methods (before Java 8) |
| Variables       | Can have instance variables | Only static & final variables |
| Inheritance     | Can extend only one abstract class | Can implement multiple interfaces |

```java
abstract class Animal {
    abstract void makeSound();
}

interface Pet {
    void play();
}

class Dog extends Animal implements Pet {
    void makeSound() { System.out.println("Bark"); }
    public void play() { System.out.println("Playing!"); }
}
```

---

### 🔸 **What’s the role of `final`, `finally`, and `finalize` in Java?**
- **`final`**: Used for constants (`final int x=10;`), method restriction (`final void show(){}`), and class restriction (`final class A{}`).
- **`finally`**: A block that executes after `try-catch`, ensuring cleanup.
- **`finalize`**: A method called by the Garbage Collector before an object is removed.

```java
class Demo {
    protected void finalize() { System.out.println("Object destroyed"); }
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
    void show(int a) { System.out.println(a); } // Overloading
}

class B extends A {
    @Override
    void show(int a) { System.out.println("Overridden: " + a); } // Overriding
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
    Car() { System.out.println("Default Constructor"); }
    Car(String model) { System.out.println("Car model: " + model); }
}
```

---

### 🔸 **Purpose of the `super` keyword in Java?**
Used to call parent class constructors or methods.

```java
class A {
    A() { System.out.println("Parent constructor"); }
}

class B extends A {
    B() { super(); System.out.println("Child constructor"); }
}
```

---

### 🔸 **What’s the purpose of static blocks in Java?**
Used to initialize static variables.

```java
class Demo {
    static { System.out.println("Static block executed first"); }
}
```

---

### 🔸 **What is the use of the `this` keyword in constructors?**
Used to call another constructor in the same class.

```java
class A {
    A() { this(10); System.out.println("Default Constructor"); }
    A(int x) { System.out.println("Parameterized Constructor: " + x); }
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
class Engine {}
class Car { Engine engine; }
```

---

### 🔸 **Explain the diamond problem in Java and its solution.**
When a class inherits from two interfaces that have the same method. Java solves this using default methods.

```java
interface A { default void show() { System.out.println("A"); } }
interface B { default void show() { System.out.println("B"); } }

class C implements A, B {
    public void show() { A.super.show(); } // Explicitly choosing
}
```

---

### 🔸 **Why are Strings immutable in Java?**
- Security (prevents modification)
- Caching (String Pool)
- Thread Safety

```java
String s = "Hello";
s.concat(" World");  // Doesn't modify original string
```

---

### 🔸 **ArrayList vs. LinkedList, key differences?**
| Feature      | ArrayList | LinkedList |
|-------------|----------|-----------|
| Access Time | Fast (O(1)) | Slow (O(n)) |
| Insertion/Deletion | Slow (O(n)) | Fast (O(1)) |

---

### 🔸 **What is an exception in Java?**
An error that occurs at runtime.

```java
try {
    int x = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Cannot divide by zero");
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
    public void run() { System.out.println("Thread running"); }
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
synchronized(obj1) { synchronized(obj2) { /* Deadlock scenario */ } }
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
            try { obj.waitMethod(); } catch (InterruptedException e) { e.printStackTrace(); }
        }).start();

        new Thread(() -> {
            try { Thread.sleep(1000); obj.notifyMethod(); } catch (InterruptedException e) { e.printStackTrace(); }
        }).start();
    }
}
```

---

### 🔸 **`synchronized` vs. `volatile` in Java?**
| Feature       | `synchronized` | `volatile` |
|--------------|---------------|------------|
| Usage        | Locks methods/blocks | Ensures visibility of changes to a variable |
| Performance  | More overhead due to locking | Faster, no locking |
| Prevents Race Condition | ✅ Yes | ❌ No |

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

### 🔸 **Difference between `HashMap` and `TreeMap`?**
| Feature       | `HashMap` | `TreeMap` |
|--------------|----------|-----------|
| Ordering     | No order | Sorted order (natural ordering) |
| Performance  | O(1) average | O(log n) |
| Null Keys    | ✅ Allowed | ❌ Not allowed |

```java
Map<Integer, String> map = new HashMap<>();
map.put(1, "Apple");
map.put(3, "Banana");
map.put(2, "Cherry");

Map<Integer, String> treeMap = new TreeMap<>(map);  // Sorted
```

---

### 🔸 **Difference between `Iterator` and `ListIterator`?**
| Feature        | `Iterator` | `ListIterator` |
|---------------|-----------|--------------|
| Traversal    | Forward only | Forward & Backward |
| Modify List  | ❌ No add | ✅ Can add elements |

```java
List<String> list = new ArrayList<>(List.of("A", "B", "C"));
ListIterator<String> it = list.listIterator();
while (it.hasNext()) System.out.println(it.next());
```

---

### 🔸 **What is the `Comparable` interface?**
Used to define **natural ordering** of objects.

```java
class Student implements Comparable<Student> {
    int age;
    Student(int age) { this.age = age; }

    public int compareTo(Student s) { return this.age - s.age; }
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
    MyException(String message) { super(message); }
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
class Animal { void sound() { System.out.println("Animal sound"); } }
class Dog extends Animal { void sound() { System.out.println("Bark"); } }
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
interface Serializable {}  // Marker Interface
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
I have covered all the questions from your list. However, let me do a final cross-check to ensure nothing is missed.

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
| Feature       | Local Variable | Instance Variable |
|--------------|---------------|-------------------|
| Scope        | Inside a method | Inside a class but outside methods |
| Default Value | ❌ No default value | ✅ Default value assigned |
| Stored in    | Stack memory | Heap memory |

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
interface A { default void show() { System.out.println("A"); } }
interface B extends A {}
interface C extends A {}
class D implements B, C {} // No ambiguity
```

---

### 🔸 **Purpose of `this` keyword in constructors?**
Used to refer to the **current instance**.  
Example:
```java
class Example {
    int x;
    Example(int x) { this.x = x; } // 'this' differentiates instance variable from parameter
}
```

---

### 🔸 **What is constructor overloading?**
Defining **multiple constructors** with different parameters.

```java
class Example {
    Example() { System.out.println("No-arg constructor"); }
    Example(int x) { System.out.println("Parameterized constructor"); }
}
```

---

### 🔸 **What are the object-oriented features in Java?**
1. **Encapsulation** - Data hiding using private fields.
2. **Inheritance** - One class inherits another.
3. **Polymorphism** - Method overloading & overriding.
4. **Abstraction** - Hiding implementation details via abstract classes/interfaces.

---

### 🔸 **Why are strings immutable in Java?**
1. **Security** - Prevents unauthorized modifications.
2. **Caching** - Java stores strings in **String Pool** to save memory.
3. **Thread-Safety** - Immutable objects are inherently thread-safe.

Example:
```java
String s = "Hello";
s.concat(" World"); // Creates a new object; does not modify 's'
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
    Parent() { System.out.println("Parent constructor"); }
}
class Child extends Parent {
    Child() { super(); } // Calls Parent's constructor
}
```

---

### 🔸 **Purpose of static blocks in Java?**
Used to **initialize static variables** before main execution.

```java
class Example {
    static { System.out.println("Static block executed!"); }
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
| Feature       | `throw` | `throws` |
|--------------|--------|---------|
| Purpose     | Manually throw exception | Declare exception |
| Used in    | Method body | Method signature |

Example:
```java
void method() throws IOException { throw new IOException("Error"); }
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
| Feature      | Process | Thread |
|-------------|---------|--------|
| Definition  | Independent execution | Part of a process |
| Memory      | Own memory space | Shared memory |
| Communication | Slow (IPC) | Fast (shared memory) |

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
| Feature        | `synchronized` | `volatile` |
|--------------|--------------|----------|
| Locks       | ✅ Yes | ❌ No |
| Atomicity   | ✅ Yes | ❌ No |
| Performance | ❌ Slower | ✅ Faster |

---

### 🔸 **Difference between `notify()` and `notifyAll()`?**
- **`notify()`** wakes up **one** thread.
- **`notifyAll()`** wakes up **all** waiting threads.

---

### 🔸 **What is the difference between `StringBuilder` and `StringBuffer`?**
| Feature       | `StringBuilder` | `StringBuffer` |
|--------------|----------------|---------------|
| Mutability   | ✅ Mutable | ✅ Mutable |
| Thread-Safety | ❌ No | ✅ Yes (Synchronized) |
| Performance  | ✅ Faster | ❌ Slower |

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
sealed class Vehicle permits Car, Bike {}
final class Car extends Vehicle {}  // Allowed
final class Bike extends Vehicle {} // Allowed
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
    public Student(int age) { this.age = age; }
    public int compareTo(Student s) { return this.age - s.age; } // Ascending
}
```

---

### 🔸 **Difference between `Comparator` and `Comparable`**
| Feature       | `Comparable` | `Comparator` |
|--------------|-------------|-------------|
| Package      | `java.lang` | `java.util` |
| Sorting Logic | **Inside the class** | **Separate class** |
| Method       | `compareTo()` | `compare()` |

Example:
```java
Comparator<Student> byAge = (s1, s2) -> Integer.compare(s1.age, s2.age);
```

---

### 🔸 **What is the difference between `synchronized` and `Lock`?**
| Feature        | `synchronized` | `Lock` (ReentrantLock) |
|---------------|---------------|-----------------------|
| Flexibility   | ❌ Less flexible | ✅ More flexible |
| Performance   | ❌ Slower | ✅ Faster |
| Explicit Locking | ❌ No | ✅ Yes |
| Try-Lock Mechanism | ❌ No | ✅ Yes |

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
| Feature    | `Runnable` | `Callable` |
|-----------|-----------|-----------|
| Return Type | `void` | **Returns a value** |
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

### 🔸 **Difference between `ConcurrentHashMap` and `HashMap`?**
| Feature         | `ConcurrentHashMap` | `HashMap` |
|---------------|-----------------|---------|
| Thread Safety | ✅ Yes | ❌ No |
| Performance   | ✅ Faster (Segmented Locks) | ❌ Slower |
| Null Keys     | ❌ Not allowed | ✅ Allowed |

---

### 🔸 **What is a BlockingQueue in Java?**
- **Thread-safe** queue for **producer-consumer** problems.

Example:
```java
BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
queue.put(1);  // Blocks if full
queue.take();  // Blocks if empty
```

---

### 🔸 **Difference between `TreeMap`, `HashMap`, and `LinkedHashMap`**
| Feature      | `TreeMap` | `HashMap` | `LinkedHashMap` |
|-------------|---------|---------|--------------|
| Ordering    | ✅ Sorted | ❌ No order | ✅ Insertion order |
| Performance | ❌ Slower | ✅ Fastest | ✅ Medium |

---

### 🔸 **What is a `default` method in an interface?**
- Introduced in Java 8.
- Allows **method implementation in interfaces**.

Example:
```java
interface MyInterface {
    default void display() { System.out.println("Default Method"); }
}
```

---

### 🔸 **What is the difference between `filter()` and `map()` in Streams?**
| Function | `filter()` | `map()` |
|----------|----------|---------|
| Purpose | Filters elements | Transforms elements |
| Return Type | `Stream<T>` | `Stream<R>` |

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

### 🔸 **What is the Factory Pattern?**
- Creates objects **without exposing the instantiation logic**.

Example:
```java
interface Car { void drive(); }
class BMW implements Car { public void drive() { System.out.println("BMW driving"); } }
class CarFactory {
    static Car getCar(String type) { return new BMW(); }
}
```

---

### 🔸 **What is the Observer Pattern?**
- Used for **event-driven programming**.

Example:
```java
class NewsPublisher extends Observable {
    void publish(String news) { setChanged(); notifyObservers(news); }
}
```

---

### 🔸 **What is the Java Memory Model (JMM)?**
JMM defines how **threads interact through memory** and ensures:
- Visibility
- Atomicity
- Ordering

### 🔸 **Key Concepts:**
| Concept | Explanation |
|---------|------------|
| **Happens-before relationship** | Ensures visibility & ordering guarantees across threads. |
| **Volatile variables** | Ensures visibility but **not atomicity**. |
| **Synchronization** | Provides both visibility & atomicity. |
| **Final field semantics** | Ensures safe publication of objects. |

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

### 🔸 **Thread Pool Types**
| Pool Type | Description |
|-----------|------------|
| **FixedThreadPool** | Fixed number of threads. Best for CPU-bound tasks. |
| **CachedThreadPool** | Dynamically grows. Best for short-lived tasks. |
| **SingleThreadExecutor** | Ensures tasks execute sequentially. |
| **WorkStealingPool** | Uses **ForkJoinPool** for parallelism. |

---

### 🔸 **JVM Architecture Components**
- **ClassLoader** (Loads `.class` files)
- **Runtime Memory Areas**:
  - **Heap** (Objects stored)
  - **Stack** (Method calls & local vars)
  - **Metaspace** (Stores class metadata)
- **Execution Engine**
- **Garbage Collector (GC)**

### 🔸 **Garbage Collection (GC) Strategies**
| GC Type | Best For | Key Mechanism |
|---------|---------|---------------|
| **Serial GC** | Small apps | Single-threaded, simple. |
| **Parallel GC** | High throughput | Uses multiple threads. |
| **G1 GC** | Large heaps | Predictable pause times. |
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
| Feature | Normal Stream | Parallel Stream |
|---------|--------------|----------------|
| Execution | Sequential | Concurrent |
| Performance | Slow for large data | Fast for large data |
| Best Use Case | Small dataset | Large dataset (CPU-intensive) |

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

---

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

### 🔸 **Garbage Collectors in Java**
| GC Type | Best Use Case | Key Features |
|---------|-------------|--------------|
| **Serial GC (-XX:+UseSerialGC)** | Small apps, single-threaded | Simple, stop-the-world, single-threaded. |
| **Parallel GC (-XX:+UseParallelGC)** | High-throughput apps | Multi-threaded GC, **default until Java 8**. |
| **G1 GC (-XX:+UseG1GC)** | Large heaps (>4GB) | Region-based, **predictable pause times**. |
| **ZGC (-XX:+UseZGC)** | Ultra-low-latency apps | Handles **very large heaps** (up to **16TB**). |

### 🔸 **How to Tune GC for Performance?**
Example:
```sh
java -XX:+UseG1GC -Xms2g -Xmx4g -XX:MaxGCPauseMillis=200
```
- `-Xms` and `-Xmx` **set heap size**.
- `-XX:MaxGCPauseMillis=200` **limits GC pause time**.

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

### 🔸 **Generics Wildcards (`? extends`, `? super`)**
| Wildcard | Use Case |
|----------|---------|
| `? extends T` | Accepts T or **subtypes** of T. |
| `? super T` | Accepts T or **supertypes** of T. |

Example:
```java
List<? extends Number> list = new ArrayList<Integer>(); // ✅ Works
List<? super Integer> list2 = new ArrayList<Number>(); // ✅ Works
```

---

### 🔸 **Types of Locks in Java**
| Lock Type | Feature |
|-----------|---------|
| **Intrinsic Locks (`synchronized`)** | Implicit, locks entire object/class. |
| **Explicit Locks (`ReentrantLock`)** | More control, supports fairness policy. |
| **ReadWriteLock** | Allows multiple readers, one writer. |

### **`synchronized` vs `ReentrantLock`**
| Feature | `synchronized` | `ReentrantLock` |
|---------|--------------|---------------|
| Locking | Implicit | Explicit (must `lock()` and `unlock()`) |
| Fairness | No fairness guarantee | Supports fairness (`true` param) |
| Interruptible | No | Yes (`lockInterruptibly()`) |

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
| State | Description |
|--------|-------------|
| **NEW** | Created but not started. |
| **RUNNABLE** | Ready to run, scheduled by CPU. |
| **BLOCKED** | Waiting for a lock. |
| **WAITING** | Waiting indefinitely for another thread (`wait()`). |
| **TIMED_WAITING** | Waiting for a fixed time (`sleep()`, `join()`). |
| **TERMINATED** | Execution finished. |

---

### 🔸 **Thread Safety Techniques**
| Technique | Example |
|-----------|---------|
| **Synchronization** | `synchronized` methods |
| **Locks** | `ReentrantLock` |
| **Atomic Variables** | `AtomicInteger` |
| **ThreadLocal** | Per-thread storage |
| **Immutable Objects** | `final` fields |

Example: **Using `AtomicInteger`**
```java
AtomicInteger counter = new AtomicInteger(0);
counter.incrementAndGet();
```

---

### 🔸 **Types of Thread Pools**
| Pool Type | Description |
|-----------|-------------|
| **FixedThreadPool(n)** | Fixed number of threads. |
| **CachedThreadPool** | Dynamically grows/shrinks. |
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

### 🔸 **Race Condition**
Happens when multiple threads access shared data **without synchronization**.

Example:
```java
counter++; // Not thread-safe 🚨
```
**Fix:** Use **`AtomicInteger`** or **synchronized block**.

