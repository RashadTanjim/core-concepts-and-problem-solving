# Java vs Go Learning Guide (Complete + Preserved Source)

This file is structured as a learning guide and also keeps all concepts and code examples from the shared link content.
No original concept/code section from the link has been removed; the original material is preserved below in ordered modules.

## How To Use This Guide

1. Read modules in order (1 -> 9).
2. For each module, retype at least 2-3 code examples in both Java and Go.
3. Convert one Java snippet to Go per module without looking at the answer first.
4. Build one mini project after Module 5 and one capstone after Module 9.

## Suggested Learning Timeline

- Week 1: Modules 1-2 (language basics and mental model)
- Week 2: Modules 3-5 (JSON mapping, logging, backend utility patterns)
- Week 3: Modules 6-8 (missing core backend concepts + DSA + migration pitfalls)
- Week 4: Module 9 + capstone (build reusable Go backend helpers)

---

## Preserved Source Material (From Shared Link)

The following sections are preserved from the link content and ordered for learning progression.

---

## Module 1: Fundamentals (Java vs Go)

Below is a **side-by-side Java vs Go (Golang) fundamentals cheat-sheet** covering **list/array, loops, if-else, switch-case, functions, structs/classes, maps, enums/constants, error handling, concurrency**, and a few **language-specific constructs**.

I’ll keep examples minimal and equivalent so you can quickly compare semantics.

---

## 1. Hello World

### Java
```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
```

### Go
```go
package main

import "fmt"

func main() {
    fmt.Println("Hello World")
}
```

---

## 2. Variables & Types

### Java
```java
int a = 10;
String name = "Rashad";
boolean active = true;
double price = 99.99;
```

### Go
```go
var a int = 10
name := "Rashad"     // type inferred
active := true
price := 99.99
```

---

## 3. Array (Fixed Size)

### Java
```java
int[] arr = {1, 2, 3, 4};
System.out.println(arr[0]);
```

### Go
```go
arr := [4]int{1, 2, 3, 4}
fmt.Println(arr[0])
```

---

## 4. List / Dynamic Array

### Java (List / ArrayList)
```java
List<Integer> list = new ArrayList<>();
list.add(10);
list.add(20);
System.out.println(list.get(0));
```

### Go (Slice)
```go
list := []int{}
list = append(list, 10)
list = append(list, 20)
fmt.Println(list[0])
```

---

## 5. Loop

### Java – for
```java
for (int i = 0; i < 5; i++) {
    System.out.println(i);
}
```

### Go – for (only one loop keyword)
```go
for i := 0; i < 5; i++ {
    fmt.Println(i)
}
```

---

### Java – enhanced for
```java
for (int v : list) {
    System.out.println(v);
}
```

### Go – range
```go
for _, v := range list {
    fmt.Println(v)
}
```

---

## 6. While Loop

### Java
```java
int i = 0;
while (i < 5) {
    i++;
}
```

### Go
```go
i := 0
for i < 5 {
    i++
}
```

---

## 7. If-Else

### Java
```java
if (a > 10) {
    System.out.println("Greater");
} else {
    System.out.println("Smaller");
}
```

### Go
```go
if a > 10 {
    fmt.Println("Greater")
} else {
    fmt.Println("Smaller")
}
```

---

## 8. Switch-Case

### Java
```java
switch (status) {
    case 1:
        System.out.println("INIT");
        break;
    case 2:
        System.out.println("RUNNING");
        break;
    default:
        System.out.println("UNKNOWN");
}
```

### Go (no `break` needed)
```go
switch status {
case 1:
    fmt.Println("INIT")
case 2:
    fmt.Println("RUNNING")
default:
    fmt.Println("UNKNOWN")
}
```

---

## 9. Function / Method

### Java
```java
static int add(int a, int b) {
    return a + b;
}
```

### Go
```go
func add(a int, b int) int {
    return a + b
}
```

---

## 10. Multiple Return Values

### Java (Wrapper object)
```java
class Result {
    int sum;
    int diff;
}
```

### Go (native support)
```go
func calc(a, b int) (int, int) {
    return a+b, a-b
}
```

---

## 11. Map / Dictionary

### Java
```java
Map<String, String> m = new HashMap<>();
m.put("key", "value");
System.out.println(m.get("key"));
```

### Go
```go
m := map[string]string{
    "key": "value",
}
fmt.Println(m["key"])
```

---

## 12. Struct / Class

### Java (Class)
```java
class User {
    String name;
    int age;
}
```

### Go (Struct)
```go
type User struct {
    Name string
    Age  int
}
```

---

## 13. Constructor

### Java
```java
class User {
    String name;
    User(String name) {
        this.name = name;
    }
}
```

### Go (constructor function)
```go
func NewUser(name string) *User {
    return &User{Name: name}
}
```

---

## 14. Interface

### Java
```java
interface Service {
    void process();
}
```

### Go
```go
type Service interface {
    Process()
}
```

---

## 15. Enum / Constants

### Java
```java
enum Status {
    INIT, RUNNING, DONE
}
```

### Go
```go
type Status int

const (
    INIT Status = iota
    RUNNING
    DONE
)
```

---

## 16. Error Handling

### Java (Exception)
```java
try {
    int x = 10 / 0;
} catch (Exception e) {
    e.printStackTrace();
}
```

### Go (explicit error)
```go
if err != nil {
    fmt.Println(err)
}
```

---

## 17. Defer / Finally

### Java
```java
try {
    // work
} finally {
    cleanup();
}
```

### Go
```go
defer cleanup()
```

---

## 18. Concurrency

### Java (Thread)
```java
new Thread(() -> {
    System.out.println("Async");
}).start();
```

### Go (Goroutine)
```go
go func() {
    fmt.Println("Async")
}()
```

---

## 19. Channel / Queue

### Java (BlockingQueue)
```java
BlockingQueue<Integer> q = new LinkedBlockingQueue<>();
q.put(10);
int v = q.take();
```

### Go (Channel)
```go
ch := make(chan int)
ch <- 10
v := <-ch
```

---

## 20. Null vs Nil

### Java
```java
User u = null;
```

### Go
```go
var u *User = nil
```

---

## 21. Package / Import

### Java
```java
package com.example.app;
import java.util.List;
```

### Go
```go
package main
import "fmt"
```

---

## Summary Table

| Concept | Java | Go |
|------|------|----|
| List | `ArrayList` | Slice |
| Loop | `for`, `while` | `for` only |
| Switch | `break` required | Auto-break |
| Error | Exceptions | `error` return |
| OOP | Class-centric | Struct + interface |
| Concurrency | Thread | Goroutine |
| Return values | Single | Multiple |

---

## Module 2: Core Comparison (Language Surface)

