package practical;

import java.sql.SQLException;

public class MainExecuter {
    public static void main(String[] args) {
        FakeDbConnection fb=FakeDbConnection.getInstance();
        String connectionString="jdbc://localhostL5432/convofy",
                sqlQuery="insert into convofy.users(id,name,password,email) values(?,?,?,?,?)";
        if(fb.openConnection(connectionString, MainExecuter.class))
        {
            try
            {
                fb.execute(connectionString,sqlQuery);
            } catch (ConnectionException e) {
                System.err.println("Error "+e.getMessage());
            }
            catch (Exception e)
            {
                System.err.println("Error "+e.getMessage());
            }
            finally{
                fb.closeConnection();
            }

        }

    }
}
