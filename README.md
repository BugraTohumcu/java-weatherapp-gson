# WeatherApp

## Overview

**WeatherApp** is a simple Java application that retrieves and displays the current weather data for a specified city. It leverages the [Open-Meteo API](https://open-meteo.com/) for weather forecasts and the [Open-Meteo Geocoding API](https://open-meteo.com/en/docs/geocoding-api) to fetch the geographical coordinates (latitude and longitude) of the specified city.

## Features

- **City Lookup:** Users can input any city name, and the application will retrieve the latitude and longitude coordinates for that city.
- **Weather Data:** The application then fetches the current weather conditions, including temperature, wind speed, and humidity, based on the city's coordinates.
- **User-Friendly Interface:** Simple console-based interaction, where users can input city names continuously until they choose to exit.

## Getting Started

### Prerequisites

- **Java Development Kit (JDK):** Make sure you have JDK 8 or higher installed.
- **Gson Library:** The application uses the Gson library to parse JSON responses. If you're using Maven or Gradle, include Gson as a dependency. Otherwise, download the Gson JAR and add it to your project's classpath.

### Installation

1. **Clone the Repository:**

    ```bash
    git clone https://github.com/BugraTohumcu/WeatherApp.git
    cd WeatherApp
    ```

2. **Add Dependencies:**

    If you're using Maven, add this to your `pom.xml`:

    ```xml
    <dependency>
        <groupId>com.google.code.gson</groupId>
        <artifactId>gson</artifactId>
        <version>2.8.9</version>
    </dependency>
    ```

## Usage

1. **Start the Application:**
   Run the `WeatherApp` and follow the prompts.

2. **Input City:**
   When prompted, enter the name of a city (e.g., "Berlin"). The application will fetch and display the current weather data.

3. **Quit:**
   Type "No" when prompted to exit the application.

### Example

```plaintext
Enter city name or say No to quit: Berlin
Time: 2024-08-18T10:45
Temperature: 22.9 °C
Wind Speed: 6.2 km/h

Enter city name or say No to quit: No