Below is a **clean, side-by-side Java vs Go comparison** for each item you listed, with **minimal examples** and **important behavioral notes**.
This is meant as a **quick reference + migration aid**.

---

# Java vs Go — Core Language Comparison

---

## 1. Comments Type

### Java
```java
// Single-line

/* Multi-line */

/**
 * Documentation (Javadoc)
 */
```

### Go
```go
// Single-line

/*
Multi-line
*/

// Documentation comment (used by godoc)
```

🔎 **Note**: Go uses normal comments for documentation (no special syntax like Javadoc).

---

## 2. Variables

### Java
```java
int a = 10;
String name = "Rashad";
```

### Go
```go
var a int = 10
name := "Rashad" // type inferred
```

🔎 **Key Difference**
- Java: explicit type
- Go: prefers **type inference**

---

## 3. Constants

### Java
```java
final int MAX = 100;
```

### Go
```go
const MAX = 100
```

🔎 Go constants are **compile-time only** (no runtime constants).

---

## 4. Output

### Java
```java
System.out.println("Hello");
```

### Go
```go
fmt.Println("Hello")
```

---

## 5. Data Types

| Java | Go |
|----|----|
| int | int |
| long | int64 |
| float | float32 |
| double | float64 |
| boolean | bool |
| char | rune |
| String | string |

### Java
```java
int a;
boolean ok;
```

### Go
```go
var a int
var ok bool
```

🔎 Go `int` is **platform dependent (usually 64-bit)**.

---

## 6. Arrays (Fixed Size)

### Java
```java
int[] arr = new int[3];
```

### Go
```go
var arr [3]int
```

🔎 Arrays are **rarely used in Go** (slices preferred).

---

## 7. Slices (Dynamic Array – Go Only)

### Java (List equivalent)
```java
List<Integer> list = new ArrayList<>();
```

### Go
```go
list := []int{1, 2, 3}
list = append(list, 4)
```

⚠ **Important**
- Slices are references to arrays
- Mutations propagate unless copied

---

## 8. Operators

### Java
```java
+, -, *, /, %
==, !=, >, <
&&, ||, !
```

### Go
```go
+, -, *, /, %
==, !=, >, <
&&, ||, !
```

🔎 **Difference**
- Go has **no ternary operator**
```java
// Java
int x = a > b ? a : b;
```

```go
// Go (if-else)
var x int
if a > b {
    x = a
} else {
    x = b
}
```

---

## 9. Conditions (if-else)

### Java
```java
if (a > 10) {
    ...
}
```

### Go
```go
if a > 10 {
    ...
}
```

🔎 No parentheses required in Go.

---

## 10. Switch

### Java
```java
switch (x) {
    case 1:
        break;
    default:
}
```

### Go
```go
switch x {
case 1:
    // auto-break
default:
}
```

🔎 Go switch:
- No `break` needed
- Can switch on **any type**
- Supports condition-less switch

---

## 11. Loops

### Java
```java
for (int i = 0; i < 5; i++) {}
while (cond) {}
```

### Go (only `for`)
```go
for i := 0; i < 5; i++ {}
for cond {}
```

🔎 Go has **one loop keyword**.

---

## 12. Functions

### Java
```java
static int add(int a, int b) {
    return a + b;
}
```

### Go
```go
func add(a int, b int) int {
    return a + b
}
```

🔎 Go supports **multiple return values**.

---

## 13. Struct (Class Alternative)

### Java (Class)
```java
class User {
    String name;
    int age;
}
```

### Go (Struct)
```go
type User struct {
    Name string
    Age  int
}
```

🔎 Go has:
- No classes
- No inheritance
- Composition over inheritance

---

## 14. Maps

### Java
```java
Map<String, Integer> map = new HashMap<>();
map.put("a", 1);
```

### Go
```go
m := make(map[string]int)
m["a"] = 1
```

⚠ **Critical Difference**
```go
v, ok := m["a"] // must check existence
```

Maps in Go are **NOT thread-safe**.

---

## 15. Compiler / Execution Model

### Java
```bash
javac Main.java
java Main
```

- Bytecode
- JVM required
- Runtime JIT

### Go
```bash
go build
./app
```

- Native binary
- No runtime dependency
- Faster startup

---

## High-Level Summary Table

| Feature | Java | Go |
|------|----|----|
| OOP | Class-based | Struct + interface |
| Generics | Mature | New (1.18+) |
| GC | Heavy | Lightweight |
| Startup | Slow | Fast |
| Binary | JVM needed | Single static binary |
| Concurrency | Thread | Goroutine |
| DS Library | Rich | Minimal |

---

## Migration Rule of Thumb

> **Java** → Complex DS, deep recursion, abstraction
> **Go** → Performance, workers, pipelines, explicit control

---

## Module 3: Type Conversion, JSON, DTO/Entity/Model

Here’s a **focused Java vs Go comparison for data type conversions, JSON, strings, marshaling/unmarshaling, and DTO/entity/model handling**, with practical examples and migration notes.

This is very relevant for **backend services, microservices, and APIs**.

---

# 1. Data Type Conversion

## Java

### Primitives
```java id="java-prim-conv"
int i = 10;
double d = (double) i;  // explicit cast
int j = (int) d;         // explicit cast

String s = "123";
int x = Integer.parseInt(s);
double y = Double.parseDouble(s);
```

### Objects
```java id="java-obj-conv"
Integer num = 5;         // autoboxing
String str = String.valueOf(num);
```

---

## Go

### Primitives
```go id="go-prim-conv"
var i int = 10
var d float64 = float64(i)
var j int = int(d)

s := "123"
x, _ := strconv.Atoi(s)
y, _ := strconv.ParseFloat(s, 64)
```

### Notes
- Go conversion **always explicit**
- Go uses `strconv` for string ↔ number conversion
- Go has no automatic boxing/unboxing

---

# 2. Strings

### Java
```java id="java-str"
String s = "Hello";
int len = s.length();
String upper = s.toUpperCase();
boolean contains = s.contains("H");
```

### Go
```go id="go-str"
s := "Hello"
len := len(s)          // bytes, not runes
upper := strings.ToUpper(s)
contains := strings.Contains(s, "H")
```

🔎 **Key Difference**
- `len()` in Go returns bytes, use `utf8.RuneCountInString()` for actual characters
- Strings are immutable in both languages

---

# 3. JSON Handling

## Java (Jackson)
```java id="java-json"
ObjectMapper mapper = new ObjectMapper();
User user = new User("Rashad", 30);

// Marshal (object → JSON)
String json = mapper.writeValueAsString(user);

// Unmarshal (JSON → object)
User user2 = mapper.readValue(json, User.class);
```

