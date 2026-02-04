## Go Design Patterns and Idioms

Go favors simple composition and small interfaces. The patterns below are common in idiomatic Go.

### 1) Singleton (with sync.Once)
Use sparingly; prefer explicit dependencies.

```go
var (
    instance *Config
    once     sync.Once
)

type Config struct {
    Env string
}

func GetConfig() *Config {
    once.Do(func() {
        instance = &Config{Env: "prod"}
    })
    return instance
}
```

### 2) Factory
Hide construction details behind a function.

```go
type Storage interface {
    Save(key string, data []byte) error
}

type MemoryStore struct{}
func (MemoryStore) Save(key string, data []byte) error { return nil }

func NewStorage(kind string) Storage {
    switch kind {
    case "memory":
        return MemoryStore{}
    default:
        return MemoryStore{}
    }
}
```

### 3) Builder (functional options)
A Go-idiomatic replacement for complex constructors.

```go
type Client struct {
    timeout time.Duration
    retries int
}

type Option func(*Client)

func WithTimeout(d time.Duration) Option {
    return func(c *Client) { c.timeout = d }
}

func WithRetries(n int) Option {
    return func(c *Client) { c.retries = n }
}

func NewClient(opts ...Option) *Client {
    c := &Client{timeout: 5 * time.Second}
    for _, opt := range opts {
        opt(c)
    }
    return c
}
```

### 4) Strategy
Swap behavior via interfaces or function types.

```go
type SortFunc func([]int)

func SortInts(data []int, fn SortFunc) {
    fn(data)
}
```

### 5) Adapter
Wrap a type to satisfy another interface.

```go
type Logger interface {
    Info(msg string)
}

type StdLogger struct{}
func (StdLogger) Println(msg string) {}

type LoggerAdapter struct{ l StdLogger }
func (a LoggerAdapter) Info(msg string) { a.l.Println(msg) }
```

### 6) Decorator
Wrap an interface to add behavior.

```go
type Handler interface {
    Handle(ctx context.Context) error
}

type HandlerFunc func(ctx context.Context) error
func (f HandlerFunc) Handle(ctx context.Context) error { return f(ctx) }

func WithLogging(next Handler) Handler {
    return HandlerFunc(func(ctx context.Context) error {
        // log before
        err := next.Handle(ctx)
        // log after
        return err
    })
}
```

### 7) Observer (via channels)
Use channels to notify listeners.

```go
type Event struct{ Name string }

type Bus struct {
    subs []chan Event
}

func (b *Bus) Subscribe() <-chan Event {
    ch := make(chan Event, 1)
    b.subs = append(b.subs, ch)
    return ch
}

func (b *Bus) Publish(e Event) {
    for _, ch := range b.subs {
        ch <- e
    }
}
```

### 8) Command
Model commands as functions.

```go
type Command func() error

func Run(cmds ...Command) error {
    for _, cmd := range cmds {
        if err := cmd(); err != nil {
            return err
        }
    }
    return nil
}
```

### 9) Pipeline / Worker Pool
A common Go concurrency pattern.

```go
func worker(in <-chan int, out chan<- int) {
    for v := range in {
        out <- v * 2
    }
}

func runPipeline() {
    in := make(chan int)
    out := make(chan int)

    var wg sync.WaitGroup
    wg.Add(1)
    go func() {
        defer wg.Done()
        worker(in, out)
    }()

    go func() {
        for i := 0; i < 5; i++ {
            in <- i
        }
        close(in)
    }()

    go func() {
        wg.Wait()
        close(out)
    }()

    for v := range out {
        _ = v
    }
}
```
