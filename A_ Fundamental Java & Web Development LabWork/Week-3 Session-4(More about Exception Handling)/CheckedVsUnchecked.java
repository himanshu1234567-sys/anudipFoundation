
// 3. Write a program that to generate 6 unchecked and 5 checked type exceptions?

package ExcptionHanding;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class CheckedVsUnchecked {

    public static void main(String[] args) {
        // Unchecked exceptions
        generateUncheckedExceptions();

        // Checked exceptions
        try {
            generateCheckedExceptions();
        } catch (IOException e) {
            System.err.println("Checked Exception caught: IOException ");
        }
    }

    private static void generateUncheckedExceptions() {
        // 1. NullPointerException
        String nullString = null;
        try {
            nullString.length();
        } catch (NullPointerException e) {
            System.err.println("Unchecked Exception caught: NullPointerException");
        }

        // 2. ArrayIndexOutOfBoundsException
        int[] array = {1, 2, 3};
        try {
            int element = array[5];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Unchecked Exception caught: ArrayIndexOutOfBoundsException ");
        }

        // 3. ArithmeticException
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.err.println("Unchecked Exception caught: ArithmeticException ");
        }

        // 4. ClassCastException
        try {
            Object obj = "Hello";
            Integer number = (Integer) obj;
        } catch (ClassCastException e) {
            System.err.println("Unchecked Exception caught: ClassCastException ");
        }

        // 5. IllegalArgumentException
        try {
            validateAge(-5);
        } catch (IllegalArgumentException e) {
            System.err.println("Unchecked Exception caught: IllegalArgumentException " );
        }

     // 6. UnsupportedOperationException
        ArrayList<String> list = new ArrayList<>();
        try {
            list.add("Item");
            if (!list.isEmpty()) {
                list.remove(0); // This operation is not supported
            } else {
                System.err.println("Unchecked Exception caught: Attempted to remove from an empty list.");
            }
        } catch (UnsupportedOperationException e) {
            System.err.println("Unchecked Exception caught: UnsupportedOperationException ");
        }

    }

    private static void generateCheckedExceptions() throws IOException {
        // 1. FileNotFoundException
        try {
            readFile("nonexistent.txt");
        } catch (FileNotFoundException e) {
            System.err.println("Checked Exception caught: FileNotFoundException ");
        }

        // 2. IOException
        try {
            performIOOperation();
        } catch (IOException e) {
            System.err.println("Checked Exception caught: performIOOperation ");
        }

        // 3. InterruptedException
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.err.println("Checked Exception caught: InterruptedException");
        }

        // 4. ClassNotFoundException
        try {
            Class.forName("nonexistent.Class");
        } catch (ClassNotFoundException e) {
            System.err.println("Checked Exception caught: ClassNotFoundException ");
        }

        // 5. InputMismatchException
        try {
            readIntegerFromUser();
        } catch (InputMismatchException e) {
            System.err.println("Checked Exception caught: InputMismatchException ");
        }
    }

    private static void validateAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative.");
        }
    }

    private static void readFile(String filename) throws FileNotFoundException {
        // Simulating reading a file
        throw new FileNotFoundException("File not found: " + filename);
    }

    private static void performIOOperation() throws IOException {
        // Simulating an IO operation
        throw new IOException("IOException during IO operation.");
    }

    private static void readIntegerFromUser() {
        // Simulating reading an integer from user input
        throw new InputMismatchException("Input mismatch. Expected an integer.");
    }
}