## Go (`encoding/json`)
```go id="go-json"
type User struct {
    Name string `json:"name"`
    Age  int    `json:"age"`
}

user := User{"Rashad", 30}

// Marshal
jsonBytes, _ := json.Marshal(user)
jsonStr := string(jsonBytes)

// Unmarshal
var user2 User
_ = json.Unmarshal(jsonBytes, &user2)
```

### Notes
- Go uses **struct tags** for JSON field names
- Go errors must be **handled explicitly**
- Both support nested objects and arrays

---

# 4. Marshaling / Unmarshaling

| Feature | Java | Go |
|---|---|---|
| JSON | `ObjectMapper` | `json.Marshal` / `json.Unmarshal` |
| XML | `JAXB` | `encoding/xml` |
| ProtoBuf | `protobuf-java` | `google.golang.org/protobuf` |
| Custom binary | Implement `Serializable` | Implement `encoding.BinaryMarshaler` / `Unmarshaler` |

### Go Example: Custom Marshal
```go id="go-custom-marshal"
func (u User) MarshalJSON() ([]byte, error) {
    return json.Marshal(map[string]interface{}{
        "username": u.Name,
        "age":      u.Age,
    })
}
```

---

# 5. DTO, Entity, Model

### Java

- **Entity** → Database model (`@Entity`)
- **DTO** → Data Transfer Object (for API)
- **Model / Domain** → Business logic representation

```java id="java-dto-entity"
@Entity
class UserEntity {
    @Id
    private Long id;
    private String name;
}

class UserDTO {
    private String name;
}

class User {
    private String name;
    public User(UserEntity e) { this.name = e.getName(); }
}
```

### Go

- Go has **structs** for everything
- Usually separate types for DB, API, and domain

```go id="go-dto-entity"
type UserEntity struct {
    ID   int64
    Name string
}

type UserDTO struct {
    Name string `json:"name"`
}

type User struct {
    Name string
}

// Conversion
func FromEntity(e UserEntity) User {
    return User{Name: e.Name}
}
```

### Notes
- No annotations; use **struct tags** for JSON/DB
- Manual mapping often preferred
- Libraries like `automapper` exist but less common in Go

---

# 6. Type Conversion Between DTO / Entity / Model

### Java (with constructor or mapper)
```java id="java-mapper"
User user = new User(userEntity);
UserDTO dto = new UserDTO();
BeanUtils.copyProperties(user, dto);
```

### Go (manual)
```go id="go-mapper"
dto := UserDTO{Name: user.Name}
```

🔎 **Go Tip**
- Explicit is preferred
- No reflection-based magic by default
- Libraries: `copier` or `automapper` (optional)

---

# 7. Null vs Zero Value

| Concept | Java | Go |
|---|---|---|
| Default primitive | 0 / false | 0 / false |
| Object reference | null | nil (pointers, slices, maps) |
| JSON marshal missing field | omitted if null | omitted if `omitempty` tag |
| Optional | `Optional<T>` | pointer `*T` |

---

# 8. JSON Example With Nested Structs

### Java
```java id="java-json-nested"
class Address { String city; }
class User { String name; Address addr; }

User u = new User("Rashad", new Address("Dhaka"));
String json = mapper.writeValueAsString(u);
```

### Go
```go id="go-json-nested"
type Address struct { City string `json:"city"` }
type User struct {
    Name string  `json:"name"`
    Addr Address `json:"address"`
}

u := User{"Rashad", Address{"Dhaka"}}
jsonBytes, _ := json.Marshal(u)
```

---

# Key Migration Rules

| Concept | Java | Go | Notes |
|---------|------|----|-------|
| JSON field mapping | Annotations | Struct tags | Go tags `json:"field,omitempty"` |
| Marshaling errors | Exception | Return value | Go errors must be handled |
| DTO → Model | BeanUtils / constructor | Manual conversion | Explicit mapping is idiomatic in Go |
| Null handling | `null` | `nil` | Use pointers for optional fields |
| Default value | Language default | Zero value | Numeric 0, string "", bool false |
| Nested structs | Object references | Struct fields | Pass by value or pointer |

---

## Module 4: Output, Print, and Logging

Below is a **focused, practical comparison of OUTPUT writing in Java vs Go**, covering **print/printf**, **logging**, **structured logs**, **performance**, and **production best-practices**.

This is written from a **backend / microservice** perspective.

---

# Java vs Go — Output Writing (Print & Logger)

---

## 1. Basic Print (Console Output)

### Java
```java
System.out.print("Hello");
System.out.println("Hello");
```

### Go
```go
fmt.Print("Hello")
fmt.Println("Hello")
```

🔎 **Notes**
- `println` automatically adds newline
- Suitable only for **debug/local use**

---

## 2. Formatted Output (`printf` style)

### Java
```java
System.out.printf("User %s is %d years old%n", name, age);
```

### Go
```go
fmt.Printf("User %s is %d years old\n", name, age)
```

| Specifier | Java | Go |
|---|---|---|
| String | `%s` | `%s` |
| Integer | `%d` | `%d` |
| Float | `%f` | `%f` |
| Newline | `%n` | `\n` |

---

## 3. Writing to Stdout vs Stderr

### Java
```java
System.out.println("INFO");
System.err.println("ERROR");
```

### Go
```go
fmt.Println("INFO")
fmt.Fprintln(os.Stderr, "ERROR")
```

🔎 **Production Rule**
- **stdout** → normal logs
- **stderr** → errors
(Kubernetes & Docker rely on this)

---

## 4. Why `print` Is BAD in Production

| Problem | Java | Go |
|---|---|---|
| No log level | ❌ | ❌ |
| No timestamp | ❌ | ❌ |
| No context | ❌ | ❌ |
| Hard to search | ❌ | ❌ |

✅ **Conclusion**:
> `print / println` is for **learning & debugging only**

---

# LOGGING (The Right Way)

---

## 5. Java Logging (Standard)

### Using SLF4J + Logback
```java
private static final Logger log =
    LoggerFactory.getLogger(MyService.class);

log.info("User {} logged in", userId);
log.warn("Retry count {}", retry);
log.error("Failed to process", ex);
```

### Log Levels
- `TRACE`
- `DEBUG`
- `INFO`
- `WARN`
- `ERROR`

🔎 **Key Advantage**
- Lazy evaluation
- Parameterized logging (no string concat)

---

## 6. Go Standard Logger (`log` package)

### Basic
```go
log.Println("User logged in")
log.Printf("User %s logged in", userID)
```

### Output example
```
2026/03/04 03:12:10 User logged in
```

🔎 Automatically includes:
- Timestamp
- Writes to stderr by default

---

## 7. Custom Logger Configuration (Go)

