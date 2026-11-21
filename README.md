# SERVEDESK — Restaurant Billing System

SERVEDESK is a menu-driven Java console application demonstrating a simple restaurant order and billing workflow.

## Features

- Display selection codes and sample prices
- Add selections by code
- Add to quantities already ordered
- Review the current order and calculated total
- Generate a bill
- Clear an order with confirmation
- Handle unknown item codes, invalid quantities, and non-numeric input

## Menu data

The program uses placeholder selection labels and sample prices. These are demonstration values, not a real restaurant menu.

## Requirements

- Java Development Kit (JDK), Java 8 or later

## Run

From the folder containing the source file:

```bash
javac RestaurantBillingSystem.java
java RestaurantBillingSystem
```

## Concepts demonstrated

- Classes and objects
- Constructors
- Encapsulation with private fields and getter methods
- Arrays
- Methods
- Loops and conditional statements
- Switch statement
- Exception handling with `try-catch`

## Testing

See [TESTING.md](TESTING.md) for the 14-case test report and the scope of verification.

## Project scope

This is a console-based educational project. It does not include a GUI, database, persistence, tax, discounts, or customer records.
