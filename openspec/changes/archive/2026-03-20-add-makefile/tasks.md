## 1. Create Makefile

- [x] 1.1 Create Makefile at project root with 7 commands: start, stop, migrate, build, test, dev, help
- [x] 1.2 Implement `start` target (./gradlew run)
- [x] 1.3 Implement `stop` target (pkill -f "UniversityManagementSystem")
- [x] 1.4 Implement `migrate` target (./gradlew flywayMigrate)
- [x] 1.5 Implement `build` target (./gradlew clean build)
- [x] 1.6 Implement `test` target (./gradlew test)
- [x] 1.7 Implement `dev` target (clean build migrate start)
- [x] 1.8 Implement `help` target (display available commands)

## 2. Update Documentation

- [x] 2.1 Update AGENTS.md Quick Reference section to reference Makefile commands
- [ ] 2.2 Verify all commands work on WSL2/Linux

## 3. Verify

- [ ] 3.1 Install make: `sudo apt install make`
- [ ] 3.2 Test `make start` launches application
- [ ] 3.3 Test `make stop` kills application process
- [ ] 3.4 Test `make migrate` runs Flyway migrations
- [ ] 3.5 Test `make build` completes successfully
- [ ] 3.6 Test `make test` runs test suite
- [ ] 3.7 Test `make dev` runs full chain
- [ ] 3.8 Test `make help` displays command list
