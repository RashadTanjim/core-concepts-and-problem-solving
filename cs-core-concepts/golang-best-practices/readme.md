# Go (Golang) Best Practices and Core Concepts

This guide summarizes idiomatic Go and practical best practices for writing clean, reliable, and maintainable Go code.

## Language fundamentals

### What is Go?
Go is a compiled, statically typed language designed for simplicity, fast builds, and strong support for concurrency.

### Zero values
Every Go type has a zero value (e.g., 0, "", false, nil). Prefer zero values over explicit initialization when
possible.

```go
var count int      // 0
var name string    // ""
var ready bool     // false
var data []byte    // nil
```

### Values vs pointers
- Use values for small, immutable data.
- Use pointers for large structs, mutation, or when you need a nil value.

```go
type User struct {
    ID   int
    Name string
}

func Rename(u *User, name string) {
    u.Name = name
}
```

### Arrays vs slices
- Arrays have fixed length and are rarely used directly.
- Slices are dynamic and are the standard for collections.

```go
numbers := []int{1, 2, 3}
numbers = append(numbers, 4)
```

### Maps
Maps are not safe for concurrent writes. Use a mutex or sync.Map for shared access.

```go
m := map[string]int{"a": 1}
if v, ok := m["a"]; ok {
    _ = v
}
```

### Struct embedding (composition)
Go favors composition over inheritance via struct embedding.

```go
type Logger struct{}
func (Logger) Info(msg string) {}

type Service struct {
    Logger
}
```

### Interfaces
Keep interfaces small. Accept interfaces and return concrete types.

```go
type Reader interface {
    Read(p []byte) (int, error)
}

type FileStore struct{}
func (FileStore) Read(p []byte) (int, error) { return 0, nil }
```

## Tooling and modules

- Use modules (`go.mod`, `go.sum`) for dependency management.
- Run `gofmt` on all code (most editors do this automatically).
- Use `go vet` and static analysis to catch common bugs.
- Prefer `go test ./...` and the race detector (`go test -race`).

## Project layout

A common layout:
- `cmd/` - application entry points
- `internal/` - private packages (not importable outside the module)
- `pkg/` - public packages (if you want to export them)
- `api/` - API definitions (OpenAPI, protobuf, etc.)

Keep `main` packages thin. Put real logic in packages under `internal/`.

## Error handling

Errors are values. Return them and handle at the call site.

```go
if err := doWork(); err != nil {
    return fmt.Errorf("doWork failed: %w", err)
}
```

Use `errors.Is` and `errors.As` for matching and unwrapping.

```go
if errors.Is(err, os.ErrNotExist) {
    // handle missing file
}
```

Avoid `panic` in libraries. Use `panic` only for programmer errors.

## Testing

Use table-driven tests and subtests for clarity.

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

Use benchmarks for performance work:

```go
func BenchmarkAdd(b *testing.B) {
    for i := 0; i < b.N; i++ {
        _ = Add(1, 2)
    }
}
```

## Concurrency

Goroutines are lightweight threads. Use channels or synchronization primitives to coordinate.

```go
var wg sync.WaitGroup
wg.Add(1)

go func() {
    defer wg.Done()
    // work
}()

wg.Wait()
```

Prefer context for cancellation and timeouts, and avoid goroutine leaks by ensuring all goroutines can exit.

## Context usage

- Pass `context.Context` as the first parameter.
- Do not store context in structs for long-term use.
- Use timeouts for I/O calls.

```go
func Fetch(ctx context.Context, url string) error {
    req, _ := http.NewRequestWithContext(ctx, http.MethodGet, url, nil)
    _, err := http.DefaultClient.Do(req)
    return err
}
```

## HTTP and I/O

- Reuse `http.Client` and set timeouts.
- Always close response bodies.
- Use `io.Reader`/`io.Writer` interfaces to keep code flexible.

```go
client := &http.Client{Timeout: 5 * time.Second}
resp, err := client.Get("https://example.com")
if err != nil {
    return err
}
defer resp.Body.Close()
```

## Performance guidelines

- Preallocate slices when size is known.
- Use `strings.Builder` for repeated string concatenation.
- Avoid unnecessary allocations and conversions.

```go
items := make([]int, 0, 100)
for i := 0; i < 100; i++ {
    items = append(items, i)
}
```

## Style and naming

- Keep names short and clear (`id`, `ctx`, `cfg`).
- Use common initialisms: `ID`, `URL`, `HTTP`.
- Comment exported identifiers and packages.
- Avoid stutter in names (`user.User` -> `user.Profile`).

## Common pitfalls

- `nil` interface vs typed nil.
- Loop variable capture in goroutines.
- Map iteration order is random.
- `time.Tick` can leak; prefer `time.NewTicker` and `Stop()`.

