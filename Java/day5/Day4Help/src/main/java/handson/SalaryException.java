package handson;

// A custom exception class for handling errors related to invalid salary values.
// This exception is thrown by EmployeeReader when a negative salary is encountered.
class SalaryException extends Exception {
    
    // Constructor that takes a message to be displayed when the exception is thrown.
    SalaryException(String message) {
        super(message);
    }
}