```go
logger := log.New(
    os.Stdout,
    "[INFO] ",
    log.Ldate|log.Ltime|log.Lshortfile,
)

logger.Println("Service started")
```

---

## 8. Structured Logging (CRITICAL in Microservices)

### Java (Logback / JSON encoder)
```java
log.info("job processed",
    kv("jobId", jobId),
    kv("status", "SUCCESS")
);
```

### Go (Recommended)
```go
log.Printf(
    "job processed jobId=%s status=%s",
    jobID, "SUCCESS",
)
```

⚠ This is still **semi-structured**

---

## 9. Proper Structured Logging in Go (zap / slog)

### Go 1.21+ (`log/slog`)
```go
logger := slog.New(slog.NewJSONHandler(os.Stdout, nil))

logger.Info("job processed",
    "jobId", jobID,
    "status", "SUCCESS",
)
```

### Output
```json
{
  "time":"2026-03-04T03:15:22Z",
  "level":"INFO",
  "msg":"job processed",
  "jobId":"123",
  "status":"SUCCESS"
}
```

🔎 **Best choice for K8s, ELK, Loki**

---

## 10. Performance Comparison

| Method | Java | Go |
|---|---|---|
| `print` | Slow | Slow |
| Logger (sync) | Medium | Medium |
| Async logger | Fast | Fast |
| Structured JSON | Medium | Medium |

⚠ `fmt.Printf` is **slow in hot paths**

---

## 11. Logging Inside Loops (Common Bug)

### ❌ Java
```java
for (...) {
    log.info("Processing {}", item);
}
```

### ❌ Go
```go
for _, item := range items {
    log.Println("Processing", item)
}
```

### ✅ Correct Pattern
- Aggregate
- Log summary
- Log errors only

---

## 12. Logging Errors (Correct Pattern)

### Java
```java
try {
    ...
} catch (Exception e) {
    log.error("Failed to process job {}", jobId, e);
}
```

### Go
```go
if err != nil {
    logger.Error("failed to process job",
        "jobId", jobID,
        "error", err,
    )
}
```

---

## 13. Context-Aware Logging

### Java (MDC)
```java
MDC.put("traceId", traceId);
log.info("Request received");
```

### Go (context)
```go
logger := slog.With("traceId", traceID)
logger.Info("request received")
```

---

## 14. Logging in Containers / K8s (IMPORTANT)

### Java
- Disable file appenders
- Log to stdout

### Go
- Default stdout/stderr
- No config needed

✅ **Golden Rule**
> Never write logs to files inside containers

---

## 15. When to Use What

| Use Case | Java | Go |
|---|---|---|
| Debug local | `System.out` | `fmt.Println` |
| Production | SLF4J | `slog` / zap |
| High throughput | Async logger | zap |
| JSON logs | Logback JSON | `slog` |

---

## Final Recommendation

### Java
- ❌ `System.out.println`
- ✅ `SLF4J + Logback`

### Go
- ❌ `fmt.Println` in services
- ✅ `log/slog` (Go ≥1.21)
- ✅ `zap` for ultra-high throughput

---

## Module 5: Most-Used Backend Methods

Here’s a **practical Java vs Go cheat sheet** for **commonly used methods and functions** when working with **arrays, lists, strings, sets, maps, slices**, and functional-style operations like **map/reduce/filter**—all oriented for **backend development**.

I’ll focus on **things you actually call in real code**, not just syntax.

---

# 1. Arrays / Lists

### Java Arrays
```java id="java-arr"
int[] arr = {1,2,3,4};

// Length
int n = arr.length;

// Iterate
for(int x : arr) System.out.println(x);

// Sort
Arrays.sort(arr);

// Copy
int[] copy = Arrays.copyOf(arr, arr.length);

// Search
int idx = Arrays.binarySearch(arr, 3);
```

### Java List (ArrayList)
```java id="java-list"
List<Integer> list = new ArrayList<>();
list.add(1);
list.add(2);
list.size();
list.get(0);
list.remove(1);
list.contains(2);

// Functional (Java 8+)
list.stream().map(x -> x*2).filter(x -> x>2).collect(Collectors.toList());
```

### Go Slice
```go id="go-slice"
arr := []int{1,2,3,4}

// Length
len(arr)

// Iterate
for _, x := range arr {
    fmt.Println(x)
}

// Append
arr = append(arr, 5)

// Copy
copyArr := make([]int, len(arr))
copy(copyArr, arr)

// Sort
sort.Ints(arr)

// Map / Filter (manual)
mapped := make([]int, 0, len(arr))
for _, x := range arr {
    if x%2==0 { // filter
        mapped = append(mapped, x*2)
    }
}
```

---

# 2. Strings

### Java
```java id="java-str-methods"
String s = "Hello, World";

// Length
int len = s.length();

// Substring
String sub = s.substring(0,5);

// Upper / Lower
s.toUpperCase();
s.toLowerCase();

// Contains / StartsWith / EndsWith
s.contains("Hello");
s.startsWith("He");
s.endsWith("ld");

// Split / Join
String[] parts = s.split(", ");
String joined = String.join("-", parts);

// Trim
s.trim();

// Replace
s.replace("World", "Go");
```

### Go
```go id="go-str-methods"
s := "Hello, World"

// Length (bytes)
len(s)
utf8.RuneCountInString(s) // actual characters

// Substring
sub := s[:5]

// Upper / Lower
strings.ToUpper(s)
strings.ToLower(s)

// Contains / Prefix / Suffix
strings.Contains(s, "Hello")
strings.HasPrefix(s, "He")
strings.HasSuffix(s, "ld")

// Split / Join
parts := strings.Split(s, ", ")
joined := strings.Join(parts, "-")

// Trim / Replace
strings.TrimSpace(s)
strings.ReplaceAll(s, "World", "Go")
```

---

# 3. Set

### Java
```java id="java-set"
Set<String> set = new HashSet<>();
set.add("A");
set.contains("A");
set.remove("B");
set.size();
```

### Go
```go id="go-set"
set := map[string]struct{}{}
set["A"] = struct{}{}
_, ok := set["A"]
delete(set, "B")
len(set)
```

---

# 4. Map / Dictionary

### Java
```java id="java-map"
Map<String,Integer> map = new HashMap<>();
map.put("a",1);
map.get("a");
map.containsKey("b");
map.remove("c");
map.size();
map.keySet();
map.values();
```

### Go
```go id="go-map"
m := make(map[string]int)
m["a"] = 1
v, ok := m["a"]
delete(m, "b")
len(m)
```

---

# 5. Slice / Array Utilities (Go)

Go has **no built-in reduce/map/filter**, so we implement manually:

```go id="go-functional"
arr := []int{1,2,3,4}

// Map
mapped := make([]int, 0, len(arr))
for _, x := range arr {
    mapped = append(mapped, x*2)
}

// Filter
filtered := make([]int, 0, len(arr))
for _, x := range arr {
    if x%2==0 {
        filtered = append(filtered, x)
    }
}

// Reduce / Sum
sum := 0
for _, x := range arr {
    sum += x
}
```

---

# 6. Common Backend Utility Functions

| Purpose | Java | Go |
|---------|------|----|
| Max / Min | `Collections.max(list)` | `math.Max(a,b)` |
| Sum | `list.stream().mapToInt(i->i).sum()` | `for _, v := range arr {sum+=v}` |
| Sort | `Collections.sort(list)` | `sort.Ints(slice)` |
| Reverse | `Collections.reverse(list)` | Manual loop or `sort.Sort(sort.Reverse(sort.IntSlice(slice)))` |
| Remove Duplicates | `new HashSet<>(list)` | `map[int]struct{}` + append |

---

# 7. JSON + Struct / DTO Mapping

### Java
```java id="java-json-dto"
ObjectMapper mapper = new ObjectMapper();
String json = mapper.writeValueAsString(user);
User u2 = mapper.readValue(json, User.class);
```

### Go
```go id="go-json-dto"
jsonBytes, _ := json.Marshal(user)
var u2 User
_ = json.Unmarshal(jsonBytes, &u2)
```

---

# 8. Summary: Most Used Backend Helpers

| Category | Java | Go |
|----------|------|----|
| Arrays | `Arrays.sort`, `Arrays.copyOf` | `append`, `copy`, `sort.Ints` |
| Lists | `add`, `get`, `remove`, `stream().map().filter()` | `append`, manual loop, slice tricks |
| Strings | `split`, `join`, `contains`, `trim`, `replace`, `substring` | `strings.Split`, `strings.Join`, `Contains`, `TrimSpace`, `Replace` |
| Set | `HashSet.add`, `contains`, `remove` | `map[T]struct{}` |
| Map | `put`, `get`, `containsKey`, `remove` | `map[T]U`, `delete`, `ok` |
| Reduce / Sum / Filter | Streams | Manual loops |
| JSON | Jackson `ObjectMapper` | `encoding/json` |

---

✅ **Tip for Backend Coding**
- Java gives **ready-to-use utilities**, Go requires **manual loops or helper functions**
- Go is explicit but **faster** and avoids extra heap allocations
- For Go, it’s worth writing small **generic helpers** like `MapIntSlice`, `FilterSlice`, `ReduceSlice` for repetitive backend tasks

---

## Module 6: Additional Missing Concepts (Added)

This section adds important concepts often missed in Java-vs-Go comparisons, especially for real backend work.

### 1) Project Layout and Dependency Management

- Java commonly uses layered packages with Maven/Gradle.
- Go commonly keeps packages simple: `cmd/`, `internal/`, `pkg/` (if needed), and module-based dependencies via `go.mod`.

```bash
# Go module basics
go mod init example.com/my-service
go mod tidy
go test ./...
```

### 2) Generics (Java vs Modern Go)

```java
public static <T> T first(List<T> items) {
    return items.get(0);
}
```

```go
func First[T any](items []T) T {
    return items[0]
}
```

### 3) Context Propagation and Cancellation (Critical in Go Services)

```go
func FetchUser(ctx context.Context, id string) (User, error) {
    req, err := http.NewRequestWithContext(ctx, http.MethodGet, "https://api.example.com/users/"+id, nil)
    if err != nil {
        return User{}, err
    }
    resp, err := http.DefaultClient.Do(req)
    if err != nil {
        return User{}, err
    }
    defer resp.Body.Close()
    // decode body...
    return User{}, nil
}
```

### 4) Error Wrapping and Classification

```go
var ErrNotFound = errors.New("not found")

func FindUser(id string) error {
    if id == "" {
        return fmt.Errorf("find user: %w", ErrNotFound)
    }
    return nil
}

func Caller() {
    if err := FindUser(""); err != nil {
        if errors.Is(err, ErrNotFound) {
            // handle not-found
        }
    }
}
```

### 5) Testing Style Differences

Java (JUnit parameterized style):

```java
@ParameterizedTest
@CsvSource({"1,2,3", "2,3,5"})
void addTest(int a, int b, int expected) {
    assertEquals(expected, add(a, b));
}
```

Go (table-driven tests):

```go
func TestAdd(t *testing.T) {
    tests := []struct{ a, b, want int }{
        {1, 2, 3},
        {2, 3, 5},
    }
    for _, tt := range tests {
        if got := Add(tt.a, tt.b); got != tt.want {
            t.Fatalf("got=%d want=%d", got, tt.want)
        }
    }
}
```

### 6) Concurrency Safety (Race Awareness)

- Java: often uses synchronized constructs, executors.
- Go: easy goroutines, but race conditions are easy too.
- Always validate concurrent code with:

```bash
go test -race ./...
```

### 7) Graceful Shutdown for APIs

```go
func main() {
    srv := &http.Server{Addr: ":8080", Handler: myRouter()}

    go func() {
        _ = srv.ListenAndServe()
    }()

    stop := make(chan os.Signal, 1)
    signal.Notify(stop, os.Interrupt, syscall.SIGTERM)
    <-stop

    ctx, cancel := context.WithTimeout(context.Background(), 5*time.Second)
    defer cancel()
    _ = srv.Shutdown(ctx)
}
```

### 8) Slice Memory Retention Fix Pattern

If you pop from the front repeatedly, avoid retaining large backing arrays:

```go
// after consuming many elements, re-copy to release old backing array
if len(queue) > 0 && len(queue) < cap(queue)/4 {
    tmp := make([]int, len(queue))
    copy(tmp, queue)
    queue = tmp
}
```

### 9) API Reliability Patterns to Learn Next

- Retries with backoff (idempotent operations only)
- Circuit breaker pattern
- Request timeout budgets
- Idempotency keys for write endpoints
- Structured audit logging for critical actions

---

## Final Study Rule

Use Java knowledge for design discipline, but write idiomatic Go instead of Java-style Go.
Prioritize correctness, explicitness, observability, and maintainability.

## Module 7: DSA Comparison

Below is a **Data Structures & Algorithms (DSA) comparison — Java vs Go**, with **idiomatic implementations**, **time complexity notes**, and **common pitfalls**.
I’ll focus on what actually matters when you *implement* DSA in production-grade services.

---

# 1. Stack (LIFO)

## Java
```java
import java.util.Stack;

Stack<Integer> st = new Stack<>();
st.push(10);
st.push(20);
int top = st.pop(); // 20
```

**Better (recommended)**
```java
Deque<Integer> st = new ArrayDeque<>();
st.push(10);
st.push(20);
int top = st.pop();
```

