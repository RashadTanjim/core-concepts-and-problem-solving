# CS Go (Golang) Core Concepts and Best Practices

This is a structured list of Go core concepts in a Java-style Q&A format, with practical backend-focused examples.

### 🔸 **What is Go?**

Go (Golang) is a compiled, statically typed language designed by Google for simplicity, fast builds, and efficient concurrency.
It is widely used for backend services, cloud tools, networking systems, and CLI applications.

---

### 🔸 **What are the key differences between `go run`, `go build`, `go install`, and `go test`?**

- `go run`: compile + run quickly (mainly for local development).
- `go build`: compile packages/binaries.
- `go install`: build and install binary to `$GOBIN`.
- `go test`: run tests (and benchmarks with flags).

```bash
go run ./cmd/api
go build ./...
go install ./cmd/mytool
go test ./...
```

---

### 🔸 **What are `go.mod` and `go.sum`?**

- `go.mod`: module name + dependency requirements.
- `go.sum`: checksums used to verify dependency integrity.

```bash
go mod init example.com/my-service
go mod tidy
```

---

### 🔸 **What is `go.work` and when should I use workspaces?**

`go.work` lets you work on multiple local modules together without publishing interim versions.
Use it when a service and its local libraries are developed side-by-side.

```bash
go work init ./service ./shared-lib
go work use ./another-lib
```

---

### 🔸 **How does module versioning work for v2+ modules?**

Go modules use semantic import versioning. For major version 2 or higher, the import path must include `/vN`.

```go
import "example.com/acme/sdk/v2/client"
```

Without `/v2` in the import path, dependency resolution will fail for v2+ modules.

---

### 🔸 **What is a package in Go?**

A package is a directory of Go files compiled together. It is the basic unit of reuse and namespace control.

```go
package user

func Create() {}
```

---

### 🔸 **What does exported vs unexported mean in Go?**

- Names starting with uppercase are exported (public to other packages).
- Lowercase names are package-private.

```go
type User struct { // exported
    Name string // exported
}

type userRepo struct { // unexported
    source string
}
```

---

### 🔸 **What is the role of `init()` in Go?**

`init()` runs automatically after package-level variable initialization and before `main()`.
Use it sparingly for lightweight setup.

```go
func init() {
    // package initialization
}
```

---

### 🔸 **How do variables and constants work in Go?**

- Variables can be declared with `var` or `:=`.
- Constants use `const`.
- `iota` is commonly used for enum-like constants.

```go
var a int = 10
name := "Rashad"

const AppName = "core-service"

type Status int
const (
    Pending Status = iota
    Running
    Done
)
```

---

### 🔸 **`new` vs `make` in Go, what is the difference?**

- `new(T)` allocates zeroed `T` and returns `*T`.
- `make` initializes slices, maps, channels and returns a value.

```go
p := new(int)       // *int
s := make([]int, 0) // []int
m := make(map[string]int)
ch := make(chan int, 1)
```

---

### 🔸 **Values vs pointers, when should I use which?**

- Prefer values for small, immutable data.
- Use pointers when mutation or shared reference is required.

```go
type User struct {
    ID   int
    Name string
}

func Rename(u *User, name string) {
    u.Name = name
}
```

---

### 🔸 **Arrays vs slices, what is the difference?**

- Arrays: fixed length (`[N]T`).
- Slices: dynamic view over an array (`[]T`), used most of the time.

```go
arr := [3]int{1, 2, 3}
sl := []int{1, 2, 3}
sl = append(sl, 4)
```

---

### 🔸 **Nil slice vs empty slice?**

- `var s []int` -> nil slice (`s == nil` true).
- `s := []int{}` -> empty but non-nil slice.

```go
var a []int
b := []int{}
_ = (a == nil) // true
_ = (b == nil) // false
```

---

### 🔸 **How does slice capacity and reallocation work?**

`append` may allocate a new backing array when capacity is exceeded.

```go
s := make([]int, 0, 2)
s = append(s, 1, 2)
s = append(s, 3) // may reallocate
```

---

### 🔸 **How do maps work in Go?**

- Reading a missing key returns zero value.
- Use `value, ok := m[key]` to check presence.
- Map iteration order is intentionally random.

```go
m := map[string]int{"a": 1}
v, ok := m["b"] // v=0, ok=false
_ = v
_ = ok
```

---

### 🔸 **Are maps safe for concurrent use?**

No, concurrent writes to a regular map are unsafe. Use synchronization.

```go
var mu sync.Mutex
m := map[string]int{}

mu.Lock()
m["k"] = 1
mu.Unlock()
```

---

### 🔸 **When should I use `sync.Map` instead of `map + mutex`?**

Use `map + mutex` by default. Consider `sync.Map` for specialized cases with many goroutines and read-heavy or disjoint-key workloads.

```go
var sm sync.Map
sm.Store("k", 1)
v, ok := sm.Load("k")
_ = v
_ = ok
```

---

### 🔸 **What are structs and embedding in Go?**