```go
for _, v := range items {
    v := v
    go func() {
        _ = v
    }()
}
```

## Minimal service pattern

```go
type Service struct {
    store Store
    log   *log.Logger
}

func NewService(store Store, log *log.Logger) *Service {
    return &Service{store: store, log: log}
}

func (s *Service) Handle(ctx context.Context, id string) error {
    if id == "" {
        return errors.New("id is required")
    }
    return s.store.Save(ctx, id)
}
```

## More core concepts and tips

### Go memory model basics
- Reads and writes to shared variables must be synchronized (mutexes, channels, atomics).
- Use `go test -race` to detect data races.
- Prefer passing immutable data to goroutines or copying before sharing.

### Interfaces and design
- Accept interfaces in constructors and function params.
- Return concrete types; it keeps APIs flexible for callers.
- Small interfaces compose better (`io.Reader`, `io.Writer`).

```go
type Clock interface {
    Now() time.Time
}

type RealClock struct{}
func (RealClock) Now() time.Time { return time.Now() }
```

### Generics (type parameters)
Use generics to reduce repetition for simple container or utility code.

```go
func Map[T any, R any](in []T, fn func(T) R) []R {
    out := make([]R, len(in))
    for i, v := range in {
        out[i] = fn(v)
    }
    return out
}
```

### Error handling patterns
- Wrap errors with context using `%w` for unwrapping.
- Sentinel errors for stable checks, custom types for richer info.
- Prefer returning errors, not logging inside libraries.

```go
var ErrNotFound = errors.New("not found")

type ParseError struct{ Line int }
func (e ParseError) Error() string { return fmt.Sprintf("bad input at line %d", e.Line) }
```

### Panic and recover
Use `panic` only for programmer errors. Recover only at boundaries (e.g., servers).

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

### Channels and select
Use `select` for timeouts and cancellation.

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

### Synchronization tools
- `sync.Mutex` for shared state.
- `sync.RWMutex` for many readers, few writers.
- `sync.Once` for one-time init.
- `sync.Pool` for temporary allocations (measure first).

### Context best practices
- Pass context explicitly and first in signature.
- Do not store context in structs long-term.
- Always cancel contexts you create with `WithCancel`/`WithTimeout`.

### Time and timers
Prefer `time.NewTicker` and `Stop()` to avoid leaks.

```go
t := time.NewTicker(500 * time.Millisecond)
defer t.Stop()
```

### Modules and dependency hygiene
- Keep `go.mod` tidy with `go mod tidy`.
- Avoid `replace` in public modules unless required.
- Use `GOPRIVATE` for private dependencies.

### Tooling checklist
- `gofmt` for formatting.
- `go vet` for common issues.
- `go test ./...` for tests.
- `go test -race ./...` for data races.
- `go test -bench .` for benchmarks.

### Profiling and debugging
- Use `pprof` for CPU and memory profiling.
- `go tool pprof` for analysis.
- `runtime/pprof` for custom profiles in services.

### Logging tips
- Use the standard library `log` or a structured logger.
- Log at boundaries (handlers, CLI entrypoints), not deep in libraries.
- Include request IDs or correlation IDs in logs.

### Configuration and env
- Read config once at startup and validate.
- Prefer explicit types over stringly-typed config.
- Use `os.LookupEnv` to distinguish missing vs empty.

### Testing tips
- Table-driven tests and subtests.
- Use helpers with `t.Helper()`.
- Prefer deterministic tests (avoid sleeps).
- Use golden files for large outputs.
- Use fuzz tests for parsers and decoders.

```go
func TestParse(t *testing.T) {
    t.Helper()
}
```

### Build tags and embed
- Use build tags for OS-specific code.
- Use `embed` for static assets in small tools.

```go
//go:embed assets/*
var assets embed.FS
```

### Code generation
`go generate` helps keep generated code in sync.

```go
//go:generate stringer -type=Status
```

### Performance quick wins
- Avoid `fmt.Sprintf` in hot paths.
- Preallocate slices and maps.
- Favor `bytes.Buffer` or `strings.Builder`.
- Reduce allocations with `strconv` instead of `fmt`.

### API design tips
- Keep exported APIs small and stable.
- Provide sensible defaults.
- Use `context.Context` and explicit timeouts.
- Avoid global state in packages.

## Go core concepts Q and A

### What is a package in Go?
A package is a directory of Go files that compile into one unit. Packages define namespaces and are imported by path.

### What does exported mean?
Identifiers that start with an uppercase letter are exported (public) to other packages.

```go
type User struct { Name string } // exported
type user struct { name string } // unexported
```

### What is an init function?
`init` runs automatically after package-level variables are initialized. Use it sparingly for setup.

```go
func init() {
    // package initialization
}
```

### make vs new
- `new(T)` allocates zeroed `T` and returns `*T`.
- `make` initializes slices, maps, and channels and returns a value (not a pointer).

