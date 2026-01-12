package practical;

// This class serves as the main entry point to demonstrate the use of the FakeDbConnection.
// It simulates opening a database connection, executing a query, and handling potential exceptions.
public class MainExecuter {
    public static void main(String[] args) {
        // Obtaining the singleton instance of FakeDbConnection.
        FakeDbConnection fb = FakeDbConnection.getInstance();
        String connectionString = "jdbc://localhost:5432/convofy";
        String sqlQuery = "INSERT INTO convofy.users(id, name, password, email) VALUES(?, ?, ?, ?)";

        // Attempting to open a connection.
        if (fb.openConnection(connectionString, MainExecuter.class)) {
            try {
                // Executing a SQL query. Passing null to demonstrate exception handling.
                fb.execute(connectionString, null);
            } catch (ConnectionException e) {
                // Catching the custom exception for connection-related errors.
                System.err.println("Connection Error: " + e.getMessage());
            } catch (Exception e) {
                // Catching any other unexpected exceptions.
                System.err.println("An unexpected error occurred: " + e.getMessage());
            } finally {
                // Ensuring the connection is closed, regardless of whether an exception occurred.
                fb.closeConnection();
            }
        }
    }
}