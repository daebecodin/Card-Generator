

# SF GIANTS THANK YOU - CSC 220 Project

This project is a command-line application developed for the CSC 220 - Data Structures course at San Francisco State University. The program simulates an interactive chat session with the San Francisco Giants baseball organization, allowing a user to order custom ASCII art 'Thank You' cards and participate in a quiz to win free tickets.

## Features

* **Interactive Chat Session**: Simulates a complete, menu-driven conversation that guides the user through the application's features.
* **Dynamic User Configuration**: Allows the user to select their preferred language and time zone at startup.
* **Rich Object-Oriented Design**: Utilizes a class hierarchy to model real-world entities like `Person`, `Player`, `Student`, `Club`, and `University`.
* **ASCII Art Card Generation**: Dynamically creates and displays stylized "Thank You" cards based on user input.
* **Comprehensive Logging System**: Redirects all standard output and error to log files for debugging and record-keeping.
* **Interactive Quiz**: Engages the user with a series of questions to win a prize.

## How to Compile and Run

1.  **Prerequisites**: Ensure you have a Java Development Kit (JDK) installed.
2.  **File Structure**: Place all `.java` files into a single package folder named `assignment02PartB`.
3.  **Compile**: Open a terminal, navigate to your project's source directory, and compile the Java files:
    ```bash
    javac assignment02PartB/*.java
    ```
4.  **Run**: Execute the application by running the `main` method in the `Messenger` class:
    ```bash
    java assignment02PartB.Messenger
    ```
5.  **Interact**: The application will start in your console. Follow the on-screen prompts.

## Key Files

* `Messenger.java`: The main entry point of the application.
* `ChatSession.java`: Manages the interactive chat flow, from greeting the user to running the quiz.
* `Config.java`: Manages application-wide settings and preferences.
* `Language.java`: Handles language selection and provides the correct text strings.
* `Person.java`: An abstract base class for all people in the simulation (`Student`, `Player`, etc.).
* `Card.java`: A data-holding class that stores all the information required for a "Thank You" card.
* `Quiz.java`: Manages the questions, answers, and logic for the end-of-session quiz.

## Authors

* Durand Dyer
* Ian Brown