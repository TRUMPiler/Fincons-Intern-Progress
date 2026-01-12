package handson;

import java.util.*;
import java.io.*;

// This class reads employee data from "Employee.txt", checks for a negative salary,
// and throws a custom exception if found.
class EmployeeReader {
    public static void main(String[] args) {
        File file = new File("Employee.txt");
        BufferedReader br = null;
        Map<String, String> empDetails = new HashMap<>();
        try {
            // Reading the file line by line and populating a map with employee details.
            br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(":");
                if (values.length == 2) {
                    empDetails.put(values[0], values[1]);
                }
            }

            // Checking for the existence and validity of the salary.
            String salary = empDetails.get("Salary");
            if (salary == null) {
                System.out.println("Salary not found in the file.");
            } else {
                if (salary.contains("-")) {
                    // Throwing a custom exception for negative salary.
                    throw new SalaryException("Salary is negative.");
                } else {
                    System.out.println("Salary is not negative.");
                }
            }

        } catch (SalaryException se) {
            System.err.println("Salary validation error: " + se.getMessage());
        } catch (FileNotFoundException e) {
            System.err.println("Error: Employee.txt not found.");
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        } finally {
            // Ensuring the BufferedReader is closed to release resources.
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                System.err.println("Error closing the file: " + e.getMessage());
            }
        }
    }
}