# Number Classification API

## Overview
The Number Classification API is a Spring Boot application that classifies numbers and provides interesting mathematical properties along with fun facts. It accepts a number as input and returns a JSON response containing details such as whether the number is prime, perfect, or an Armstrong number.

## Features
- Classifies numbers based on mathematical properties.
- Returns fun facts about numbers using the Numbers API.
- Handles CORS for cross-origin requests.
- Provides responses in JSON format.

## API Endpoint
### GET /api/classify-number?number={number}
- **Parameters:**
  - `number`: The number to classify (must be a valid integer).
  
- **Responses:**
  - **200 OK**
    ```json
    {
        "number": 371,
        "is_prime": false,
        "is_perfect": false,
        "properties": ["armstrong", "odd"],
        "digit_sum": 11,
        "fun_fact": "371 is an Armstrong number because 3^3 + 7^3 + 1^3 = 371"
    }
    ```
  - **400 Bad Request**
    ```json
    {
        "number": "alphabet",
        "error": true
    }
    ```

## Project Structure
```
number-classification-api
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           ├── NumberClassificationApplication.java
│   │   │           ├── controller
│   │   │           │   └── NumberClassificationController.java
│   │   │           ├── service
│   │   │           │   └── NumberClassificationService.java
│   │   │           ├── model
│   │   │           │   └── NumberProperties.java
│   │   │           └── util
│   │   │               └── NumberUtils.java
│   │   └── resources
│   │       └── application.properties
│   └── test
│       └── java
│           └── com
│               └── example
│                   ├── controller
│                   │   ├── DefaultControllerTest.java
│                   │   └── NumberClassificationControllerTest.java
│                   ├── service
│                   │   └── NumberClassificationServiceTest.java
│                   └── util
│                       └── NumberUtilsTest.java
├── .gitignore
├── pom.xml
└── README.md
```

## Setup Instructions
1. Clone the repository:
   ```
   git clone <repository-url>
   ```
2. Navigate to the project directory:
   ```
   cd number-classification-api
   ```
3. Build the project using Maven:
   ```
   mvn clean install
   ```
4. Run the application:
   ```
   mvn spring-boot:run
   ```

## Testing
Unit tests are included in the `src/test/java/com/example` directory to ensure the API behaves as expected.

To run the tests, use the following command:
```
mvn test
```

## License
This project is licensed under the MIT License. See the LICENSE file for more details.