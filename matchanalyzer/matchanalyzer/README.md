# Match Analyzer

## Overview
The **Match Analyzer** is a Spring Boot application that processes football match data to identify pairs of football players who have played together in the common matches for the longest time. It reads data from CSV files, including player details, team information, match data, and individual player participation records, then computes the pair of players who have shared the field the longest.

## Table of Contents
- [Overview](#overview)
- [Installation](#installation)
- [Configuration](#configuration)
- [Usage](#usage)
- [Features](#features)
- [Algorithm](#algorithm)
- [Dependencies](#dependencies)
- [License](#license)

## Installation
To get started with the Match Analyzer application:

1. Clone the repository:
    ```bash
    git clone https://github.com/horhe579/sirma-academy-java-2024.git

    cd sirma-academy-java-2024\matchanalyzer\matchanalyzer\matchanalyzer
    ```

2. Build the project using Maven:
    ```bash
    mvn clean install
    ```

3. Run the Spring Boot application:
    ```bash
    mvn spring-boot:run
    ```

## Configuration
The application can be configured via the `application.properties` file. Below are the settings I used:

```properties
# Server properties
spring.application.name=matchanalyzer
server.port=PORT_NUMBER

# Database properties
spring.datasource.url=DATASOURCE_URL
spring.datasource.username=DATASOURCE_USERNAM
spring.datasource.password=DATASOURCE_PASSWORD

# Hibernate properties
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

## Usage
To try the app out you can either:
- Visit the `/parse-files/csv` endpoint and specify the routes of the CSV files. The files have to be formatted as follows:
  - `teams.csv`: `ID,Name,ManagerFullName,Group
    `
  - `matches.csv`: `ID,ATeamID,BTeamID,Date,Score
    `
  - `players.csv`: `ID,TeamNumber,Position,FullName,TeamID`
  - `records.csv`: `ID,PlayerID,MatchID,fromMinutes,toMinutes`

- Or enter some data manually using the CRUD operations:
  - `/teams`
  - `/matches`
  - `/players`
    - Keep in mind that the `toMinutes` column can have NULL values, representing the end of the match. Also, the `Date` column is in the format Month-Date-Year. The `Score` also has a specific format, either `X-Y` or `X(X1)-Y(Y1)` with penalties. A **team** cannot have more than 1 player with a specific `FullName` or `TeamNumber`. Each **team** can only be associated with a single **manager**.

## Features
Covers the following goals:
- [x] Parsing of the CSV files without using an external library
- [x] Data integrity checks
- [x] Persistence of the data in an SQL database
- [x] Field validation
- [x] Handling edge cases
- [x] Computing the pair of players who have played together the longest
- [x] CRUD operations for the entities
- [x] Custom ID generation for the entities created via the CRUD operations
- [x] Custom exceptions
- [x] Support more than one date format (to my understanding at least)
- [ ] Followed SOLID principles (for the most part) and clean code principles (for the most part), no time left to refactor code to follow some design patterns

## Algorithm
The algorithm for finding the pair of players who have played together the longest is as follows:
1. After calling the `/player-analysis/player-pair/most-time-together` endpoint, a method `.getPairsWithMostTime()` from the `PlayerAnalysisService` is called.
2. The `RecordService` is injected into the `PlayerAnalysisService`, and after calling the `.getPairsWithMostTime()` method `.getPlayerRecordsByMatch()` gets called.
3. The `.getPlayerRecordsByMatch()` returns a map, where the key is the match ID and the value is a list of records for that match.
    - it accesses a list of all records from the database in the following format: `MatchID, PlayerID, fromMinutes, toMinutes` and then it groups them by match ID and collects all the records for that match in a list using parsers that take the raw `Object` array from the query and return a `DTO`.
4. Then the `.extractPairsWithTimeTogether()` method is called, it takes the map from the previous step.
    - it uses a nested loop to compare each player with every other player in the match and calculates the time they spent together on the field by taking the maximum of the start times and the minimum of the end times.
    - if the players have spent any time together, they get added to a map where the key is the pair of players and the value is a DTO, holding information about the time they spent together and each match with their overlap time in it.
    - this method has a flag that can be set to true to return the map with the player pairs who played the most together instead of all player pairs with time together.
    - it loops through the map and finds the maximum time a pair spent, then goes over the map again and for each pair that did not spend the maximum time together, it removes them from the map.