## Go
```go
stack := []int{}
stack = append(stack, 10)
stack = append(stack, 20)

top := stack[len(stack)-1]
stack = stack[:len(stack)-1]
```

**Time Complexity:**
- Push / Pop → **O(1)**

---

# 2. Queue (FIFO)

## Java
```java
Queue<Integer> q = new LinkedList<>();
q.offer(10);
q.offer(20);
int v = q.poll(); // 10
```

## Go
```go
queue := []int{}
queue = append(queue, 10)
queue = append(queue, 20)

v := queue[0]
queue = queue[1:]
```

⚠ **Go note:** slicing causes underlying array retention (possible memory leak for long queues).

---

# 3. Deque (Double-ended Queue)

## Java
```java
Deque<Integer> dq = new ArrayDeque<>();
dq.addFirst(10);
dq.addLast(20);
dq.removeFirst();
dq.removeLast();
```

## Go
```go
// Not built-in; use container/list
import "container/list"

dq := list.New()
dq.PushFront(10)
dq.PushBack(20)
dq.Remove(dq.Front())
```

---

# 4. HashMap / Dictionary

## Java
```java
Map<String, Integer> map = new HashMap<>();
map.put("a", 1);
int v = map.getOrDefault("a", 0);
```

## Go
```go
m := make(map[string]int)
m["a"] = 1

v, ok := m["a"]
if !ok {
    v = 0
}
```

**Time Complexity:**
- Average: **O(1)**
- Worst: **O(n)**

---

# 5. Set

## Java
```java
Set<Integer> set = new HashSet<>();
set.add(1);
set.contains(1);
```

## Go (map as set)
```go
set := make(map[int]struct{})
set[1] = struct{}{}

_, exists := set[1]
```

---

# 6. Priority Queue / Heap

## Java
```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
pq.offer(3);
pq.offer(1);
pq.offer(2);

int min = pq.poll(); // 1
```

## Go
```go
import "container/heap"

type IntHeap []int
func (h IntHeap) Len() int           { return len(h) }
func (h IntHeap) Less(i, j int) bool { return h[i] < h[j] }
func (h IntHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }
func (h *IntHeap) Push(x interface{}) {
    *h = append(*h, x.(int))
}
func (h *IntHeap) Pop() interface{} {
    old := *h
    x := old[len(old)-1]
    *h = old[:len(old)-1]
    return x
}

h := &IntHeap{}
heap.Init(h)
heap.Push(h, 3)
heap.Push(h, 1)
heap.Push(h, 2)

min := heap.Pop(h).(int)
```

---

# 7. Linked List

## Java
```java
LinkedList<Integer> list = new LinkedList<>();
list.add(1);
list.add(2);
list.removeFirst();
```

## Go
```go
import "container/list"

l := list.New()
l.PushBack(1)
l.PushBack(2)
l.Remove(l.Front())
```

---

# 8. Binary Search

## Java
```java
int[] arr = {1, 3, 5, 7};

int l = 0, r = arr.length - 1;
while (l <= r) {
    int mid = l + (r - l) / 2;
    if (arr[mid] == 5) break;
    if (arr[mid] < 5) l = mid + 1;
    else r = mid - 1;
}
```

## Go
```go
arr := []int{1, 3, 5, 7}

l, r := 0, len(arr)-1
for l <= r {
    mid := l + (r-l)/2
    if arr[mid] == 5 {
        break
    }
    if arr[mid] < 5 {
        l = mid + 1
    } else {
        r = mid - 1
    }
}
```

---

# 9. Sorting

## Java
```java
Arrays.sort(arr);              // primitive
Collections.sort(list);        // objects
```

## Go
```go
import "sort"

sort.Ints(arr)
sort.Slice(users, func(i, j int) bool {
    return users[i].Age < users[j].Age
})
```

---

# 10. Two Pointers

## Java
```java
int l = 0, r = arr.length - 1;
while (l < r) {
    if (arr[l] + arr[r] == target) break;
    if (arr[l] + arr[r] < target) l++;
    else r--;
}
```

## Go
```go
l, r := 0, len(arr)-1
for l < r {
    sum := arr[l] + arr[r]
    if sum == target {
        break
    }
    if sum < target {
        l++
    } else {
        r--
    }
}
```

---

# 11. Sliding Window

## Java
```java
int sum = 0, left = 0;
for (int right = 0; right < arr.length; right++) {
    sum += arr[right];
    while (sum > k) {
        sum -= arr[left++];
    }
}
```

## Go
```go
sum, left := 0, 0
for right := 0; right < len(arr); right++ {
    sum += arr[right]
    for sum > k {
        sum -= arr[left]
        left++
    }
}
```

---

# 12. BFS (Graph / Tree)

## Java
```java
Queue<Integer> q = new LinkedList<>();
q.offer(1);

while (!q.isEmpty()) {
    int cur = q.poll();
    for (int next : graph.get(cur)) {
        q.offer(next);
    }
}
```

## Go
```go
queue := []int{1}

for len(queue) > 0 {
    cur := queue[0]
    queue = queue[1:]
    for _, next := range graph[cur] {
        queue = append(queue, next)
    }
}
```

---

# 13. DFS (Recursive)

## Java
```java
void dfs(int node) {
    visited[node] = true;
    for (int n : graph[node]) {
        if (!visited[n]) dfs(n);
    }
}
```

## Go
```go
func dfs(node int) {
    visited[node] = true
    for _, n := range graph[node] {
        if !visited[n] {
            dfs(n)
        }
    }
}
```

---

# 14. Recursion Depth (Important Difference)

| Topic | Java | Go |
|----|----|----|
| Stack size | Large | Smaller |
| Deep recursion | Safer | Risky |
| Alternative | Recursion | Iterative preferred |

---

# 15. Dynamic Programming (Fibonacci)

## Java
```java
int[] dp = new int[n+1];
dp[0] = 0;
dp[1] = 1;
for (int i = 2; i <= n; i++) {
    dp[i] = dp[i-1] + dp[i-2];
}
```

## Go
```go
dp := make([]int, n+1)
dp[0], dp[1] = 0, 1
for i := 2; i <= n; i++ {
    dp[i] = dp[i-1] + dp[i-2]
}
```

---

# 16. Bit Manipulation

## Java
```java
boolean isPowerOfTwo = (n & (n - 1)) == 0;
```

## Go
```go
isPowerOfTwo := n&(n-1) == 0
```

---

# Key DSA Differences (Real-World)

| Area | Java | Go |
|---|---|---|
| Built-in DS | Rich (Collections) | Minimal |
| Heap | Easy | Verbose |
| Generics | Mature | Improving |
| Memory control | GC heavy | More predictable |
| Competitive coding | Excellent | Good but manual |

