## Context

This is a JavaFX desktop application built with Gradle, Flyway, and SQLite. The development workflow currently requires developers to use Gradle commands directly (`./gradlew run`, `./gradlew flywayMigrate`, etc.). The Makefile provides a conventional wrapper layer for common tasks.

**Current State:**
- Commands: `./gradlew run`, `./gradlew flywayMigrate`, `./gradlew clean build`, `./gradlew test`
- No standard stopping mechanism (JavaFX app exits on window close)
- No logging infrastructure (System.out only)
- Team workflow not standardized

**Constraints:**
- Desktop application (not server/daemon)
- WSL2/Linux environment (Make available)
- Minimal scope - wrapper only, no new Gradle tasks

## Goals / Non-Goals

**Goals:**
- Provide 7 standard commands: `start`, `stop`, `migrate`, `build`, `test`, `dev`, `help`
- Wrap existing Gradle tasks (no new tasks created)
- Update AGENTS.md to reference Makefile
- Keep Makefile minimal and readable

**Non-Goals:**
- No logging framework addition
- No new Gradle tasks
- No server-style lifecycle management
- No Windows batch file alternative (`.cmd`/`ps1`)

## Decisions

### 1. Command Set: Minimal (7 commands)

**Decision:** Include only essential commands
- `start`, `stop`, `migrate`, `build`, `test`, `dev`, `help`

**Alternatives Considered:**
- Comprehensive (15+ commands): Rejected - too much for convention setting
- Standard (10-12): Rejected - minimal is cleaner for initial convention

**Rationale:** Covers 90% of workflow, easy to extend later.

### 2. `stop` Implementation: `pkill`

**Decision:** Use `pkill -f "UniversityManagementSystem"`

**Alternatives Considered:**
- Create custom Gradle task: Rejected - overkill for this change
- Document as no-op: Rejected - team needs to kill orphaned processes
- Skip command: Rejected - useful for cleaning stuck processes

**Rationale:** Simple, works on Linux/WSL, handles edge cases.

### 3. `dev` Command: Full Chain

**Decision:** `dev` runs `clean build migrate start`

**Alternatives Considered:**
- Just `build run`: Rejected - migrations often needed
- Interactive prompt: Rejected - automation is better

**Rationale:** One command for fresh dev startup.

### 4. Naming: Pattern A (Verb-focused)

**Decision:** Use verb names: `start`, `stop`, `migrate`, `build`, `test`

**Alternatives Considered:**
- Noun-focused (`app-start`, `db-migrate`): Rejected - more typing
- Hybrid: Rejected - inconsistent

**Rationale:** Concise, standard convention.

### 5. `logs` Command: Skipped

**Decision:** No `logs` command

**Rationale:** Desktop app has no persistent log output. Add later if logging framework is introduced.

## Risks / Trade-offs

### [Risk] Make not available on all systems
**Mitigation:** Document that Make is required. Gradle commands remain available as fallback.

### [Risk] `pkill` kills wrong process
**Mitigation:** Pattern is specific to `UniversityManagementSystem`. Review if false positives occur.

### [Risk] Team members forget Gradle commands
**Mitigation:** Keep Makefile simple. Gradle tasks still accessible via `./gradlew tasks`.

### [Trade-off] Abstraction layer
**Pro:** Simpler interface, standardization
**Con:** Hides Gradle capabilities, developers may not learn full Gradle power
