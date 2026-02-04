## SOLID Principles in Go

Go is not an object-oriented language in the classic sense, but SOLID ideas still apply. The examples below show how
these principles map to Go's composition and interfaces.

### 1) Single Responsibility Principle (SRP)
A type should have one reason to change.

```go
// Bad: mixing persistence and email concerns

type UserService struct{}

func (UserService) SaveUser(u User) error { return nil }
func (UserService) SendWelcomeEmail(u User) error { return nil }

// Good: split responsibilities

type UserStore interface {
    Save(u User) error
}

type Mailer interface {
    SendWelcome(u User) error
}

type UserService struct {
    store  UserStore
    mailer Mailer
}

func (s UserService) Register(u User) error {
    if err := s.store.Save(u); err != nil {
        return err
    }
    return s.mailer.SendWelcome(u)
}
```

### 2) Open/Closed Principle (OCP)
Make code open for extension by depending on interfaces.

```go
type Discount interface {
    Apply(total int) int
}

type Order struct{
    Total int
}

func (o Order) FinalTotal(d Discount) int {
    return d.Apply(o.Total)
}

// Add new discounts without changing Order

type FixedDiscount struct{ Amount int }
func (d FixedDiscount) Apply(total int) int { return total - d.Amount }
```

### 3) Liskov Substitution Principle (LSP)
Implementations should be substitutable for their interface.

```go
type Reader interface {
    Read(p []byte) (int, error)
}

// A reader that returns data and follows the contract

type FileReader struct{}
func (FileReader) Read(p []byte) (int, error) { return 0, io.EOF }
```

### 4) Interface Segregation Principle (ISP)
Prefer small, focused interfaces.

```go
// Bad: bloated interface

type Worker interface {
    Work()
    Eat()
}

// Good: split interfaces

type Workable interface { Work() }
type Eatable interface { Eat() }
```

### 5) Dependency Inversion Principle (DIP)
Depend on abstractions, not concrete types.

```go
type Store interface {
    Save(id string) error
}

type Service struct {
    store Store
}

func NewService(store Store) *Service {
    return &Service{store: store}
}
```

Summary:
- Use composition and small interfaces to keep code extensible.
- Inject dependencies via constructors.
- Keep responsibilities isolated and testable.