Go uses structs instead of classes. Embedding is used for composition.

```go
type Logger struct{}
func (Logger) Info(msg string) {}

type Service struct {
    Logger
}
```

---

### 🔸 **Method receiver: value or pointer?**

- Value receiver for read-only/small structs.
- Pointer receiver for mutation or large structs.

```go
type Counter struct{ N int }

func (c Counter) Value() int { return c.N }
func (c *Counter) Inc()      { c.N++ }
```

---

### 🔸 **How do interfaces work in Go?**

Interfaces are implemented implicitly. Keep them small and focused.

```go
type Reader interface {
    Read(p []byte) (int, error)
}

type FileStore struct{}
func (FileStore) Read(p []byte) (int, error) { return 0, nil }
```

---

### 🔸 **`any` vs `interface{}` in Go?**

They are equivalent (`any` is an alias), introduced for readability in generics-era Go.

```go
func Print(v any) {}
```

---

### 🔸 **What is the typed-nil interface pitfall?**

An interface can hold a typed nil value and still be non-nil as an interface value.

```go
var r io.Reader = (*bytes.Reader)(nil)
if r == nil {
    // false: interface contains (type, nil)
}
```

---

### 🔸 **What is `defer` used for?**

`defer` schedules cleanup to run when the function returns (LIFO order).

```go
f, err := os.Open("x.txt")
if err != nil {
    return err
}
defer f.Close()
```

---

### 🔸 **How does error handling work in Go?**

Errors are explicit return values, not exceptions.

```go
if err := doWork(); err != nil {
    return fmt.Errorf("doWork failed: %w", err)
}
```

Use `errors.Is` and `errors.As` for checks and unwrapping.

```go
if errors.Is(err, os.ErrNotExist) {
    // handle missing file
}
```

---

### 🔸 **When should I use `panic` and `recover`?**

- `panic`: programmer errors or unrecoverable state.
- `recover`: only at boundaries (middleware, worker wrapper), not normal flow.

```go
func safe(fn func()) (err error) {
    defer func() {
        if r := recover(); r != nil {
            err = fmt.Errorf("panic: %v", r)
        }
    }()
    fn()
    return nil
}
```

---

### 🔸 **How do goroutines work?**

Goroutines are lightweight concurrent tasks scheduled by the Go runtime.

```go
go func() {
    // async work
}()
```

---

### 🔸 **Buffered vs unbuffered channels?**

- Unbuffered channels synchronize sender and receiver.
- Buffered channels allow limited queued sends.

```go
unbuf := make(chan int)
buf := make(chan int, 2)
```

---

### 🔸 **How do I use `select` for timeouts/cancellation?**

```go
select {
case msg := <-ch:
    _ = msg
case <-time.After(2 * time.Second):
    return errors.New("timeout")
case <-ctx.Done():
    return ctx.Err()
}
```

---

### 🔸 **What is `context.Context` best practice in Go?**

- Pass `context.Context` as first parameter.
- Do not store it long-term in structs.
- Always cancel derived contexts.

```go
func Fetch(ctx context.Context, url string) error {
    req, _ := http.NewRequestWithContext(ctx, http.MethodGet, url, nil)
    _, err := http.DefaultClient.Do(req)
    return err
}
```

---

### 🔸 **What is `context.WithCancelCause` and why is it useful?**

`context.WithCancelCause` lets you cancel a context with a specific error cause, making debugging and error propagation clearer.

```go
ctx, cancel := context.WithCancelCause(context.Background())
cancel(errors.New("upstream timeout"))
err := context.Cause(ctx) // returns "upstream timeout"
_ = err
```

---

### 🔸 **What synchronization tools does Go provide?**

- `sync.WaitGroup`
- `sync.Mutex`, `sync.RWMutex`
- `sync.Once`
- `sync/atomic`
- `sync.Pool` (use only after measurement)

```go
var wg sync.WaitGroup
wg.Add(1)
go func() {
    defer wg.Done()
}()
wg.Wait()
```

---

### 🔸 **Go memory model basics, what should I know?**

Shared memory writes must be synchronized (mutex/channel/atomic). Otherwise behavior is undefined due to data races.

Run race checks regularly:

```bash
go test -race ./...
```

---

### 🔸 **How are strings handled in Go?**

Strings are immutable byte sequences.

- `byte` is `uint8`.
- `rune` is `int32` (Unicode code point).

```go
s := "Go"
_ = len(s) // bytes
for _, r := range s {
    _ = r // rune
}
```

---

### 🔸 **How to do JSON marshal/unmarshal in Go?**

Use `encoding/json` with struct tags.

```go
type User struct {
    Name string  `json:"name"`
    Age  int     `json:"age"`
    Note *string `json:"note,omitempty"`
}

b, _ := json.Marshal(User{Name: "Rashad", Age: 30})
var u User
_ = json.Unmarshal(b, &u)
```

---

### 🔸 **HTTP client and server best practices in Go?**

- Reuse `http.Client` with timeouts.
- Always close response bodies.
- Keep handlers thin; move business logic to services.