---

## Recommendation (Based on Your Background)

Since you work with **high-throughput backend systems**:
- **Java** → complex DS-heavy logic (PQ, trees, deep recursion)
- **Go** → streaming, workers, queues, BFS/DFS iterative, pipelines

---

## Module 8: Java -> Go DSA Migration Checklist

Below is a **practical, production-oriented Java → Go DSA migration checklist**, written for engineers who already *know* Java DS well and want to **avoid correctness, performance, and memory pitfalls in Go**.

This is **not theory**—it’s a *migration playbook*.

---

# Java → Go DSA Migration Checklist

---

## 1. Arrays vs Slices (🚨 Most Common Bug)

### Java
```java
int[] arr = new int[10];
```

### Go
```go
arr := make([]int, 10)
```

### ⚠ Migration Rules
- **Slices ≠ arrays**
- Slices are **views over arrays**
- Passing slice → **mutates original data**

✅ **Checklist**
- [ ] Check every function param: slice mutation intended?
- [ ] Use `copy()` when isolation is required
```go
dst := make([]int, len(src))
copy(dst, src)
```

---

## 2. List → Slice (Capacity Pitfall)

### Java
```java
List<Integer> list = new ArrayList<>();
```

### Go
```go
list := make([]int, 0, 100) // pre-allocate if size known
```

### ⚠ Why it matters
- Frequent `append()` → reallocation
- Reallocation → CPU + GC overhead

✅ **Checklist**
- [ ] Estimate size & pre-allocate
- [ ] Avoid appending inside tight loops blindly

---

## 3. Queue Migration (🚨 Hidden Memory Leak)

### Java
```java
Queue<Integer> q = new LinkedList<>();
q.poll();
```

### ❌ Naive Go (leaks memory)
```go
queue = queue[1:]
```

### ✅ Correct Go
```go
v := queue[0]
queue[0] = 0        // clear reference
queue = queue[1:]
```

### OR use index-based queue
```go
head := 0
for head < len(queue) {
    v := queue[head]
    head++
}
```

✅ **Checklist**
- [ ] Clear references before slicing
- [ ] Prefer index-based queues for BFS

---

## 4. Stack Migration

### Java
```java
Deque<Integer> st = new ArrayDeque<>();
```

### Go
```go
stack := []int{}
```

### ⚠ Rule
- Never pop without length check

```go
if len(stack) == 0 {
    // handle empty
}
```

---

## 5. HashMap → Map (Zero Value Trap)

### Java
```java
map.get(key) == null
```

### Go
```go
v, ok := m[key]
```

### ⚠ Trap
- Zero value ≠ key missing

❌ Wrong
```go
if m[key] == 0 {}
```

✅ Correct
```go
v, ok := m[key]
if !ok {}
```

✅ **Checklist**
- [ ] Always use `comma-ok` idiom
- [ ] Don’t rely on zero values

---

## 6. Set Migration

### Java
```java
Set<Integer> set = new HashSet<>();
```

### Go
```go
set := map[int]struct{}{}
```

### Why `struct{}`?
- Zero allocation
- No memory overhead

---

## 7. PriorityQueue / Heap (Verbose but Powerful)

### Java
```java
PriorityQueue<int[]> pq;
```

### Go
- Must implement `heap.Interface`
- Less boilerplate → bugs if careless

✅ **Checklist**
- [ ] Double-check `Less()` logic
- [ ] Pointer receiver for Push/Pop
- [ ] Test min/max heap explicitly

---

## 8. Recursion → Iteration (🚨 Stack Risk)

| | Java | Go |
|--|--|--|
| Recursion depth | Large | Small |
| DFS | Recursive OK | Iterative preferred |

### Java
```java
dfs(node);
```

### Go (preferred)
```go
stack := []int{start}
for len(stack) > 0 {
    node := stack[len(stack)-1]
    stack = stack[:len(stack)-1]
}
```

✅ **Checklist**
- [ ] Convert DFS recursion → stack
- [ ] Especially for trees/graphs

---

## 9. Graph Representation

### Java
```java
Map<Integer, List<Integer>> graph;
```

### Go
```go
graph := make(map[int][]int)
```

### ⚠ Gotcha
Appending to nil slice is safe:
```go
graph[u] = append(graph[u], v)
```

---

## 10. Visited Array vs Map

### Java
```java
boolean[] visited;
```

### Go
```go
visited := make([]bool, n) // faster
// OR
visited := map[int]bool{} // flexible
```

✅ **Rule**
- Dense nodes → slice
- Sparse keys → map

---

## 11. Sorting with Custom Comparator

### Java
```java
Arrays.sort(arr, (a,b) -> a-b);
```

### Go
```go
sort.Slice(arr, func(i, j int) bool {
    return arr[i] < arr[j]
})
```

⚠ Comparator must be **strict weak ordering**

---

## 12. Integer Overflow Differences

### Java
```java
int x = Integer.MAX_VALUE;
```

### Go
```go
var x int // platform-dependent (64-bit mostly)
```

✅ **Checklist**
- [ ] Use `int64` for safety
- [ ] Avoid assuming 32-bit int

---

## 13. Error Handling vs Exceptions

### Java
```java
try { ... } catch {}
```

### Go
```go
if err != nil { return err }
```

### Migration Rule
- Every function that can fail → returns error
- No silent failures

---

## 14. Generics vs Empty Interface

### Java
```java
List<Integer>
```

### Go (pre-generics)
```go
[]interface{}
```

### Modern Go
```go
type Stack[T any] struct {
    data []T
}
```

✅ **Checklist**
- [ ] Prefer generics (Go ≥1.18)
- [ ] Avoid `interface{}` in DS

---

## 15. Memory Visibility (No `volatile`)

### Java
```java
volatile boolean done;
```

### Go
```go
atomic.LoadInt32(&done)
// OR channel synchronization
```

---

## 16. Concurrency + DSA (Critical Difference)

### Java
- Thread-safe collections available

### Go
- **Maps are NOT thread-safe**

❌ Crash
```go
go func() { m[1] = 1 }()
```

✅ Fix
```go
sync.Mutex
sync.Map
channel ownership
```

---

## 17. BFS / Sliding Window Optimization

### Java
```java
Queue<Integer> q;
```

### Go (best)
```go
queue := make([]int, n)
head, tail := 0, 0
```

Avoid slice-shifting.

---

## 18. Time Complexity ≠ Performance

| Case | Java | Go |
|--|--|--|
| O(1) map | Good | Faster |
| Heap | Easy | Slower (manual) |
| Slice copy | N/A | Costly |
| GC pressure | Higher | Lower |

---

## 19. Testing Migration Correctness

