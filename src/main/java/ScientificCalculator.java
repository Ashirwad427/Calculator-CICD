import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * A menu-driven scientific calculator application for a DevOps mini-project.
 * Implements Square Root, Factorial, Natural Logarithm, and Power functions
 */
public class ScientificCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("--- Scientific Calculator ---");

        while (running) {
            displayMenu();
            System.out.print("\nEnter your choice: ");

            try {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        calculateSquareRoot(scanner);
                        break;
                    case 2:
                        calculateFactorial(scanner);
                        break;
                    case 3:
                        calculateNaturalLog(scanner);
                        break;
                    case 4:
                        calculatePower(scanner);
                        break;
                    case 5:
                        running = false;
                        System.out.println("\nExiting calculator. Goodbye!");
                        break;
                    default:
                        System.out.println("\nError: Invalid choice. Please select an option from 1 to 5.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nError: Invalid input. Please enter a number corresponding to a menu choice.");
                scanner.next(); // Clear the invalid input from the scanner buffer
            }
            System.out.println("---------------------------");
        }

        scanner.close();
    }

    /**
     * Displays the main menu of calculator operations[cite: 4].
     */
    private static void displayMenu() {
        System.out.println("\nChoose an operation:");
        System.out.println("1. Square Root (√x)");
        System.out.println("2. Factorial (!x)");
        System.out.println("3. Natural Logarithm (ln(x))");
        System.out.println("4. Power (x^b)");
        System.out.println("5. Exit");
    }

    /**
     * Calculates the square root of a number[cite: 5].
     * @param scanner Scanner object to read user input.
     */
    private static void calculateSquareRoot(Scanner scanner) {
        try {
            System.out.print("Enter a number: ");
            double num = scanner.nextDouble();
            if (num < 0) {
                System.out.println("Result: Error! Cannot calculate the square root of a negative number.");
            } else {
                double result = Math.sqrt(num);
                System.out.println("Result: √" + num + " = " + result);
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter a valid number.");
            scanner.next(); // Clear buffer
        }
    }

    /**
     * Calculates the factorial of a non-negative integer[cite: 6].
     * @param scanner Scanner object to read user input.
     */
    private static void calculateFactorial(Scanner scanner) {
        try {
            System.out.print("Enter a non-negative integer: ");
            int num = scanner.nextInt();
            if (num < 0) {
                System.out.println("Result: Error! Factorial is not defined for negative numbers.");
            } else {
                long result = 1;
                for (int i = 1; i <= num; i++) {
                    result *= i;
                }
                System.out.println("Result: !" + num + " = " + result);
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter a valid integer.");
            scanner.next(); // Clear buffer
        }
    }

    /**
     * Calculates the natural logarithm (base e) of a number[cite: 7].
     * @param scanner Scanner object to read user input.
     */
    private static void calculateNaturalLog(Scanner scanner) {
        try {
            System.out.print("Enter a positive number: ");
            double num = scanner.nextDouble();
            if (num <= 0) {
                System.out.println("Result: Error! Natural logarithm is only defined for positive numbers.");
            } else {
                double result = Math.log(num);
                System.out.println("Result: ln(" + num + ") = " + result);
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter a valid number.");
            scanner.next(); // Clear buffer
        }
    }

    /**
     * Calculates the power of a number (x^b)[cite: 7].
     * @param scanner Scanner object to read user input.
     */
    private static void calculatePower(Scanner scanner) {
        try {
            System.out.print("Enter the base (x): ");
            double base = scanner.nextDouble();
            System.out.print("Enter the exponent (b): ");
            double exponent = scanner.nextDouble();
            double result = Math.pow(base, exponent);
            System.out.println("Result: " + base + " ^ " + exponent + " = " + result);
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter valid numbers for base and exponent.");
            scanner.next(); // Clear buffer
        }
    }

}
