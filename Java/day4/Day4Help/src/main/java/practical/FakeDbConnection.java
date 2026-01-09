package practical;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class FakeDbConnection{
    static FakeDbConnection fb;
    Logger logger;
    private FakeDbConnection(){
        logger= LoggerFactory.getLogger(FakeDbConnection.class);
    }
    public static FakeDbConnection getInstance(){
        if(fb==null){
            fb=new FakeDbConnection();
        }
        return fb;
    }
    public boolean openConnection(String connectionString,Class OpeningClass){
        logger.info("Opening connection to "+connectionString);
        logger.info("Connection opend by"+OpeningClass.getName());
        return  true;
    }
    public int execute(String Connection,String sql) throws ConnectionException
    {
        if(Connection==null||sql==null)
        {
            logger.error("Connection or sql is null");
            throw new ConnectionException("SQL connection is null for instance "+this.getInstance().getClass().getName());
        }
        logger.info("Executing SQL statement");
        return 1;
    }
    public void closeConnection(){
        logger.info("Closing connection");
    }
}