✅ **Checklist**
- [ ] Compare outputs for same input
- [ ] Stress test with large data
- [ ] Enable race detector
```bash
go test -race
```

---

## 20. Migration Decision Rule (Very Important)

| Scenario | Choose |
|--|--|
| Heavy DS logic | Java |
| Streaming / BFS / queues | Go |
| Recursive algorithms | Java |
| Worker pipelines | Go |

---

## Final Rule of Thumb

> **Java = abstraction-heavy, DS-rich**
> **Go = explicit, memory-aware, iteration-first**

---

## Module 9: Practical Go Helper Library

Perfect! Let’s create a **practical Go backend helper library** that mimics Java’s **Collections + Streams** utilities for **slices, maps, sets, strings**, etc. It will be **ready-to-use in real projects**.

---

# Go Backend Helper Library — `goutil`

```go
package goutil

import (
	"sort"
	"strings"
	"unicode/utf8"
)

// ---------------------------
// Slices (List) Utilities
// ---------------------------

// MapInt applies a function to each element of an int slice
func MapInt(slice []int, fn func(int) int) []int {
	res := make([]int, len(slice))
	for i, v := range slice {
		res[i] = fn(v)
	}
	return res
}

// FilterInt filters an int slice based on a predicate
func FilterInt(slice []int, fn func(int) bool) []int {
	res := make([]int, 0)
	for _, v := range slice {
		if fn(v) {
			res = append(res, v)
		}
	}
	return res
}

// ReduceInt reduces a slice to a single value
func ReduceInt(slice []int, fn func(int, int) int, init int) int {
	acc := init
	for _, v := range slice {
		acc = fn(acc, v)
	}
	return acc
}

// SumInt returns the sum of an int slice
func SumInt(slice []int) int {
	sum := 0
	for _, v := range slice {
		sum += v
	}
	return sum
}

// MaxInt returns the maximum value in a slice
func MaxInt(slice []int) int {
	if len(slice) == 0 {
		panic("slice is empty")
	}
	max := slice[0]
	for _, v := range slice[1:] {
		if v > max {
			max = v
		}
	}
	return max
}

// MinInt returns the minimum value in a slice
func MinInt(slice []int) int {
	if len(slice) == 0 {
		panic("slice is empty")
	}
	min := slice[0]
	for _, v := range slice[1:] {
		if v < min {
			min = v
		}
	}
	return min
}

// ReverseInt reverses an int slice in place
func ReverseInt(slice []int) {
	for i, j := 0, len(slice)-1; i < j; i, j = i+1, j-1 {
		slice[i], slice[j] = slice[j], slice[i]
	}
}

// ---------------------------
// String Utilities
// ---------------------------

// Contains checks if string s contains substr
func Contains(s, substr string) bool {
	return strings.Contains(s, substr)
}

// StartsWith checks prefix
func StartsWith(s, prefix string) bool {
	return strings.HasPrefix(s, prefix)
}

// EndsWith checks suffix
func EndsWith(s, suffix string) bool {
	return strings.HasSuffix(s, suffix)
}

// Split splits string by sep
func Split(s, sep string) []string {
	return strings.Split(s, sep)
}

// Join joins a slice of strings with sep
func Join(slice []string, sep string) string {
	return strings.Join(slice, sep)
}

// ToUpper converts string to uppercase
func ToUpper(s string) string {
	return strings.ToUpper(s)
}

// ToLower converts string to lowercase
func ToLower(s string) string {
	return strings.ToLower(s)
}

// Trim trims spaces
func Trim(s string) string {
	return strings.TrimSpace(s)
}

// RuneCount returns number of characters (not bytes)
func RuneCount(s string) int {
	return utf8.RuneCountInString(s)
}

// ---------------------------
// Set Utilities
// ---------------------------

// NewSet creates a set from a slice
func NewSet(slice []string) map[string]struct{} {
	set := make(map[string]struct{})
	for _, s := range slice {
		set[s] = struct{}{}
	}
	return set
}

// SetContains checks if element exists in set
func SetContains(set map[string]struct{}, key string) bool {
	_, ok := set[key]
	return ok
}

// AddToSet adds element to set
func AddToSet(set map[string]struct{}, key string) {
	set[key] = struct{}{}
}

// RemoveFromSet removes element from set
func RemoveFromSet(set map[string]struct{}, key string) {
	delete(set, key)
}

// ---------------------------
// Map Utilities
// ---------------------------

// Keys returns keys of a map as slice
func Keys[K comparable, V any](m map[K]V) []K {
	res := make([]K, 0, len(m))
	for k := range m {
		res = append(res, k)
	}
	return res
}

// Values returns values of a map as slice
func Values[K comparable, V any](m map[K]V) []V {
	res := make([]V, 0, len(m))
	for _, v := range m {
		res = append(res, v)
	}
	return res
}

// MergeMaps merges multiple maps into one
func MergeMaps[K comparable, V any](maps ...map[K]V) map[K]V {
	res := make(map[K]V)
	for _, m := range maps {
		for k, v := range m {
			res[k] = v
		}
	}
	return res
}

// ---------------------------
// Sorting Utilities
// ---------------------------

// SortIntAsc sorts int slice ascending
func SortIntAsc(slice []int) {
	sort.Ints(slice)
}

// SortIntDesc sorts int slice descending
func SortIntDesc(slice []int) {
	sort.Sort(sort.Reverse(sort.IntSlice(slice)))
}
```

---

# ✅ Usage Example

```go
package main

import (
	"fmt"
	"goutil"
)

func main() {
	arr := []int{3,1,4,1,5,9}

	fmt.Println("Sum:", goutil.SumInt(arr))
	fmt.Println("Max:", goutil.MaxInt(arr))
	fmt.Println("Even numbers:", goutil.FilterInt(arr, func(x int) bool { return x%2==0 }))
	fmt.Println("Doubled:", goutil.MapInt(arr, func(x int) int { return x*2 }))
	goutil.SortIntAsc(arr)
	fmt.Println("Sorted:", arr)

	str := " Hello Go World "
	fmt.Println("Trimmed:", goutil.Trim(str))
	fmt.Println("Upper:", goutil.ToUpper(str))

	set := goutil.NewSet([]string{"a","b"})
	fmt.Println("Contains 'a'?", goutil.SetContains(set,"a"))
	goutil.AddToSet(set,"c")
	fmt.Println("Set keys:", goutil.Keys(set))
}
```

---

# ✅ Features of This Library

- **Slice utilities**: map, filter, reduce, sum, min, max, reverse
- **String utilities**: contains, startsWith, endsWith, split, join, trim, upper/lower
- **Set utilities**: create, contains, add, remove
- **Map utilities**: keys, values, merge
- **Sort utilities**: ascending / descending

---
