## Why

Establish project conventions for the development workflow. A Makefile provides a standardized interface for common tasks, making it easier for team members to start, build, test, and manage the application consistently.

## What Changes

- Add `Makefile` at project root with standard development commands
- Commands: `start`, `stop`, `migrate`, `build`, `test`, `dev`, `help`
- Update `AGENTS.md` to reference Makefile commands in Quick Reference section
- No breaking changes - Gradle commands remain available

## Capabilities

### New Capabilities
- No new application capabilities - this is developer tooling only

### Modified Capabilities
- No requirement changes to existing capabilities

## Impact

- **Developer Workflow**: Team uses `make <command>` instead of `./gradlew <task>`
- **Dependencies**: Make utility required (available on Linux/macOS/WSL)
- **Documentation**: AGENTS.md Quick Reference updated
- **Build System**: Wraps existing Gradle tasks (run, flywayMigrate, clean build, test)
- **Process Management**: `stop` command kills Java processes running UniversityManagementSystem
