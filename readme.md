# Automation SauceDemo - Java Selenium (Cucumber)

This repository contains automation scripts for web testing on "https://www.saucedemo.com/" website using Java, Selenium, and Cucumber. The project follows the Page Object Model (POM) design pattern for maintainable and scalable test automation.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [Test Execution](#test-execution)

## Introduction

This automation framework aims to provide an easy-to-use and efficient approach to test web applications using Selenium with Java and Cucumber. The Page Object Model (POM) design pattern helps keep the test code separate from the page-specific code, making it easier to maintain and update tests when the web application's UI changes.

## Features

- Utilizes Selenium WebDriver for browser automation.
- Written in Java, making it easily understandable for developers and testers.
- Integrates with Cucumber for writing and executing feature files in Gherkin format.
- Follows the Page Object Model (POM) design pattern for reusable and modular test code.
- Provides easy configuration using properties files or environment variables.
- Extensible and customizable for different testing scenarios.

## Prerequisites

Before running the automation scripts, ensure you have the following installed:

- Java Development Kit (JDK) 1.8 or higher
- Apache Maven

Make sure to set the `JAVA_HOME` environment variable and add the Maven to the system path.

## Installation

1. Clone this repository to your local machine:

```
git clone https://github.com/baihaqybeki/automation-saucedemo.git
```

2. Navigate to the project directory:

```
cd automation-saucedemo
```

3. Install the required dependencies using Maven:

```
mvn clean install
```

## Usage

To create new feature files and step definitions, add them to the `src/test/resources/features` and `src/test/java/steps` directories, respectively.

To create POM classes for new web pages, add them to the `src/main/java/com/saucedemo/pages` directory.

To running with other browser, open `src/test/java/steps/Hook.java` and changes this code :

```
DriverSingleton.getInstance(Constants.Chrome);
```

If want to running on Firefox browser, change with this code :

```
DriverSingleton.getInstance(Constants.Firefox);
```

And if want to running on Safari browser, change with this code :

```
DriverSingleton.getInstance(Constants.Safari);
```

## Test Execution

To run the Cucumber tests, use the following command:

```
mvn test
```
