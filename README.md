# Pokédex - SOLID Principles Implementation

This project was created as part of my software engineering coursework.  
The goal is to implement a command-line Pokédex in Java while applying all five SOLID principles.

<img src="solid.jpg" alt="SOLID Principles Illustration" width="300" height="300">

## Overview

This Pokédex allows users to:
- Query Pokémon information by ID
- Choose between two data sources: PokéAPI (online) or SQLite (local database)
- Select language preference (English or French) for Pokémon names and descriptions
- View formatted Pokémon data including name, description, height, and weight

### Example Output
```
=============================
Pokémon # 1
Nom : Bulbizarre
Description : Il a une graine qui pousse sur son dos
Taille : 7
Poids : 69
=============================
```

## SOLID Principles Applied
This project demonstrates all five SOLID principles:
- **Single Responsibility**: Each class handles one specific concern
- **Open/Closed**: Extensible design without modifying existing code
- **Liskov Substitution**: Polymorphic behavior with proper inheritance
- **Interface Segregation**: Focused, specific interfaces
- **Dependency Inversion**: Abstractions over concrete implementations

Detailed comments explaining each principle can be found throughout the source code.

## Prerequisites

- **Java 11 or higher**
- **Gradle** (wrapper included in the project)
- **Internet connection** (for PokéAPI data source)

## Installation

Clone the repository:

```bash
git clone git@github.com:ilies-sghiar/AWS_Cloud.git
```

## Run the Application

**Option 1: Command line**
```bash
./gradlew run
```

**Option 2: IntelliJ IDEA / VS Code**
- Open `Main.java` and click the Run button


## Build the Project
```bash
./gradlew build
```

The compiled artifacts will be in `build/`

## Project Structure

```
SOLID_Pokedex/
├── src/main/java/com/example/
│   └── pokedex/
│       ├── Main.java             # Application entry point
│       ├── PokedexRunner.java    # Main runner with user interaction
│       ├── controllers/
│       │   └── PokemonController.java      # Business logic layer
│       ├── models/
│       │   └── Pokemon.java                # Pokemon model
│       ├── services/
│       │   ├── AbstractPokemonService.java              # Base service abstraction
│       │   ├── PropertyProviderInterface.java           # Basic provider interface
│       │   ├── LocalizedPropertyProviderInterface.java  # Localization interface
│       │   ├── PokemonHttpProvider.java                 # HTTP API Service
│       │   ├── PokemonSqliteProvider.java               # SQLite Service
│       │   └── PokemonJsonParser.java                   # JSON parsing utility
│       ├── utilities/
│       │   └── AbstractPokedexRunner.java  # Base runner abstraction
│       └── views/
│           └── PokemonView.java            # Display formatting
├── ressources/
│   └── pokemondatabase.sqlite    # Local SQLite database (Pokémon 1-5)
├── bin/                          # Compiled binaries (generated)
├── build/                        # Build artifacts (generated)
├── gradle/                       # Gradle wrapper files
├── build.gradle                  # Gradle build configuration
├── settings.gradle               # Gradle settings
├── gradlew                       # Gradle wrapper script (Unix)
├── gradlew.bat                   # Gradle wrapper script (Windows)
├── LICENSE                       # MIT License
└── README.md                     # This file
```

## Data Sources

### 1. PokéAPI (Online)
- Public REST API: `https://pokeapi.co/`
- Supports many localizations
- Requires internet connection

### 2. SQLite Database (Local)
- File: `resources/pokemondatabase.sqlite`
- Contains data for Pokémon IDs 1-5
- Single language only (french)
- Works offline

## Licence

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact

For any questions, you can contact me at `iliesghiar@gmail.com`.
