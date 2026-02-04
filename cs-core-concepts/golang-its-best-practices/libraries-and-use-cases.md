# Go Libraries and Use Cases (Standard Library)

This file summarizes core Go standard library packages and when to use them. These packages ship with Go and require no
external dependencies.

## Basics

- `fmt`: formatted I/O (printing and scanning). Use for logs or CLI output.
- `errors`: create and wrap errors (`errors.New`, `errors.Is`, `errors.As`).
- `reflect`: runtime reflection (advanced; avoid when possible).
- `runtime`: low-level runtime info, GC, stack, and goroutine details.

## Strings and bytes

- `strings`: string manipulation (split, trim, join, replace).
- `bytes`: byte slice utilities; use `bytes.Buffer` for efficient writes.
- `strconv`: convert strings to numbers and vice versa.
- `unicode`, `unicode/utf8`: rune-level work and UTF-8 validation.
- `regexp`: regex matching and extraction.

## Collections and sorting

- `sort`: sorting slices and custom collections.
- `container/heap`, `container/list`, `container/ring`: specialized containers.

## Time and scheduling

- `time`: timestamps, durations, timers, tickers.

## Concurrency and synchronization

- `sync`: mutexes, wait groups, once, pools.
- `sync/atomic`: atomic operations for shared counters and flags.
- `context`: cancellation, deadlines, and request-scoped values.

## File system and OS

- `os`: files, environment, args, process control.
- `io`: reader/writer interfaces, streaming utilities.
- `bufio`: buffered I/O for scanners and writers.
- `path/filepath`: OS-agnostic path handling.
- `io/fs`: filesystem interfaces and helpers (including `fs.FS`).
- `embed`: compile static files into binaries.
- `os/exec`: run external commands (use carefully).
- `os/signal`: handle OS signals for graceful shutdown.

## Networking and HTTP

- `net`: TCP/UDP, IP, and low-level networking.
- `net/http`: HTTP clients and servers.
- `net/url`: URL parsing and building.

## Encoding and data formats

- `encoding/json`: JSON encode/decode.
- `encoding/xml`: XML encode/decode.
- `encoding/csv`: CSV reading and writing.
- `encoding/gob`: binary encoding for Go types.
- `encoding/base64`: base64 encoding/decoding.

## Cryptography and security

- `crypto`: high-level cryptographic primitives.
- `crypto/rand`: secure random bytes (use instead of `math/rand` for security).
- `crypto/sha256`, `crypto/hmac`, `crypto/tls`: hashing, MACs, TLS support.
- `hash`: hash interfaces, checksums.

## Databases and storage

- `database/sql`: database access with drivers (Postgres, MySQL, SQLite, etc.).
- `database/sql/driver`: driver interfaces for custom drivers.

## Logging and metrics

- `log`: standard logger.
- `log/slog`: structured logging (Go 1.21+).
- `expvar`: publish metrics as JSON for monitoring.

## Templates and formatting

- `text/template`: data-driven text templates.
- `html/template`: HTML templates with auto-escaping.

## CLI and config

- `flag`: command-line parsing.

## Testing and profiling

- `testing`: unit tests and benchmarks.
- `testing/fstest`: testing filesystem implementations.
- `runtime/pprof`: CPU and memory profiling.
- `net/http/pprof`: pprof endpoints for servers.

## Common use cases by area

- Web services: `net/http`, `context`, `encoding/json`, `log/slog`.
- CLI tools: `flag`, `os`, `io`, `bufio`, `strings`.
- File processing: `os`, `io`, `bufio`, `path/filepath`, `encoding/csv`.
- Concurrency: `sync`, `context`, `time`.
- Security: `crypto/*`, `crypto/rand`, `crypto/tls`.
- Observability: `log/slog`, `expvar`, `net/http/pprof`.

## Tips

- Prefer `io.Reader`/`io.Writer` for composable I/O.
- Use `context` for cancellation and timeouts in I/O-heavy code.
- Avoid global state; pass dependencies explicitly.
- Keep interfaces small and focused.
