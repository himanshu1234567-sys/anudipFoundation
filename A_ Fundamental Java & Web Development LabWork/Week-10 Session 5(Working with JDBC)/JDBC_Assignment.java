package com.jdbc.labassignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBC_Assignment {
	public static void main(String[] args) {

	//	jdbcImplementSteps();
	//	preparedStatementEg();
	//	statementEg();
	//	resultSetEg();
		resultSetMetaDataEg();

	}

	/*
	 Q.1     Write the steps to implement JDBC code in java?
	 Ans -  There are mainly 6 major steps to implement JDBC code in java are as follow-
	 
	 Import statement
	       import.java.sql.*;         
	       
	 Load the driver
	       Class.forName(“com.mysql.cj.jdbc.Driver”);   
	 
	 Establish the connection
	       Connection con = DriverManager.getConnection(“url”, “username”, “password”);  
	 
	 Prepare statement
	       PreparedStatement ps = con.preparedStatement(“SELECT * FROM     table_name WHERE column = ?”); 
	 ps.setString(1, “some_value”);

	 Execute the query
	                ResultSet rs = ps.executeQuery();
	                while(rs.next()){
	                   System.out.println(rs.getStrig(“column_name”));
	               }

	 Close the connection
	              rs.close();
	             ps.close();
	                con.close();    
	*/


	public static void jdbcImplementSteps() {

		Connection con = null;
		PreparedStatement ps = null;

		try {

			// step1: Load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step2: Establish the connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab_assignments", "root", "rootroot");
			if (con != null) {
				System.out.println("Connected...");
			} else {
				System.out.println("Not Connected");
			}

			// Step4: Prepare statement to execute queries
//		    ps = con.prepareStatement("CREATE TABLE emp(id int PRIMARY KEY, name VARCHAR(30) NOT NULL, city VARCHAR(40))");
			ps = con.prepareStatement("insert into emp(id,name,city) values(?,?,?)");

			Scanner s = new Scanner(System.in);

			System.out.println("Enter person Id");
			int id = s.nextInt();
			ps.setInt(1, id);

			System.out.println("Enter person name");
			String name = s.next();
			ps.setString(2, name);

			System.out.println("Enter city name");
			String city = s.next();
			ps.setString(3, city);

			// Step5: Execute the query
			int rows = ps.executeUpdate();
			if (rows > 0) {
				System.out.println(rows + " Record has been inserted successfully");
			} else {
				System.out.println("Something went wrong to insert record..");
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				// Step6: close resources
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

//	-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

	
	
	/*
	  Q.2 What is the role of "PreparedStatement" interface? Explain with example?
	  
	 Ans - “PrepareStatement” Interface is a part of JDBC API which represents a
	        precompiled SQL statement that can be executed multiple times with different
	        parameters. It is a subinterface of Statement. It helps enhance performance
	        by allowing the database to reuse the execution plan and provides a safeguard
	        against SQL injection attacks.
	  
	 Example - Consider a scenario where you want to retrieve data from a database
	          using a parameterized SQL query. Instead of concatenating values directly
	          into the query string, you can use a PreparedStatement to enhance both
	          performance and security.
	 
	 */

	public static void preparedStatementEg() {

		Connection con = null;
		PreparedStatement ps = null;

		try {

			// step1: Load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step2: Establish the connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab_assignments", "root", "rootroot");
			if (con != null) {
				System.out.println("Connected...");
			} else {
				System.out.println("Not Connected");
			}

			// Step4: Prepare statement to execute queries
//		    ps = con.prepareStatement("CREATE TABLE emp(id int PRIMARY KEY, name VARCHAR(30) NOT NULL, city VARCHAR(40))");
			ps = con.prepareStatement("update emp set name=?, city=? where id=?");

			Scanner s = new Scanner(System.in);

			
			System.out.println("Enter Employee Name");
			String name = s.next();
			ps.setString(1, name);

            System.out.println("Enter City Name");
			String city = s.next();
			ps.setString(2, city);
			
			System.out.println("Enter Employee Id");
			int id = s.nextInt();
			ps.setInt(3, id);

			// Step5: Execute the query
			int rows = ps.executeUpdate();
			if (rows > 0) {
				System.out.println(rows + " Record has been updated successfully");
			} else {
				System.out.println("Something went wrong to updated record..");
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				// Step6: close resources
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	
//	-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	
	
	/*
	Q. 3)   What is the role of "Statement" interface? Explain with example?

	Ans-  In Java, the Statement interface is part of the JDBC (Java Database Connectivity) API and serves 
	      as a mechanism to execute SQL queries against a database. It represents a simple, non-parameterized statement 
	      and is the foundation for more specialized interfaces like PreparedStatement and CallableStatement. Statement
	      is suitable for executing SQL statements without parameters or when the queries are known at compile-time.

	Example- Imagine a scenario where you need to retrieve data from a database using a basic Statement. 
	In this case, the SQL query is known in advance, and there are no parameters to substitute.
   
   */
	
	public static void statementEg() {

		Connection con = null;
		Statement stmt = null;

		try {

			// step1: Load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step2: Establish the connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab_assignments", "root", "rootroot");
			if (con != null) {
				System.out.println("Connected...");
			} else {
				System.out.println("Not Connected");
			}

			// Step3:  Statement to execute queries
			stmt = con.createStatement();

			Scanner s = new Scanner(System.in);

			System.out.println("Enter Employee Id");
			int id = s.nextInt();

			System.out.println("Enter Employee Name");
            String name = s.next();

            System.out.println("Enter City Name");
            String city = s.next();

         // Step 4: Execute the update query
            String updateQuery = "DELETE FROM emp WHERE id=" + id;
            int rows = stmt.executeUpdate(updateQuery);
            
			if (rows > 0) {
				System.out.println(rows + " Record has been deleted successfully");
			} else {
				System.out.println("Something went wrong deleting record..");
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				// Step 5: close resources
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

//	-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	
	
	/*
	Q.4)  What is the difference between "Statement" and "PreparedStatement" interface? Explain with example?


	Ans.     Feature                           Statement                                                            PreparedStatement
	   
	       Compilation            Queries are compiled every time they are executed.                Queries are precompiled, enhancing execution efficiency.
	
	       Dynamic values         Not suitable for dynamic values in queries.                       Ideal for dynamic values, as it supports placeholders.
	 
	       Reusability            Each query is compiled and executed independently.                Queries are compiled once and can be reused with new values.
	
	       Performance            Generally slower due to lack of query precompilation.             Faster execution as queries are precompiled by the database.
	
	       Flexibility            Limited flexibility for dynamic query construction.               Allows dynamic construction of queries at runtime.
	
	       Maintainability        May lead to harder-to-maintain code with concatenated strings.    Enhances code maintainability with clear parameterization.


	*/
//	-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

	
	
	
	/*
	Q.5)  What is the use of execute(), executeUpdate(), executeQuery() methods? Explain with example?

	Ans-  In Java, the execute(), executeUpdate(), and executeQuery() methods are part of the Statement interface, 
		  which is used to execute SQL queries and updates against a database. These methods are typically associated with
		  the java.sql.Statement class or its subclasses, such as java.sql.PreparedStatement or java.sql.CallableStatement.

		  execute() :

			The execute() method is a general-purpose method that can be used to execute any SQL statement, be it a query,
			update, or any other type of SQL command. It returns a boolean value of true if a ResultSet object can be retrieved; 
			otherwise, it returns false. Use this method to execute SQL DDL statements or when you need to use truly dynamic SQL.

			Statement statement = connection.createStatement();
			boolean hasResultSet = statement.execute("SELECT * FROM employees");

			if (hasResultSet) {
			    ResultSet resultSet = statement.getResultSet();
			    // Process the ResultSet
			} else {
			    int updateCount = statement.getUpdateCount();
			    // Process the update count
			}

		 executeUpdate :

			The ‘executeUpdate()’ method is used to execute SQL statements that update the database, such as INSERT, UPDATE, DELETE,
			etc.It returns the number of rows affected by the execution of the SQL statement. Use this method to execute SQL statements, 
			for which you expect to get a number of rows affected – for example, an INSERT, UPDATE, or DELETE statement.

			Statement statement = connection.createStatement();
			int rowsAffected = statement.executeUpdate("UPDATE employees SET salary = salary * 1.1 WHERE department = 'IT'");
			System.out.println(rowsAffected + " rows updated");


		 executeQuery():

			The executeQuery() method is specifically used for executing SELECT queries that retrieve data from the database.
			It returns a ResultSet object containing the results of the query.

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM employees WHERE department = 'HR'");

			while (resultSet.next()) {
			    // Process each row in the ResultSet
			    String name = resultSet.getString("name");
			    int age = resultSet.getInt("age");
			    // ... (process other columns)
			}

			*/

//	-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

   
	
	
	/*
	Q.6)  What is the role of "ResultSet" interface? How we can make any ResultSet bidirectional? Explain with example?

	Ans - The ResultSet interface in Java is a crucial component when working with relational databases. It serves as a container
	      for the data retrieved from a database after executing a query. The ResultSet provides methods to navigate through the 
	      result set, retrieve data, and perform various operations on the data.

	      One unique aspect of the ResultSet interface is its ability to be made bidirectional, meaning you can traverse the data in
	      both forward and backward directions. This is achieved by creating a ResultSet object with a specific type and concurrency 
	      combination during its creation.
	     
	     */
	      
	public static void resultSetEg() {

		Connection con = null;
		PreparedStatement ps = null;

		try {

			// step1: Load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step2: Establish the connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab_assignments", "root", "rootroot");
			if (con != null) {
				System.out.println("Connected...");
			} else {
				System.out.println("Not Connected");
			}

			// Step3: Prepare statement to execute queries
            ps = con.prepareStatement("select*from emp");

         // Step4: Execute the query
         	ResultSet rs = ps.executeQuery();
         	while (rs.next()) {
         	int id = rs.getInt("id");
         	String name = rs.getString("name");
         	String city = rs.getString("city");
         	System.out.println("Id = " + id + " Name = " + name + " City = " + city);
         		}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				// Step5: close resources
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

//	-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

	
	
	/*
	Q.7) What is the use of "ResultSetMetaData" interface? Explain with example?

	Ans - The ResultSetMetaData interface in Java provides a way to obtain metadata about the structure of a ResultSet, which includes information about the columns such as column names, data types, and more. This metadata can be valuable for dynamically processing results, building generic database tools, or generating reports based on the retrieved data.

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.ResultSetMetaData;

	public class ResultSetMetaDataEg {

	    public static void main(String[] args) {
	        try {
	            // Establish a database connection
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");

	            // Prepare a SQL query with a parameter
	            String sql = "SELECT * FROM employees WHERE department = ?";
	            PreparedStatement ps= con.prepareStatement(sql);

	            // Set the parameter value
	            preparedStatement.setString(1, "IT");

	            // Execute the query
	            ResultSet rs = ps.executeQuery();

	            // Obtain the ResultSetMetaData
	            ResultSetMetaData metaData = rs.getMetaData();

	            // Display column information
	            int columnCount = metaData.getColumnCount();
	            System.out.println("Column Information:");

	            for (int i = 1; i <= columnCount; i++) {
	                System.out.println("Column " + i + ":");
	                System.out.println("  Name: " + metaData.getColumnName(i));
	                System.out.println("  Type: " + metaData.getColumnTypeName(i));
	                System.out.println("  Size: " + metaData.getColumnDisplaySize(i));
	                // ... (additional metadata can be retrieved)
	            }

	            // Process the result set data
	            System.out.println("\nQuery Results:");
	            while (rs.next()) {
	                // Access data using column names or indices
	                String name = rs.getString("name");
	                int age = rs.getInt("age");
	                // ... (process other columns)

	                System.out.println("Name: " + name + ", Age: " + age);
	            }

	            // Close resources
	            rs.close();
	            ps.close();
	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}

	*/

	public static void resultSetMetaDataEg() {

		Connection con = null;
		PreparedStatement ps = null;

		try {

			// step1: Load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step2: Establish the connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab_assignments", "root", "rootroot");
			if (con != null) {
				System.out.println("Connected...");
			} else {
				System.out.println("Not Connected");
			}

			// Step3: Prepare statement to execute queries
            ps = con.prepareStatement("select*from emp where city =?");
            
            ps.setString(1, "Pune");

         // Step4: Execute the query
         	ResultSet rs = ps.executeQuery();
         	
         // Obtain the ResultSetMetaData
            ResultSetMetaData metaData = rs.getMetaData();

            // Display column information
            int columnCount = metaData.getColumnCount();
            System.out.println("Column Information:");

            for (int i = 1; i <= columnCount; i++) {
                System.out.println("Column " + i + ":");
                System.out.println("  Name: " + metaData.getColumnName(i));
                System.out.println("  Type: " + metaData.getColumnTypeName(i));
                System.out.println("  Size: " + metaData.getColumnDisplaySize(i));
                // ... (additional metadata can be retrieved)
            }


         	while (rs.next()) {
         	int id = rs.getInt("id");
         	String name = rs.getString("name");
         	String city = rs.getString("city");
         	System.out.println("Id = " + id + " Name = " + name + " City = " + city);
         		}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				// Step5: close resources
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
	
//	-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

	
	
	/*
	Q. 8) What is driver? explain in details type1, type2, type3, type4 drivers?

	Ans - A driver is a software component that enables a Java application to interact with a database. JDBC drivers provide a standardized 
	      interface for Java applications to connect to various types of databases. 

	      There are four types of JDBC drivers defined by Sun Microsystem that are mentioned below:

	Type 1 Driver (JDBC-ODBC Bridge Driver) : Type-1 driver is also called Universal driver because it can be used to connect to any of the databases.
	                                          It uses ODBC driver to connect to the database. The JDBC-ODBC bridge driver converts JDBC method calls into 
	                                          the ODBC function calls. 

	                                          This driver software is built-in with JDK so no need to install separately.
	                                          It is a database independent driver.

	Type 2 Driver (Native-API Driver):  The Type 2 driver, also known as the Native-API driver.
                                        The Native API driver uses the client -side libraries of the database. This driver converts JDBC method calls into 
                                        native calls of the database API. 

	                                    In order to interact with different databases, this driver needs their local API, that’s why data transfer is much more 
	                                    secure as compared to type-1 driver. 

	                                    This driver is not fully written in Java that is why it is also called Partially Java driver.

	                                    It requires the installation of a native library on the client machine, making it database-specific.

	Type 3 Driver (Network Protocol Driver): The Type 3 driver, also known as the Network Protocol driver.
                                             It uses a middleware server to connect the Java application to the database. 
                                 
                                             The middleware server translates JDBC calls into a database-independent protocol, which is then converted 
                                             into native database calls.

	                                         It provides a level of abstraction, making the application independent of the underlying database. Offers database 
	                                         independence and better performance than the Type 1 and Type 2 drivers.

	                                         It requires additional middleware installation and configuration.

	Type 4 Driver (Thin Driver or Direct-to-Database Driver): The Type 4 driver, also known as the Thin Driver or Direct-to-Database driver.
                                                              It communicates directly with the database using a database-specific protocol. 

	                                                          It is a pure Java implementation that requires no additional native libraries.

	                                                          It is considered the most efficient and platform-independent driver, making it highly portable.

	*/
//	-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

 }