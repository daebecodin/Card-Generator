Of course\! Based on the files you've provided, here is a comprehensive `README.md` for your CSC 220 project. I've analyzed the Java source code, the log files, and the assignment rubric to create a detailed overview.

-----

# SF GIANTS THANK YOU - CSC 220 Project

This project is a command-line application developed for the CSC 220 - Data Structures course at San Francisco State University. The program simulates an interactive chat session with the San Francisco Giants baseball organization. [cite\_start]A user, playing the role of a student, can provide their information, order custom ASCII art 'Thank You' cards, and participate in a quiz to win free tickets. [cite: 68, 72] The project is a comprehensive demonstration of Object-Oriented Programming (OOP) principles in Java.

## Features

* **Interactive Chat Session**: Simulates a complete, menu-driven conversation that guides the user through the application's features, from initial setup to a final quiz.
* **Dynamic User Configuration**: Allows the user to select their preferred language (English or a placeholder "Alien") and time zone (PST/EST) at startup.
* **Rich Object-Oriented Design**: Utilizes a well-defined class hierarchy to model real-world entities like `Person`, `Player`, `Student`, `Club`, and `University`, showcasing principles of inheritance and polymorphism.
* **ASCII Art Card Generation**: Dynamically creates and displays stylized "Thank You" cards based on user input for the recipient, a message, and a chosen art symbol.
* **Comprehensive Logging System**: Redirects all standard output (`System.out`) and standard error (`System.err`) to log files for debugging and record-keeping, in addition to displaying it on the console.
* **Interactive Quiz**: Engages the user with a series of questions about Java and the SF Giants to win a prize.

## How to Compile and Run

To get the application running, follow these steps.

1.  **Prerequisites**: Ensure you have a Java Development Kit (JDK) installed on your system.
2.  **File Structure**: Place all `.java` files into a single package folder named `assignment02PartB`. This folder should be inside a source directory (e.g., `src`).
3.  **Compile**: Open a terminal or command prompt, navigate to your project's source directory (the one containing the `assignment02PartB` folder), and compile all the Java files using the `javac` command:
    ```bash
    javac assignment02PartB/*.java
    ```
4.  **Run**: Execute the application by running the `main` method located in the `Messenger` class:
    ```bash
    java assignment02PartB.Messenger
    ```
5.  **Interact**: The application will start in your console. Follow the on-screen prompts to select your language and timezone, and then proceed through the chat session.

## Project Structure and Key Files

The project is composed of several classes, each with a specific responsibility. Here is a breakdown of the most important ones:

| File                      | Description                                                                                                                              |
| :------------------------ | :--------------------------------------------------------------------------------------------------------------------------------------- |
| **Main Application Flow** |                                                                                                                                          |
| `Messenger.java`          | The main entry point of the application. It initializes the system, starts the chat, and handles shutdown procedures.                    |
| `ChatSession.java`        | The core class that manages the interactive chat flow, from greeting the user to running the quiz.                                       |
| `Config.java`             | Manages application-wide settings and preferences, such as default names and file paths.                                       |
| **Configuration & Utilities** |                                                                                                                                          |
| `Language.java`           | Handles language selection and provides the correct text strings based on user preference.                                               |
| `Timer.java`              | Manages time zone selection and provides formatted timestamps.                                                                   |
| `StdOutStdErrTee.java`    | A custom `OutputStream` that "tees" (splits) console output to log files, capturing everything that is printed.                          |
| `SFGiantsCardGenerator.java` | A powerful utility that generates ASCII art from text using `java.awt` libraries. It is responsible for creating the visual "Thank You" cards. |
| **OOP Class Hierarchy** |                                                                                                                                          |
| `Person.java`             | An abstract base class for all people in the simulation. It is `sealed` to permit only specific subclasses (`Student`, `Player`, etc.). |
| `Student.java`            | Represents the user, holding information like name and email.                                                                   |
| `Player.java`             | Represents an SF Giants player (e.g., Buster Posey) that the user interacts with.                                                |
| `Organization.java`       | An abstract base class for organizations, `sealed` to permit `Club`, `University`, and `OwnerGroup`.                                       |
| `Club.java`               | Models the SF Giants baseball club, containing details like its name, colors, and staff.                                     |
| `University.java`         | Models the user's university (SFSU), containing details about the school.                                                  |
| **Data/Model Classes** |                                                                                                                                          |
| `Card.java`               | A data-holding class that stores all the information required for a single "Thank You" card.                                             |
| `Quiz.java`               | Manages the questions, answers, and logic for the end-of-session quiz.                                                                   |

## Authors

* Durand Dyer
* Ian