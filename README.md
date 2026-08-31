# Puzzle Game

## Overview

A Java-based puzzle game developed as an Advanced Programming course project.

The project demonstrates the application of object-oriented programming and software engineering principles in the development of an interactive game application.

The codebase separates application source code, tests, assets, and configuration into dedicated project components.

## Project Structure

```text
puzzle-game/
├── src/
│   ├── assets/
│   ├── main/
│   │   └── java/
│   │       └── org/example/
│   ├── test/
│   │   └── java/
│   │       └── org/example/
│   └── config.json
├── pom.xml
├── .gitignore
└── README.md
```

### Source Code

The main application implementation is located under:

```text
src/main/java/org/example
```

### Tests

Automated tests are located under:

```text
src/test/java/org/example
```

### Assets

Game-related resources are stored under:

```text
src/assets
```

### Configuration

The project contains a `config.json` file for application configuration.

## Technologies

* Java
* Maven
* Object-Oriented Programming
* Automated Testing

## Architecture

The project follows a modular organization separating the primary application concerns:

```text
                 Puzzle Game
                      │
          ┌───────────┼───────────┐
          ▼           ▼           ▼
      Game Logic   Resources    Configuration
          │           │           │
          ▼           ▼           ▼
      Application    Assets     config.json
                      │
                      ▼
                    Tests
```

This organization keeps application behavior, resources, configuration, and tests separated within the project.

## Building the Project

Clone the repository:

```bash
git clone https://github.com/MehrshadHaghighat007/puzzle-game.git
cd puzzle-game
```

Build the project using Maven:

```bash
mvn clean package
```

## Running Tests

Run the automated test suite with:

```bash
mvn test
```

## Running the Game

After building the project, execute the application's configured main entry point.

The main source code is located under:

```text
src/main/java/org/example
```

The exact entry point depends on the current project configuration.

## Configuration

The project includes:

```text
src/config.json
```

Configuration values should be kept consistent with the expected local execution environment.

## Development

The project uses the standard Maven directory structure:

```text
src/main/java
src/test/java
```

This makes the application compatible with conventional Java development and build workflows.

## Academic Context

This project was developed as an Advanced Programming course project.

The primary objective was to apply object-oriented programming and software development principles to an interactive Java application.

## Learning Objectives

The project provides practical experience with:

* Object-oriented programming
* Java application development
* Maven project management
* Game application structure
* Resource management
* Configuration management
* Automated testing
* Modular software organization

## Author

**Mehrshad Haghighat**

## License

This project was developed primarily for academic and educational purposes.
