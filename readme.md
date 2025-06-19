

# SF GIANTS THANK YOU - CSC 220 Project

This project is a command-line application developed for the CSC 220 - Data Structures course at San Francisco State University. The program simulates an interactive chat session with the San Francisco Giants baseball organization. [cite_start]A user, playing the role of a student, can provide their information, order custom ASCII art 'Thank You' cards, and participate in a quiz to win free tickets. [cite: 1, 9, 20, 29] The project is a comprehensive demonstration of Object-Oriented Programming (OOP) principles in Java.

## Features

* [cite_start]**Interactive Chat Session**: Simulates a complete, menu-driven conversation, gathering user information and guiding them through the application's features. [cite: 11]
* [cite_start]**Dynamic User Configuration**: Allows the user to select their preferred language (English or a placeholder "Alien") and time zone (PST/EST) at startup. [cite: 2, 7]
* [cite_start]**Rich Object-Oriented Design**: Utilizes a well-defined class hierarchy to model real-world entities like `Person`, `Player`, `Student`, `Club`, and `University`, showcasing principles of inheritance and polymorphism.
* [cite_start]**ASCII Art Card Generation**: Dynamically creates and displays stylized "Thank You" cards based on user input for the recipient, message, and a chosen art symbol. [cite: 24, 27]
* [cite_start]**Comprehensive Logging System**: Redirects all standard output (`System.out`) and standard error (`System.err`) to log files for debugging and record-keeping, in addition to displaying it on the console. [cite: 8]
* [cite_start]**Interactive Quiz**: Engages the user with a series of questions about Java and the SF Giants to win a prize. [cite: 29, 30, 31, 32, 33, 35]

## How to Compile and Run

To get the application running, follow these steps.

1.  **Prerequisites**: Ensure you have a Java Development Kit (JDK) installed on your system.
2.  **File Structure**: Place all `.java` files into a single package folder named `assignment02PartB`. This folder should be inside a source directory (e.g., `src`).
3.  **Compile**: Open a terminal or command prompt, navigate to your project's source directory, and compile all the Java files using the `javac` command:
    ```bash
    javac assignment02PartB/*.java
    ```
4.  **Run**: Execute the application by running the `main` method located in the `Messenger` class:
    ```bash
    java assignment02PartB.Messenger
    ```
5.  **Interact**: The application will start in your console. [cite_start]Follow the on-screen prompts to select your language and timezone, and then proceed through the chat session. [cite: 2]

## Project Structure and Key Files

The project is composed of several classes, each with a specific responsibility. Here is a breakdown of the most important ones:

| File | Description |
| :--- | :--- |
| **Main Application Flow** | |
| `Messenger.java` | The main entry point of the application. It initializes the system, starts the chat, and handles shutdown procedures. |
| `ChatSession.java` | The core class that manages the interactive chat flow, from greeting the user to running the quiz. |
| `Config.java` | [cite_start]Manages application-wide settings and preferences, such as default names and file paths. [cite: 8] |
| **Configuration & Utilities** | |
| `Language.java` | Handles language selection and provides the correct text strings based on user preference. |
| `Timer.java` | [cite_start]Manages time zone selection and provides formatted timestamps. [cite: 11] |
| `StdOutStdErrTee.java` | A custom `OutputStream` that "tees" (splits) console output to log files, capturing everything that is printed. |
| `SFGiantsCardGenerator.java` | A powerful utility that generates ASCII art from text using `java.awt` libraries. It is responsible for creating the visual "Thank You" cards. |
| **OOP Class Hierarchy** | |
| `Person.java` | An abstract base class for all people in the simulation. It is `sealed` to permit only specific subclasses (`Student`, `Player`, `President`, `GeneralManager`, `Manager`). |
| `Student.java` | [cite_start]Represents the user, holding information like name and email. [cite: 5] |
| `Player.java` | [cite_start]Represents an SF Giants player (e.g., Buster Posey) that the user interacts with. [cite: 17] |
| `Organization.java`| An abstract base class for organizations, `sealed` to permit `Club`, `University`, and `OwnerGroup`. |
| `Club.java` | [cite_start]Models the SF Giants baseball club, containing details like its name, colors, and staff. [cite: 10] |
| `University.java` | [cite_start]Models the user's university (SFSU), containing details about the school. [cite: 12, 15] |
| **Data/Model Classes** | |
| `Card.java` , `Quiz.java` | Data-holding classes that are part of the application's structure, intended to hold card and quiz information. |

## Authors

* **Durand Dyer**
* **Ian**

