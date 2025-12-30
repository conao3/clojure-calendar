# clojure-calendar

A Clojure-based calendar application with PostgreSQL backend.

## Overview

This project provides a calendar service built with Clojure, leveraging modern libraries for database interaction and a Docker-based development environment.

## Requirements

- Clojure 1.12+
- Docker and Docker Compose
- [psqldef](https://github.com/sqldef/sqldef) (for database migrations)

## Tech Stack

- **Clojure 1.12** - Core language
- **next.jdbc** - JDBC-based database access
- **HoneySQL** - SQL as Clojure data structures
- **PostgreSQL** - Relational database
- **Kaocha** - Test runner

## Getting Started

### Start the Database

```bash
docker compose up -d
```

PostgreSQL will be available on port `15432`.

### Run Database Migrations

```bash
make migrate
```

### Start a REPL

```bash
clojure -A:dev
```

## Development

The project uses a standard Clojure tools.deps setup with the following aliases:

| Alias    | Purpose                    |
|----------|----------------------------|
| `:dev`   | Development environment    |
| `:test`  | Run tests with Kaocha      |
| `:build` | Build JAR artifacts        |

### Running Tests

```bash
clojure -M:test
```

## Building

### Create a JAR

```bash
make build
```

### Create an Uberjar

```bash
make uber
```

## Database

The application uses PostgreSQL with the following default configuration:

| Setting    | Value              |
|------------|-------------------|
| Host       | localhost         |
| Port       | 15432             |
| Database   | calendar          |
| User       | calendar          |
| Password   | postgrespassword  |

Schema migrations are managed with psqldef. See `schema.sql` for the current schema.

## Project Structure

```
.
├── src/
│   └── calendar/
│       └── core.clj      # Main application entry point
├── dev/
│   └── user.clj          # Development utilities
├── docker/
│   └── postgresql/       # PostgreSQL Docker configuration
├── deps.edn              # Dependencies and aliases
├── build.clj             # Build configuration
├── schema.sql            # Database schema
├── compose.yml           # Docker Compose configuration
└── Makefile              # Build tasks
```

## License

See LICENSE file for details.