```go
p := new(int)       // *int
s := make([]int, 0) // []int
m := make(map[string]int)
```

### What is a nil slice vs empty slice?
- `nil` slice: `var s []int` with `len=0`, `cap=0`, `s == nil` is true.
- empty slice: `s := []int{}` with `len=0`, `cap=0`, `s == nil` is false.

### How does slice capacity work?
`append` grows a slice, potentially allocating a new backing array when capacity is exceeded.

```go
s := make([]int, 0, 2)
s = append(s, 1, 2)
s = append(s, 3) // triggers reallocation
```

### How do you copy a slice?
Use `copy(dst, src)` which returns the number of elements copied.

```go
dst := make([]int, len(src))
copy(dst, src)
```

### Map basics
- Reading a missing key returns the zero value.
- Use the comma-ok idiom to detect presence.

```go
v, ok := m["key"]
```

### Why is map iteration order random?
Go intentionally randomizes map iteration to prevent code depending on order.

### What is a struct tag?
Metadata on a struct field used by reflection (JSON, validation, etc.).

```go
type User struct {
    Name string `json:"name"`
}
```

### What is a method receiver?
Receivers bind methods to types. Use pointer receivers to mutate or avoid copying large structs.

```go
func (u *User) Rename(name string) { u.Name = name }
```

### How do interface values work?
An interface stores (type, value). A typed nil value inside an interface is not a nil interface.

```go
var r io.Reader = (*bytes.Reader)(nil)
if r == nil { /* false */ }
```

### Type assertion and type switch
Use assertions to get the concrete type, and switches to branch by type.

```go
if v, ok := x.(string); ok { _ = v }

switch v := x.(type) {
case string:
    _ = v
case int:
    _ = v
}
```

### any vs interface{}
`any` is an alias for `interface{}` since Go 1.18. Use `any` for readability.

### Defer evaluation order
Arguments to deferred calls are evaluated immediately. Deferred calls run in LIFO order.

```go
defer fmt.Println("last")
defer fmt.Println("first")
```

### Panic and recover usage
`panic` is for programmer errors. `recover` should be used at boundaries to prevent crashing.

### Goroutines
Goroutines are lightweight. They are multiplexed onto OS threads by the runtime.

### Buffered vs unbuffered channels
- Unbuffered: sender and receiver must rendezvous.
- Buffered: sends block only when the buffer is full.

### Closing channels
Close only from the sender side. Receivers use the comma-ok idiom to detect closure.

```go
v, ok := <-ch
```

### select and timeouts
Use `select` to multiplex channel operations with timeouts or cancellation.

### Context propagation
Pass context explicitly. Use `ctx.Done()` to exit goroutines early.

### WaitGroup usage
Always call `Add` before starting goroutines and `Done` exactly once per goroutine.

### Mutex vs RWMutex
Use `RWMutex` when reads are frequent and writes are rare. Prefer plain `Mutex` for simplicity.

### Atomic operations
Use `sync/atomic` for low-level counters and flags; prefer mutexes for complex state.

### Race detector
`go test -race` catches data races in tests and is critical for concurrent code.

### HTTP client best practices
Reuse `http.Client`, set timeouts, and always close response bodies.

### JSON encoding tips
Use struct tags, avoid omitting required fields, and use pointers for optional fields.

### Testing style
Prefer table-driven tests with subtests for clarity and coverage.

### Benchmarks
Use `go test -bench .` and avoid allocations inside the benchmark loop.

### Build tags
Use `//go:build` to separate OS-specific or optional code paths.

### Modules and go.sum
- `go.mod` declares module path and dependencies.
- `go.sum` stores checksums for module verification.

### Workspaces (go.work)
Use workspaces to develop multiple modules together locally.

### Embed
`embed` packages static files into the binary for small tools and CLIs.

### Garbage collector basics
Go uses a concurrent GC. `GOGC` controls heap growth targets.

### Escape analysis
The compiler decides whether values are allocated on the stack or heap. Avoid unnecessary heap allocations in hot paths.

### bytes vs rune
`byte` is an alias for `uint8`, `rune` is an alias for `int32`. Use `rune` for Unicode code points.

## Go tips and tricks

- Use the blank identifier `_` to ignore values intentionally.
- Avoid capturing loop variables in goroutines; copy them first.
- Use `strings.Builder` for repeated string concatenation.
- Prefer `io.Copy` for streaming data between readers and writers.
- Avoid `time.After` in tight loops; reuse a ticker instead.
- Do not use pointers to interfaces; interfaces already hold pointers.
- Keep errors close to their source and wrap with context.
- Keep package APIs small and rely on interfaces for decoupling.

## Related notes

- `solid.md`
- `design-patterns.md`
- `libraries-and-use-cases.md`
