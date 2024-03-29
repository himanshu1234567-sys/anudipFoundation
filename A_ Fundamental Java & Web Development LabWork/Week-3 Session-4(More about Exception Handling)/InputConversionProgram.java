
// 2. Write a program that takes user input and converts it to an integer using Integer.parseInt(). Handle the NumberFormatException  that might occur during the conversion



package ExcptionHanding;

import java.util.Scanner;

public class InputConversionProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter an integer: ");
            String userInput = scanner.nextLine();

            // Attempt to convert user input to an integer
            int convertedValue = convertToInteger(userInput);

            // Display the converted value
            System.out.println("Successfully converted to integer: " + convertedValue);

        } catch (NumberFormatException e) {
            System.err.println("Error: NumberFormatException - " + e.getMessage());
        } catch (NullPointerException e) {
            System.err.println("Error: NullPointerException - Input is null.");
        } finally {
            // Close the scanner to prevent resource leak
            scanner.close();
        }
    }

    private static int convertToInteger(String userInput) {
        // Check for null input
        if (userInput == null) {
            throw new NullPointerException("Input is null.");
        }

        // Attempt to convert to integer
        return Integer.parseInt(userInput);
    }
}
