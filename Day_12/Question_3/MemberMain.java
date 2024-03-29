package Assignment_12;


public class MemberMain {
	public static void main(String[] args) {
		// Creating an Employee object
		Employee employee = new Employee("John Doe", 25, "1234567890", "123 Main St", 50000.0, "Software Engineer",
				"Engineering");

		// Creating a Manager object
		Manager manager = new Manager("Jane Smith", 35, "9876543210", "456 Broad St", 80000.0, "Project Manager",
				"Management");

		
		System.out.println("Employee Details:");
		System.out.println("Name: " + employee.name);
		System.out.println("Age: " + employee.age);
		System.out.println("Phone Number: " + employee.phoneNumber);
		System.out.println("Address: " + employee.address);
		employee.printSalary(); 
		System.out.println("Specialization: " + employee.specialization);
		System.out.println("Department: " + employee.department);

		
		System.out.println("\nManager Details:");
		System.out.println("Name: " + manager.name);
		System.out.println("Age: " + manager.age);
		System.out.println("Phone Number: " + manager.phoneNumber);
		System.out.println("Address: " + manager.address);
		manager.printSalary(); 
		System.out.println("Specialization: " + manager.specialization);
		System.out.println("Department: " + manager.department);
	}
}