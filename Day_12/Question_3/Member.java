package Assignment_12;

class Member {
	String name;
	int age;
	String phoneNumber;
	String address;
	double salary;

	
	Member(String name, int age, String phoneNumber, String address, double salary) {
		this.name = name;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.salary = salary;
	}

	
	void printSalary() {
		System.out.println("Salary: " + salary);
	}
}


class Employee extends Member {
	String specialization;
	String department;

	
	Employee(String name, int age, String phoneNumber, String address, double salary, String specialization,
			String department) {
		super(name, age, phoneNumber, address, salary);
		this.specialization = specialization;
		this.department = department;
	}
}


class Manager extends Member {
	String specialization;
	String department;

	
	Manager(String name, int age, String phoneNumber, String address, double salary, String specialization,
			String department) {
		super(name, age, phoneNumber, address, salary);
		this.specialization = specialization;
		this.department = department;
	}
}