```go
client := &http.Client{Timeout: 5 * time.Second}
resp, err := client.Get("https://example.com")
if err != nil {
    return err
}
defer resp.Body.Close()
```

---

### 🔸 **How should logging be done in modern Go services?**

Use structured logging (for example, `log/slog`) in services so logs are machine-parseable and easier to query.

```go
logger := slog.New(slog.NewJSONHandler(os.Stdout, nil))
logger.Info("request completed", "path", "/users", "status", 200)
```

Prefer logging at boundaries (HTTP handlers, jobs, CLI commands) and return errors from library code.

---

### 🔸 **How should Go project layout look for backend services?**

A practical layout:

- `cmd/` entrypoints
- `internal/` private app packages
- `pkg/` reusable public packages (optional)
- `api/` OpenAPI/proto specs (optional)

Keep `main` thin and place logic in `internal` packages.

---

### 🔸 **What are `//go:build` constraints used for?**

Build constraints include/exclude files by OS, architecture, or custom tags.

```go
//go:build linux

package platform
```

Use this for platform-specific implementations without runtime branching.

---

### 🔸 **How does testing work in Go?**

Use table-driven tests, subtests, benchmarks, and fuzz tests where relevant.

```go
func TestAdd(t *testing.T) {
    tests := []struct {
        name string
        a, b int
        want int
    }{
        {"small", 1, 2, 3},
        {"zero", 0, 0, 0},
    }

    for _, tt := range tests {
        t.Run(tt.name, func(t *testing.T) {
            if got := Add(tt.a, tt.b); got != tt.want {
                t.Fatalf("got %d, want %d", got, tt.want)
            }
        })
    }
}
```

Benchmark example:

```go
func BenchmarkAdd(b *testing.B) {
    for i := 0; i < b.N; i++ {
        _ = Add(1, 2)
    }
}
```

---

### 🔸 **How does fuzz testing work in Go?**

Fuzz tests generate random inputs to discover edge cases and crashes in parsers/decoders/protocol handlers.

```go
func FuzzParseInt(f *testing.F) {
    f.Add("123")
    f.Fuzz(func(t *testing.T, s string) {
        _, _ = strconv.Atoi(s)
    })
}
```

Run with:

```bash
go test -fuzz=Fuzz -run=^$
```

---

### 🔸 **How do profiling and performance tuning work in Go?**

Use benchmarks first, then profile with `pprof`.

```bash
go test -bench . -benchmem
```

Common quick wins:

- Preallocate slices/maps when possible.
- Use `strings.Builder` or `bytes.Buffer` for repeated concatenation.
- Avoid unnecessary conversions/allocations.

---

### 🔸 **What is `GOMAXPROCS` and when should I care?**

`GOMAXPROCS` controls the number of OS threads that can execute Go code simultaneously.
By default, it is set to available CPU count; tune only when you have measured evidence.

```go
prev := runtime.GOMAXPROCS(0) // read current value
_ = prev
```

---

### 🔸 **What are generics in Go and when to use them?**

Use generics to remove simple type repetition in utilities and containers.

```go
func Map[T any, R any](in []T, fn func(T) R) []R {
    out := make([]R, len(in))
    for i, v := range in {
        out[i] = fn(v)
    }
    return out
}
```

---

### 🔸 **What is the `comparable` constraint in Go generics?**

`comparable` is used when a type must support `==` and `!=`, commonly for generic map keys or set helpers.

```go
func ContainsKey[K comparable, V any](m map[K]V, k K) bool {
    _, ok := m[k]
    return ok
}
```

---

### 🔸 **How do SOLID principles map to Go?**

Go applies SOLID through composition and small interfaces.

- SRP: separate responsibilities.
- OCP: extend through interfaces.
- ISP: prefer small interfaces.
- DIP: depend on abstractions via constructor injection.

See: [`solid.md`](./solid.md)

---

### 🔸 **How do design patterns apply in Go?**

Go favors simple, explicit patterns:

- Functional options (Builder alternative)
- Adapter/Decorator via interfaces
- Worker pool / pipeline for concurrency

See: [`design-patterns.md`](./design-patterns.md)

---

### 🔸 **Most common Go pitfalls to avoid**

- Loop variable capture in goroutines.
- Concurrent map writes without synchronization.
- Nil interface vs typed nil confusion.
- Ignoring `context` cancellation causing goroutine leaks.
- Forgetting to close `resp.Body`.
- Using `time.After` repeatedly in tight loops.

```go
for _, v := range items {
    v := v // capture safely
    go func() {
        _ = v
    }()
}
```

---

### 🔸 **Tooling checklist for production Go code**

- `gofmt`
- `go vet`
- `go test ./...`
- `go test -race ./...`
- `go test -bench .`
- `go mod tidy`

---

### 🔸 **Related notes**

- [`solid.md`](./solid.md)
- [`design-patterns.md`](./design-patterns.md)
- [`libraries-and-use-cases.md`](./libraries-and-use-cases.md)
