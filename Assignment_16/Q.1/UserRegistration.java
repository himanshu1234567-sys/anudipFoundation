package Assdignment_16;

import java.util.Scanner;

public class UserRegistration {

	public static void registerUser(String username, String userCountry) throws InvalidCountryException {
	
		if (!userCountry.equalsIgnoreCase("India")) {
            throw new InvalidCountryException();
        }
        
        else {
            System.out.println("User registered");
        }
	}
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Your Name:");
        String username = sc.nextLine();

        System.out.println("Enter Your Country:");
        String userCountry = sc.nextLine();

       
        try {
            registerUser(username, userCountry);
        } catch (InvalidCountryException e) {
            
            System.out.println(e.getMessage());
        } 
    }
}


