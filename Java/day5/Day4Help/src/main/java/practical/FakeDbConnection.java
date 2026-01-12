package practical;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// A singleton class that simulates a database connection and its operations.
// It uses a logger to provide information about its state.
class FakeDbConnection {
    private static FakeDbConnection fb;
    private final Logger logger;

    // Private constructor to ensure only one instance of the class is created.
    private FakeDbConnection() {
        logger = LoggerFactory.getLogger(FakeDbConnection.class);
    }

    // Provides a global point of access to the singleton instance.
    public static FakeDbConnection getInstance() {
        if (fb == null) {
            fb = new FakeDbConnection();
        }
        return fb;
    }

    // Simulates opening a database connection and logs the action.
    public boolean openConnection(String connectionString, Class<?> openingClass) {
        logger.info("Opening connection to " + connectionString);
        logger.info("Connection opened by " + openingClass.getName());
        return true;
    }

    // Simulates executing a SQL query and throws a custom exception if inputs are null.
    public int execute(String connection, String sql) throws ConnectionException {
        if (connection == null || sql == null) {
            logger.error("Connection or SQL string is null.");
            throw new ConnectionException("SQL connection or query is null.");
        }
        logger.info("Executing SQL statement: " + sql);
        return 1; // Simulates one row affected.
    }

    // Simulates closing the database connection and logs the action.
    public void closeConnection() {
        logger.info("Closing connection.");
    }
}