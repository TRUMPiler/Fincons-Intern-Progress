package practical;

// A custom exception for handling errors related to the fake database connection.
// This is thrown by FakeDbConnection to indicate issues like null connection strings or queries.
public class ConnectionException extends Exception {
    
    // Constructor that accepts a message detailing the specific connection error.
    public ConnectionException(String message) {
        super(message);
    }
}