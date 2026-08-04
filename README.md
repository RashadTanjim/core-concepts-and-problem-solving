# Core Concepts and Problem Solving

A practical study repository for data structures and algorithms, coding interviews, language fundamentals, software quality, system design, and cloud engineering. The main interview-preparation track contains complete Go and Java solutions for the shared [LeetCode Top Practice Problems list](https://leetcode.com/problem-list/24s7vlue/).

## LeetCode Top Practice Problems

The [Go and Java problem collection](./leetcode-top-practice-problems/) contains **333 problems**, organized as one independently compilable directory per problem.

| Difficulty | Problems |
|---|---:|
| Easy | 85 |
| Medium | 204 |
| Hard | 44 |
| **Total** | **333** |

Each problem directory follows the same interview-focused structure:

```text
0001-two-sum/
|-- README.md     # Problem statement, examples, and constraints
|-- solution.md   # Brute force through optimized interview approach
|-- solution.go   # Go implementation
|-- Solution.java # Java implementation
|-- types.go      # Local Go judge types or callbacks when required
`-- Types.java    # Local Java judge types or callbacks when required
```

Use the [complete problem index](./leetcode-top-practice-problems/README.md) to browse by list order, difficulty, or algorithmic approach.

## Interview Study Workflow

1. Read the problem statement and clarify inputs, outputs, constraints, and edge cases.
2. Explain a direct or brute-force solution before optimizing it.
3. Identify the reusable pattern and state the invariant that makes the optimized approach correct.
4. Implement the solution in Go or Java without referring to the checked-in implementation.
5. Compare implementations, analyze time and space complexity, and test boundary cases aloud.

The solution guides are written for FAANG-style interview discussion: pattern recognition, baseline reasoning, optimization, correctness, complexity, edge cases, and language-specific implementation notes.

## Repository Map

| Path | Contents |
|---|---|
| [`leetcode-top-practice-problems/`](./leetcode-top-practice-problems/) | 333 documented LeetCode solutions in Go and Java |
| [`cs-core-concepts/java-and-oop/`](./cs-core-concepts/java-and-oop/) | Java, OOP, SOLID, and design-pattern notes |
| [`cs-core-concepts/golang-learning/`](./cs-core-concepts/golang-learning/) | Go fundamentals, libraries, SOLID, and design patterns |
| [`cs-core-concepts/java-vs-go-learning-path/`](./cs-core-concepts/java-vs-go-learning-path/) | Java-to-Go comparison and migration-focused learning path |
| [`cs-core-concepts/sqa/`](./cs-core-concepts/sqa/) | Software quality assurance and testing concepts |
| [`cs-core-concepts/github-best-practices/`](./cs-core-concepts/github-best-practices/) | GitHub workflows and collaboration practices |
| [`cs-core-concepts/project-managment-best-practices/`](./cs-core-concepts/project-managment-best-practices/) | Agile and project-management notes |
| [`cloud-and-devops/`](./cloud-and-devops/) | Cloud and DevOps concepts |
| [`system-design-concepts/`](./system-design-concepts/) | System-design notes, patterns, and white papers |
| [`src/leetcode/`](./src/leetcode/) | Earlier Java problem-solving implementations |
| [`src/others/`](./src/others/) | Additional exercises and experiments |

## Verify the Problem Collection

Go 1.22 or newer and JDK 17 or newer are required.

```bash
cd leetcode-top-practice-problems
go test ./...
go vet ./...
go run ./tools/verify-java
```

The repository test validates the problem manifest and required files. The Go command compiles every Go package, and the Java verifier compiles every Java solution in isolation with its local judge types.

## Documentation Tooling

Problem metadata and documentation indexes are maintained by [`tools/general-docs`](./leetcode-top-practice-problems/tools/general-docs/). Run the generator from the Go module directory:

```bash
cd leetcode-top-practice-problems
go run ./tools/general-docs
```

Some problem descriptions are derived from attributed third-party material. See the collection's [notice](./leetcode-top-practice-problems/NOTICE.md) and [third-party license](./leetcode-top-practice-problems/THIRD_PARTY_LICENSES/doocs-leetcode-CC-BY-SA-4.0.txt) for details.
